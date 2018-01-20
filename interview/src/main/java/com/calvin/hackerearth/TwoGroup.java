package com.calvin.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoGroup {
	public void main(String[] args){
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input;
		TwoGroup group = new TwoGroup();
		try {
			input = reader.readLine();
			int numTest = Integer.parseInt(input);
			while ((input = reader.readLine()) != null){
				int n = Integer.parseInt(input);
						
				group.findWaysToDivideIntoTwoGroups(n);
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public long findWaysToDivideIntoTwoGroups(int n){
		return 0;
	}
}
