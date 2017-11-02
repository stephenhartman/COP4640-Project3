package project3_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


/**
 * Multi-threaded server instance.  Accepts a client socket, reads clientNumber
 * variable from client, and prints output to the console and stream.
 */
public class Multi_Threaded_Server extends Thread {

    private final Socket socket;

    /**
     * Constructor
     * @param socket Socket passed and accepted from Server class
     */
    Multi_Threaded_Server(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader (new InputStreamReader(socket.getInputStream()));
             PrintWriter writer = new PrintWriter(socket.getOutputStream())) {
            Thread.sleep(250);

            String clientNumber = reader.readLine();
            String message = "Client " + clientNumber + " Processed.";
            System.out.println(message);
            writer.println(message);
            writer.flush();
            socket.close();     // Close socket
        }
        catch (IOException | InterruptedException exception) {
            exception.printStackTrace();
            System.exit(1);
        }
    }
}
