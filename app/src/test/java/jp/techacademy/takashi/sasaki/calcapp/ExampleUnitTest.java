package jp.techacademy.takashi.sasaki.calcapp;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void test() {
        BigDecimal v1 = new BigDecimal("123456789");
        BigDecimal v2 = new BigDecimal("789456123");
        System.out.println(v1.divide(v2, 5, BigDecimal.ROUND_HALF_UP));

        assertTrue("123".matches("(([0-9]+)|([0-9]+)(\\.[0-9]+))"));
        assertTrue("123.456".matches("(([0-9]+)|([0-9]+)(\\.[0-9]+))"));

        assertFalse("".matches("(([0-9]+)|([0-9]+)(\\.[0-9]+))"));
        assertFalse(".".matches("(([0-9]+)|([0-9]+)(\\.[0-9]+))"));
        assertFalse(".123".matches("(([0-9]+)|([0-9]+)(\\.[0-9]+))"));
        assertFalse("123.".matches("(([0-9]+)|([0-9]+)(\\.[0-9]+))"));
    }
}
