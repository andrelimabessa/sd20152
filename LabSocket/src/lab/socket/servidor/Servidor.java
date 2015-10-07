package lab.socket.servidor;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Servidor {

  public Servidor() throws IOException {

	//Cria o servidor  
    ServerSocket servidor = new ServerSocket(12345);
    System.out.println("Porta 12345 aberta!");

    //Espera um cliente se conectar e imprime o seu IP
    Socket cliente = servidor.accept();
    System.out.println("Nova conexão com o cliente: " +   
      cliente.getInetAddress().getHostAddress()
    );

    //Lê as informações enviada pelo cliente
    Scanner s = new Scanner(cliente.getInputStream());
    while (s.hasNextLine()) {
      System.out.println(s.nextLine());
    }
    
    //Fecha a conexão
    System.out.println("Conclui a conexão");
    s.close();
    servidor.close();
    cliente.close();
    
  }

}