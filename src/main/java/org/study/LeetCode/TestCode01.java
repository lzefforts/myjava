package org.study.LeetCode;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次
 * 找出那个只出现了一次的元素。
 *
 * @author ArnoldLee
 * @date 2019/3/1
 */
public class TestCode01 {

    public int singleNumber(int[] nums) {
        int num = 0;
        for(int i = 0; i < nums.length; i++){
            num = num ^ nums[i];
        }
        return num;
    }

    public static void main(String[] args) {
        int[] data = new int[]{4,1,2,1,2};
        TestCode01 sol = new TestCode01();
        System.out.println(sol.singleNumber(data));
    }


}
