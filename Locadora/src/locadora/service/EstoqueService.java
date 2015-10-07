package locadora.service;

import java.util.Collection;


import locadora.dao.EstoqueFilmeDao;
import locadora.entidades.Estoque;
import locadora.entidades.Filme;


public class EstoqueService {
	
	private EstoqueFilmeDao estoqueFilmeDao;
	
	public EstoqueService() {
		
		estoqueFilmeDao = EstoqueFilmeDao.getInstance();

	}
	
	public Estoque adicionarNovoFilme(Filme filme, Integer quantidade){
		
		Estoque estoque = new Estoque();
		
		estoque.setFilme(filme);
		estoque.setDisponibilidade(quantidade);
		estoque.setQuantidade(quantidade);
		
		estoque = estoqueFilmeDao.adicionarNovoFilme(estoque);
		
		return estoque;
	}
	
	public Collection<Estoque> obterFilmes(){
		return estoqueFilmeDao.obterTodosFilmes();
	}

	public void exportarRegistro(){
		
		estoqueFilmeDao.salvarRegistro();
		
	}
}
