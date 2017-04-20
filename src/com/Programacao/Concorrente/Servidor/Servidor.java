package com.Programacao.Concorrente.Servidor;
   
  import java.io.IOException;
  import java.net.ServerSocket;
  import java.net.Socket;
  import java.util.Scanner;
  import java.util.logging.Level;
  import java.util.logging.Logger;
   
  public class Servidor {
      
       Scanner entrada;
       
      public static void main(String args[])throws IOException{
          
          Scanner entrada;
          
          try {
              ServerSocket server = new ServerSocket(9020);                       
              System.out.println("Servidor iniciado na porta 3322");
              
              while(true){
              Socket cliente = server.accept();
              //new Thread(new EscutaCliente(cliente)).start();
              //System.out.println("Cliente conectado do IP "+cliente.getInetAddress().getHostName());
              //  /*getHostAddress()*/);
              //   System.out.println(cliente.);
              //Nesse momento o SocketServer bloqueia esperando a conexao com o cliente
              entrada = new Scanner(cliente.getInputStream());
              while(entrada.hasNextLine()){
                  System.out.println(entrada.nextLine());
              }
              
              
              entrada.close();
              //server.close();
              }
          } catch (IOException ex) {
              Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
          }
          
      }
      
     /* public class EscutaCliente implements Runnable{

          public EscutaCliente(Socket cliente){
              
              try {
                  entrada = new Scanner(cliente.getInputStream());
              } catch (IOException ex) {
                  Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
              }
             
              
          }
          
       /* @Override
        public void run() {
            
            String texto;
            while((texto = entrada.nextLine()) != null){
                System.out.println("Recebeu " + texto);
            }
            
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }*/
      
  }

  