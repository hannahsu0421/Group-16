import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class WebNode {
	private WebNode parent;
	private List<WebNode> children;
	private ArrayList<Keyword> keywords;
	private String name;
	private double sum;
	private String url;
	
	public WebNode(String name, URL url, String keyword){
		
	}
	public void buildChildren(){
		
	}
	private void buildKeywords(){
		
	}
	public double calculateSum(){
		//計算網頁中所有關鍵字的加權分數
		return 0;
	}
	public String toString() {
		return "";
	}
	public int getDepth(){
		int retVal = 1;
		WebNode currNode = this;
		while(currNode.parent != null){
			retVal++;
			currNode = currNode.parent;
		}
		return retVal;
	}
}





