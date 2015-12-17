/*
 * Bob
 * 1163802968@qq.com
 * South China Normal University
 * 2015-12-16
 * 
 * 功能：词向量化
 * 参考：https://github.com/NLPchina/Word2VEC_java/blob/master/src/com/ansj/vec/Word2VEC.java
 * */

package word2vec;


import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import com.ansj.vec.Learn;
import com.ansj.vec.Word2VEC;

public class word2vecDemo {
	public static void main(String[] args) throws IOException{
//		String sougouWordFile ="E:\\python\\FTWord2vec.txt";
//		File sougoufile = new File(sougouWordFile);
//		String huaweiWord ="E:\\python\\jdHuaweiP8FC.txt";
//		File huaweiWordFile = new File(huaweiWord);
//		
//		//开始训练		
//	    Learn lean = new Learn() ;
//	    lean.setLayerSize(10);
//	    lean.learnFile(sougoufile) ;
//	    lean.learnFile(huaweiWordFile);
//	    lean.saveModel(new File("E:\\python\\vector.mod")) ;

	    //加载测试
	    Word2VEC w2v = new Word2VEC() ;
	    w2v.loadJavaModel("E:\\python\\vector.mod") ;
	    System.out.println("手机的向量是："+Arrays.toString(w2v.getWordVector("手机")));
	    System.out.println("手机的向量长度是："+w2v.getWordVector("手机").length);
	    System.out.println("与\"新闻\"相关的词有："+w2v.distance("新闻"));
	}
}
