package project3_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Multi_Threaded_Server extends Thread {

    private final Socket socket;

    public Multi_Threaded_Server(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try (BufferedReader reader = new BufferedReader (new InputStreamReader(socket.getInputStream()));
             PrintWriter writer = new PrintWriter(socket.getOutputStream())) {
            Thread.sleep(250);

            int clientNumber = Integer.parseInt(reader.readLine());
            System.out.println("Processing Request from Client " + clientNumber + ".");
            writer.print("Client " + clientNumber + " Processed.");
            writer.flush();
            socket.close();
        }
        catch (IOException | InterruptedException exception) {
            exception.printStackTrace();
            System.exit(1);
        }
    }
}
