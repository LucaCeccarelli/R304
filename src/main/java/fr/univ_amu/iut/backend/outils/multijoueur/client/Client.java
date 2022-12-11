package fr.univ_amu.iut.backend.outils.multijoueur.client;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class Client {
    private String hostname;
    private int port;
    private Socket socketClient;
    private BufferedWriter out;
    private BufferedReader in;
    private List<String> txtReceived;

    /**
     * Constructor of the console used in the "play" scenes
     *
     * @param hostname
     * @param port
     */
    public Client(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    /**
     * Method used to initialize the connection between the client and the server
     *
     * @throws UnknownHostException
     * @throws IOException
     */
    public void connect() throws UnknownHostException, IOException {
        socketClient = new Socket(hostname, port);
        out = new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream()));
        in = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
    }

    /**
     * Method used to send a message
     *
     * @param msg
     */
    public void send(String msg){
        try {
            out.write(msg);
            out.newLine();
            out.flush();
            Thread.sleep(500);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method used to listen continuously to all the responses sent from the server
     */
    public void listen(){
        txtReceived = new ArrayList<String>();

        Thread receive = new Thread(new Runnable() {
            @Override
            public void run() {
                String bufReceived = "";
                try {
                    bufReceived = in.readLine();

                    while(bufReceived!=null){
                        //System.out.println(bufReceived);
                        txtReceived.add(bufReceived);
                        bufReceived = in.readLine();
                    }
                    System.out.println("Server out of service");
                    out.close();
                    socketClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        receive.start();
    }

    /**
     * Method used to return the buffer received from the server
     *
     * @return the buffer received from the server
     */
    public List<String> getBufferReceived(){
        List<String> buffReceived = new ArrayList<String>(txtReceived);
        txtReceived = new ArrayList<String>();
        return buffReceived;
    }
}
