package array;

import java.util.Arrays;

public class MergeArrays {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        //basic checks
        //if nums1 is null : throw exception
        //if nums2 is null : return
        //if m is 0 : populate nums2 in nums 1
        //if n is 0 :  return

        // [ 1,2,3,0,0,0] m
        // [ 2,5,6] n
        // 3 < 6 max (nums1[m-1], nums2[m-1])
        // [ 1,2,3,0,0,6] n--
        // 3 < 5
        // [ 1,2,3,0,5,6] n--
        // 3 > 2
        // [ 1,2,3,3,5,6] m--

        if( nums1 == null || nums2 == null) return;
        if(n == 0) return;
        if(m == 0){
            for( int i = 0; i < n; i++){
                nums1[i] = nums2[i];
            }
            return;
        }

        int i = m + n - 1; // 5
        m--; // 2
        n--; // 2

        // 6
        while(i >= 0 && m >= 0 && n >= 0){
            if(nums1[m] >= nums2[n]){
                nums1[i] = nums1[m];
                m--;
            }
            else{
                nums1[i] = nums2[n];
                n--;
            }
            i--;
        }
        System.out.println(Arrays.toString(nums1));
        System.out.println( n + " : " + i);
        if(m <= 0){
            while( n >= 0 && i >= 0){
                nums1[i] = nums2[n];
                System.out.println(nums1[i] + " : " + nums2[n]);
                n--;
                i--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {4,5,6,0,0,0};
        int[] nums2 = {1,2,3};
        int m = 3;
        int n = 3;

        merge(nums1, m, nums2, n);

        System.out.println(Arrays.toString(nums1));
    }
}
