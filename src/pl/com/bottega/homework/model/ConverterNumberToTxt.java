package pl.com.bottega.homework.model;
import java.util.*;
import java.text.DecimalFormat;

/**
 * Created by macie on 26.11.2016.
 */

public class ConverterNumberToTxt {
    static String resultInTxt;

    private static final String[] numbersInTxtToTwenty = {"", "jeden ", "dwa ", "trzy ", "cztery ", "pięć ", "sześć ",
            "siedem ", "osiem ", "dziewięć ", "dziesięć ", "jedenaście ", "dwanaście ", "trzynaście ", "czternaście ",
            "piętnaście ", "szesnaście ", "siedemnaście ", "osiemnaście ", "dziewiętnaście "};

    private static final String[] numbersInTxtToHundreds = {"", "dziesięć ", "dwadzieścia ", "trzydzieści ",
            "czterdzieści ", "pięćdziesiąt ", "sześćdziesiąt ", "siedemdziesiąt ", "osiemdziesiąt ", "dziewięćdziesiąt "};

    private static final String[] numbersInTxtToTousen = {"", "sto ", "dwieście ", "trzysta ", "czterysta ",
            "pięćset ", "sześćset ", "siedemset ", "osiemset ", "dziewięćset "};


    public static String converterNumbersToTxt(long number) {
        String resultInTxtMinus = "";
        resultInTxt = "";
        DecimalFormat numberDecimalFmt = new DecimalFormat("000000000000000");
        String stringNumber;

//Sprawdzamy czy nie jest ujemna, jeśli jest to do wyniku dodajemy słownie minus i pod numer podstawiamy wartość bezwzględną
        if (number < 0) {
            resultInTxtMinus = "minus ";
            stringNumber = numberDecimalFmt.format(Math.abs(number));
            number = Math.abs(number);
        } else {
            stringNumber = numberDecimalFmt.format(number);
        }

        //Jeśli jest zero to wyświetlamy słownie zero
        if (number == 0) {
            return "Zero";
        }

//Liczymy ile jest cyfr w liczbie
        int counter = stringNumber.length();

        if (counter > 15 )
        return "Liczba większa od tryliona.";
        else {
//Podział na segmenty 3 cyfrowe
            int bilionSegmentNumber = Integer.parseInt(stringNumber.substring(0, 3));
            int miliardSegmentNumber = Integer.parseInt(stringNumber.substring(3, 6));
            int milonSegmentNumber = Integer.parseInt(stringNumber.substring(6, 9));
            int tousandSegmentNumber = Integer.parseInt(stringNumber.substring(9, 12));
            int hundredSegmentNumber = Integer.parseInt(stringNumber.substring(12, 15));

//Zamiana segmentów i dodanie oznaczeń dla poszczególnych segmentów jeśli wystąpiły
            converterSegmentToTxt(bilionSegmentNumber);
            if (!resultInTxt.equals("")) {
                resultInTxt += "bln. ";
            }
            converterSegmentToTxt(miliardSegmentNumber);
            if (!resultInTxt.equals("")) {
                resultInTxt += "mld. ";
            }
            converterSegmentToTxt(milonSegmentNumber);
            if (!resultInTxt.equals("")) {
                resultInTxt += "mln. ";
            }
            converterSegmentToTxt(tousandSegmentNumber);
            if (!resultInTxt.equals("")) {
                resultInTxt += "tys. ";
            }
            converterSegmentToTxt(hundredSegmentNumber);
        }

//Wynik końcowy
            resultInTxt = resultInTxtMinus + resultInTxt;
            return resultInTxt;

        }

//Metoda zamieniająca na tekst segmenty 3 cyfrowe
        private static String converterSegmentToTxt(int segmentNumber){
            String resultInTxtSegment = "";
            if (segmentNumber % 100 < 20) {
                resultInTxtSegment += numbersInTxtToTwenty[segmentNumber % 100];
                segmentNumber /= 100;
                resultInTxt += numbersInTxtToTousen[segmentNumber % 10] + resultInTxtSegment;
            } else {
                resultInTxtSegment = numbersInTxtToTwenty[segmentNumber % 10];
                segmentNumber /= 10;
                resultInTxtSegment = numbersInTxtToHundreds[segmentNumber % 10] + resultInTxtSegment;
                segmentNumber /= 10;
                resultInTxt += numbersInTxtToTousen[segmentNumber % 10] + resultInTxtSegment;

            }
            return resultInTxt;
        }


    }








