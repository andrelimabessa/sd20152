package lab.socket.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServidorThread {

	  public ServidorThread() throws IOException {

			//Cria o servidor  
		    ServerSocket servidor = new ServerSocket(12345);
		    System.out.println("Porta 12345 aberta!");

		    while (true) {

			      //Espera um cliente se conectar e imprime o seu IP	
		    	  Socket cliente = servidor.accept();
		    	    System.out.println("Nova conexão com o cliente: " +   
		    	      cliente.getInetAddress().getHostAddress()
		    	    );
		    	  
		    	  // cria um objeto que vai tratar a conexão
		    	  TratarConexaoServidorSimples tratamento = new TratarConexaoServidorSimples(cliente);

		    	  // cria a thread em cima deste objeto
		    	  Thread t = new Thread(tratamento);

		    	  // inicia a thread
		    	  t.start();

		   }

	  }
	  
}
