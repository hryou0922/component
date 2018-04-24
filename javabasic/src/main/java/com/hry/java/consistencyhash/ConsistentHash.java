package com.hry.java.consistencyhash;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class ConsistentHash<T> {
    private final IHashFunction hashFunction;
    private final int numberOfReplicas;// 节点的复制因子,实际节点个数 * numberOfReplicas = 虚拟节点个数
    private final SortedMap<Long, T> circle = new TreeMap<Long, T>();// 存储虚拟节点的hash值到真实节点的映射

    public ConsistentHash(IHashFunction hashFunction, int numberOfReplicas,
            Collection<T> nodes) {
        this.hashFunction = hashFunction;
        this.numberOfReplicas = numberOfReplicas;
        for (T node : nodes)
            add(node);
    }

    public void add(T node) {
        for (int i = 0; i < numberOfReplicas; i++){
            // 对于一个实际机器节点 node, 对应 numberOfReplicas 个虚拟节点
            /*
             * 不同的虚拟节点(i不同)有不同的hash值,但都对应同一个实际机器node
             * 虚拟node一般是均衡分布在环上的,数据存储在顺时针方向的虚拟node上
             */
            circle.put(hashFunction.hash(node.toString() + i), node);
        }
    }

    public void remove(T node) {
        for (int i = 0; i < numberOfReplicas; i++){
            circle.remove(hashFunction.hash(node.toString() + i));
        }
    }

    /*
     * 获得一个最近的顺时针节点,根据给定的key 取Hash
     * 然后再取得顺时针方向上最近的一个虚拟节点对应的实际节点
     * 再从实际节点中取得 数据
     */
    public T get(Object key) {
        if (circle.isEmpty())
            return null;
        long hash = hashFunction.hash((String) key);// node 用String来表示,获得node在哈希环中的hashCode
        if (!circle.containsKey(hash)) {//数据映射在两台虚拟机器所在环之间,就需要按顺时针方向寻找机器
            SortedMap<Long, T> tailMap = circle.tailMap(hash);
            hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
        }
        return circle.get(hash);
    }

    public long getSize() {
        return circle.size();
    }
    
    /*
     * 查看MD5算法生成的hashCode值---表示整个哈希环中各个虚拟节点位置
     */
    public void testBalance(){
        Set<Long> sets  = circle.keySet();//获得TreeMap中所有的Key
        SortedSet<Long> sortedSets= new TreeSet<Long>(sets);//将获得的Key集合排序
        for(Long hashCode : sortedSets){
            System.out.println(hashCode);
        }
        
        System.out.println("----each location 's distance are follows: ----");
        /*
         * 查看用MD5算法生成的long hashCode 相邻两个hashCode的差值
         */
        Iterator<Long> it = sortedSets.iterator();
        Iterator<Long> it2 = sortedSets.iterator();
        if(it2.hasNext())
            it2.next();
        long keyPre, keyAfter;
        while(it.hasNext() && it2.hasNext()){
            keyPre = it.next();
            keyAfter = it2.next();
            System.out.println(keyAfter - keyPre);
        }
    }
    
    public static void main(String[] args) {
        Set<String> nodes = new HashSet<String>();
        nodes.add("10.30.4.31");
        nodes.add("10.30.4.32");
        nodes.add("10.30.4.33");
        nodes.add("10.30.4.34");
//        nodes.add("10.30.4.35");
//        nodes.add("10.30.4.36");
//        nodes.add("10.30.4.37");
//        nodes.add("10.30.4.38");
        ConsistentHash<String> consistentHash = new ConsistentHash<String>(new HashFunction(), 20, nodes);
        
        System.out.println("hash circle size: " + consistentHash.getSize());
        System.out.println("location of each node are follows: ");
        consistentHash.testBalance();
        
        fnv132HashFunction();
        
    }
    
    public static void fnv132HashFunction(){
    	 Set<String> nodes = new HashSet<String>();
         nodes.add("10.30.4.31");
         nodes.add("10.30.4.32");
         nodes.add("10.30.4.33");
         nodes.add("10.30.4.34");
//         nodes.add("10.30.4.35");
//         nodes.add("10.30.4.36");
//         nodes.add("10.30.4.37");
//         nodes.add("10.30.4.38");
         ConsistentHash<String> consistentHash = new ConsistentHash<String>(new Fnv132HashFunction(), 20, nodes);
         
         System.out.println("hash circle size: " + consistentHash.getSize());
         System.out.println("location of each node are follows: ");
         consistentHash.testBalance();
    }
}
