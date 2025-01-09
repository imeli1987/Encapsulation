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
    public int maxResult(String str, String query) {
        int count = 0;
        int index = 0;
        int indexSubstr = str.indexOf(query, index);
        while (indexSubstr != -1) {
            count++;
            index += query.length();
            indexSubstr = str.indexOf(query, index);
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
                    if (best == null || best.getSearchTerm().length() > searchable.getSearchTerm().length()) {
                        best = searchable;
                        maxScore = score;
                    }
                }
            }
        }
        return best;
    }
}
