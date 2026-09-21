import java.io.*;
import java.net.*;
import java.util.*;

class program929
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
                System.out.println("FTP Commands");
                System.out.println("-----------------------------------------------------");

                System.out.println("LIST");
                System.out.println("EXISTS <FileName>");
                System.out.println("INFO <FileName>");
                System.out.println("SIZE <FileName>");
                System.out.println("GET <FileName>");
                System.out.println("PUT <FileName>");
                System.out.println("DELETE <FileName>");
                System.out.println("RENAME <OldFileName> <NewFileName>");
                System.out.println("QUIT");
                

                System.out.println("Enter Commmand");

                // RENAME Demo.txt DemoX.txt
                String command = sobj.nextLine();

                String parts[] = command.split(" ");

                String operation = parts[0].toUpperCase();

                if(operation.equals("GET"))
                {
                    if(parts.length != 2)
                    {
                        System.out.println("Usage : GET <FileName>");
                        continue;
                    }

                    dos.writeUTF(command);
                }
                else if(operation.equals("PUT"))
                {
                    if(parts.length != 2)
                    {
                        System.out.println("Usage : PUT <FileName>");
                        continue;
                    }

                    dos.writeUTF(command);
                }
                //Done
                else if(operation.equals("INFO"))
                {
                    if(parts.length != 2)
                    {
                        System.out.println("Usage : INFO <FileName>");
                        continue;
                    }

                    dos.writeUTF(command);

                    String response = dis.readUTF();

                                        System.out.println("-----------------------------------------------------");
                    System.out.println("File Informataion is :");
                    System.out.println(response);
                    System.out.println("-----------------------------------------------------");
                }
                //Done
                else if(operation.equals("SIZE"))
                {
                    if(parts.length != 2)
                    {
                        System.out.println("Usage : SIZE <FileName>");
                        continue;
                    }

                    dos.writeUTF(command);

                    System.out.println("-----------------------------------------------------");
                    String response = dis.readUTF();
                    System.out.println(response);
                    System.out.println("-----------------------------------------------------");

                }
                else if(operation.equals("EXISTS"))
                {
                    if(parts.length != 2)
                    {
                        System.out.println("Usage : EXISTS <FileName>");
                        continue;
                    }

                    dos.writeUTF(command);
                }
                //Done
                else if(operation.equals("DELETE"))
                {
                    if(parts.length != 2)
                    {
                        System.out.println("Usage : DELETE <FileName>");
                        continue;
                    }

                    dos.writeUTF(command);

                    System.out.println("-----------------------------------------------------");
                    String response = dis.readUTF();
                    System.out.println(response);
                    System.out.println("-----------------------------------------------------");
                }
                else if(operation.equals("RENAME"))
                {
                    if(parts.length != 3)
                    {
                        System.out.println("Usage : RENAME <OldFileName> <NewFileName>");
                        continue;
                    }

                    dos.writeUTF(command);
                }
                else if(operation.equals("LIST"))
                {
                    if(parts.length != 1)
                    {
                        System.out.println("Usage : LIST");
                        continue;
                    }

                    dos.writeUTF(command);

                    System.out.println("-----------------------------------------------------");
                    String response = dis.readUTF();

                    System.out.println("Files Presnet on server are:");
                    System.out.println(response);
                    System.out.println("-----------------------------------------------------");
                }
                // Dne 
                else if(operation.equals("QUIT"))
                {
                    if(parts.length != 1)
                    {
                        System.out.println("Usage : QUIT");
                        continue;
                    }

                    System.out.println("Thank You for Using MArvellous FTP Server");

                    dos.writeUTF(command);

                    String response = dis.readUTF();

                    System.out.println(response);

                    break;
                }
                else
                {
                    System.out.println("There is no such command");
                    continue;
                }
            } // ENd of While
;
            socket.close();
            sobj.close();
            dis.close();
            dos.close();
        }
        catch(Exception e)
        {
            System.out.println("Exception Occured:"+e);
        }
    }// End of main
}// End of class
