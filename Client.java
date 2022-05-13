import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {

		int port = 2000;
		InetAddress serverAddress;
		DatagramSocket dSocket;
		DatagramPacket outPkt;
		DatagramPacket inPkt;
		
		byte[] buffer;
		String message="<c> data e ora";
		String response;
		
		
		try {
			serverAddress = InetAddress.getLocalHost();
			
			System.out.println("<c> Indirizzo server trovato!");
			dSocket = new DatagramSocket();
			
			outPkt = new DatagramPacket(message.getBytes(), message.length(), serverAddress, port);
			
			dSocket.send(outPkt);
			
			buffer = new byte[256];
			inPkt = new DatagramPacket(buffer, buffer.length);
			
			dSocket.receive(inPkt);
			
			response = new String(inPkt.getData(), 0, inPkt.getLength());
			
			System.out.println("<c> Connessione stabilita!");
			System.out.println("<c> Data e ora del server: " + response);
			System.out.println("<c> Connessione chiusa!");
			
			dSocket.close();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
				
	}

}