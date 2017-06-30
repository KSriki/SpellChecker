
import java.util.Scanner;

public class SpellCheck {
	public static void main(String[] args){
		
		
		Scanner s = new Scanner(System.in);
		System.out.print("Enter a word or sentence: ");
		String parts = s.nextLine();
		SpellChecker sChecker = new SpellChecker("/usr/share/dict/words");
		sChecker.spellCheck(parts);
	}
}
