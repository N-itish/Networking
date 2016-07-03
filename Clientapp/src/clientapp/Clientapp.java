/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientapp;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

/**
 *
 * @author Nitish
 */
public class Clientapp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //InetAddress ip;
        Scanner reader = new Scanner(System.in);
        String localhost = "NITISH-PC";
        DataOutputStream os = null;
        String message;
        int port = 8000;
        try
        {
            Socket client = new Socket(localhost, port);
            System.out.println("connected to "+ client.getRemoteSocketAddress());
            message = "Enter your messages";
            System.out.println(message);
            while(!message.equalsIgnoreCase("exit"))
            {
                os = new DataOutputStream(client.getOutputStream());
                System.out.println("Enter message:");
                message = reader.nextLine();
                os.writeUTF(message); 
            }
	    os.close();
            client.close();
        }
        catch(IOException ioe)
        {
            System.out.println(ioe.getMessage());
        }
             
    }
}
