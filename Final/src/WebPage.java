import java.io.IOException;
import java.util.ArrayList;

public class WebPage {
	public String url;
	public String name;
	public WordCounter counter;
	public double score;
	
	public WebPage(String url, String name){
		this.url = url;
		this.name = name;
		this.counter = new WordCounter(url);	
	}
	
	public void setScore(ArrayList<Keyword> keywords) throws IOException{
		score = 0;
		//算keyword的權重、計算總共出現幾次
		for(Keyword keyword : keywords){		
			//score += keyword.weight*counter.countKeyword(keyword.name);	
		}
	}
}