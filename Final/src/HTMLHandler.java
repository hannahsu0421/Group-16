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
	
	public HTMLHandler(String searchKeyword) throws IOException {
		this.searchKeyword = searchKeyword;
	}
	
	public void import_content() throws IOException {
		try {
			link = new Google(searchKeyword).query();
		} 
		catch (IOException e) {
		}
		
		for (int i = 0; i < link.size(); i++) {
			content.add(fetchContent(link.get(i)));
		}
		
		System.out.println(fetchSublink(link.get(1), content.get(1)));
		
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
	
	private ArrayList<String> fetchSublink(String link , String content) throws IOException{
		ArrayList<String> sub = new ArrayList<String>();
		
		int counter = 0;
		char slash;
		int where = 0;
		String concatlink = "1";
		
//		判斷網頁是不是子網頁
		for (int i = 0; i < link.length(); i++) {
            slash = link.charAt(i);
            if (slash == '/')
                counter++;
            if (counter >= 3) {
            	where = i;
            	break;
            }
        }

//		做出主網頁的網址
        if (where != 0) {
        	concatlink = link.substring(0, where);
        }

		Document doc = Jsoup.parse(content);
		Elements aLinks = doc.select("a[href]");
		for(Element element:aLinks){
			String url =element.attr("href");
			
//			挑出開頭不是http或https但又存在href的東西
			if(!url.contains("http://")&&!url.contains("https://")){ 
				if (concatlink != "1") {
					url = concatlink + url; 
				}
				else {
					url = link+url;
				}
			}
			sub.add(url);
		}
		
		return sub;
	}
		
	
}




