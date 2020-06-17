package com.optimaize.counter;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Store {

    private final Map<String, Integer> map = new HashMap<>();

    public void put(String line) {
        map.putIfAbsent(line, 0);
        map.computeIfPresent(line, (k, v) -> ++ v);
    }

    public List<Map.Entry<String, Integer>> counters() {
        return map.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toList());
    }

    public double averageLength() {
        return map.keySet()
                .stream()
                .collect(Collectors.averagingInt(String::length));
    }

    public void reset() {
        map.clear();
    }

}
