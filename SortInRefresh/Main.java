package SortInRefresh;
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
		Scanner scanner = new Scanner(new FileReader("parsed.txt"));
		Date start = new Date();
		for (int i=0;i<1;i++) {
			a.refresh(scanner);
		}
		Date end = new Date();
		result.append((double)(end.getTime()-start.getTime())/100+"ms\n");
		result.append("Search time:");
		start = new Date();
		for (int i=0;i<1;i++) {
			a.guess("�");
		}
		end = new Date();
		result.append((double)(end.getTime()-start.getTime())+"ms\n");
		return result.toString();
	}
	/**
	 * @param args nothing, it's main (:
	 */
	public static void main(String[] args) throws Exception{
		StringBuffer output = new StringBuffer();
		try {
		int number = TextParser.parse("data.txt", "parsed.txt");
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
	}

}
