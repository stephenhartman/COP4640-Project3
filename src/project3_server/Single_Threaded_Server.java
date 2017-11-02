package project3_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Single-threaded server instance.  Accepts a client socket, reads clientNumber
 * variable from client, and prints output to the console and stream.
 */
public class Single_Threaded_Server {
    private final ServerSocket serverSocket;

    /**
     * Constructor
     * @param serverSocket Socket passed from Server class
     */
    Single_Threaded_Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    /**
     * Runs each single thread.
     */
    protected void run() {
        while (true) try (Socket socket = serverSocket.accept();
                          BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                          PrintWriter writer = new PrintWriter(socket.getOutputStream())) {
            Thread.sleep(250);

            String clientNumber = reader.readLine();    // Read from client
            String message = "Client " + clientNumber + " Process";

            // Print message to console and output stream
            System.out.println(message + "ing.");
            writer.println(message + "ed.");

            writer.flush();     // Flush output stream
            socket.close();     // Close socket
        } catch (IOException | InterruptedException exception) {
            exception.printStackTrace();
            System.exit(1);
        }
    }
}
