import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;

import javax.swing.JOptionPane;

import com.sample.AnagramMatcher;

public class MainApp {

	public static void main(String[] args) throws ClassNotFoundException {
		Class cls = Class.forName("MainApp");
		URL url = cls.getResource("wordlist.txt");
		try {
			while (true) {
				AnagramMatcher an = new AnagramMatcher();
				an.start(new File(url.getPath()),JOptionPane.showInputDialog(null, "Enter the Word to find the Anagrams:"));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
