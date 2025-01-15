package org.skypro.skyshop.search;

import java.util.*;

public class SearchEngine {
    private static Map<String, List<Searchable>> searchables;

    public SearchEngine() {
        searchables = new TreeMap<>();
    }

    public void add(Searchable searchable) {
        searchables.computeIfAbsent(searchable.getName(), k -> new ArrayList<>()).add(searchable);}

    public static Map<String, Searchable> search(String query) {
        Map<String, Searchable> searchMap = new TreeMap<>();
        for (Map.Entry<String, List<Searchable>> entry : searchables.entrySet()) {
            if (entry.getKey().contains(query)) {
                for (Searchable searchable : entry.getValue()) {
                    searchMap.put(searchable.getName(), searchable);
                }
            }
        }
        if (searchMap.isEmpty()){
            System.out.println("Поиск не дал результата");
        }
        return searchMap;
    }
}
