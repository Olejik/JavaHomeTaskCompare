import java.io.*;
import java.util.*;

public class Main {

	/**
	 * Тестирует класс на обновление и поиск, выполняет сабж 100 раз
	 * @param a Класс который осцществляет поиск
	 * @return Возвращает строку, которая содержит время заполнения и время поиска
	 */
	public static String testTime(ISearchable a) throws FileNotFoundException {
		StringBuffer result = new StringBuffer();
		result.append(a.getClass()+"\n");
		result.append("Refreshing time: ");
		Scanner scanner = new Scanner(new FileReader("/home/olejik/Java/3DZ/COMPARE HASH TREE LIST/src/parsed.txt"));
		Date start = new Date();
		for (int i=0;i<100;i++) {
			a.refresh(scanner);
		}
		Date end = new Date();
		result.append((double)(end.getTime()-start.getTime())/100+"ms\n");
		result.append("Search time:");
		start = new Date();
		for (int i=0;i<100;i++) {
			a.guess("а");
		}
		end = new Date();
		result.append((double)(end.getTime()-start.getTime())/100+"ms\n");
		return result.toString();
	}
	/**
	 * @param args nothing, it's main (:
	 */
	public static void main(String[] args) throws Exception{
		StringBuffer output = new StringBuffer();
		try {
		int number = TextParser.parse("/home/olejik/Java/3DZ/COMPARE HASH TREE LIST/src/data.txt", "/home/olejik/Java/3DZ/COMPARE HASH TREE LIST/src/parsed.txt");
		System.out.println("number of unique words is "+number);
		output.append("Number of unique words: "+number+"\n");
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		
		try {
			System.out.println(testTime(new MyList()));
		}
		catch (Exception e) {
			System.out.println("List Crash");
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println(testTime(new MyTree()));
		}
		catch (Exception e) {
			System.out.println("Tree Crash");
			System.out.println(e.getMessage());
		}
		try
		{
			System.out.println(testTime(new Hash()));
		}
		catch (Exception e) {
			System.out.println("Hash Crash!");
			System.out.println(e.getStackTrace());
		}
		/*
		try {
			System.out.println("MyHash:");
			for (int i=0;i<100;i++) {
				MyTime hashTime = Hash.MyHash("а");
				fill+=hashTime.getFillTime();
				search+=hashTime.getSearchTime();
			}
			fill/=100;
			search/=100;
			output.append("hash: fill-"+fill+" search-"+search+"\n");
			System.out.println("fill time: "+fill);
			System.out.println("search time: "+search);
		}
		catch (Exception e) {
			System.out.println("Hash crash: "+e.getMessage());
		}
		
		
		try {
			System.out.println("MyTree:");
			for (int i=0;i<100;i++) {
				MyTime treeTime = MyTree.myTree("а");
				fill+=treeTime.getFillTime();
				search+=treeTime.getSearchTime();
			}
			fill/=100;
			search/=100;
			output.append("Tree: fill-"+fill+" search-"+search+"\n");
			System.out.println("fill time: "+fill);
			System.out.println("search time: "+search);
		}
		catch (Exception e) {
			System.out.println("Tree crash: "+e.getMessage());
		}
		
		try {
			System.out.println("MyList:");
			for (int i=0;i<100;i++) {
				MyTime listTime = MyList.myList("а");
				fill+=listTime.getFillTime();
				search+=listTime.getSearchTime();
			}
			fill/=100;
			search/=100;
			output.append("List: fill-"+fill+" search-"+search+"\n");
			System.out.println("fill time: "+fill);
			System.out.println("search time: "+search);
		}
		catch (Exception e) {
			System.out.println("List crash: "+e.getMessage());
		}
		try {
			FileWriter fw = new FileWriter("/home/olejik/test3");
			fw.write(output.toString());
			fw.close();
		}
		catch (Exception e) {
			System.out.println("final crash");
		}
		*/
	}

}
