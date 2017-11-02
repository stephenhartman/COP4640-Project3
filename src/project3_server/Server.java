package project3_server;

import java.io.IOException;
import java.net.ServerSocket;

/**
 *  Server creates either single or multi-threaded server objects to process
 *  client data.
 *  @author stephenhartman
 *  @version 11/2/17
 */
public class Server {


    public static void main(String[] args) {

        final int PORT_NUMBER = Integer.parseInt(args[0]);
        final boolean SINGLE_THREADED_SERVER = args[1].equals("true");

        try {
            ServerSocket serverSocket = new ServerSocket(PORT_NUMBER);

            if(SINGLE_THREADED_SERVER)
                System.out.println("Single-Threaded Server ... Listening on port " + PORT_NUMBER);
            else
                System.out.println("Multi-Threaded Server ... Listening on port " + PORT_NUMBER);

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
