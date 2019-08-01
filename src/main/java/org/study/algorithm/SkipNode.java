package org.study.algorithm;

import java.util.Arrays;

/**
 * 跳跃列表节点
 * @author ArnoldLee
 * @date 18/8/19
 */
public class SkipNode<K,V>{
    K k;
    V v;
    SkipNode<K,V>[] forward;

    @SuppressWarnings("unchecked")
    public SkipNode(K k,V v,int level) {
        this.k = k;
        this.v = v;
        forward = (SkipNode<K,V>[])new SkipNode[level + 1];
        for(int i = 0;i < level;i++) {
            forward[i] = null;
        }
    }

    @Override
    public String toString() {
        return "SkipNode [k=" + k + ", v=" + v + ", forward=" + Arrays.toString(forward) + "]";
    }
}
