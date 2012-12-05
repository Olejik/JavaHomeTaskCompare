package SortInRefresh;
import java.util.*;

public class Hash implements ISearchable {

	private HashMap<String, Integer> _hashOfPairs;

	/**
	 * constructor
	 */
	Hash() {
		super();
		_hashOfPairs = new HashMap<String, Integer>();
	}

	/**
	 * @see ISearchable
	 */
	public void refresh(Scanner scanner) {
		while (scanner.hasNext()) {
			_hashOfPairs.put(scanner.next(), scanner.nextInt());
		}
	}

	/**
	 * @see ISearchable
	 */
	public String[] guess(String userInput) {
		List<PairWordFrequency> list = new ArrayList<PairWordFrequency>();
		for (String key : _hashOfPairs.keySet()) {
			if (key.startsWith(userInput)) {
				list.add(new PairWordFrequency(key, _hashOfPairs.get(key)));
			}
		}
		Collections.sort(list);
		String res[] = new String[list.size()];
		int i = 0;
		for (PairWordFrequency pair : list) {
			res[i++] = pair.getWord();
		}
		return res;
	}
}