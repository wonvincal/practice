package com.calvin.cake;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.calvin.cake.HiCal.Meeting;
import com.calvin.collection.SinglyLinkedList;
import com.calvin.collection.SinglyLinkedList.Node;

public class HiCalTest {

	@Test
	public void test(){
		Meeting[] meetings = new Meeting[]{
				new Meeting(3, 4), new Meeting(1, 3), new Meeting(6, 8), new Meeting(11, 12), new Meeting(7, 11)
		};
		Node<Meeting> head = HiCal.mergeRange(meetings);
		assertList(new Meeting[]{new Meeting(1, 4), new Meeting(6, 12)}, head);
		
		List<Meeting> result = HiCal.mergeRangeOnePass(meetings);
		assertList(new Meeting[]{new Meeting(1, 4), new Meeting(6, 12)}, result);
		
	}
	
	public static void assertList(Meeting[] meetings, List<Meeting> result){
		assertTrue(meetings.length == result.size());
		for (int i = 0; i < meetings.length; i++){
			assertTrue(result.get(i).equals(meetings[i]));			
		}
	}

	public static void assertList(Meeting[] meetings, SinglyLinkedList.Node<Meeting> head){
		int i = 0;
		while (head != null){
			assertTrue(head.data().equals(meetings[i]));
			i++;
			head = head.next();
		}
		assertTrue(meetings.length == i);
	}
} 
