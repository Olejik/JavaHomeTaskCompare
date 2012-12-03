import java.util.*;

public class MyList  implements ISearchable{
	//список в котором хрянятся пары - слово - частота 
	private List<PairWordFrequency> _listOfPairs;
	/**
	 * @see Isearchable
	 */
	
	MyList() {
		super();
		_listOfPairs = new ArrayList<PairWordFrequency>();
	}
	public void refresh(Scanner scanner) {
		//заполнение списка
		while (scanner.hasNext()) {
			_listOfPairs.add(new PairWordFrequency(scanner.next(),scanner.nextInt()));
		}
		//сортировка списка
		Collections.sort(_listOfPairs);
	}
	
	/**
	 * @see ISearchable
	 */
	public String[] guess(String userInput) {
		//требуемый список
		List<String> result = new ArrayList<String>();
		//выборка необходимых строк из отсортированного списка
		for (PairWordFrequency pair : _listOfPairs) {
			if (pair.getWord().startsWith(userInput)) 
				result.add((String)pair.getWord());
		}
		//вывод
		String res[] = new String[result.size()];
		result.toArray(res);
		return res;
	}
}
