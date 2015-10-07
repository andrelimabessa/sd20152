package locadora.entidades;

import java.util.Date;

public class Registro {
	
	private Integer id;
	
	private Filme filmeLocado;
	
	private Cliente cliente;

	private Funcionario Funcionario;
		

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Filme getFilmeLocado() {
		return filmeLocado;
	}

	public void setFilmeLocado(Filme filmeLocado) {
		this.filmeLocado = filmeLocado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionario() {
		return Funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		Funcionario = funcionario;
	}
	
}
