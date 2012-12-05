package SortInGuess;
import java.util.Scanner;

public interface ISearchable {
	/**
	 * Обновляет внутренние структуры данных
	 * @param inputText сканнер с открытым файлом
	 */
	public void refresh(Scanner scanner);
	
	/**
	 * Поиск по внутренней структуре данных подходящих строк
	 * @param userInput строка для которой выполняется поиск
	 * @return массив подходящих строк
	 */
	public String[] guess(String userInput);
}
