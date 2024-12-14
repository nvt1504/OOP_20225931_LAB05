import java.util.Scanner;
import java.util.Arrays;
public class SortArray {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.println("Input number of element: ");
       int n = sc.nextInt();
       int[] arr = new int[n];
        System.out.println("Input your element: ");
        int sum = 0;
       for(int i = 0; i < n; i ++) {
           arr[i] = sc.nextInt();
           sum += arr[i];
       }

       Arrays.sort(arr);
       for(int i = 0; i < n; i++){
           System.out.print(arr[i] + " ");
       }

       double avg = sum / n;
        System.out.println( "\n" + avg);
    }
}
