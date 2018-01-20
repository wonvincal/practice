package com.calvin.educative.io.math;

public class IsStringValidNumber {
	public static interface State{
		State process(char character);
	}

	public static Idle IDLE = new Idle();
//	public static NegState NEG = new NegState();
	public static DecimalAllowableNumberState DEC_ALLOW = new DecimalAllowableNumberState();
	public static DecimalNotAllowableNumberState DEC_NOT_ALLOW = new DecimalNotAllowableNumberState();
	public static PrefixZeroState PREFIX_ZERO = new PrefixZeroState();
	public static FailState FAILED = new FailState();
	
	public static class Idle implements State {
		@Override
		public State process(char character) {
//			if (character == '-'){
//				return NEG;
//			}
			if (character == '0'){
				return PREFIX_ZERO;
			}
			if (character >= '1' && character <= '9'){
				return DEC_ALLOW;
			}
			return FAILED;
		}
	}
	
//	public static class NegState implements State {
//		@Override
//		public State process(char character) {
//			if (character == '0'){
//				return PREFIX_ZERO;
//			}
//			if (character >= '1' && character <= '9'){
//				return DEC_ALLOW;
//			}
//			return FAILED;
//		}
//	}
//
	public static class DecimalAllowableNumberState implements State {
		@Override
		public State process(char character) {
			if (character == '.'){
				return DEC_NOT_ALLOW;
			}
			if (character >= '0' && character <= '9'){
				return this;
			}
			return FAILED;
		}
	}
	
	public static class DecimalNotAllowableNumberState implements State {
		@Override
		public State process(char character) {
			if (character >= '0' && character <= '9'){
				return this;
			}
			return FAILED;
		}
	}

	public static class PrefixZeroState implements State {
		@Override
		public State process(char character) {
			if (character == '.'){
				return DEC_NOT_ALLOW;
			}
			return FAILED;
		}
	}

	public static class FailState implements State {
		@Override
		public State process(char character) {
			return this;
		}
	}

	public static boolean isValid(String number){
		State current = IDLE;
		
		int start = 0;
		if (number.charAt(0) == '-' || number.charAt(0) == '+'){
			start++;
		}
		for (int i = start; i < number.length(); i++){
			current = current.process(number.charAt(i));
		}
		return current != FAILED;
	}
}
