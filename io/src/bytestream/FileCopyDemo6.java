package bytestream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

public class FileCopyDemo6 {

	public static void main(String[] args) throws IOException{
		
		FileInputStream fis = new FileInputStream("c:/files/03.TortoiseGit-2.8.0.0-64bit.msi");
		FileOutputStream fos = new FileOutputStream("c:/files/03.TortoiseGit-copy2.msi");
		
		IOUtils.copy(fis, fos);
	}
}
