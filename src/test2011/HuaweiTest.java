package test2011;

public class HuaweiTest {

	/**
	 * 输入字符串长度len1，字符串s1，字符串长度len2，字符串s2。 从后向前比较，以最短字符串为标准，输出不同的元素的个数。
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

	public static void main(String[] args) {
		String s1 = "1,3,5";
		String s2 = "2,4,1,7,5";
		int len1 = 3;
		int len2 = 5;
		System.out.println(HuaweiTest.getDiffCharNum(s1, len1, s2, len2));
	}

}
