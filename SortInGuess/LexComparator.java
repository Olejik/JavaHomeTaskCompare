package SortInGuess;

import java.util.Comparator;


public class LexComparator implements Comparator<PairWordFrequency>{

	LexComparator() {
		super();
	}
	
	/**
	 * Lexicographical sort
	 */
	public int compare(PairWordFrequency arg0, PairWordFrequency arg1) {
		return arg0.getWord().compareTo(arg1.getWord());
	}

}
