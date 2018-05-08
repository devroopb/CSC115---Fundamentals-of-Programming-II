public void remove(int index){
	for(int i = index; i < numItems - 1; i++){
		item[i] = item[i+1];
}
numItems--;




public static int maxNumber(ListInterface aList){
	int max = aList.retrieve(0);
	for(int i = 1; i < aList.getLength()-1; i++){
		if(aList.retrieve(i)>max){
			max = aList.retrieve(i);
		}
	}
	return max;
}




public static boolean isMatching(String input){
	Stack<Character> stack = new Stack<Character>();

	for(int i = 0; i < stack.size()-1; i++){
		if input.charAt(i) == '{'{
			stack.push('{');
		}else if(input.charAt(i) == '}'){
			try{
				stack.pop()
			}catch(StackEmptyException e){
				return false;
			}
		}else{
			return false;
		}
	}

	if (stack.empty() == true){
		return true;
	}else(
		return false;
	)
}




private static boolean isPalindrome(String s){
	if(s.length() == 0 || s.length() == 1){
		return true;
	}
	
	if(s.charAt(0) == s.charAt(s.length()-1)){
		return isPalindrome(s.substring(1, s.length()-1))
	}
	
	return false;
}