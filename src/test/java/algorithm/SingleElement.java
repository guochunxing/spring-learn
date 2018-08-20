package algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * Author: chunxing
 * Date: 2018/7/12  下午10:44
 * Description:
 */
public class SingleElement {

    public static void main(String[] args) {
        int[] arr = {3, 3, 7, 7, 10, 11, 11};
        int i = singleNonDuplicate2(arr);
        System.out.println(i);
    }

    public static int singleNonDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            boolean add = set.add(num);
            if (!add) {
                set.remove(num);
            }
        }
        int i = 0;
        for (Integer integer : set) {
            i = integer;
        }
        return i;
    }

    public static int singleNonDuplicate2(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int middle = left + ((right - left) >> 2);

            if (middle % 2 == 1) middle--;

            if (nums[middle] != nums[middle + 1]) right = middle;
            else left = middle + 2;
        }
        return nums[left];
    }

}
