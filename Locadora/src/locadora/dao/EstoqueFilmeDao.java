package locadora.dao;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import locadora.entidades.Estoque;
import locadora.entidades.Filme;
import locadora.io.EscreverArquivo;
import locadora.io.LerArquivo;


public class EstoqueFilmeDao {

	private final String fileNameEstoqueFilme = "resource/EstoqueLocadora.txt";
	private final String tagFilme = "[Filme]";
	
	private static EstoqueFilmeDao instance ;
	private Map<Integer, Estoque> storageFilme;
	private Integer filmeKey;
	
	public static EstoqueFilmeDao getInstance(){
		
		if(instance == null){
			instance = new EstoqueFilmeDao();
		}
		
		return instance;
	}
	
	private EstoqueFilmeDao() {
		
		storageFilme = new HashMap<Integer, Estoque> ();
		filmeKey = 0;
	
		//Carregar os dados salvos em registro
		obterEstoque();

	}
	
	public Filme obterFilmePorID(Integer key){
		
		if(storageFilme.get(key) != null){
		
			return storageFilme.get(key).getFilme();
			
		}
		
		return null;
	}
	
	public Estoque adicionarNovoFilme(Estoque estoque){

		estoque.getFilme().setId(filmeKey);
		storageFilme.put(filmeKey, estoque);
		
		filmeKey++;
		
		return estoque;

	}
	
	public Collection<Estoque> obterTodosFilmes(){
		return storageFilme.values();
	}
	
	public void salvarRegistro(){
		
		Collection<Estoque> colecaoEstoque = storageFilme.values();
		EscreverArquivo escrevendoArquivo;
		try {
			
			escrevendoArquivo = new EscreverArquivo(fileNameEstoqueFilme);
			
			for(Estoque item : colecaoEstoque){
					
				escrevendoArquivo.inserirTag(tagFilme);

				escrevendoArquivo.inserirParametro(item.getFilme().getId().toString());
				escrevendoArquivo.inserirParametro(item.getFilme().getNome());
				escrevendoArquivo.inserirParametro(item.getFilme().getAno().toString());
				escrevendoArquivo.inserirParametro(item.getFilme().getCensura().toString());
				escrevendoArquivo.inserirParametro(item.getQuantidade().toString());
				escrevendoArquivo.inserirParametro(item.getDisponibilidade().toString());

			}
		
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		
	}
	
	public void obterEstoque(){
		
		try {
			
			LerArquivo lerArquivo = new LerArquivo(fileNameEstoqueFilme);
			
			Boolean continuarLendo = true;
			String linha;
			
			while(continuarLendo){
				
				linha = lerArquivo.getLinha();
				if(linha != null){
					
					if(linha.equals(tagFilme)){
						
						Filme filme = new Filme(); 
						Estoque estoque = new Estoque();
						
						linha = lerArquivo.getLinha();
						filme.setId(new Integer(linha));
						
						linha = lerArquivo.getLinha();
						filme.setNome(linha);
						
						linha = lerArquivo.getLinha();
						filme.setAno(new Integer(linha));
						
						linha = lerArquivo.getLinha();
						filme.setCensura(new Integer(linha));
						
						linha = lerArquivo.getLinha();
						estoque.setQuantidade(new Integer(linha));
						
						linha = lerArquivo.getLinha();
						estoque.setDisponibilidade(new Integer(linha));
						
						estoque.setFilme(filme);
						storageFilme.put(filme.getId(), estoque);
						
					}
					
				}else{
					continuarLendo = false;
				}
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
