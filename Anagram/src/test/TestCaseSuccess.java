package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;

import javax.swing.JOptionPane;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sample.AnagramMatcher;

public class TestCaseSuccess {

	static URL url = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Class cls = Class.forName("TestCaseSuccess");
		url = cls.getResource("wordlist.txt");
	}

	@Test
	public void TestSuccess_fresher() throws ClassNotFoundException {
		try {
			AnagramMatcher an = new AnagramMatcher();
			an.start(new File(url.getPath()), "fresher");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void TestSuccess_kinship() throws ClassNotFoundException {
		try {
			AnagramMatcher an = new AnagramMatcher();
			an.start(new File(url.getPath()), "kinship");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void TestSuccess_boaster() throws ClassNotFoundException {
		try {
			AnagramMatcher an = new AnagramMatcher();
			an.start(new File(url.getPath()), "boaster");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
