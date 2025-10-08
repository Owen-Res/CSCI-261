import java.util.ArrayList;
import java.util.Collections;


public class Main {

	public static void printList(ArrayList<String> list) {
		int idx = 0;
		for (String word : list) {
			System.out.printf("%s%s", word, (idx == list.size() - 1) ? "\n" : ", ");
			idx++;
		}
	}

	public static void addToList(ArrayList<String> words, String word){
		int index = Collections.binarySearch(words, word);
		if (index <= 0)
			index = (-index) - 1;
		words.add(index, word);
	}

	public static void main(String[] args) {
		final String WORDPREFIX = "as";

		ArrayList<String> words = new ArrayList<String>();
		addToList(words, "null");
		addToList(words, "nulver");
		addToList(words, "nump");
		addToList(words, "asshole");
		addToList(words, "able");
		addToList(words, "abacus");

		int index = Collections.binarySearch(words, WORDPREFIX);
		if (index <= 0)
			index = (-index) - 1;

		System.out.println(index);
		printList(words);

		ArrayList<String> answers = new ArrayList<String>();
		for(int i = index; i < words.size() && words.get(i).startsWith(WORDPREFIX); i++){
			answers.add(words.get(i));
		}
		printList(answers);
		
	}
}
