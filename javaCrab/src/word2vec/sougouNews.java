/*Bob
 * 1163802968@qq.com
 * South China Normal University
 * 2015-12-16
 * 功能：把搜狗新闻语料分词
 */
 
package word2vec;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import fengCi.fengCi;

public class sougouNews {
	
	public static void main(String[] args) throws IOException {
		String word2vecFile ="E:\\python\\FTWord2vec.txt";
		String ss = "E:\\python\\SogouNews\\Sample\\";
		parseFile(ss, word2vecFile);
		
		
		
		
		
		
	}
	@SuppressWarnings({ "static-access", "resource" })
	public static void fengCi(String filepath,String out) throws IOException{
//		File[] files = new File(ss).listFiles();		
		StringBuffer FT = new StringBuffer();
		String sb = null;
		try{
            if (filepath.endsWith(".txt")) {
                BufferedReader jdFTBr = new BufferedReader(new InputStreamReader(new FileInputStream(new File(filepath)), "gb2312"));
                while ((sb = jdFTBr.readLine().toString())!=null) {
                	StringReader sr=new StringReader(sb);  
            	    IKSegmenter ik=new IKSegmenter(sr, true);  
            	    Lexeme lex=null; 
            	    while((lex=ik.next())!=null){
        		        FT.append(lex.getLexemeText()+"\r\n");
        	        } 
            	        
                }
            }
            
        }catch (NullPointerException e) {
        	fengCi saveJT = new fengCi();
        	saveJT.saveFengci(out,FT.toString());
		}
	}
	
	public static void parseFile(String ss,String word2vecFile) throws IOException {
		File[] files = new File(ss).listFiles();
		Integer j = new Integer(10);
		for (int i =0; i<files.length;i++) {
			for (; j < 20; j++) {
				String Filess = ss+files[i].getName()+"\\"+j.toString()+".txt";
				System.out.println(Filess);
				fengCi(Filess,word2vecFile);
			}
			if (j == 20) {j=10;}
		}
		System.out.println("语料处理完成！(^.^)");
	}
    
}
