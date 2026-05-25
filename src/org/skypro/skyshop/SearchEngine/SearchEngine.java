package org.skypro.skyshop.SearchEngine;

import org.skypro.skyshop.Article.Searchable;

public class SearchEngine {

    private Searchable[] searchables;
    private int size;

    public SearchEngine(int size) {
        this.searchables = new Searchable[size];
        System.out.println("Массив поиска с " + size + " ячейками \n");
        this.size = 0; //теперь отвечает за заполненные ячейки
    }

    public Searchable[] search(String seek) {
        System.out.println("поиск совпадений с " + seek);
        Searchable[] searchResult = new Searchable[5];
        if (seek == null || seek.trim().isEmpty()) { //trim убирает пробелы isEmpty пров длину на 0
            System.out.println("поисковый запрос пуст или равен null");
            return searchResult;
        }
        int index = 0;
        for (Searchable search : searchables) {
            if (search != null && search.searchForMatches(seek)) {
                System.out.println(search.getStringRepresentation());
                searchResult[index++] = search;
                if (index == searchResult.length) {
                    System.out.println("массив полностью заполнен, был выставлен лимит на " + searchResult.length + " совпадений \n");
                    return searchResult;
                }
            }
        }
        if (index == 0) {
            System.out.println("Совпадений нет \n");
        } else {
            System.out.println("Найдено " + index + " совпадений \n");
        }
        return searchResult; //в массиве возможен null
    }

    public void add(Searchable added) {
        if (size < searchables.length) {
            searchables[size++] = added;
            System.out.println(added.searchTerm() + " добавлен");
            return;
        }
        System.out.println("массив поиска заполнен");
    }
}
