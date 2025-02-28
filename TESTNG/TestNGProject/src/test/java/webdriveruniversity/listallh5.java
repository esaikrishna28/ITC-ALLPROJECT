package webdriveruniversity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.testng.annotations.Test;

public class listallh5 {
	@Test
	public void listh5() {
	 listallele("optimize");	
	}
	
	
	
    public void  listallele(String nameobj) {
    	
    	String url = "https://www.zebra.com/ap/en/software/mobile-computer-software.html"; // Replace with the target website URL

        try {
            // Fetch the HTML from the live website
            Document document = Jsoup.connect(url).get();
            
            // Select all h5 elements
            Elements h5Elements = document.select("div#"+nameobj+" h5");
            
            
            Set<String> h5TextsSet = new LinkedHashSet<>();
            for (Element h5 : h5Elements) {
                h5TextsSet.add(h5.text());
            }

            // Convert the set back to a list if needed
            List<String> uniqueH5Texts = new ArrayList<>(h5TextsSet);

            // Output the unique texts (you can also assert these in your tests)
            for (String text : uniqueH5Texts) {
                System.out.println(text);
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle exceptions as needed
        }
    	
    	
    }
	
}
