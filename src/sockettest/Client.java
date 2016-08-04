/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockettest;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import static javax.xml.bind.JAXBIntrospector.getValue;

/**
 *
 * @author Dulaj Ayeshan
 */
public class Client {
    
    private  Socket clientSocket;
    private  DataOutputStream outToServer;

// Initiate & Start the Client
    public  void startClient(){
        try {
            clientSocket = new Socket("localhost", 6789);
            outToServer = new DataOutputStream(clientSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
      
       public  void sendAction(Derection d){
        String msg = getValue(d);
        try {
            outToServer.writeBytes(msg + '\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
       public enum Derection{
        // constants
        UP("UP"),DOWN("DOWN"),LEFT("LEFT"),RIGHT("RIGHT");
        String msg;
        Derection(String msg){
            this.msg = msg;
        }
    }
      
        public static String getValue(Derection d){
        String a = "";
        switch (d){
            case UP:
                a=Derection.UP.msg;
                break;
            case DOWN:
                a=Derection.DOWN.msg;
                break;
            case LEFT:
                a=Derection.LEFT.msg;
                break;
            case RIGHT:
                a=Derection.RIGHT.msg;
                break;
            default:
                break;
        }
        return a;
    }
        // close the client
    public  void CloseClient(){
        try {
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
