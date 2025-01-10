package org.skypro.skyshop.search;

public class SearchEngine {
    private final Searchable[] searchables;

    public SearchEngine(int size) { searchables = new Searchable[size]; }

    public void add(Searchable searchable) {
        for (int i = 0; i < searchables.length; i++) {
            if (searchables[i] == null) {
                searchables[i] = searchable;
                break;
            }
        }
    }
    public int maxResult(String query, String str) {
        int count = 0;
        for ( int index = 0; (index = str.indexOf(query, index)) != -1; index += query.length()) {
            count++;
        }
        return count;
    }

    public Searchable bestResult(String query) {
        int maxScore = 0;
        Searchable best = null;
        for (Searchable searchable : searchables) {
            if (searchable != null) {
                int score = maxResult(query, searchable.getSearchTerm());
                if (searchable.getSearchTerm().contains(query)) {
                    if (score > maxScore) {
                        best = searchable;
                        maxScore = score;
                    }
                }
            }
        }
        return best;
    }
}
