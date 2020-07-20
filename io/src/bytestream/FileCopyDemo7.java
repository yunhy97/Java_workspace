package bytestream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.commons.io.IOUtils;

public class FileCopyDemo7 {

	public static void main(String[] args) throws IOException{
		
		URL url = new URL("https://postfiles.pstatic.net/MjAyMDAzMzBfMjIg/MDAxNTg1NTYwMzIwMDc1.JQmDQJhWqJ18aR4tiigDvdoXi0lCiVP34HnKTh7G6w4g.WW5CqUGhfOPJjbdOdfuxfPoaXHnZxxzr-IvD_JwApvAg.PNG.hyeonseo0818/%EC%98%A8%EB%AF%B8%EB%82%A8_%EB%B0%95%EB%B3%B4%EA%B2%80.png?type=w966");
		
		InputStream is = url.openStream();
		FileOutputStream fos = new FileOutputStream("c:/files/박보검2.png");
		
		IOUtils.copy(is, fos);
		
	}
}
