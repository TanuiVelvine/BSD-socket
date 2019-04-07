package myserver;
import java.io.*;
import java.net.*;


public class MyServer {

    
    public static void main(String[] args)  throws Exception
       {
            ServerSocket sersock = new ServerSocket(6666);
            System.out.println("ready for chatting");
            Socket sock = sersock.accept();//establishs connection
            
            BufferedReader keyRead =new BufferedReader(new InputStreamReader(System.in));
            OutputStream ostream = sock.getOutputStream();
            
            PrintWriter pwrite = new PrintWriter(ostream, true);
            
            InputStream istream = sock.getInputStream();
            BufferedReader receiveRead =new BufferedReader (new InputStreamReader(istream));
            
            String receiveMessage, sendMessage;
            while(true)
            {
              if((receiveMessage=receiveRead.readLine()) !=null)
              {

            System.out.println("message="+ receiveMessage);
              }
              sendMessage=keyRead.readLine();
              pwrite.println(sendMessage);
              pwrite.flush();
                
            }
        }

}