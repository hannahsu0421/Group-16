import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Stack;

import javax.print.attribute.standard.PrinterInfo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

//把輸入進來的URL裡的內容跟子連結都抓出來

public class HTMLHandler {
	
	ArrayList<String> link = new ArrayList<String>();
	ArrayList<String> content = new ArrayList<String>();
	public String searchKeyword;
	
	public HTML_Handler(String searchKeyword) throws IOException {
		this.searchKeyword = searchKeyword;
	}
	
	public void import_content() throws IOException {
		try {
			link = new Google(searchKeyword).query();
//			System.out.println(link);
			System.out.println(link.get(0));
		} 
		catch (IOException e) {
		}
		
		for (int i = 0; i < link.size(); i++) {
			content.add(fetchContent(link.get(i)));
		}
		
		System.out.println(content.get(0));
	}
	
	private ArrayList<String> getContent() {
		return content;
	}
	
	
	private String fetchContent(String link) throws IOException{
		URL url = new URL(link);
		URLConnection conn = url.openConnection();
		InputStream in = conn.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String retVal = "";
		String line = null;
		while ((line = br.readLine()) != null){
		    retVal = retVal + line + "\n";
		}
		
		return retVal;
    }
	
	private ArrayList<String> fetchSublink(String content) throws IOException{
		ArrayList<String> sublink = new ArrayList<String>();
		
		Document doc = Jsoup.parse(content);
		Elements lis = doc.select("div");
		lis = lis.select(".kCrYT");
		for(Element li : lis)
		{
			try 
			{
				String subUrl = li.select("a").get(0).attr("href");
				subUrl = subUrl.substring(7);
				sublink.add(subUrl);

			} catch (IndexOutOfBoundsException e) {
			}
			
		}
		
		return sublink;
	}
		
	
}




