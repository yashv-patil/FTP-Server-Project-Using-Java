import java.io.*;
import java.net.*;
import java.util.*;

class program918 
{
    public static void main(String[] args) 
    {
        try
        {
            ServerSocket serversocket = new ServerSocket(9000);
            System.out.println("-----------------------------------------------------");
            System.out.println("-------------Marvellous Server Started----------------");
            System.out.println("-----------------------------------------------------");

            System.out.println("Server is Waiting for Client request");

            Socket clientsocket = serversocket.accept();

            System.out.println("Client Connected Successfully");
        }
        catch(Exception e)
        {
            System.out.println("Exception Occured:"+e);
        }
    }
}
