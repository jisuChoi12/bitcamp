import java.net.*;
import java.io.*;

class URLTest{
	public static void main(String[] args) throws MalformedURLException, IOException {
		URL url = new URL("https://www.naver.com/index.html");
		System.out.println("프로토콜 : "+url.getProtocol());
		System.out.println("호스트 : "+url.getHost());
		System.out.println("포트 : "+url.getPort());
		System.out.println("기본 포트 : "+url.getDefaultPort());
		System.out.println("파일 : "+url.getFile());

		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
		String line = null;
		while((line = br.readLine()) != null) {
			System.out.println(line);
		}
		br.close();
	}
}
