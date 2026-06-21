package org.skypro.skyshop.SearchEngine;

import org.skypro.skyshop.Article.Searchable;
import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    List<Searchable> searchables = new ArrayList<>();

    public List<Searchable> search(String seek) {
        System.out.println("поиск совпадений с " + seek);
        List<Searchable> searchResult = new ArrayList<>();
        if (seek == null || seek.trim().length() < 3) {
            System.out.println("поисковый запрос должен быть не короче 3 символов\n");
            return searchResult;
        }
        for (Searchable search : searchables) {
            if (search != null && search.searchForMatches(seek)) {
                System.out.println(search.getStringRepresentation());
                searchResult.add(search);
            }
        }
        if (searchResult.size() == 0) {
            System.out.println("Совпадений нет \n");
        } else {
            System.out.println("Найдено " + searchResult.size() + " совпадений \n");
        }
        return searchResult; //в массиве возможен null
    }

    public void add(Searchable added) {
        searchables.add(added);
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
