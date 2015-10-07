package comum.entidade;

import java.io.Serializable;

public class Entidade implements Serializable{
	
	String text = "Ola Entidade";

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
