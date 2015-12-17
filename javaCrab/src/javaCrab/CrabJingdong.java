/*
 * Bob
 * 1163802968@qq.com
 * South China Normal University
 * 2015-12-16
 * 
 * 功能：爬取京东评论数据
*  该网页是一个动态js网页，其评论数据需要结合火狐chrome等浏览器查看其请求
 * 
 */

package javaCrab;

import java.io.*;
import java.net.*;
import java.util.Timer; 

public class CrabJingdong {
	
	public static void main(String[] args) throws Exception{
		
		Integer s = new Integer(0);
		String URL = null;
		
		captureJavascript jdhtml = new captureJavascript( );
		Crab jdcoment =new Crab();
		
		//抓取999页评论
		for (; s < 998; s++) {
			URL = "http://club.jd.com/productpage"
					+"/p-1509659-s-0-t-3-p-"+s.toString()+".html?"
				+"callback=fetchJSON_comment98vv6132";
			String com = jdcoment.takeHtml(jdhtml.comment(URL));
			System.out.println("正在保存第"+s+"页评论");
			jdcoment.Save(com);
		}
		System.out.println("主人，爬虫已经抓完数据啦！♪(´ε｀)");
	}

	

}

