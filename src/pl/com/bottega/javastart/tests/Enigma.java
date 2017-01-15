package pl.com.bottega.javastart.tests;

import java.util.Scanner;

/**
 * Created by macie on 06.01.2017.
 * Pobierz od użytkownika liczbę, która określać będzie ile wyrazów użytkownik chce wprowadzić. Następnie wczytaj od niego listę ciągów znaków na podstawie, których wygenerujesz wynik.

 Wynikiem jest wyraz składający się z ostatnich liter każdego z wprowadzonych słów. Wykorzystaj klasy String i StringBuilder.

 Przykładowe wejście:

 5
 Roman
 kratka
 kanar
 robot
 nuty

 Wyjście

 narty
 */
public class Enigma {
    public static void main(String[] args) {
            Scanner input = new Scanner(System.in);

            System.out.println("Podaj liczbę wyrazów: ");
            int wordsNumber = input.nextInt();
            input.nextLine();

            String[] words = new String[wordsNumber];

            for(int i=0; i<wordsNumber; i++) {
                System.out.println("Podaj kolejne słowo: ");
                words[i] = input.nextLine();
            }

            StringBuilder build = new StringBuilder();
            for(int i=0; i<wordsNumber; i++) {
                build.append(words[i].charAt(words[i].length() - 1));
            }

            System.out.println("Nowe słowo: " + build.toString());

            input.close();
        }
    }

