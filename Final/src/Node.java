import java.net.URL;
import java.util.List;

public class Node {
	private String ancestor;
	private List<Node> children;
	private List<Keyword> keywords;
	private String name;
	private double sum;
	private String url;
	
	public Node(String name, URL url, String keyword){
		
	}
	public void buildChildren(){
		
	}
	private void buildKeywords(){
		
	}
	public double calculateSum(){
		//計算網頁中所有關鍵字的加權分數
	}
	public String toString() {
		
	}
}
