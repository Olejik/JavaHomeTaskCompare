package SortInRefresh;
import java.util.*;

public class MyTree implements ISearchable{

	private TreeSet<PairWordFrequency> _treeOfPairs;
	
	MyTree() {
		super();
		_treeOfPairs = new TreeSet<PairWordFrequency>();
	}
	
	/**
	 * @see ISearchable
	 */
	public void refresh(Scanner scanner) {
		//заполнение с сортировкой
		while (scanner.hasNext()) {
			_treeOfPairs.add(new PairWordFrequency(scanner.next(),scanner.nextInt()));
		}
	}

	/**
	 * @see ISearchable
	 */
	public String[] guess(String userInput) {
		List<String> resultList = new ArrayList<String>();
		//выборка
		for (PairWordFrequency pair : _treeOfPairs) {
			if (pair.getWord().startsWith(userInput)) {
				resultList.add(pair.getWord());
			}
		}
		//вывод
		String res[] = new String[resultList.size()];
		resultList.toArray(res);
		return res;
	}
}
