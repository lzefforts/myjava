package org.study.algorithm;

import java.util.Stack;

/**
 * Created by ArnoldLee on 18/6/26.
 */
public class StackTest {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.add("123");
        stack.add("234");
        stack.add("345");

        System.out.println(stack.empty());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.size());

        Integer a = Integer.valueOf(990);
        Double aa = Double.valueOf(a)/100;
        System.out.println("###########");
        System.out.println(aa);
    }

}
