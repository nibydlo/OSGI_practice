package com.krylov.osgi.common;

import com.krylov.osgi.common.MediaPortal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Collections.reverseOrder;

public abstract class MediaPortalAbstract implements MediaPortal {

    public List<String> getTopWords() {
        List<String> res = new ArrayList<>();
        List<String> newsNames = this.getNewsNames();
        Map<String, Long> wordMap = new HashMap<>();
        for (String newsName : newsNames) {
            String[] words = newsName.split("\\s+");
            for (String word : words) {
                word = word.replaceAll("[^а-яА-Яa-zA-Z0-9\\-\\s]", "").toLowerCase();
                wordMap.put(word, wordMap.containsKey(word) ? wordMap.get(word) + 1 : 1);
            }
        }
        if (wordMap.size() <= WORDS_COUNT) {
            return new ArrayList<>(wordMap.keySet());
        } else {
            List<Map.Entry<String, Long>> list = new ArrayList<>(wordMap.entrySet());
            list.sort(Map.Entry.comparingByValue());
            List<Map.Entry<String,Long>> sorted =
                    wordMap.entrySet().stream()
                            .sorted(reverseOrder(Map.Entry.comparingByValue())).limit(10).collect(Collectors.toList());
            for (int i = 0; i < WORDS_COUNT; i++) {
                res.add(sorted.get(i).getKey());
            }
        }
        return res;
    }
}