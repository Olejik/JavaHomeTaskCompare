package SortInGuess;
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
		Collections.sort(_listOfPairs,new LexComparator());
	}
	
	/**
	 * @see ISearchable
	 */
	public String[] guess(String userInput) {
		List<String> result = new ArrayList<String>();
		List<PairWordFrequency> buffer = new ArrayList<PairWordFrequency>();
		for (PairWordFrequency pair : _listOfPairs) {
			if (pair.getWord().startsWith(userInput)) 
				buffer.add(pair);
		}
		Collections.sort(buffer);
		String res[] = new String[buffer.size()];
		for (PairWordFrequency pair : buffer) {
			result.add(pair.getWord());
		}
		result.toArray(res);
		return res;
	}
}
