package project3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;
import java.net.Socket;

public class Threaded_Client extends Thread {

    public String host;
    public int port;
    public final static AtomicInteger numFinished = new AtomicInteger(0);

    public Threaded_Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public int getNumFinished() {
        return numFinished.get();
    }

    @Override
    public void run() {
        try (Socket socket = new Socket(host, port);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            /*
            Write data to the writer
            Read data from the reader
            Calculate turn-around time
             */
            numFinished.incrementAndGet();
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
            System.exit(1);
        }
    }
}
