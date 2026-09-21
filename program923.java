import java.io.*;
import java.net.*;
import java.util.*;

class program921
{
    public static void main(String[] args) 
    {
        try
        {
            ServerSocket serversocket = new ServerSocket(9000);
            System.out.println("-----------------------------------------------------");
            System.out.println("-------------Marvellous Server Started----------------");
            System.out.println("-----------------------------------------------------");

            //loop for multiple client request
            while (true) 
            {
                System.out.println("Server is Waiting for Client request");

                Socket clientsocket = serversocket.accept();

                System.out.println("Client Connected Successfully");

                // Thread gets Created for Client
                Thread t = new Thread(() -> HandleClientRequest(clientsocket));

                t.start();
            }// end of while

        }
        catch(Exception e)
        {
            System.out.println("Exception Occured:"+e);
        }

    }

    public static void HandleClientRequest(Socket socket)
    {
        try
        {
            DataInputStream dis = new DataInputStream(socket.getInputStream());

            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            dos.writeUTF("Connected to Marevellous Server");
        }
        catch(Exception e)
        {
            System.out.println("Exception Occured:"+e);
        }
    }
}
