public class PairWordFrequency implements Comparable<PairWordFrequency>{
	//слово
	private String _word;
	//частота этого слова
	private long _frequency;
	
	//конструктор
	PairWordFrequency(String word,long frequency) {
		super();
		setWord(word);
		setFrequency(frequency);
	}
	
	//геттеры сеттеры
	public void setWord(String word) {
		if (word==null) {
			_word = "";
		} else {
			_word = word;
		}
	}
	
	public void setFrequency(long frequency) {
		if (frequency<0) {
			_frequency = 0;
		} else {
			_frequency = frequency;
		}
	}
	
	public String getWord() {
		return _word;
	}
	
	public long getFrequency() {
		return _frequency;
	}

	public int compareTo(PairWordFrequency o) {
		if (_frequency>o.getFrequency()) {
			return -1;
		} else {
			if (_frequency<o.getFrequency()) {
				return 1;
			} else {
				if (_word.compareTo(o.getWord())<0) { //сравнение в лексикографическом порядке, если частоты равны
					return -1;
				} else {
					return 1;
				}
			}
		}
	}
}
