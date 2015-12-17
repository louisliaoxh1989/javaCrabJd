package javaCrab;

import java.io.File;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Crab {
	//筛选评论
	public String takeHtml(String comment) {
		String regx = "\\{\"id\":.+?content\":\"(.+?)\",\"creationTime";
		Pattern p = Pattern.compile(regx);
        Matcher m = p.matcher(comment);
        
        StringBuffer sb = new StringBuffer();
        String qq = null;
        while (m.find()) {
//			 System.out.println(m.group(1));
             qq = m.group(1).replaceAll("<div class=.+?</div>", "").replaceAll("\n", "");

             sb.append(qq+"\r\n");
	
		}
        return sb.toString();
	}
	
	//创建文件保存评论
	public void Save(String afterTake){
		String path = "E:\\python\\jdHuaweiP8Comment.txt";
		File file = new File(path);
		try {
			if (!file.exists()) {
			file.createNewFile();
		}
		FileWriter  fwriter = new FileWriter(path,true);
		fwriter.write(afterTake);
		fwriter.flush();
		fwriter.close();
		} catch (Exception e) {
			System.out.print("爬虫在保存数据时候出现IO错误：");
			e.printStackTrace();
		}

	}
	
}
