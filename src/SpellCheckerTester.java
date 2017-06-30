import static org.junit.Assert.*;

import org.junit.Test;

public class SpellCheckerTester {

	SpellChecker sChecker = new SpellChecker("/usr/share/dict/words");
	
	@Test
	public void test() {
		assertTrue(sChecker.spellCheck("Klass"));
		assertFalse(sChecker.spellCheck("class"));
		
	}
	
	@Test
	public void test2(){
		assertFalse(sChecker.spellCheck("This sentence is correctly spelled"));
		assertTrue(sChecker.spellCheck("This sentnce is not correctly spelled"));
		assertTrue(sChecker.spellCheck("This sentence is not crrorectly speled"));
	}

}
