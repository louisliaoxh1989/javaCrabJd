package javaCrab;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class captureJavascript {
	
	public  String comment(String strURL ) throws Exception {
		
		URL url = new URL(strURL);
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		InputStreamReader input = new InputStreamReader(httpConn
				.getInputStream(), "gbk");
		BufferedReader bufReader = new BufferedReader(input);
		String line = "";
		StringBuilder contentBuf = new StringBuilder();
		while ((line = bufReader.readLine()) != null) {
//			System.out.println(line);
			contentBuf.append(line);
		}
//		System.out.println(contentBuf);
		return(contentBuf.toString());
	}
}
