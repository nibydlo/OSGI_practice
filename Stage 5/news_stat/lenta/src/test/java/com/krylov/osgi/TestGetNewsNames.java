package com.krylov.osgi;

import com.krylov.osgi.lenta.LentaImpl;

import java.io.*;

import static java.util.Collections.reverseOrder;



public class TestGetNewsNames {


    public static void main(String[] args) throws IOException {

        LentaImpl li = new LentaImpl();
        System.out.println(li.getTopWords());
        /*List<String> newsNames = li.getNewsNames();
        Map<String, Long> wordMap = new HashMap<String, Long>();
        for (String newsName : newsNames) {
            String[] words = newsName.split("\\s+");
            for (String word : words) {
                word = word.replaceAll("[^а-яА-Яa-zA-Z0-9\\-\\s]", "");
                System.out.println(word);
                wordMap.put(word, wordMap.containsKey(word) ? wordMap.get(word) + 1 : 1);
            }
        }
        if (wordMap.size() <= 10) {
            System.out.println(wordMap.keySet());
        } else {
            List<Map.Entry<String, Long>> list = new ArrayList<>(wordMap.entrySet());
            list.sort(Map.Entry.comparingByValue());
            System.out.println(wordMap);
            List<Map.Entry<String,Long>> sorted =
                    wordMap.entrySet().stream()
                            .sorted(reverseOrder(Map.Entry.comparingByValue())).limit(10).collect(Collectors.toList());
            for (int i = 0; i < 10; i++) {
                System.out.println(sorted.get(i).getKey() + " " +  sorted.get(i).getValue());
            }
        }*/

    }
}
