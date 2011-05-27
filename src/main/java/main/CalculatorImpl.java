package main;

public class CalculatorImpl implements Calculator {

	public String add(String left, String right) {
		Integer sizeLeft = left.length();
		Integer sizeRight = right.length();
		
		Integer[] leftNumber = createArray(left, sizeLeft);
		Integer[] rightNumber = createArray(right, sizeRight);
		Integer[] addResult = new Integer[Math.max(sizeLeft, sizeRight) + 1];
		
		Integer rest = 0;
		for (int i = 0; i < (Math.max(sizeLeft,	sizeRight)); i++) {
			Integer partial = (i < sizeLeft ? leftNumber[i] : 0) + (i < sizeRight ? rightNumber[i] : 0) + rest;
			addResult[i] = partial % 10;
			rest = (Integer) partial / 10; 
		}
		
		if (rest > 0) addResult[addResult.length - 1] = rest;
				
		StringBuilder returnAdd = new StringBuilder();
		for (Integer integer : addResult) {
			if (integer != null) returnAdd.append(String.valueOf(integer));		
		}
		
		return returnAdd.reverse().toString();
	}

	public String subtract(String left, String right) {
		Integer sizeLeft = left.length();
		Integer sizeRight = right.length();
		
		Integer[] leftNumber = createArray(left, sizeLeft);
		Integer[] rightNumber = createArray(right, sizeRight);
		Integer[] addResult = new Integer[Math.max(sizeLeft, sizeRight) + 1];
		
		Integer rest = 0;
		for (int i = 0; i < (Math.max(sizeLeft,	sizeRight)); i++) {
			Integer leftPartial = i < sizeLeft ? leftNumber[i] : 0;
			Integer rightPartial = i < sizeRight ? rightNumber[i] : 0;
			
			Integer partial = 0;
			if (leftPartial < rightPartial) {
				leftPartial += 10;
				partial = leftPartial - rest - rightPartial;
				rest = 1;
			} else {
				partial = leftPartial - rest - rightPartial;
				rest = 0;
			}

			addResult[i] = partial; 
		}
		
		StringBuilder returnAdd = new StringBuilder();
		for (Integer integer : addResult) {
			if (integer != null) returnAdd.append(String.valueOf(integer));		
		}
		
		return returnAdd.reverse().toString();
	}

	public int compare(String left, String right) {
		return left.compareTo(right);
	}
	
	public Integer[] createArray(String number, Integer size) {
		Integer[] arrReturn = new Integer[size];
		
		for (int i = 0; i < size; i++) {
			arrReturn[i] = Integer.valueOf(String.valueOf(number.charAt(size - (i + 1))));
		}
		return arrReturn;
	}
}
