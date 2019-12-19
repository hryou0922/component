package com.hry.guava.collection;

import com.hry.guava.collection.support.StudentScore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Guava
 *  集合使用
 *
 *
 * @author: huangrongyou@yixin.im
 * @date: 2019/12/16 9:48
 */
public class MultiCollectionDemo {

    /**
     * 测试 Multimap
     *  处理构造像Map<K, List<V>>或者Map<K, Set<V>>这样比较复杂的集合类型的数据结构
     *
     */
    public void testMultimap(){
        Multimap<String, StudentScore> scoreMultimap = ArrayListMultimap.create();
        for(int i=10;i<20;i++){
            StudentScore studentScore=new StudentScore();
            studentScore.setCourseId(1001+i);
            studentScore.setScore(100-i);
            scoreMultimap.put("peida" ,studentScore);
        }
        System.out.println("scoreMultimap:"+scoreMultimap.size());
        System.out.println("scoreMultimap:"+scoreMultimap.keys());

        Collection<StudentScore> studentScore = scoreMultimap.get("peida");
        studentScore.clear();
        StudentScore studentScoreNew=new StudentScore();
        studentScoreNew.setCourseId(1034);
        studentScoreNew.setScore(67);
        studentScore.add(studentScoreNew);

        System.out.println("scoreMultimap:"+scoreMultimap.size());
        System.out.println("scoreMultimap:"+scoreMultimap.keys());
    }

    /**
     *
     */
    public void testMultset(){
        String strWorld="wer|dfd|dd|dfd|dda|de|dr";
        String[] words=strWorld.split("\\|");
        List<String> wordList=new ArrayList<String>();
        for (String word : words) {
            wordList.add(word);
        }
        Multiset<String> wordsMultiset = HashMultiset.create();
        wordsMultiset.addAll(wordList);

        for(String key:wordsMultiset.elementSet()){
            System.out.println(key+" count："+wordsMultiset.count(key));
        }

        if(!wordsMultiset.contains("peida")){
            wordsMultiset.add("peida", 2);
        }
        System.out.println("============================================");
        for(String key:wordsMultiset.elementSet()){
            System.out.println(key+" count："+wordsMultiset.count(key));
        }


        if(wordsMultiset.contains("peida")){
            wordsMultiset.setCount("peida", 23);
        }

        System.out.println("============================================");
        for(String key:wordsMultiset.elementSet()){
            System.out.println(key+" count："+wordsMultiset.count(key));
        }

        if(wordsMultiset.contains("peida")){
            wordsMultiset.setCount("peida", 23,45);
        }

        System.out.println("============================================");
        for(String key:wordsMultiset.elementSet()){
            System.out.println(key+" count："+wordsMultiset.count(key));
        }

        if(wordsMultiset.contains("peida")){
            wordsMultiset.setCount("peida", 44,67);
        }

        System.out.println("============================================");
        for(String key:wordsMultiset.elementSet()){
            System.out.println(key+" count："+wordsMultiset.count(key));
        }
    }

    /**
     * 双向 Map
     */
    public void biMap(){
        BiMap<String, Integer> userId = HashBiMap.create();
        String userForId = userId.inverse().get("id");
    }

    /**
     * Table用法：
     *  https://blog.csdn.net/Bazingaea/article/details/51233969
     *
     */
    public void testTable(){
        // 把数据存储到Table中，通过HashBasedTable.create()新建一个Table对象
        Table<String,String,Integer> tables=HashBasedTable.create();
        tables.put("a", "javase", 80);
        tables.put("b", "javaee", 90);
        tables.put("c", "javame", 100);
        tables.put("d", "guava", 70);

        // 得到所有行数据 tables.cellSet()
        Set<Table.Cell<String,String,Integer>> cells=tables.cellSet();
        for(Table.Cell<String,String,Integer> temp:cells){
            System.out.println(temp.getRowKey()+" "+temp.getColumnKey()+" "+temp.getValue());
        }
    }

    /**
     * RangeSet
     *  https://blog.csdn.net/wypblog/article/details/9363861
     */
    public void testRangeSet(){
        RangeSet rangeSet = TreeRangeSet.create();
        rangeSet.add(Range.closed(1, 10));
        System.out.println(rangeSet);
        rangeSet.add(Range.closedOpen(11, 15));
        System.out.println(rangeSet);
        rangeSet.add(Range.open(15, 20));
        System.out.println(rangeSet);
        rangeSet.add(Range.openClosed(0, 0));
        System.out.println(rangeSet);
        rangeSet.remove(Range.open(5, 10));
        System.out.println(rangeSet);
    }
}
