package pl.com.bottega.javastart.library.utils;

import pl.com.bottega.javastart.library.data.Publication;
import pl.com.bottega.javastart.library.data.Book;
import pl.com.bottega.javastart.library.data.Library;
import pl.com.bottega.javastart.library.data.Magazine;

import java.util.Arrays;

/**
 * Created by macie on 06.01.2017.
 */
public class LibraryUtils {

    public static void printBooks(Library lib) {
        Publication[] publications = lib.getPublications();
        Arrays.sort(publications, new Library.AlphabeticalComparator());
        int publicationsNumber = lib.getPublicationsNumber();
        int countBooks = 0;
        for(int i=0; i<publicationsNumber; i++) {
            if(publications[i] instanceof Book) {
                System.out.println(publications[i]);
                countBooks++;
            }
        }

        if(countBooks == 0) {
            System.out.println("Brak książek w bibliotece");
        }
    }

    public static void printMagazines(Library lib) {
        Publication[] publications = lib.getPublications();
        Arrays.sort(publications, new Library.AlphabeticalComparator());
        int publicationsNumber = lib.getPublicationsNumber();
        int countMagazines = 0;
        for(int i=0; i<publicationsNumber; i++) {
            if(publications[i] instanceof Magazine) {
                System.out.println(publications[i]);
                countMagazines++;
            }
        }

        if(countMagazines == 0) {
            System.out.println("Brak magazynów w bibliotece");
        }
    }
}

