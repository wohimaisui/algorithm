package algorithm;

import java.util.Stack;

public class ReverseStackRecursive {

	/**
	 * Q 66.颠倒栈。
	 * 题目：用递归颠倒一个栈。例如输入栈{1,2,3,4,5}，1在栈顶。
	 * 颠倒之后的栈为{5,4,3,2,1}，5处在栈顶。
	 *1. Pop the top element
	 *2. Reverse the remaining stack
	 *3. Add the top element to the bottom of the remaining stack
	 */
	public static void main(String[] args) {
		ReverseStackRecursive r=new ReverseStackRecursive();
		Stack<Integer> stack=new Stack<Integer>();
		for(int i=0;i<10;i++){
			stack.add(i);
		}
		r.printStack(stack);
		r.reverseStack(stack);
		r.printStack(stack);
	}

	public void reverseStack(Stack<Integer> stack){
		if(!stack.empty()){
			Integer top=stack.pop();
			reverseStack(stack);
			//每放一个都把目前栈里面的数全部弹出
			addToBottom(stack,top);
		}
	}
/**
 * 重要方法:由于递归调用reverseStack方法最后弹出的肯定也会被先push进去,比如0先被push了进去,如何1放入底部？
 * 方法就是再次利用递归方法把栈清空,然后把1放入底部,当轮到2的时候,再次把1,0弹出,然后把2压入底部。如此循环到9,
 * 该方法时间复杂度是n*n
 * **/
	public void addToBottom(Stack<Integer> stack,Integer ele){
		if(stack.empty()){
			stack.push(ele);
		}else{
			Integer top=stack.pop();
			addToBottom(stack,ele);//important
			System.err.print("放入元素: "+ele+" ");
			stack.push(top);
		}
	}
	public void printStack(Stack<Integer> stack){
		/*
		while(!stack.empty()){
			System.out.print(stack.pop()+",");
		}
		*/
		//we don't remove the elements in the stack.
		for(Integer x:stack){
			System.out.print(x+",");
		}
		System.out.println();
	}
}

