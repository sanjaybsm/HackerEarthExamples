package geeksofgeeks;


// { Driver Code Starts
import java.util.Scanner;
import java.util.Stack;
class SpeStack {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			Stack<Integer> s=new Stack<>();
			GfG g=new GfG();
			while(!g.isFull(s,n)){
				g.push(sc.nextInt(),s);
			}
			System.out.println(g.min(s));
		}
	}
}// } Driver Code Ends


class GfG extends  Stack<Integer> {

	Stack<Integer> minimum = new Stack<>();

	public void push(int a,Stack<Integer> s)
	{
		if(minimum == null){
			s.push(a);
			minimum.push(a);
		}
		int temp = s.pop();
		if(temp < a){
			minimum.push(temp);
			s.push(temp);
			s.push(a);
		}else{
			minimum.push(a);
			s.push(temp);
			s.push(a);
		}
	}
	public int pop(Stack<Integer> s)
	{
		if(isEmpty(s)){
			return 0;
		} else {
			int value = s.pop();
			minimum.pop();
			return value;
		}
	}
	public int min(Stack<Integer> s)
	{
		int min = minimum.pop();
		minimum.push(min);
		return min;
	}
	public boolean isFull(Stack<Integer>s, int n)
	{
		if(s.capacity() == n){
			return true;
		}else {
			return false;
		}
	}
	public boolean isEmpty(Stack<Integer> s)
	{
		return s.isEmpty();
	}
}