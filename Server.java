import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{
    public static void main(String[] args){
        try{
            //Empty Server Socket
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server started at port 8080");

            //Binding a socket to Socket Address
            //serverSocket.bind(new InetSocketAddress(hostname:"localhost", port:8080));

            //Client connection acceptance
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client Connected: " + clientSocket.getInetAddress().getHostAddress());

            //Reading from the client
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String clientMessage = in.readLine();
            System.out.println("Message from Client: " + clientMessage);

            //Send data to the client
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(),true);
            output.println("Hello from Server!");

            //Close the connection
            clientSocket.close();
            serverSocket.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        

    }
    
}