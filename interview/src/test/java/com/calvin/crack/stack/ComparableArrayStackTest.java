package com.calvin.crack.stack;

import static org.junit.Assert.*;

import org.junit.Test;

public class ComparableArrayStackTest {
	
	public static class IntComparable implements Comparable<IntComparable>{
		private final int value;
		public static IntComparable of(int x){
			return new IntComparable(x);
		}
		IntComparable(int value){
			this.value = value;
		}		
		public int compareTo(IntComparable o) {
			return this.value - o.value;
		}
		int intValue(){
			return value;
		}
	}
	
	@Test
	public void testEmpty(){
		ComparableArrayStack<IntComparable> stack = new ComparableArrayStack<IntComparable>(IntComparable.class, 10);
		assertNull(stack.min());		
	}

	@Test(expected=RuntimeException.class)
	public void giveEmptyWhenPopThrowException(){
		ComparableArrayStack<IntComparable> stack = new ComparableArrayStack<IntComparable>(IntComparable.class, 10);
		stack.pop();
	}

	
	@Test
	public void givenEmptyWhenAddOneThenThatIsMin(){
		ComparableArrayStack<IntComparable> stack = new ComparableArrayStack<IntComparable>(IntComparable.class, 10);
		IntComparable ten = IntComparable.of(10);
		stack.push(ten);
		assertEquals(10, stack.min().intValue());
		stack.push(IntComparable.of(5));
		stack.push(IntComparable.of(6));
		stack.push(IntComparable.of(3));
		assertEquals(3, stack.min().intValue());
		assertEquals(3, stack.pop().intValue());
		assertEquals(5, stack.min().intValue());
		assertEquals(6, stack.pop().intValue());
		assertEquals(5, stack.min().intValue());
		assertEquals(5, stack.pop().intValue());
	}
}
