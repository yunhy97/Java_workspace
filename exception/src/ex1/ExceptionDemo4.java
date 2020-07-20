package ex1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class ExceptionDemo4 {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://imgnews.naver.net/image/5129/2015/07/22/1437522693_947221_99_20150722085409.jpg");
			InputStream in = url.openStream();
			
			FileOutputStream out = new FileOutputStream("c:/files/star.png");
			
			byte[] buf = new byte[1024];
			int len = 0;
			while((len=in.read(buf)) != -1) {
				out.write(buf, 0, len);	
			}
			out.close();
			
		} catch (MalformedURLException e) {
			String errorMessage = e.getMessage();
			System.out.println("에러 메세지 : " + errorMessage);
			//e.printStackTrace();
		} catch (FileNotFoundException e) {
			String errorMessage = e.getMessage();
			System.out.println("에러 메세지 : " + errorMessage);
			//e.printStackTrace();
		} catch (IOException e) {
			String errorMessage = e.getMessage();
			System.out.println("에러 메세지 : " + errorMessage);
			//e.printStackTrace();
		}
	}
}
