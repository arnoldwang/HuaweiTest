package test2011;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class HuaweiTest {

	/**
	 * 输入字符串长度len1，字符串s1，字符串长度len2，字符串s2。 从后向前比较，以最短字符串为标准，输出不同的元素的个数。
	 * 
	 * @param str1
	 * @param len1
	 * @param str2
	 * @param len2
	 * @return
	 */
	public static int getDiffCharNum(String str1, int len1, String str2,
			int len2) {
		int count = 0;
		int len = (len1 > len2 ? len2 : len1);
		String[] s1 = str1.split(",");
		String[] s2 = str2.split(",");
		for (int i = 0; i < len; i++) {
			if (!s1[len1 - i - 1].equals(s2[len2 - i - 1]))
				count++;
		}
		return count;
	}

	/**
	 * 输入字符串长度，字符串，计数m。从前往后计数，当数到m个元素时，m个元素出列，同时将该元素赋值给m，然后从下一个数计数循环，直到所有数字都出列
	 * 给定的数全部为大于0的数字,输出出队队列。(约瑟夫环)
	 * 
	 * @param str
	 * @param len
	 * @param m
	 */
	public static void getOutString(String str, int len, int m) {
		String[] s = str.split(",");
		List<String> list = new ArrayList<String>(Arrays.asList(s)); 
		int i = 0;
		int count = 1;
		while(len > 0){
			while(count != m){
				count++;
				if(i < len-1)
					i++;
				else
					i = 0;
					
			}
			m = Integer.parseInt(list.get(i));
			System.out.println(list.remove(i));
			i = i == (len - 1) ? 0 : i;//注意这里！
			len--;
			count = 1;
		}
	}

	public static int getMyRet(String str){  
		Stack<Integer> numStack = new Stack<Integer>();
		Stack<Character> charStack = new Stack<Character>();
		char[] c = str.toCharArray();
		for(int i = 0; i < c.length; i++){
			switch(c[i]){
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9': 
				numStack.push(Character.digit(c[i], 10));
				break;
			case '+':
			case '-':
				charStack.push(c[i]);
				break;
			case '*':
				i++;
				numStack.push((int)(numStack.pop()*Character.digit(c[i], 10)));
				break;
			case '/':
				i++;
				numStack.push((int)(numStack.pop()/Character.digit(c[i], 10)));
				break;
			}
		}
		while(!charStack.isEmpty()){
			int num2 = numStack.pop();
			int num1 = numStack.pop();
			if(charStack.pop() == '+')
				numStack.push(num1 + num2);
			else
				numStack.push(num1 - num2);
		}
		return numStack.pop();
	}
	
	public static void main(String[] args) {
		String s1 = "1,3,5";
		String s2 = "2,4,1,7,5";
		String s3 = "3,1,2,4";
		int len1 = 3;
		int len2 = 5;
		int len3 = 4;
		System.out.println(HuaweiTest.getMyRet("3+8*2/9-2"));
	}

}
