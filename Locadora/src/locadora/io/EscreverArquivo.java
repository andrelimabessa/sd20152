package locadora.io;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class EscreverArquivo {

	private DataOutputStream dataOutputStream;
	private File inFile;
	
	public EscreverArquivo(String nomeArquivo) throws IOException{
		
		inFile = new File(nomeArquivo);

		dataOutputStream = new DataOutputStream(new FileOutputStream(inFile, true));

		close();
	}
	
	public void inserirTag(String tag) throws IOException{
		
		dataOutputStream = new DataOutputStream(new FileOutputStream(inFile, true));
		
		dataOutputStream.writeBytes(tag+"\n");
	
		close();
	}
	
	public void inserirParametro(String parametro) throws IOException{
		
		dataOutputStream = new DataOutputStream(new FileOutputStream(inFile, true));
		
		dataOutputStream.writeBytes(parametro + "\n");
		
		close();
		
	}
		
	public void close() throws IOException{
		dataOutputStream.flush();
		dataOutputStream.close();
	}
}
