package comum.servico;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import comum.entidade.Entidade;

public class GestorImpl extends UnicastRemoteObject implements Gestor{

	public GestorImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 7081203609115456698L;

	@Override
	public String hello(String nome) throws RemoteException {
		// TODO Auto-generated method stub
		return "Ola mundo";
	}

	@Override
	public Entidade getEntidade() throws RemoteException {
		return new Entidade();
	}

}
