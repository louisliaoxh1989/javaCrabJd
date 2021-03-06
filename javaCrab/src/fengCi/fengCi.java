/*
 * Bob
 * 1163802968@qq.com
 * South China Normal University
 * 2015-12-16
 * 功能：实现分词
 * */
package fengCi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Set;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

public class fengCi {

	//停用词词表
	public static final String stopWordTable = "E:\\python\\StopWord.txt";
	public static final String jdCommemt = "E:\\python\\jdHuaweiP8Comment.txt";

	public static void main(String[] args) throws IOException {
	
		//读入停用词文件
		BufferedReader StopWordFileBr = new BufferedReader(new InputStreamReader(new FileInputStream(new File(stopWordTable))));
		
		//用来存放停用词的集合
		Set<String> stopWordSet = new HashSet<String>();
		
		//初如化停用词集
		String stopWord = null;
		for(; (stopWord = StopWordFileBr.readLine()) != null;){
			stopWordSet.add(stopWord);
		}
		
		//导入我们之前抓取的京东评论,注意编码格式
		BufferedReader jdComFileBr = new BufferedReader(new InputStreamReader(new FileInputStream(new File(jdCommemt)), "utf8"));
 
		//创建分词对象
		String text =null;
		StringBuffer FT = new StringBuffer();
		try {
			while ((text = jdComFileBr.readLine().toString())!=null) {
			StringReader sr=new StringReader(text);  
	        IKSegmenter ik=new IKSegmenter(sr, true);  
	        Lexeme lex=null;  
	    
	        //分词
	        while((lex=ik.next())!=null){
		        	//去除停用词   自己添加了\n,p8
		        	if(stopWordSet.contains(lex.getLexemeText())) {
		        		continue;
		        	}
	//	            System.out.print(lex.getLexemeText()+"\t"); 
		        	FT.append(lex.getLexemeText()+"\r\n");
	        	} 
//	        FT.append("\r\n");
			}
			StopWordFileBr.close();//关闭流
			jdComFileBr.close();
			
		} catch (NullPointerException e) {
			String path = "E:\\python\\jdHuaweiP8FC.txt";
			saveFengci(path,FT.toString());//保存
			System.out.println("\r\n"+"分词完成！(^.^)");
		}
        
        
	}
	
	
	//保存分词
	public static void saveFengci(String path,String ci) {
		File file = new File(path);
		try {
			if (!file.exists()) {
			file.createNewFile();
		}
		FileWriter  fwriter = new FileWriter(path,true);
		fwriter.write(ci);
		fwriter.flush();
		fwriter.close();
		} catch (Exception e) {
			System.out.print("分词在保存数据时候出现IO错误：");
			e.printStackTrace();
		}
		
	}
}