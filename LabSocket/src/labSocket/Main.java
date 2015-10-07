package labSocket;

import java.io.IOException;

import lab.socket.cliente.Cliente;
import lab.socket.cliente.ClienteCompleto;
import lab.socket.servidor.Servidor;
import lab.socket.servidor.ServidorThread;


public class Main {

	public static void main(String[] args) throws IOException {
		
		//new Servidor();
		//new ServidorThread();	
		new Cliente();
		//new ClienteCompleto();
	}

}
