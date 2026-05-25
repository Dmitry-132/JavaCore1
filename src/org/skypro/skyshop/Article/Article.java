package org.skypro.skyshop.Article;

public class Article implements Searchable {
    private final String titleOfArticle;
    private final String textOfArticle;

    public Article(String titleOfArticle, String textOfArticle) {
        this.titleOfArticle = titleOfArticle;
        this.textOfArticle = textOfArticle;
    }

    @Override
    public String toString() {
        return titleOfArticle + "\n " + textOfArticle;
    }

    @Override
    public String searchTerm() {
        return titleOfArticle;
    }

    @Override
    public String typeContent() {
        return "ARTICLE";
    }
}
