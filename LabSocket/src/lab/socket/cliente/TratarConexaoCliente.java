package lab.socket.cliente;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class TratarConexaoCliente implements Runnable {

	Socket servidor;
	
	public TratarConexaoCliente(Socket servidor){
		this.servidor = servidor;
	}
	
	
	public void run() {
		
		try {
			
			Scanner s = new Scanner(servidor.getInputStream());
		    while (s.hasNextLine()) {
		        System.out.println(s.nextLine());
		    }
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
