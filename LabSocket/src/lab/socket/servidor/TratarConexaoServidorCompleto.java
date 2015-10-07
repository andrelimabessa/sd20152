package lab.socket.servidor;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class TratarConexaoServidorCompleto implements Runnable {
	
	Socket cliente;
	PrintStream clientePrintStrem;
	
	public TratarConexaoServidorCompleto(Socket cliente) throws IOException{
		this.cliente = cliente;
		clientePrintStrem = new PrintStream(cliente.getOutputStream());
	}

	
	public void run() {
		
	    //Lê as informações enviada pelo cliente
	    Scanner s;
		try {
			
			s = new Scanner(cliente.getInputStream());
			while (s.hasNextLine()) {
			      System.out.println(s.nextLine());
			      clientePrintStrem.println("Mensagem Recebida");
			}
			
		    s.close();
		    cliente.close();
		    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	} 

}
