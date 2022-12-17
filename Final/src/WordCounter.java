import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class WordCounter {
	private String urlStr;
    private String content;
    
    public WordCounter(String urlStr){
    	this.urlStr = urlStr;
    }
    
    private String fetchContent() throws IOException{
		URL url = new URL(this.urlStr);
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
        
    public int BoyerMoore(String T, String P){
        int i = P.length() -1;
        int j = P.length() -1;
        int count = 0;
        
        while(i < T.length()) {
        	if(T.charAt(i) == P.charAt(j)) {
        		
        		if(j == 0) {
        			count++;
        			i+=P.length();
        			j = P.length() - 1;
        		}else {
        			i = i - 1;
        			j = j - 1;
        		}
        	}else {
        		i = i + P.length() - min(j, 1 + last(T.charAt(i), P));
        		j = P.length() - 1;
        	}
        }
        
        // Bonus: Implement Boyer-Moore Algorithm     
        return count;
    }

    public int last(char c, String P){
    	// Bonus: Implement last occurence function
    	for(int i = P.length()-1;i >= 0; i--) {
    		
    		if (P.charAt(i)== c) {
				return i;
			}
    		
    	}
        return -1;
    }

    public int min(int a, int b){
        if (a < b)
            return a;
        else if (b < a)
            return b;
        else 
            return a;
    }
    
    public int countKeyword(String keyword) throws IOException{
		if (content == null){
		    content = fetchContent();
		}		
		//To do a case-insensitive search, we turn the whole content and keyword into upper-case:
		content = content.toUpperCase();
		keyword = keyword.toUpperCase();
		int retVal = 0; 
		return BoyerMoore(content, keyword);
    }
}