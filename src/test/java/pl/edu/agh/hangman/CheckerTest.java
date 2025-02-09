package pl.edu.agh.hangman;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckerTest {

    @Test
    public void ckeckLetterTest(){
        Checker checker = new Checker("JAVA");
        checker.checkLetter('J');
        Assertions.assertEquals(checker.getNumberOfMistakes(), 0);
        checker.checkLetter('M');
        Assertions.assertEquals(checker.getNumberOfMistakes(),1);
        Assertions.assertEquals("J___", checker.getWordState());
        checker.checkLetter('A');
        Assertions.assertEquals("JA_A", checker.getWordState());
    }


}
