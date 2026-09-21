import java.io.*;
import java.net.*;
import java.util.*;

class program927
{

    public static int ClientCount = 1;
    public static void main(String[] args) 
    {
        try
        {
            ServerSocket serversocket = new ServerSocket(9000);
            
            System.out.println("-----------------------------------------------------");
            System.out.println("-------------Marvellous Server Started----------------");
            System.out.println("-----------------------------------------------------");

            while (true) 
            {
                System.out.println("Server is Waiting for Client request");

                Socket clientsocket = serversocket.accept();

                System.out.println("Client Connected Successfully");

                Thread t = new Thread(() -> HandleClientRequest(clientsocket));

                t.start();
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception Occured:"+e);
        }
    }

    public static void HandleClientRequest(Socket socket)
    {
        System.out.println("New Thread is Created for Client"+ClientCount);
        ClientCount++;

        try
        {
            DataInputStream dis = new DataInputStream(socket.getInputStream());

            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            dos.writeUTF("Connected to Marevellous Server");

            while (true) 
            {
                // Read Command from Client
                String command = dis.readUTF();

                System.out.println("Command received for Client:"+command);

                command = command.trim();

                if(command.length() == 0)
                {
                    dos.writeUTF("Please enter a valid command");
                    continue;
                }

                String parts[] = command.split("\\s+");

                String operation = parts[0].toUpperCase();

                if(operation.equals("QUIT"))
                {
                    if(parts.length != 1)
                    {
                        dos.writeUTF("Usage : QUIT");
                        continue;
                    }

                    dos.writeUTF("Client Disconnected Successfully");

                    ClientCount--;
                    
                    break;
                }
                else if(operation.equals("GET"))
                {
                    if(parts.length != 2)
                    {
                        dos.writeUTF("Usage : GET <FileName>");
                        continue;
                    }
                }
                else if(operation.equals("PUT"))
                {
                    if(parts.length != 2)
                    {
                        dos.writeUTF("Usage : PUT <FileName>");
                        continue;
                    }
                }
                else if(operation.equals("INFO"))
                {
                    if(parts.length != 2)
                    {
                        dos.writeUTF("Usage : INFO <FileName>");
                        continue;
                    }
                }
                else if(operation.equals("SIZE"))
                {
                    if(parts.length != 2)
                    {
                        dos.writeUTF("Usage : SIZE <FileName>");
                        continue;
                    }
                }
                else if(operation.equals("EXISTS"))
                {
                    if(parts.length != 2)
                    {
                        dos.writeUTF("Usage : EXISTS <FileName>");
                        continue;
                    }
                }
                else if(operation.equals("RENAME"))
                {
                    if(parts.length != 3)
                    {
                        dos.writeUTF("Usage : RENAME <OldFileName> <NewFileName>");
                        continue;
                    }
                }
                else if(operation.equals("DELETE"))
                {
                    if(parts.length != 2)
                    {
                        dos.writeUTF("Usage : DELETE <FileName>");
                        continue;
                    }
                }
                else if(operation.equals("LIST"))
                {
                    if(parts.length != 1)
                    {
                        dos.writeUTF("Usage : LIST");
                        continue;
                    }
                }
                else
                {
                    dos.writeUTF("Invalid Operation");
                }

            }

            dis.close();
            dos.close();
            socket.close();

        }
        catch(Exception e)
        {
            System.out.println("Exception Occured:"+e);
        }
    }
}