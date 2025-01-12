package org.skypro.skyshop.search;

import org.skypro.skyshop.BestResultNotFound;

import java.util.LinkedList;

public class SearchEngine {
    private final LinkedList<Searchable> searchables;

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

    public Searchable bestResult(String query) throws BestResultNotFound {
        int maxScore = 0;
        Searchable best = null;
        for (Searchable searchable : searchables) {
            if (searchable == null || !searchable.getSearchTerm().contains(query)) {
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
