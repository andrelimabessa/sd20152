package locadora.entidades;

public class Filme {

	private Integer id;
	
	private String nome;
	
	private Integer ano;
		
	private Integer censura;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Integer getCensura() {
		return censura;
	}

	public void setCensura(Integer censura) {
		this.censura = censura;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
