package SortInGuess;
import java.util.*;

public class MyTree implements ISearchable{

	private TreeSet<PairWordFrequency> _treeOfPairs;
	
	MyTree() {
		super();
		_treeOfPairs = new TreeSet<PairWordFrequency>(new LexComparator());
	}
	
	/**
	 * @see ISearchable
	 */
	public void refresh(Scanner scanner) {
		while (scanner.hasNext()) {
			_treeOfPairs.add(new PairWordFrequency(scanner.next(),scanner.nextInt()));
		}
	}

	/**
	 * @see ISearchable
	 */
	public String[] guess(String userInput) {
		TreeSet<PairWordFrequency> buffer = new TreeSet<PairWordFrequency>();
		List<String> resultList = new ArrayList<String>();
		for (PairWordFrequency pair : _treeOfPairs) {
			if (pair.getWord().startsWith(userInput)) {
				buffer.add(pair);
			}
		}
		String res[] = new String[buffer.size()];
		for (PairWordFrequency pair : buffer) {
			resultList.add(pair.getWord());
		}
		resultList.toArray(res);
		return res;
	}
}
