import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.ScrollPane;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class MainApp {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		Map<String, Set<String>> anagrams = new HashMap<String, Set<String>>();

		Class cls = Class.forName("MainApp");
		InputStream in = cls.getResourceAsStream("wordlist.txt");
		BufferedReader buf = new BufferedReader(new InputStreamReader(in));

		try (Stream<String> stream = buf.lines()) {
			anagrams = stream.flatMap(Pattern.compile("\\W+")::splitAsStream)
					.collect(Collectors.groupingBy(MainApp::canonicalize, Collectors.toSet()));
		}
		buf.close();
		in.close();

		List<Set<String>> sets = anagrams.values().stream().filter(line -> line.size() > 1)
				.collect(Collectors.toList());
		JFrame frame = new JFrame();
		List<String> cols=  new ArrayList<String>();
		List<String[]> vals  = new ArrayList<String[]>();
		StringBuilder sb =new StringBuilder();
		for(Set<String> s : sets){	
			sb =new StringBuilder();
			for(String sr : s){
				sb.append(sr).append(",");
			}	
			vals.add(new String[]{sb.toString()});
			
		}
		cols.add("ANAGRAMS");

		DefaultTableModel model = new DefaultTableModel(vals.toArray(new Object[][]{}),cols.toArray());

		JTable table = new JTable(model);
		table.setFont(new Font("Tahoma",Font.PLAIN,15));
		table.setEnabled(false);
		
		frame.setTitle("ANAGRAM MATCHER");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(new JScrollPane(table),BorderLayout.CENTER);
		frame.setSize(400, 400);
		frame.setVisible(true);
		frame.pack();
	}

	private static String canonicalize(String s) {
		return Stream.of(s.split("")).sorted().collect(Collectors.joining());
	}

}
