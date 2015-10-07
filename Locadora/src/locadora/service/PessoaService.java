package locadora.service;

import java.util.Collection;

import locadora.dao.PessoaDao;
import locadora.entidades.Cliente;
import locadora.entidades.Funcionario;
import locadora.entidades.Pessoa;


public class PessoaService {
	
	private PessoaDao pessoaStorage;
	
	public PessoaService() {
		
		pessoaStorage = PessoaDao.getInstance();
		
	}
	
	public void adicionarNovoCliente(Cliente cliente){
		
		pessoaStorage.adicionarNovoCliente(cliente.getId(), cliente);
		
	}
	
	public void adicionarNovoFucionario(Pessoa funcionario){
		
		pessoaStorage.adicionarNovoFuncionario(((Funcionario)funcionario).getId(), ((Funcionario)funcionario));

	}
	
	public Collection<Pessoa> oberterTodosClientes(){
		return pessoaStorage.obterListaClientes();
	}

	public Collection<Funcionario> oberterTodosFuncionarios(){
		return pessoaStorage.obterListaFuncionarios();
	}
	
	public void exportarRegistro(){
		
		pessoaStorage.salvarPessoaRegistro();
		
	}
}
