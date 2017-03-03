/**
 * 
 */
package algorithm;


/**
 * @author yangchangjian_d
 *寻找最大的连续子数组
 */
public class FindMaxContinueSubArray {
	/**
	 * 暴力尝试法 时间复杂度n*n
	 *     sum                                maxSum
	 *    array[i]
	 *    array[i]+array[i+1]
	 *    array[i]+array[i+1]+array[i+2]
	 *    ...... 
	 * 
	 * **/
	public static int maxSumBase(int[] array){
		int maxSum=array[0];
		for (int i = 0; i < array.length; i++) {
			int sum=0;
			for (int j = i; j < array.length; j++) {
				sum=sum+array[j];
				if(sum>maxSum){
					maxSum=sum;
				}
			}
		}
		return maxSum;
	}

	public static int maxSsubArrSum(int[] array){
		//当前子数组
		int currSum=0;
		//最大子数组和
		int maxSum=array[0];
		for (int i = 0; i < array.length; i++) {
			//对每一个元素有2中情况,要么放入当前数组则+1,要么不放入当前数组则成下一个集合的元素
			if(currSum<0){
				//当前sum被重置,子序列的第一个值
				currSum=array[i];
				System.out.println("重置后 "+array[i]);
			}else{
				//当前sum被累加
				currSum=currSum+array[i];
			}
			if(maxSum<currSum){
				System.out.println("max重新赋值 "+array[i]);
				maxSum=currSum;
			}
				
		}
		return maxSum;
		
	}
	
	public static void main(String[] args) {
		int[] intArray=new int[]{1, -2, 3, 10, -4, 7, 2, -5};
		System.out.println(maxSsubArrSum(intArray));
		System.out.println(maxSumBase(intArray));
	}
}
