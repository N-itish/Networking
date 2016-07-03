/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverapp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nitish
 */
public class Serverapp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int port = 8000;
        Socket client = new Socket();
        DataInputStream is = null;
        try {
            ServerSocket server = new ServerSocket(port);
            
            while (true)
            {
                 System.out.println("The server is running at port no:"+port);
                client = server.accept();
                 //PrintWriter send = new PrintWriter(client.getOutputStream());
                System.out.println("Connection request from"+" "+client.getInetAddress());
                
                while((is = new DataInputStream(client.getInputStream())) != null)
                {
                    if(is.equals("exit"))
                    {
                        server.close();
                        is.close();
                    }
                    else
                    {
                        System.out.println(is.readUTF());
                         
                    }
                }
                is.close();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
}
