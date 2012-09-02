package net.sf.laja.reflection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import static junit.framework.Assert.*;

public class TypelistEvaluatorTest {
	
	@Test
	public void string() {
		Class[] callingTypes = { String.class };
		
		Typelist bestTypelist = TypelistEvaluator.getBestTypelist(callingTypes, new Iterable<Typelist>() {
			public Iterator<Typelist> iterator() {
				List<Typelist> list = new ArrayList<Typelist>();
				list.add(new Typelist() {
					public Class[] getTypes() {
						return new Class[] { String.class };
					}
					public int getVarargStartIndex() {
						return 0;
					}
					public void setVarargStartIndex(int startIndex) {
					}
					public boolean isVararg() {
						return false;
					}
					public Class getVarargType() {
						return null;
					}
				});
				return list.iterator();
			}
		});

		assertEquals(1, bestTypelist.getTypes().length);
		assertEquals(String.class, bestTypelist.getTypes()[0]);
	}

	@Test
	public void varargs() {
		final boolean isVararg = true;
		final int varargStartIndex = 1;
		final Class type0 = int.class;
		final Class type1 = Object[].class;
		
		Class[] callingTypes = { int.class, String.class, Integer.class };
		
		Typelist bestTypelist = TypelistEvaluator.getBestTypelist(callingTypes, new Iterable<Typelist>() {
			public Iterator<Typelist> iterator() {
				List<Typelist> list = new ArrayList<Typelist>();
				list.add(new Typelist() {
					public Class[] getTypes() {
						return new Class[] { type0, type1 };
					}
					public int getVarargStartIndex() {
						return varargStartIndex;
					}
					public void setVarargStartIndex(int startIndex) {
					}
					public boolean isVararg() {
						return isVararg;
					}
					public Class getVarargType() {
						return Object.class;
					}
				});
				return list.iterator();
			}
		});

		assertEquals(2, bestTypelist.getTypes().length);
		assertEquals(isVararg, bestTypelist.isVararg());
		assertEquals(varargStartIndex, bestTypelist.getVarargStartIndex());
		assertEquals(type0, bestTypelist.getTypes()[0]);
		assertEquals(type1, bestTypelist.getTypes()[1]);
	}
}
