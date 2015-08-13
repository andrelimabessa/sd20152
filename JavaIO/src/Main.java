import java.io.IOException;

import lab.io.EscreverArquivo;
import lab.io.LerTeclado;


public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		LerTeclado lerTeclado = new LerTeclado();
		
		String linha = lerTeclado.lerLinha();
		
		lerTeclado.close();
		
		new EscreverArquivo();
	}

}
