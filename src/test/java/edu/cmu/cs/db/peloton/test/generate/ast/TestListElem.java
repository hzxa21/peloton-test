package edu.cmu.cs.db.peloton.test.generate.ast;

import edu.cmu.cs.db.peloton.test.generate.util.Iterators;
import edu.cmu.cs.db.peloton.test.generate.ast.exhaustive.ListElem;
import org.junit.Test;

import java.util.List;

import static edu.cmu.cs.db.peloton.test.generate.ast.TestUtil.clauseOf;
import static org.junit.Assert.*;

public class TestListElem {
    @Test
    public void testListElem() {
        Ast.Elem test = new StubElem("foo", "bar", "42");
        List<Ast.Clause> result = Iterators.toList(new ListElem(test).allClauses(null, Context.EMPTY, 0));
        assertTrue(result.contains(clauseOf("foo")));
        assertTrue(result.contains(clauseOf("bar")));
        assertTrue(result.contains(clauseOf("42")));
        assertTrue(result.contains(clauseOf("foo,bar")));
        assertTrue(result.contains(clauseOf("foo,42")));
        assertTrue(result.contains(clauseOf("bar,42")));
        assertTrue(result.contains(clauseOf("foo,bar,42")));
        assertEquals(7, result.size());
    }

}
