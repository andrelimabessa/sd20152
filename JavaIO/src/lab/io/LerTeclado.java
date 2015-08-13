package lab.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LerTeclado {

	InputStream inputStream;
	InputStreamReader inputStreamReader;
	BufferedReader bufferedReader;
	
	public LerTeclado() throws IOException {

		//Ler cadeia de bytes de um teclado
		inputStream = System.in;
		
		//Converte para Char
		inputStreamReader = new InputStreamReader(inputStream);
		
		//Conctena o conjunto de Char em uma String
		bufferedReader = new BufferedReader(inputStreamReader);
		
	
	}
	
	public String lerLinha() throws IOException{
		
		//Lê uma linha
		String line = bufferedReader.readLine();
		return line;
	}
	
	public void close() throws IOException{

		//Close
		bufferedReader.close();

	}

}
