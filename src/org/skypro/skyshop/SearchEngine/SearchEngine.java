package org.skypro.skyshop.SearchEngine;

import org.skypro.skyshop.Article.Searchable;
import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.product.Product;

import java.util.*;

public class SearchEngine {
    private Set<Searchable> searchables = new TreeSet<>(new ArticleComparator());

    public Set<Searchable> search(String seek) {
        System.out.println("поиск совпадений с " + seek);
        Set<Searchable> searchResult = new HashSet<>();
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
        if (searchResult.isEmpty()) {
            System.out.println("Совпадений нет \n");
        } else {
            System.out.println("Найдено " + searchResult.size() + " совпадений \n");
        }
        return searchResult; //в массиве возможен null
    }

    public void add(Searchable added) {
        if (searchables.contains(added)) {
            System.out.println(added + " уже был(а) добавлен(а)");
        }
        searchables.add(added);
    }

    public Searchable searchTheBest(String seek) throws BestResultNotFound {
        System.out.println("Поиск наиболее подходящего по запросу: " + seek);
        if (seek == null || seek.isBlank()) {
            System.out.println("Поисковый запрос пуст");
            return null;
        }
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
            System.out.println("Наиболее подходящее: " + bestMatch.getStringRepresentation());
        }
        return bestMatch;
    }

    public static class ArticleComparator implements Comparator<Searchable> {
        @Override
        public int compare(Searchable o1, Searchable o2) {
            if (o1 == null && o2 == null) return 0;
            if (o1 == null) return 1;
            if (o2 == null) return -1;

            int lengthCompare = Integer.compare(o2.searchTerm().length(), o1.searchTerm().length());
            if ((lengthCompare) != 0) {
                return lengthCompare;
            }
            return o1.searchTerm().compareTo(o2.searchTerm());
        }
    }
}
