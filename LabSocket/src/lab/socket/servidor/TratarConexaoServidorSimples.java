package lab.socket.servidor;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class TratarConexaoServidorSimples implements Runnable {
	
	Socket cliente;
	
	public TratarConexaoServidorSimples(Socket cliente) throws IOException{
		this.cliente = cliente;
	}

	
	public void run() {
		
	    //Lê as informações enviada pelo cliente
	    Scanner s;
		try {
			
			s = new Scanner(cliente.getInputStream());
			while (s.hasNextLine()) {
			      System.out.println(s.nextLine());
			}
			
		    s.close();
		    cliente.close();
		    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	} 

}
