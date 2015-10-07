package locadora.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import locadora.entidades.Cliente;
import locadora.entidades.Funcionario;
import locadora.entidades.Pessoa;
import locadora.entidades.enumeration.Cargo;
import locadora.io.EscreverArquivo;
import locadora.io.LerArquivo;


public class PessoaDao {
	
	private final String fileNameRegistrpPesso = "resource/RegistroPessoa.txt";
	private final String tagCliente = "[CLIENTE]";
	private final String tagFuncionario = "[FUNCIONARIO]";
	
	private static PessoaDao instance;
	private Map<Long, Pessoa> storagePessoa;
	private Map<Long, Funcionario> storageFuncionario;
	private Map<Cargo, List<Funcionario>> storageFuncionarioCargo;

	
	public static PessoaDao getInstance() {
		
		if(instance == null){
			instance = new PessoaDao();
		}
		
		return instance;
	}
	
	private PessoaDao() {
		
		storagePessoa = new HashMap<Long, Pessoa> ();
		storageFuncionario = new HashMap<Long, Funcionario>();
		storageFuncionarioCargo = new HashMap<Cargo, List<Funcionario>>();
		
		//Carregar os dados salvos em registro
		obterDadosRegistro();

		
	}
	
	public Pessoa obterPessoaPorID(Long key){
		
		return storagePessoa.get(key);
		
	}
	
	public Pessoa obterFuncionarioPorID(Long key){
		
		return storageFuncionario.get(key);
		
	}
	
	public Collection<Pessoa> obterListaClientes(){
		
		return storagePessoa.values();
		
	}
	
	public Collection<Funcionario> obterListaFuncionarios(){
		
		return storageFuncionario.values();
		
	}
	
	public void adicionarNovoCliente(Long key, Pessoa pessoa){
		
		if(storagePessoa.get(key) == null){
			
			storagePessoa.put(key, pessoa);
			
		}else{
			
			//TODO: implementar tratamento para id repetido
			
		}
	
	}
	
	public void adicionarNovoFuncionario(Long key, Funcionario pessoa){
		
		if(storagePessoa.get(key) == null){
			
			storagePessoa.put(key, pessoa);
			storageFuncionario.put(key, pessoa);
			
			if(storageFuncionarioCargo.get(pessoa.getCargo()) == null){
				
				storageFuncionarioCargo.put(pessoa.getCargo(), new ArrayList<Funcionario>());
				
			}
			
			storageFuncionarioCargo.get(pessoa.getCargo()).add(pessoa);
			
		}else{
			
			//TODO: implementar tratamento para id repetido
			
		}
	
	}
	
	public void salvarPessoaRegistro() {
		
		
		Collection<Pessoa> colecaoPessoa = storagePessoa.values();
		EscreverArquivo escrevendoArquivo;
		try {
			
			escrevendoArquivo = new EscreverArquivo(fileNameRegistrpPesso);		
			
			for(Pessoa pessoa : colecaoPessoa){
				
				if(pessoa instanceof Cliente){
					
					escrevendoArquivo.inserirTag(tagCliente);
					
					Cliente c =(Cliente)pessoa;
					
					escrevendoArquivo.inserirParametro(c.getId().toString());
					escrevendoArquivo.inserirParametro(c.getNome());
					escrevendoArquivo.inserirParametro(c.getEndereco());
					
				}else{
					
					escrevendoArquivo.inserirTag(tagFuncionario);
					
					Funcionario f =(Funcionario)pessoa;
					
					escrevendoArquivo.inserirParametro(f.getId().toString());
					escrevendoArquivo.inserirParametro(f.getNome());
					escrevendoArquivo.inserirParametro(f.getEndereco());
					escrevendoArquivo.inserirParametro(f.getCargaHoraria().toString());
					escrevendoArquivo.inserirParametro(f.getSalario().toString());
				}
			}
			
			escrevendoArquivo.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void obterDadosRegistro (){
		
		LerArquivo lerArquivo;
		try {
			lerArquivo = new LerArquivo(fileNameRegistrpPesso);
			
			Boolean continuarLendo = true;
			String linha;
			
			while(continuarLendo){
				
				linha = lerArquivo.getLinha();
				if(linha != null){
					
					if(linha.equals(tagCliente)){
						
						Cliente cliente = new Cliente();
						
						linha = lerArquivo.getLinha();
						cliente.setId(new Long(linha));
						
						linha = lerArquivo.getLinha();
						cliente.setNome(linha);
						
						linha = lerArquivo.getLinha();
						cliente.setEndereco(linha);
						
						storagePessoa.put(cliente.getId(), cliente);
						
					}else if(linha.equals(tagFuncionario)){
						
						Funcionario funcionario = new Funcionario();
						
						linha = lerArquivo.getLinha();
						funcionario.setId(new Long(linha));
						
						linha = lerArquivo.getLinha();
						funcionario.setNome(linha);
						
						linha = lerArquivo.getLinha();
						funcionario.setEndereco(linha);
						
						linha = lerArquivo.getLinha();
						funcionario.setCargaHoraria(new Integer(linha));
						
						linha = lerArquivo.getLinha();
						funcionario.setSalario(new Integer(linha));
						
						storagePessoa.put(funcionario.getId(), funcionario);
						storageFuncionario.put(funcionario.getId(), funcionario);
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
