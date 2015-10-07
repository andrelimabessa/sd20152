package locadora.io;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class LerArquivo {

	private File inFile;
	BufferedReader bufferedReader;
	
	public LerArquivo(String nomeArquivo) throws IOException {
		
		inFile = new File(nomeArquivo);

		bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(inFile)));
	}
	
	public String getLinha() throws IOException{
		return bufferedReader.readLine();
	}
	
	public void close() throws IOException{
		bufferedReader.close();
	}
}
