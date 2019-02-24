/**
 * @Author: 98050
 * @Time: 2019-01-22 09:55
 * @Feature:
 */
import java.util.ArrayList;
public class Solution {

    public static void main(String[] args) {
        int[] array = new int[]{6501,6828,6963,7036,7422,7674,8146,8468,8704,8717,9170,9359,9719,9895,9896,9913,9962,154,293,334,492,1323,1479,1539,1727,1870,1943,2383,2392,2996,3282,3812,3903,4465,4605,4665,4772,4828,5142,5437,5448,5668,5706,5725,6300,6335};
        System.out.println(minNumberInRotateArray(array));
    }

    public static int minNumberInRotateArray(int [] array) {
        int length = array.length;
        if (length == 0){
            return 0;
        }
//        for (int i = 0; i < length; i++) {
//            if (i - 1 >= 0 && i + 1 <= length - 1){
//                if (array[i - 1] > array[i] && array[i + 1] > array[i]){
//                    return array[i];
//                }
//            }
//        }
//        return 0;
        int low = 0;
        int high = length - 1;
        int mid;
        while (low <= high){
            mid = (low + high) / 2;
            System.out.println(array[mid]);
            if (mid - 1 >= 0 && mid + 1 <= length - 1){
                if (array[mid] < array[mid - 1] && array[mid] <= array[mid + 1]){
                    return array[mid];
                }else if (array[mid] > array[low]){
                    low = mid + 1;
                }else {
                    high = mid - 1;
                }
            }
        }
        return 0;
    }
}
