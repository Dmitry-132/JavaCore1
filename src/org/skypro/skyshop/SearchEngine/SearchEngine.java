package org.skypro.skyshop.SearchEngine;

import org.skypro.skyshop.Article.Searchable;
import org.skypro.skyshop.exceptions.BestResultNotFound;

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
        if (seek == null || seek.trim().length() < 3) {
            System.out.println("поисковый запрос должен быть не короче 3 символов");
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

    public Searchable searchTheBest(String seek) throws BestResultNotFound {
        System.out.println("Поиск наиболее подходящего по запросу: " + seek);
        if (seek == null || seek.isBlank()) {
            System.out.println("Поисковый запрос пуст");
            return null;
        } // вроде работет но надо будет отредачить, если вспомню, что и зачем здесь писал
        String cleanSearch = seek.trim().toLowerCase();
        int maxCount = 0;
        Searchable bestMatch = null;
        for (Searchable s : searchables) {
            if (s == null) continue;
            int count = 0;
            int index = 0;
            int indexSubstring = s.searchTerm().toLowerCase().indexOf(cleanSearch, index); //indexOf начинает с позиции index
            // ищет подстроку в строке и возвращает позицию (в дальнейшем индекс), где она начинается.
            while (indexSubstring != -1) { // -1 (не найдено!)
                count++;
                index = indexSubstring + cleanSearch.length();
                indexSubstring = s.searchTerm().toLowerCase().indexOf(cleanSearch, index);
            }
            if (count > maxCount) {
                maxCount = count;
                bestMatch = s;
            }
        }
        if (bestMatch == null) {
            throw new BestResultNotFound("Совпадений c " + seek + " нет");
        } else {
            System.out.println("Наиболее подходящее: "+ bestMatch.getStringRepresentation());
        }
        return bestMatch;
    }
}
