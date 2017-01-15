package pl.com.bottega.javastart.tests.BubbleSort;

/**
 * Created by macie on 09.01.2017.
 */
public class ArraySorter {
    public static void main(String[] args) {
        Sortable sorter = new Sortable() {

            @Override
            public int[] sort(int[] tab) {
                int temp;
                for (int i = 0; i < tab.length; i++) {
                    System.out.println("*");
                    for (int j = 1; j < tab.length - i; j++) {
                        System.out.println(tab[j-1] + ">" + tab[j] + " " + (tab[j-1] > tab[j]));
                        if (tab[j-1] > tab[j]) {
                            temp = tab[j];
                            tab[j] = tab[j-1];
                            tab[j-1] = temp;
                        }
                    }
                }
                return tab;
            }
        };

        int[] array = { 10, 9, 8, 1, 2, 3, 6, 5, 4, 7 };
        sorter.sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }
    }
}
