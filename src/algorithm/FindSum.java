/**
 * 
 */
package algorithm;

/**
 * @author yangchangjian_d
 * 寻找定值为sum的2个数
 */
public class FindSum {
/**
 * 如果没有排序则先排序
 * */
	public static void main(String[] args) {
		int sum=15;
		//如果没排序则先排序
		int[] ins = new int[] { 1, 2, 4, 7, 8,11, 15 };
		//排序过后形成越往左越小,越往右越大的数据序列,2个指针,2端扫描
		int i=0,j=ins.length-1;
		while(i<j){
			if(ins[i]+ins[j]<sum)
				++i;
			else if(ins[i]+ins[j]>sum)
				--j;
			else{
				System.out.print(ins[i]+"  "+ins[j]);
				i++;--j;
				System.out.println();
				continue;
			}
				
		}
	}
}
