/**
 * 
 */
package algorithm;

/**
 * @author yangchangjian_d
 * @desc 根据二叉树的性质,完全二叉树中第i个节点,如果有孩子,则左子树为第2i+1个节点,右子树为2i+2个节点
 *       将一个序列调整为堆的时间复杂度为logn,堆排序的时间复杂度为n*logn
 */
public class HeapUtil {

	public static void heapSort(int[] table) {
		int n = table.length;
		for (int j = n / 2 - 1; j >= 0; j--) {
			sift(table, j, n - 1);
		}
		for (int j = n - 1; j > 0; j--) {
			int temp = table[0];
			table[0] = table[j];
			table[j] = temp;
			sift(table, 0, j - 1);
		}
	}

	// 将以begin为根的子树调整为最小堆,begin,end是序列下界和上界
	private static void sift(int[] table, int begin, int end) {
		// i为子树的根,j为i节点的左孩子
		int i = begin, j = 2 * i + 1;
		// 获得第i个元素的值
		int temp = table[i];
		// 沿着较小值孩子节点向下筛选
		while (j <= end) {
			// 数组元素比较,(改成<成最大堆)
			if (j < end && table[j] > table[j + 1])
				// j为左右孩子的最小者
				j++;
			// 若父母节点的值较大(改成<成最大堆)
			if (temp > table[j]) {
				// 孩子节点中的最小值向上移
				table[i] = table[j];
				// i j向下一层
				i = j;
				j = 2 * i + 1;
			} else {
				break;
			}

		}
		// 当前子树的原根值调整后的位置
		table[i] = temp;
	}

	public static void main(String[] args) {
		int[] ins = new int[] { 8, 6, 10, 7, 1, 2 };
		heapSort(ins);
		for (int i = 0; i < ins.length; i++) {
			System.out.print(ins[i] + " ");
		}
	}
}
