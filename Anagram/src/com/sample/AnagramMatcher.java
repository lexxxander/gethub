package com.sample;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.JOptionPane;

public class AnagramMatcher {

	public void start(File file, String word) throws FileNotFoundException {
		List<String> anagrams = searchInFile(word, file);
		JOptionPane.showMessageDialog(null,String.format("The word '%s' has %d matches.\n\n%s", word, anagrams.size(), format(anagrams)));
	}

	private List<String> searchInFile(String word, File file) throws FileNotFoundException {
		char[] canonical = sort(word);
		List<String> anagrams = new ArrayList<String>();

		try (Stream<String> stream = Files.lines(Paths.get(file.getAbsolutePath()), Charset.defaultCharset())) {
			anagrams = stream
					.filter(line -> line.length() == word.length() && !line.equals(word)  && (Arrays.equals(canonical, sort(line))))
					.collect(Collectors.toList());

		} catch (IOException e) {
			e.printStackTrace();
		}
		return anagrams;
	}

	private char[] sort(String word) {
		char[] array = word.toCharArray();
		Arrays.sort(array);
		return array;
	}

	private String format(List<String> words) {
		StringBuilder out = new StringBuilder();	
		int ctr = 0;
		Iterator<String> w = words.iterator();
		while (w.hasNext()) {
			out.append(w.next());
			if (w.hasNext()) {
				out.append((++ctr % 8 == 0) ? "\n" : ", ");
			}
		}
		return out.toString();
	}

}
