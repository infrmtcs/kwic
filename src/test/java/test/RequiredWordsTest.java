package test;

import CS3213.CircularShift;
import CS3213.RequiredWords;
import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.*;

public class RequiredWordsTest {

    @Test
    public void testSetImplementation() throws Exception {
        RequiredWords requiredWords = RequiredWords.getRequiredWords();

        assertFalse(requiredWords.isWordRequired("the"));

        requiredWords.addRequiredWord("the");
        requiredWords.addRequiredWord("of");
        requiredWords.addRequiredWord("");
        assertTrue(requiredWords.isWordRequired("the"));
        assertTrue(requiredWords.isWordRequired("of"));
        assertTrue(requiredWords.isWordRequired(""));
        assertFalse(requiredWords.isWordRequired("after"));
        assertFalse(requiredWords.isWordRequired("before"));

        requiredWords.addRequiredWord("of"); // add duplicated word
        requiredWords.addRequiredWord("after");
        requiredWords.removeRequiredWord("the");
        requiredWords.removeRequiredWord("");
        assertFalse(requiredWords.isWordRequired("the"));
        assertTrue(requiredWords.isWordRequired("of"));
        assertFalse(requiredWords.isWordRequired(""));
        assertTrue(requiredWords.isWordRequired("after"));
        assertFalse(requiredWords.isWordRequired("before"));
    }

    @Test
    public void testCircularShift() throws Exception {
        RequiredWords.getRequiredWords().addRequiredWord("circular");
        RequiredWords.getRequiredWords().addRequiredWord("shift");
        CircularShift circularShit = new CircularShift("tEst this Circular shIft");
        String[] shifts = circularShit.getCircularShifts();
        HashSet<String> testSet = new HashSet<String>();
        for (String str : shifts) {
            testSet.add(str);
        }
        assertTrue(testSet.size() == 2);
        assertTrue(testSet.contains("Circular Shift Test This"));
        assertTrue(testSet.contains("Shift Test This Circular"));
    }
}
