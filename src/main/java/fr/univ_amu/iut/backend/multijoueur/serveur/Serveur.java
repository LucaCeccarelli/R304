package fr.univ_amu.iut.backend.multijoueur.serveur;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {
    private int port;

    /**
     * Constructor for the server hosting the linux console used to play the games
     *
     * @param port
     */
    public Serveur(int port) {
        this.port = port;
    }

    /**
     * Method used to launch the server
     *
     * @throws IOException
     */
    public void launch() throws IOException {
            Thread receive = new Thread(new Runnable() {
                String msg;

                @Override
                public void run() {
                    try {
                        ServerSocket server = new ServerSocket(port);

                        System.out.println("Bash server launched on port : " + port);


                        Socket client = server.accept();

                        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

                        while ((msg = in.readLine()) != null) {
                            try {
                                Process process = Runtime.getRuntime().exec(msg);

                                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                                String line = "";

                                while ((line = reader.readLine()) != null) {
                                    out.write(line);
                                    out.newLine();
                                    out.flush();
                                    System.out.println(line);
                                }
                            }catch (IOException | NullPointerException | IllegalArgumentException e) {
                                out.write("Command does not exist");
                                out.newLine();
                                out.flush();
                            }
                        }
                        //Exit if the user disconnects
                        System.out.println("Client disconnected");
                        //Close the flux if the user disconnects
                        out.close();
                        client.close();
                        server.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            receive.start();

    }
}
