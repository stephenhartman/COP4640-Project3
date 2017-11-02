package project3_server;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {


    public static void main(String[] args) {

        final int PORT_NUMBER = Integer.parseInt(args[0]);
        final boolean SINGLE_THREADED_SERVER;

        if (args[1].equals("true"))
            SINGLE_THREADED_SERVER = true;
        else
            SINGLE_THREADED_SERVER = false;

        try {
            ServerSocket serverSocket = new ServerSocket(PORT_NUMBER);

            if(SINGLE_THREADED_SERVER) {
                new Single_Threaded_Server(serverSocket).run();
            }
            else {
                while(true)
                {
                    new Multi_Threaded_Server(serverSocket.accept()).start();
                }
            }
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
            System.exit(1);
        }
    }
}
