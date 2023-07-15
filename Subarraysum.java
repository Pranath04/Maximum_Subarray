package subarraysum;
import java.util.Scanner;
public class Subarraysum {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.println("Enter value of A");
        int A=scanner.nextInt();

        System.out.println("Enter value of B");
        int B=scanner.nextInt();

        System.out.println("Enter the size of the array !!!");
        int size=scanner.nextInt();

        int array[]=new int[size];
        System.out.println("Enter the Array Elements !!!");
        for(int i=0;i<size;i++){
            array[i]=scanner.nextInt();
        }
        scanner.close();

        System.out.println(maximumSubarraySum(A,B,array));
    }
    public static int maximumSubarraySum(int A, int B, int[] C) {
        int[] prefixSum = new int[A + 1];
        for (int i = 1; i <= A; i++) {
            prefixSum[i] = prefixSum[i - 1] + C[i - 1];
        }

        int maxSum = 0;
        for (int i = 0; i <= A; i++) {
            int j = 0;
            while (j < i && prefixSum[i] - prefixSum[j] > B) {
                j++;
            }
            int subarraySum = prefixSum[i] - prefixSum[j];
            maxSum = Math.max(maxSum, subarraySum);
        }

        return maxSum;
    }


}