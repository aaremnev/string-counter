package com.optimaize.counter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StoreTest {

    private Store store;

    @BeforeEach
    public void init() {
        store = new Store();
    }

    @Test
    public void testEmptyStats() {
        assertEquals(0, store.counters().size());
        assertEquals(0, store.averageLength());
    }

    @Test
    public void testReset() {
        store.put("111");
        store.reset();

        assertEquals(0, store.counters().size());
        assertEquals(0, store.averageLength());
    }

    @Test
    public void testCounterValues(){
        store.put("111");
        store.put("222");

        List<Map.Entry<String, Integer>> stats = store.counters();

        assertEquals(2, stats.size());
        assertEquals(1, stats.get(0).getValue());
        assertEquals(1, stats.get(1).getValue());
    }

    @Test
    public void testCounterOrder() {
        store.put("111");
        store.put("222");
        store.put("222");

        List<Map.Entry<String, Integer>> stats = store.counters();

        assertEquals(2, stats.size());
        assertEquals(2, stats.get(0).getValue());
        assertEquals("222", stats.get(0).getKey());
        assertEquals(1, stats.get(1).getValue());
        assertEquals("111", stats.get(1).getKey());
    }

    @Test
    public void testAverageLength() {
        store.put("111");
        store.put("22");

        assertEquals(2.5, store.averageLength());
    }

}