package hackerrank;

import org.junit.Assert;
import org.junit.Test;

public class JavaStackTest {

    @Test(expected = IllegalArgumentException.class)
    public void caseNull() {
        assertEquals(null, false);
    }

    @Test
    public void caseEmpty() {
        assertEquals("", true);
    }

    @Test
    public void casesOne() {
        assertEquals("(", false);
        assertEquals("[", false);
        assertEquals("{", false);
        assertEquals(")", false);
        assertEquals("]", false);
        assertEquals("}", false);
    }

    @Test
    public void casesTwo() {
        assertEquals("()", true);
        assertEquals("((", false);
        assertEquals("{[", false);
        assertEquals("[)", false);
        assertEquals(")(", false);
        assertEquals("]{", false);
    }

    @Test
    public void casesThree() {
        assertEquals("(((", false);
    }

    @Test
    public void casesFour() {
        assertEquals("(())", true);
        assertEquals("([])", true);
        assertEquals("(()(", false);
        assertEquals("(()[", false);
        assertEquals("]()[", false);
        assertEquals("([))", false);
    }

    @Test
    public void casesComplex() {
        assertEquals("{}()", true);
        assertEquals("[{()}]", true);
        assertEquals("({()})", true);
    }

    private void assertEquals(String value, boolean expected) {
        Assert.assertEquals(expected, JavaStack.check(value));
    }

}
