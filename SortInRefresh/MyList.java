package SortInRefresh;
import java.util.*;

public class MyList  implements ISearchable{
	private List<PairWordFrequency> _listOfPairs;
	/**
	 * @see Isearchable
	 */
	
	MyList() {
		super();
		_listOfPairs = new ArrayList<PairWordFrequency>();
	}
	public void refresh(Scanner scanner) {
		while (scanner.hasNext()) {
			_listOfPairs.add(new PairWordFrequency(scanner.next(),scanner.nextInt()));
		}
		Collections.sort(_listOfPairs);
	}
	
	/**
	 * @see ISearchable
	 */
	public String[] guess(String userInput) {
		List<String> result = new ArrayList<String>();
		for (PairWordFrequency pair : _listOfPairs) {
			if (pair.getWord().startsWith(userInput)) 
				result.add((String)pair.getWord());
		}
		String res[] = new String[result.size()];
		result.toArray(res);
		return res;
	}
}
