package project3_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Single_Threaded_Server {
    private final ServerSocket serverSocket;

    public Single_Threaded_Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void run() {
        while(true) {
            try (Socket socket = serverSocket.accept();
                 BufferedReader reader = new BufferedReader (new InputStreamReader(socket.getInputStream()));
                 PrintWriter writer = new PrintWriter(socket.getOutputStream())) {
                Thread.sleep(250);

                System.out.println("Single-Threaded Server ... Listening on port " + serverSocket.getLocalPort());
                int clientNumber = Integer.parseInt(reader.readLine());
                System.out.println("Processing Request from Client " + clientNumber + ".");
                writer.print("Client " + clientNumber + " Processed.");
                writer.flush();
            }
            catch (IOException | InterruptedException exception) {
                exception.printStackTrace();
                System.exit(1);
            }
        }
    }
}
