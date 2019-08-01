package org.study.algorithm;

/**
 * 二分查找
 * @author ArnoldLee
 * @date 2019/3/12
 */
public class BinarySearch {


    public int search(int[] nums, int target) {
        int length = nums.length -1;
        int begin = 0;
        int mid = 0;
        while(begin <= length){
            mid = (begin+length)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] > target){
                length = mid -1;
            }
            else if(nums[mid] < target){
                begin = mid + 1;
            }

        }
        return -1;
    }

    public int search2(int[] nums, int target) {
        int begin = 0;
        int end = nums.length;
        int half = (begin+end)/2;
        while(begin<end){
            if(nums[half]<target){
                begin = half;
            }else if(nums[half]>target){
                end = half;
            }else if(nums[half]==target){
                return half;
            }
            if((half)==(begin+end)/2){
                return -1;
            }else {
                half=(begin+end)/2;
            }

        }
        return -1;
    }

}
