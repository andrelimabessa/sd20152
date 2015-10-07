package comum.servico;

import java.rmi.Remote;
import java.rmi.RemoteException;

import comum.entidade.Entidade;

public interface Gestor extends Remote {

	public String hello(String nome) throws RemoteException;
	
	public Entidade getEntidade() throws RemoteException;
	
}
