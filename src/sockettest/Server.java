/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockettest;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Dulaj Ayeshan
 */
public class Server {
   
    public static void main(String argv[]) throws Exception
    {
        final String[] clientSentence = new String[1];
        String capitalizedSentence;
        ServerSocket welcomeSocket = new ServerSocket(6789);

        while(true)
        {
            Socket connectionSocket = welcomeSocket.accept();
            final BufferedReader inFromClient =
                    new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
            Thread t = new Thread(new Runnable() {
                public void run()
                {
                    try {
                        clientSentence[0] = inFromClient.readLine();
                        System.out.println("Received: " + clientSentence[0]);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            });
            t.start();
        }
    }
 
    
}
