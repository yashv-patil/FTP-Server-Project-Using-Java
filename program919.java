import java.io.*;
import java.net.*;
import java.util.*;

class program919
{
    public static void main(String[] args) 
    {
        try
        {
            System.out.println("-----------------------------------------------------");
            System.out.println("-------------Marvellous Client Started----------------");
            System.out.println("-----------------------------------------------------");

            Socket socket = new Socket("127.0.0.1",
                                         9000);

            System.out.println("Connection with Server is Successful");
        }
        catch(Exception e)
        {
            System.out.println("Exception Occured:"+e);
        }
    }
}
