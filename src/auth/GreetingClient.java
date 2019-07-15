package auth;

// File Name GreetingClient.java
import Callee.PCS_RTP_Callee;
import java.net.*;
import java.io.*;

public class GreetingClient
{
	public static int port;
	public static int localRtpPorts;
	public static void main(String [] args)
   {
      String serverName = Shootmetest.localIP;
      
      port = 51982;
      try
      {
         System.out.println("Connecting to " + serverName
                             + " on port " + port);
         Socket client = new Socket(serverName, port);
         
         localRtpPorts = client.getLocalPort();
         System.out.println("localport" + serverName
                 + " on port " +localRtpPorts);
         
         System.out.println("Just connected to "
                      + client.getRemoteSocketAddress());
         
         OutputStream outToServer = client.getOutputStream();
         DataOutputStream out =
                       new DataOutputStream(outToServer);

         out.writeUTF("Hello from "
                      + client.getLocalSocketAddress());
         InputStream inFromServer = client.getInputStream();
         DataInputStream in =
                        new DataInputStream(inFromServer);
         System.out.println("Server says " + in.readUTF());
        // client.close();
      //   new PCS_RTP_Callee().main2();
      }catch(IOException e)
      {
         e.printStackTrace();
      }
   }
}