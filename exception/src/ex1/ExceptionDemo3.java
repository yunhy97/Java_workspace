package ex1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class ExceptionDemo3 {

	public static void main(String[] args) {
		
		try {
			URL url = new URL("http://imgnews.naver.net/image/5129/2015/07/22/1437522693_947221_99_20150722085409.jpg");
			InputStream in = url.openStream();
			System.out.println("해당 인터넷 리소스와 연결이 완료되었습니다.");
			
			System.out.println("사진 저장을 시작합니다.");
			FileOutputStream out = new FileOutputStream("c:/files/star.png");
			
			byte[] buf = new byte[1024];
			int len = 0;
			while((len=in.read(buf)) != -1) {
				out.write(buf, 0, len);	
			}
			out.close();
			
			System.out.println("사진이 저장이 완료되었습니다.");
		} catch (MalformedURLException e) {
			System.out.println("올바른 URL이 아닙니다.");
		} catch (IOException e) {
			System.out.println("해당 인터넷 리소스를 읽어오는 도중 오류가 발생하였습니다.");
		}
	}
}
