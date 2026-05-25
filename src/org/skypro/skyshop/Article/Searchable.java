package org.skypro.skyshop.Article;

public interface Searchable {
    String searchTerm();

    String typeContent();

    default String getStringRepresentation() {
        return searchTerm() + " " + typeContent();
    }

    default boolean searchForMatches(String seek) {
        return searchTerm().toLowerCase().contains(seek.toLowerCase());
    }
}
