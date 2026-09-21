import java.io.*;
import java.net.*;
import java.util.*;

class program919
{
    public static void main(String[] args) 
    {
        Scanner sobj = new Scanner(System.in);

        try
        {
            System.out.println("-----------------------------------------------------");
            System.out.println("-------------Marvellous Client Started----------------");
            System.out.println("-----------------------------------------------------");

            Socket socket = new Socket("127.0.0.1",
                                         9000);

            System.out.println("Connection with Server is Successful");

            DataInputStream dis = new DataInputStream(socket.getInputStream());

            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            System.out.println(dis.readUTF());

            while (true) 
            {
                System.out.println("-----------------------------------------------------");
                System.out.println("Matamatical Commands");
                System.out.println("-----------------------------------------------------");

                System.out.println("Enter Commmand");

                String command = sobj.nextLine();

                dos.writeUTF(command);

                String responce = dis.readUTF();

                System.out.println(responce);
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception Occured:"+e);
        }
    }// End of main
}// End of class
