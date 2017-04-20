package ServidorUDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClienteUdp {

public static void main(String[] args) {

        String mensagem = "Qual o ip do servidor: ";
        byte[] data = mensagem.getBytes();
        int porta = 12345;
        String ip = "255.255.255.255";
        try {
            DatagramSocket cliente = new DatagramSocket(12345);
            InetAddress ina = InetAddress.getByName(ip);
            DatagramPacket enviando = new DatagramPacket(data,data.length, ina, porta);
            cliente.send(enviando);

            byte[] receive = new byte[1024];
            DatagramPacket recebendo = new DatagramPacket(receive, receive.length, ina, porta);
            cliente.receive(recebendo);

            String ipServidor = recebendo.getAddress().toString();
            System.out.println("Mostrando o ip do servidor: " + ipServidor);

            cliente.close();
            } catch (Exception e) {
        }
    }
}
