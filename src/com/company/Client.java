package com.company;

public class Client {

    private static String HOST;
    private static int PORT;
    private static int NUM_CLIENTS;

    private Client(int num_clients) {
        this.NUM_CLIENTS = num_clients;
    }

    public static void main(String[] args) {
        args[0] = HOST;
        PORT = Integer.parseInt(args[1]);
        NUM_CLIENTS = Integer.parseInt(args[2]);

        new Client(NUM_CLIENTS).execute(HOST, PORT);
    }

    @SuppressWarnings("empty-statement")
    private void execute(String host, int port) {
        Threaded_Client[] clients = new Threaded_Client[NUM_CLIENTS];

        try {
            for (int x = 0; x < NUM_CLIENTS; x++) {
                (clients[x] = new Threaded_Client(host, port)).start();
                Thread.sleep(10);
            }
            while (clients[0].getNumFinished() < NUM_CLIENTS)
            {
                /*
                Display the results of each client (report turn-around time in ms)
                Display the average turn-around time for all clients
                 */
            }
        }
        catch (InterruptedException iee) {
            iee.printStackTrace();
            System.exit(1);
        }
    }
}
