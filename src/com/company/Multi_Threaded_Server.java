package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Multi_Threaded_Server extends Thread {

    private final Socket socket;

    public Multi_Threaded_Server(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while(true) {
            try (BufferedReader reader = new BufferedReader (new InputStreamReader(socket.getInputStream()));
                 PrintWriter writer = new PrintWriter(socket.getOutputStream())) {
                Thread.sleep(250);

                /*
                Read data from the reader
                Write data to the writer
                Flush the writer
                 */
                socket.close();
            }
            catch (IOException | InterruptedException exception) {
                exception.printStackTrace();
                System.exit(1);
            }
        }
    }
}
