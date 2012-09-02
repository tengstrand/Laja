package net.sf.laja.parser.cdd.statetemplate;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StatementPrefixerTest {

    @Test
    public void isLetter_true() {
        StatementPrefixer prefixer = new StatementPrefixer("state.", "(a)", "a");
        assertTrue(prefixer.isLetter(2));
    }

    @Test
    public void isLetter_false() {
        StatementPrefixer prefixer = new StatementPrefixer("state.", "(a)", "a");
        assertFalse(prefixer.isLetter(3));
    }

    @Test
    public void isPeriod_true() {
        StatementPrefixer prefixer = new StatementPrefixer("state.", ".ax", "a");
        assertTrue(prefixer.isPeriod(1));
    }

    @Test
    public void isPeriod_false() {
        StatementPrefixer prefixer = new StatementPrefixer("state.", ".ax", "a");
        assertFalse(prefixer.isPeriod(2));
    }

    @Test
    public void prefixAttribute_sameValue() {
        StatementPrefixer prefixer = new StatementPrefixer("state.", "abc", "abc");
        assertEquals("state.abc", prefixer.prefixAttribute());
    }

    @Test
    public void prefixAttribute_endsWith() {
        StatementPrefixer prefixer = new StatementPrefixer("state.", "hej-abc", "abc");
        assertEquals("hej-state.abc", prefixer.prefixAttribute());
    }

    @Test
    public void prefixAttribute_startsWith() {
        StatementPrefixer prefixer = new StatementPrefixer("state.", "abc-hello", "abc");
        assertEquals("state.abc-hello", prefixer.prefixAttribute());
    }

    @Test
    public void prefixAttribute_severalOneOccurances() {
        StatementPrefixer prefixer = new StatementPrefixer("state.", "red-abc1(123 abc1) end", "abc1");
        assertEquals("red-state.abc1(123 state.abc1) end", prefixer.prefixAttribute());
    }

    @Test
    public void prefixAttribute_replaceSeveralOccurance() {
        StatementPrefixer prefixer = new StatementPrefixer("state.", "red-abc(123 abc) end", "abc", "getAbc");
        assertEquals("red-state.getAbc(123 state.getAbc) end", prefixer.prefixAttribute());
    }

    @Test
    public void prefixAttribute_replaceSeveralOccuranceNoPrefix() {
        StatementPrefixer prefixer = new StatementPrefixer("", "red-abc(123 abc) end", "abc", "getAbc");
        assertEquals("red-getAbc(123 getAbc) end", prefixer.prefixAttribute());
    }

    @Test
    public void prefixAttribute_noMatch() {
        StatementPrefixer prefixer = new StatementPrefixer("state.", "new Car(xStateView);", "xState", "getXState()");
        assertEquals("new Car(xStateView);", prefixer.prefixAttribute());
    }

    @Test
    public void prefixAttribute_ignoreIfTrailingPeriod() {
        StatementPrefixer prefixer = new StatementPrefixer("state.", "x.abc)", "abc");
        assertEquals("x.abc)", prefixer.prefixAttribute());
    }

    @Test
    public void prefixAttribute_dontIgnoreIfEmptyPrefixAndTrailingPeriod() {
        StatementPrefixer prefixer = new StatementPrefixer("", "x.abc!", "abc", "abc()");
        assertEquals("x.abc()!", prefixer.prefixAttribute());
    }
}
