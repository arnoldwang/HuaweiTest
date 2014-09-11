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
		while (len > 0) {
			while (count != m) {
				count++;
				if (i < len - 1)
					i++;
				else
					i = 0;

			}
			m = Integer.parseInt(list.get(i));
			System.out.println(list.remove(i));
			i = i == (len - 1) ? 0 : i;// 注意这里！
			len--;
			count = 1;
		}
	}

	/**
	 * 输入一个表达式，没有括号，数字小于0-9之间，输出计算结果，所有的中间结果化为整形。
	 * 
	 * @param str
	 * @return
	 */
	public static int getMyRet(String str) {
		Stack<Integer> numStack = new Stack<Integer>();
		Stack<Character> charStack = new Stack<Character>();
		char[] c = str.toCharArray();
		for (int i = 0; i < c.length; i++) {
			switch (c[i]) {
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
				numStack.push((int) (numStack.pop() * Character.digit(c[i], 10)));
				break;
			case '/':
				i++;
				numStack.push((int) (numStack.pop() / Character.digit(c[i], 10)));
				break;
			}
		}
		while (!charStack.isEmpty()) {
			int num2 = numStack.pop();
			int num1 = numStack.pop();
			if (charStack.pop() == '+')
				numStack.push(num1 + num2);
			else
				numStack.push(num1 - num2);
		}
		return numStack.pop();
	}

	/**
	 * 选秀节目打分，分为专家评委和大众评委，score[] 数组里面存储每个评委打的分数，judge_type[] 里存储与 score[]
	 * 数组对应的评委类别， judge_type[i] == 1，表示专家评委，judge_type[i] == 2，表示大众评委，n表示评委总数。
	 * 打分规则如下：专家评委和大众评委的分数先分别取一个平均分（平均分取整），然后，总分 = 专家评委平均分 * 0.6 + 大众评委
	 * *0.4，总分取整。 如果没有大众评委，则 总分 = 专家评委平均分，总分取整。函数最终返回选手得分。
	 * 
	 * @param score
	 * @param judge_type
	 * @param n
	 * @return
	 */
	public static int cal_score(int score[], int judge_type[], int n) {
		int result = 0;
		int perScore = 0, norScore = 0;
		int perNum = 0, norNum = 0;
		for (int i = 0; i < n; i++) {
			if (judge_type[i] == 1) {
				perScore += score[i];
				perNum++;
			}
			if (judge_type[i] == 2) {
				norScore += score[i];
				norNum++;
			}
		}
		result = norNum == 0 ? (int) (perScore / perNum) : (int) (perScore
				/ perNum * 0.6)
				+ (int) (norScore / norNum * 0.4);
		return result;
	}

	/**
	 * 给定一个数组input[] ，如果数组长度n为奇数，则将数组中最大的元素放到 output[] 数组最中间的位置，
	 * 如果数组长度n为偶数，则将数组中最大的元素放到 output[] 数组中间两个位置偏右的那个位置上，
	 * 然后再按从大到小的顺序，依次在第一个位置的两边，按照一左一右的顺序，依次存放剩下的数。
	 * 
	 * @param input
	 * @param n
	 * @param output
	 */
	public static void sort(int input[], int n, int output[]) {
		quickSort(input, 0, input.length - 1);
		int p = n / 2;
		int q = n / 2 - 1;
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				output[p] = input[i];
				p++;
			} else {
				output[q] = input[i];
				q--;
			}
		}
		for (int temp : output)
			System.out.print(temp + " ");
	}

	private static void quickSort(int[] input, int left, int right) {
		if (left + 1 < right) {
			int pivot = median3(input, left, right);

			int i = left + 1, j = right;
			while (true) {
				while (input[++i] > pivot) {
				}
				while (input[--j] < pivot) {
				}

				if (i < j)
					swap(input, i, j);
				else
					break;
			}
			swap(input, j, left + 1);
			quickSort(input, left, j - 1);
			quickSort(input, j + 1, right);
		} else {
			if (input[left] < input[right])
				swap(input, left, right);
		}

	}

	private static int median3(int[] input, int left, int right) {
		// TODO Auto-generated method stub
		int center = (left + right) / 2;
		if (input[left] < input[center])
			swap(input, left, center);
		if (input[center] < input[right])
			swap(input, center, right);
		if (input[left] < input[center])
			swap(input, left, center);
		swap(input, center, left + 1);
		return input[left + 1];
	}

	private static void swap(int[] input, int a, int b) {
		// TODO Auto-generated method stub
		int temp = input[a];
		input[a] = input[b];
		input[b] = temp;
	}

	/**
	 * 操作系统任务调度问题。操作系统任务分为系统任务和用户任务两种。其中，系统任务的优先级 < 50，用户任务的优先级 >= 50且 <= 255。
	 * 优先级大于255的为非法任务，应予以剔除。现有一任务队列task[]，长度为n，task中的元素值表示任务的优先级，数值越小，优先级越高。
	 * 函数scheduler实现如下功能，将task[] 中的任务按照系统任务、用户任务依次存放到
	 * system_task[]数组和user_task[]数组中（数组中元素的值是任务在task[]数组中的下标），
	 * 并且优先级高的任务排在前面，优先级相同的任务按照入队顺序排列（即先入队的任务排在前面），数组元素为-1表示结束。
	 * 
	 * @param task
	 * @param n
	 * @param system_task
	 * @param user_task
	 */
	public static void scheduler(int task[], int n, int system_task[],
			int user_task[]) {
		int p = 0, q = 0;
		for (int i = 0; i < n; i++) {
			if (task[i] < 50) {
				int m = p;
				while (m > 0) {
					if (task[system_task[m - 1]] < task[i])
						break;
					system_task[m] = system_task[m - 1];
					m--;
				}
				system_task[m] = i;
				p++;
			}
			if (task[i] >= 50 && task[i] <= 255) {
				int m = q;
				while (m > 0) {
					if (task[user_task[m - 1]] < task[i])
						break;
					user_task[m] = user_task[m - 1];
					m--;
				}
				user_task[m] = i;
				q++;
			}
		}
		system_task[p] = -1;
		user_task[q] = -1;
		for (int temp : system_task)
			System.out.print(temp + " ");
		for (int temp : user_task)
			System.out.print(temp + " ");
	}

	
	public static void main(String[] args) {
		String s1 = "1,3,5";
		String s2 = "2,4,1,7,5";
		String s3 = "3,1,2,4";
		int len1 = 3;
		int len2 = 5;
		int len3 = 4;
		// System.out.println(HuaweiTest.getMyRet("3+8*2/9-2"));
		int score[] = { 34, 53, 65, 75, 64 };
		int judge_type[] = { 1, 1, 1, 2, 2 };
		// System.out.print(HuaweiTest.cal_score(score, judge_type, 5));
		int input[] = { 3, 6, 1, 9, 7, 8 };
		int output[] = new int[6];
		// HuaweiTest.sort(input, 6, output);
		int task[] = { 0, 30, 155, 1, 80, 300, 170, 40, 99 };
		int system_task[] = new int[9];
		int user_task[] = new int[9];
		HuaweiTest.scheduler(task, 9, system_task, user_task);
	}

}
