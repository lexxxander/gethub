package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;

import org.junit.BeforeClass;
import org.junit.Test;


public class TestCaseFailure {

	static URL url = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Class cls = Class.forName("TestCaseFailure");
		url = cls.getResource("wordlists.txt");//file not be found
	}

	@Test
	public void TestFailure_NullException() throws NullPointerException, FileNotFoundException {		
		/*	AnagramMatcher an = new AnagramMatcher();
			an.start(new File(url.getPath()), "fresher");
		*/
	}

}
