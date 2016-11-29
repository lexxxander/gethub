package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;

import javax.swing.JOptionPane;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestCaseSuccess {

	static URL url = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Class cls = Class.forName("TestCaseSuccess");
		url = cls.getResource("wordlist.txt");
	}

	@Test
	public void TestSuccess_fresher() throws ClassNotFoundException {
		
	}

	@Test
	public void TestSuccess_kinship() throws ClassNotFoundException {
		
	}
	
	@Test
	public void TestSuccess_boaster() throws ClassNotFoundException {
		
	}

}
