/*
 * A simple spell checker using a given library/dictionary of correctly spelled words
 * Srikant Kumar Kalaputapu
 * June 30th, 2017
 * 
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class SpellChecker {
	
	HashSet<String> dict = new HashSet<String>();
	
	/**
	 * Creates the dictionary for the spell checker based on given file at location path
	 * @param path - location of the dictionary file
	 */
	public SpellChecker(String path){
			File file = new File(path);
		
		try {
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				String word = sc.nextLine();
				dict.add(word);
				// another while on words in input would be O(nxm) where n = size of dictionary and m is size of input

			}
			sc.close();
			
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Determines if a word is misspelled 
	 * @param word - word to spell check
	 * @return true if word is misspelled, false if the word is in the dictionary
	 */
	private boolean findAMistake(String word){
		if(!dict.contains(word)){
			System.out.printf("%s is not a word. Please reenter.\n",word);
			return true;
		}
		return false;
	}
	
	/**
	 * Find all mistakes in a list of words
	 * @param parts - list of words
	 * @return true for mistake found, false for no mistakes
	 */
	private boolean findAllMistakes(String[] parts){
	
		boolean mistake = false;
		for(int i = 0; i < parts.length; i++){
			if(findAMistake(parts[i])){
				mistake = true;
			}
		}
		return mistake;
	}

	/**
	 * Finds all spelling mistakes in a line of input. DOES NOT work with punctuation
	 * @param line - input text sentence
	 */
	public boolean spellCheck(String line){
		
		
		String[] parts = line.toLowerCase().split(" ");
		
		if(parts.length==1){
			if(!this.findAMistake(parts[0])){
				System.out.println("There are no mistakes in your sentence!");
				return false;
			}
			else{
				System.out.println("Please fix your mistakes!");
				return true;
			}
		}
		else{
			if(!this.findAllMistakes(parts)){
				System.out.println("There are no mistakes in your sentence!");
				return false;
			}
			else{
				System.out.println("Please fix your mistakes!");
				return true;
			}
		}
		
	}

}
