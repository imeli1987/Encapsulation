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
    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int count = 0;
        for (Searchable searchable : searchables) {
            if (searchable != null && searchable.getSearchTerm().contains(query)) {
                results[count++] = searchable;
                if (count == 5) {
                    break;
                }
            }
        }
        return results;
    }
}
