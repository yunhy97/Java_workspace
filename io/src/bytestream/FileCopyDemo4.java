package bytestream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyDemo4 {

	public static void main(String[] args) throws IOException{
		System.out.println("파일 복사를 시작합니다.");
		long startTime = System.currentTimeMillis();
		
		FileInputStream fis = new FileInputStream("c:/files/03.TortoiseGit-2.8.0.0-64bit.msi");
		FileOutputStream fos = new FileOutputStream("c:/files/03.TortoiseGit-copy.zmsi");
		
		int value = 0;
		while((value = fis.read()) != -1) {
			fos.write(value);
			
		}
		fis.close();
		fos.close();
		long endTime = System.currentTimeMillis();
		System.out.println("파일 복사가 종료합니다.");
		System.out.println("소요시간: " + (endTime - startTime)/10000 + "초");

	}
}
