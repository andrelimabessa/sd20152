package lab.io;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class EscreverArquivo {

	public EscreverArquivo() throws IOException {
		
		//Abri arquivo para escrever cadeia de bytes
		OutputStream outputStream = new FileOutputStream("teste");
		//Converte de Char para Byte
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter
		(outputStream);
		//Receber String e converte em cadeia de Char
		BufferedWriter bufferedWriter = new BufferedWriter
		(outputStreamWriter);
		
		//Escreve uma linha no arquivo e move o cursor do arquivo uma linha para baixo
		bufferedWriter.write("teste arquivo");
		bufferedWriter.newLine();
		//Força enviar cadeia de Char para arquivo físico e fecha arquivo
		bufferedWriter.flush();
		bufferedWriter.close();
		
	}

}
