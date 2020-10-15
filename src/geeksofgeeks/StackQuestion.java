package geeksofgeeks;

import java.util.Stack;

public class StackQuestion extends Stack<Integer> {

	Stack<Integer> minimum = new Stack<>();

	public Integer push(Integer item) {

		if(minimum == null){
			super.push(item);
			minimum.push(item);
		}
		int temp = super.pop();
		if(temp < item){
			minimum.push(temp);
			super.push(temp);
			super.push(item);
		}else{
			minimum.push(item);
			super.push(temp);
			super.push(item);
		}
		return item;
	}

}
