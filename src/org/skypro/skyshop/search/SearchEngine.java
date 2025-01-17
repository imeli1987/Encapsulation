package org.skypro.skyshop.search;

import org.skypro.skyshop.BestResultNotFound;

import java.util.*;

public class SearchEngine {
    private final List<Searchable> searchables;

    public SearchEngine() {
        searchables = new LinkedList<>();
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }
    public int maxResult(String query, String str) {
        int count = 0;
        for ( int index = 0; (index = str.indexOf(query, index)) != -1; index += query.length()) {
            count++;
        }
        return count;
    }

    public Map<String, Searchable> search(String query) {
        List<Searchable> results = new LinkedList<>();
        Map<String, Searchable> map = new TreeMap<>();
        for (Searchable searchable : searchables) {
            if (searchable != null && searchable.getSearchTerm().contains(query)) {
                results.add(searchable);
                map.put(searchable.getName(), searchable);
            }
        }
        if (results.isEmpty()){
            System.out.println("Поиск не дал результатов");
        }
        return map;
    }

    public Searchable bestResult(String query) throws BestResultNotFound {
        int maxScore = 0;
        Searchable best = null;
        Map<String, Searchable> results = search(query);
        for (Map.Entry<String, Searchable> entry : results.entrySet()){
            Searchable searchable = entry.getValue();
            if (searchable == null || !searchable.getSearchTerm().contains(searchable.getName())) {
                continue;
            }
            int score = maxResult(query, searchable.getSearchTerm());
            if (score > maxScore) {
                best = searchable;
                maxScore = score;
            }
        }
        checkBestResultNotNull(best);
        return best;
    }

    private void checkBestResultNotNull(Searchable best) throws BestResultNotFound {
        if (best == null){
            throw new BestResultNotFound("Ничего не найдено");
        }
    }

}