package pl.com.bottega.homework.numbers;

/**
 * Created by macie on 03.12.2016.
 */

//TO DO i18n Internacjonalizacja
    //Jako switch w swichu albo mapa w mapie (kluczem jest kraj a wartością jest słownik)


public class AlmightyStringUtils extends ConverterApp{
   // String dictionary = "PL";

    public static String convert(long number) { //parametr
        StringBuilder result = new StringBuilder(); //Nie należy sklejać Stringów poprzez dodawanie

        boolean first = true;
        do{
            long digit = number % 10;

            if (first)
                first = false;
            else
                result.insert(0, " ");

            result.insert(0, digitToWord((char) ('0' + digit))); //działa lecz nie jest to za ładne
            //result.insert(0, " ").insert(0, digit); //można to zrobić w dwóch linijakch, ale tak jest ładniej
            number = number / 10;
        }while(number != 0);

        return result.toString();
    }

    public static String convert(double value) {
        String stringValue = String.valueOf(value);
        StringBuilder result = new StringBuilder(); //Nie należy sklejać Stringów poprzez dodawanie
        boolean first = true;

        for (char character : stringValue.toCharArray()) {
            String word = digitToWord(character);

                if (first)
                    first = false;
                else
                    result.append(" ");

            result.append(word);
        }

    return result.toString();
    }

    private static String digitToWord(char character) {
        String dictionary = dict();

        switch (dictionary){
           case "PL":
           switch (character){
                case '0': return "zero";
                case '1': return "jeden";
                case '2': return "dwa";
                case '3': return "trzy";
                case '4': return "cztery";
                case '5': return "pięć";
                case '6': return "sześć";
                case '7': return "siedem";
                case '8': return "osiem";
                case '9': return "dziewięć";
                case '.': return "przecinek";
                case '-': return "minus";
                default: return "nierozpoznany znak";
           }

            case "US":
            switch (character){
                case '0': return "zero";
                case '1': return "one";
                case '2': return "two";
                case '3': return "tree";
                case '4': return "four";
                case '5': return "five";
                case '6': return "six";
                case '7': return "seven";
                case '8': return "eight";
                case '9': return "nine";
                case '.': return "dot";
                case '-': return "minus";
                default: return "sign non recognized";

            }
            default: return "Inwalid dictionary, Zły słownik !!!";

    }
    }
}
