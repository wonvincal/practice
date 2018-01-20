package com.calvin.interview.io;

public class CalculateProduct {
	/**
	 * Two passes
	 * @param inputs
	 * @return
	 */
	public int[] calculate(int[] inputs){
		if (inputs.length < 2){
			throw new IllegalArgumentException("Array must be of size >= 2");
		}
		
		int[] interim = new int[inputs.length];
		int running = 1;
		interim[0] = 1;
		for (int i = 1; i < inputs.length; i++){
			running *= inputs[i- 1];
			interim[i] = running;
		}
		running = 1;
		for (int j = inputs.length - 2; j >=0; j--){
			running *= inputs[j + 1];
			interim[j] = interim[j] * running;
		}
		return interim;
	}
}
