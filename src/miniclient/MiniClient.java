/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Tobias
 */
public class MiniClient
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter host name: ");
        String host = keyboard.nextLine();
        Socket socket = new Socket(host,1717);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream());
        while(true)
        {
            System.out.println("Enter command: ");
            String cmd = keyboard.nextLine();
            out.writeUTF(cmd);
            String res = in.readUTF();
            System.out.println("Respond: " + res);
            if(res.equalsIgnoreCase("goodbye!"))
            {
                break;
            }
        }
        System.out.println("Client closing...");
    }
    
}
