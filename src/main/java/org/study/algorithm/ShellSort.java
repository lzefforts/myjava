package org.study.algorithm;

/**
 * 希尔排序
 * @author ArnoldLee
 * @date 18/8/26
 */
public class ShellSort {

    public static void sort(long[] arrs){
        //初始化间隔
        int h = 1;
        //计算最大间隔
        while(h < arrs.length/3){
            h = 3*h +1;
            System.out.println("最大间隔是:"+h);
        }

        while(h > 0){
            long tmp = 0;
            for(int i=h;i<arrs.length;i++){
                tmp = arrs[i];
                int j = i;
                while(j>h-1 && arrs[j-h]>=tmp){
                    arrs[j] = arrs[j-h];
                    j-=h;
                }
                arrs[j]=tmp;
            }
            //减少间隔
            h = (h-1)/3;
            System.out.println("减少后的间隔是:"+h);
        }
    }

    public static void main(String[] args) {
        long[] arrs = {12,99,56,1,30,100};
        ShellSort.sort(arrs);
        int i = 0;
        while (i<arrs.length){
            System.out.println(arrs[i]);
            i++;
        }
    }
}
