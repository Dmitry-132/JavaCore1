package org.skypro.skyshop.Article;

import java.util.Objects;

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
        return "< ARTICLE >";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return Objects.equals(searchTerm(), ((Article) o).searchTerm());
    }

    @Override
    public int hashCode() {
        return Objects.hash(searchTerm());
    }

}
