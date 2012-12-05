package SortInGuess;
import java.io.*;
import java.util.*;

public final class TextParser {
	/**
	 * 
	 * @param in файл откуда взять текст
	 * @param out файл куда записать пары слово-частота
	 */
	public static int parse(String in,String out) throws Exception {
		FileReader fReader = new FileReader(in);
		BufferedReader br = new BufferedReader(fReader);
		FileWriter fWriter = new FileWriter(out);
		BufferedWriter bw = new BufferedWriter(fWriter);
		String source;
		StringBuffer targ = new StringBuffer();
		while ((source=br.readLine())!=null) {
			targ.append(source).append("\n");
			source=null;
		}
		Map<String,Integer> hash = new HashMap<String,Integer>();
		StringTokenizer word = new StringTokenizer(targ.toString(),"\t\n\r.,/?\'\"()-_\\ {}=+-*&^%$#@!:;1234567890");
		while (word.hasMoreTokens()) {
			String cur = word.nextToken().toString().toLowerCase();
			if (hash.containsKey(cur)) {
				hash.put(cur, hash.get(cur)+1);
			} else {
				hash.put(cur,1);
			}
		}
		int number=0;
		for (String key : hash.keySet()) {
			bw.write(key+"  "+hash.get(key)+"\n");
			++number;
		}
		bw.flush();
		fReader.close();
		fWriter.close();
		return number;
	}
}
