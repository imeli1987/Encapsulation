package org.skypro.skyshop.search;

public class Article implements Searchable {

    private final String title;
    private final String text;

    public Article(String title, String text) {
        this.title = title;
        this.text = text;
    }

    @Override
    public String toString() {
        return title + "\n" +
                text;
    }

    @Override
    public String getSearchTerm() {
        return title + " " +
                text;
    }

    @Override
    public String getContentType() {
        return text;
    }

    @Override
    public String getName() {
        return "";
    }
}