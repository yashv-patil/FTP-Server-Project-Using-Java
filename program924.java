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

            while (true) 
            {
                String command = dis.readUTF();

                System.out.println("Command received for Client:"+command);

                String parts[] = command.split(" ");

                String operation = parts[0].toUpperCase();

                if(operation.equals("QUIT"))
                {
                    dos.writeUTF("Disconneced from Server");

                    break;
                }


                if(parts.length != 3)
                {
                    dos.writeUTF("Invalid command format");

                    continue;
                }

                double no1 = Double.parseDouble(parts[0]);
                double no2 = Double.parseDouble(parts[2]);

                double result  = 0.0;

                if(operation.equals("ADD"))
                {
                    result = no1 + no2;

                    dos.writeUTF("Result is :"+result);
                }
                else
                {
                    dos.writeUTF("Invalid Input");
                }
            }// End of while 
        }
        catch(Exception e)
        {
            System.out.println("Exception Occured:"+e);
        }
    }
}
