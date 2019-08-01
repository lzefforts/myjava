package org.study.algorithm;

/**
 * Created by ArnoldLee on 18/8/26.
 */
public class BTree {

    private Node left;

    private Node right;




    public void insert(Integer insObj){



    }





    protected class Node{

        private Integer left;

        private Integer right;

        public Node(Integer left, Integer right) {
            this.left = left;
            this.right = right;
        }

        public Integer getLeft() {
            return left;
        }

        public Integer getRight() {
            return right;
        }
    }


}
