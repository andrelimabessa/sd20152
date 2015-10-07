package locadora.entidades.enumeration;

public enum Cargo {

	GERENTE(1,"Gerente"),
	ASSISTENTE(2,"Assistente");
	
	private Integer id;
	private String desc;
	
	private Cargo(Integer id, String desc) {
		this.id = id;
		this.desc = desc;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
