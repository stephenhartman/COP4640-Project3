package project3;

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

                /*
                Read data from the reader
                Write data to the writer
                Flush the writer
                 */
            }
            catch (IOException | InterruptedException exception) {
                exception.printStackTrace();
                System.exit(1);
            }
        }
    }
}
