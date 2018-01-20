package com.calvin.cake;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

import com.calvin.collection.SinglyLinkedList;

public class HiCal {
	public static final Meeting NULL_MEETING = new Meeting(-1, -1);
	public static final SinglyLinkedList.Node<Meeting> NULL_MEETING_NODE = SinglyLinkedList.Node.of(NULL_MEETING);
	public static class Meeting {
		private int startTime;
		private int endTime;

		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + endTime;
			result = prime * result + startTime;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Meeting other = (Meeting) obj;
			if (endTime != other.endTime)
				return false;
			if (startTime != other.startTime)
				return false;
			return true;
		}
		public Meeting(int startTime, int endTime){
			this.startTime = startTime;
			this.endTime = endTime;
		}
		public int getStartTime() {
			return startTime;
		}

		public void setStartTime(int startTime) {
			this.startTime = startTime;
		}

		public int getEndTime() {
			return endTime;
		}

		public void setEndTime(int endTime) {
			this.endTime = endTime;
		}
		
		@Override
		public String toString() {
			return "[" + startTime + ", " + endTime + "]";
		}
		
		boolean overlaps(Meeting other){
			return !(this.endTime < other.startTime || this.startTime > other .endTime);
		}
		
		boolean before(Meeting other){
			return this.endTime < other.startTime;
		}
		
		boolean after(Meeting other){
			return this.startTime > other.endTime;
		}
		
		/**
		 * Side effect: This object is modified
		 * @param other
		 * @return
		 */
		Meeting mergeWith(Meeting other){
			this.startTime = Math.min(this.startTime, other.startTime);
			this.endTime = Math.max(this.endTime, other.endTime);
			return this;
		}
	}
	
	public static List<Meeting> mergeRangeOnePass(Meeting...meetings){
		// [8, 12], [4, 3], [2, 1]
		// O(n^2) -  we want to do O(n)
		// [0, 100]
		// if we put this into an array of boolean, we can put 1s into 
		BitSet slots = new BitSet(1024);
		int lastSlot = -1;
		for (Meeting meeting : meetings){
			slots.set(meeting.startTime, meeting.endTime + 1);
			lastSlot = Math.max(meeting.endTime, lastSlot);
		}
		
		// Check first bit location
		List<Meeting> result = new ArrayList<Meeting>();
		boolean mode = slots.get(0);
		int modeStartIndex = 0;
		int i = 1;
		
		// We only want a series of "true"
		boolean foundBegin = false;
		int beginStart = -1;
		while (i <= lastSlot){
			if (foundBegin){
				if (!slots.get(i)){
					result.add(new Meeting(beginStart, i - 1));
					foundBegin = false;
					beginStart = -1;
				}
			}
			else{
				if (slots.get(i)){
					foundBegin = true;
					beginStart = i;
				}
			}
			i++;
		}
		if (foundBegin){
			result.add(new Meeting(beginStart, lastSlot));
		}
		return result;
	}
	
	/**
	 * One off
	 * O(n^2)
	 * 
	 * By sorting the input by start time, we can do the merge in one pass.  Complexity will be
	 * O(n log n)
	 * 
	 * @param meetings
	 * @return
	 */
	public static SinglyLinkedList.Node<Meeting> mergeRange(Meeting...meetings){
		// For each meeting
		// Check against existing slots
		// If overlap, merge until meeting.end is covered
		if (meetings.length <= 0){
			return null;
		}
				
		SinglyLinkedList.Node<Meeting> head = SinglyLinkedList.Node.of(meetings[0]);
		for (int i = 1; i < meetings.length; i++){
			// Check if we should insert to head
			SinglyLinkedList.Node<Meeting> previous = NULL_MEETING_NODE.next(head);
			SinglyLinkedList.Node<Meeting> current = head;
			Meeting meeting = meetings[i];

			// [6, 8]
			boolean processed = false;
			while (current != null){
				// It is slow to begin searching from the beginning of the list
				// We can use a tree to hold end time
				if (meeting.before(current.data())){
					// Insert before current
					previous.next(SinglyLinkedList.Node.of(meeting).next(current));
					processed = true;
					break;
				}
				else if (meeting.overlaps(current.data())){
					// Found out when is the end
					SinglyLinkedList.Node<Meeting> runner = current;
					while (runner.next() != null){
						if (meeting.endTime < runner.next().data().startTime){
							break;
						}
						runner = runner.next();
					}
					// Merge current, runner and meeting
					current.data().mergeWith(meeting).mergeWith(runner.data());
					if (current != runner){
						current.next(runner.next());						
					}
					processed = true;
					break;
				}
				previous = current;
				current = current.next();
			}
			if (!processed){
				previous.next(SinglyLinkedList.Node.of(meetings[i]));
			}
		}
		
		// Print things out
		head = NULL_MEETING_NODE.next();
		int previousEnd = 0;
		while (head != null){
			if (head.data().startTime > previousEnd){
				System.out.println("Empty from " + previousEnd + " to " + head.data().startTime);
			}
			previousEnd = head.data().endTime;
			head = head.next();
		}
		
		return NULL_MEETING_NODE.next();
	}
}
