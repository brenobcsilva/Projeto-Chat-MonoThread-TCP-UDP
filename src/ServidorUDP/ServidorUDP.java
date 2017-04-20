package ServidorUDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServidorUDP {

    public static void main(String[] args) {
        try {
            DatagramSocket server = new DatagramSocket();
            byte[] receptor = new byte[1024];
            
            DatagramPacket bufferRecebimento = new DatagramPacket(receptor, receptor.length);
            server.receive(bufferRecebimento);
            
            String msg = new String(bufferRecebimento.getData());
            System.out.println(msg);
            
            DatagramPacket bufferEnvio = new DatagramPacket(receptor, receptor.length, 
                bufferRecebimento.getAddress(), bufferRecebimento.getPort());
            server.send(bufferEnvio);
            server.close();
            
        } catch (Exception e) {
        }
    }
    
}
