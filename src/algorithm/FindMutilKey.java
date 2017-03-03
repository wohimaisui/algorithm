/**
 * 
 */
package algorithm;


/**
 * @author yangchangjian_d 寻找为定值的多个key
 */
public class FindMutilKey {

	static int length;
/**
 * @param n 0...n个整数序列
 * @param m 为定值的和
 * @param flagI 为n个整数序列的数组
 * **/
	static void findCombination(int n, int m, int flagI[]) {
		if (n < 1 || m < 1) {
			return;
		}
		//n大于m,则n之后的数字肯定不在序列几何中
		if (n > m) {
			n = m;
		}
		if (n == m) {
			//注意:数组下标和n值序列差1,加入n值
			flagI[n - 1] = 1;
			for (int i = 0; i < length; i++) {
				//等于1的说明包括了
				if (flagI[i] == 1) {
					System.out.print(i + 1 + " ");
				}

			}
			System.out.println();
			//去掉n值
			flagI[n - 1] = 0;
		}
        //算最后一个数字,则1...n-1 与 m-n 相等
		flagI[n - 1] = 1;
		findCombination(n - 1, m - n, flagI);
		//不算最后一个数字 1....n-1 与m相等
		flagI[n - 1] = 0;
		findCombination(n - 1, m, flagI);
	}

	public static void main(String[] args) {
		/**
		 * 1,2,3....n
		 * */
		int n=100;
		/**
		 * 总共和为m
		 * */
		int m=80;
		length = n;
		int[] flag = new int[n];
		findCombination(n, m, flag);
	}

}
