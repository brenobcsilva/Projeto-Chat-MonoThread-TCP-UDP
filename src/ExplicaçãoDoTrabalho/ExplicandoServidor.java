package ExplicaçãoDoTrabalho;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExplicandoServidor {
    
    /*
    Socket, comunicação por porta, uma porta de canal de comunicação que permite um processo executando num computador, enviar e receber
    de processos que podem ser executadas no mesmo computador ou computado remoto.
    
    Estamos usando o dataStream que são os transportes orientado a conexao com controle de erros, atraves do protoco TCP
    
    Entre os vários protocolos disponíveis para comunicação entre comunicadores em redes, vamos uasr o TCP.
    Ele cria um fluxo entre um computador e outro, no nosso caso entre o servidor e o cliente.
    
    É possivel conectar mais de um cliente a um servidor, usando o metodo accept e colocando para executar com threads,
    mas para esse programa vamos criar somente um cliente por conexao.
    
    Ao usar um programa em um computador cliente, precisamos do ip do servidor e a porta informando para identificar o
    programa, podemos definir tambem uma quantidade de clientes que podem conectar nesse servidor.
    
    A classe Socket(Objeto que representa uma conexao de rede) trabalha como um canal de comunicação bidirecional, mas no nosso caso
    somente o servidor iniciara a conexao
    
    O cliente recebe a conexao do cliente na porta informada e transferi esse cliente para outra porta 
    deixando a porta disponivel para outros clientes conectarem, isso quando o programa permite mais de uma conexao por vez
    
    Ou seja, ao chamar o metodo accept da classe ServerSocket, isso significa que a porta estava fechada e foi aberta.
    
    Ao executar o programa no computador servidor, ele na verdade abri a porta e so bloqueia quando algum cliente conecta.

    Esse processo de deixar a porta disponivel para um cliente, precisa ser feito dentro de um try-catch(tratamento de excecao)
    pois um dos erros é quando o servidor que ja está conectado e tenta conectar novamente usando a mesma porta.
   
    Quando o servidor inicializar o objeto ServerSocket será inicializado com a porta expecificada e para no accept
    
    A variavel ObjcteOutputStream executa o envio de mensagem do servidor e a variavel ObjecteInputStream recebe as mesnagens enviadas pelo clientes.
    
    ListenerSocket é o ouvinte do servidor, inicializa os objetos input e output que passam a ser exclusivamente dos objetos
    que se conectou, depois dessa conexao, ele libera a porta para receber um novo cliente
    
    Classe serverSocket,o servidor fica disponivel para os clientes, é responsavel por esperar a conexao com o cliente, esse classe possui
    um construtor onde digitamos a porta que para escutar a conexao.
    
    ServerSocket server = new ServerSocket(NumeroDaPorta)
    
    Serializacao: é pegar um objeto e fazer um fluxo, passar por um canal de dados, fz um stream de objetos para um arquivos
    
    .   Socket: Cria um novo descritor para conexao
    .   Write:  Escreve dados em uma conexao
    .   Read:   lê dados de uma conexao
    .   Closed: Fecha a conexao
    .   Bind:   Atribui um endereco ip e uma porta a um socket
    .   Listen: Coloca o socket para escutar a porta
    .   Accept: Bloqueia o servidor ate a chegada de uma conexao
    
    O metodo getHostName retorna o nome da maquina e o metodo getInetAddress pega o ip do cliente
    */
    
    
    
    public static void main(String[] args) {
        
        try {
            //Criando o servidor
            ServerSocket server = new ServerSocket(6000,2);
            //O numero da porta é usado pelos clientes para localizar o aplicativo no servidor
            //Se a fila estiver cheia o servidor recusará a conexao com o cliente
            //Para esse programa, somente um aplicativo por vez pode se conectar
            //Existem 65.535 portas de comunicação, mas podemos usar a partir da porta 1.025
            //O programa percebe a conexao de um cliente atraves do metodo accept
            
            //Ao conectar usando uma porta que ja está conectada ou usar uma porta invalida, ocorre a excecao BindException
            
            Socket connection = server.accept();
            
            /*Para o servidor comunicar com o cliente, primeiro precisa instanciar as classes ObjectInputStream(O servidor envia informações para o cliente)
            e ObjectOutputStream(o servidor recebe informações do cliente), para enviar e receber bytes 
            */
            
            
        } catch (IOException ex) {
            Logger.getLogger(ExplicandoServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }
    
}
