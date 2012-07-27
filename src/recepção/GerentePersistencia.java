package recep��o;

import java.io.FileInputStream; 
import java.io.FileOutputStream; 
import java.io.IOException; 
import java.io.ObjectInputStream; 
import java.io.ObjectOutputStream; 
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;


public class GerentePersistencia implements Serializable {
	
private static Persistencia instance= null;

public  GerentePersistencia(){ }


//singleton 

public static Persistencia getInstance() {
	if(instance == null) {
      // "lazy instantiation"
      instance = new Persistencia();
    }
    return instance;
}

	
public static void persistir() {
		
		FileOutputStream f = null;
		ObjectOutputStream stream = null;
		
		try {
			f = new FileOutputStream("dados.bin");
			stream = new ObjectOutputStream(f);
			stream.writeObject(instance);
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			if (f != null) {
				try {
					f.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (stream != null) {
				try {
					stream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

public static void recuperar() {
	
	FileInputStream fis = null; 
	ObjectInputStream stream = null; 
	try { 
		fis = new FileInputStream("dados.bin"); 
		stream = new ObjectInputStream(fis); 
		instance = (Persistencia) stream.readObject(); 
		}catch (Exception e) { 

				e.printStackTrace(); 
		} finally { 

			if (fis != null) { 
				try { 
					fis.close(); 
				} catch (IOException e) { 

					e.printStackTrace(); 
				} 
			} 

		if (stream != null) { 
			try { 
				stream.close(); 
			} catch (IOException e) { 
				e.printStackTrace(); 
			} 
		} 
	} 
  }

public static void apagarConteudoArquivo() throws IOException{
	  // uma inst�ncia de RandomAccessFile para leitura e escrita
      RandomAccessFile arquivo = new RandomAccessFile("dados.bin", "rw");
      //excluir todo o conte�do do arquivo
      arquivo.setLength(0);
      arquivo.close();    
}
}
