import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        System.out.println("Результат: " + calc(input));
    }

    public static String calc(String input) throws Exception {
        String result = null;
        List<String> list = new ArrayList<>();
        List<String> allNumbers = new ArrayList<>();
        List<String> allSigns = new ArrayList<>();
        List<String> calculRomanNumbers = new ArrayList<>();
        List<String> arabianNumbers = new ArrayList<>();
        List<String> romanNumbers = new ArrayList<>();

        Collections.addAll(allNumbers, "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X");

        Collections.addAll(allSigns, "+", "-", "*", "/");

        Collections.addAll(calculRomanNumbers, "O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX",
                "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII",
                "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII",
                "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI",
                "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI",
                "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI",
                "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII",
                "XCVIII", "XCIX", "C");

        Collections.addAll(arabianNumbers, "1", "2", "3", "4", "5", "6", "7", "8", "9", "10");

        Collections.addAll(romanNumbers, "O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X");

        String[] str = input.split(" "); //Разделяем на 3 элемента

        if (str.length != 3) { // Проверка на длинну, если больше 3х значений, то брэйк
            throw new Exception("Неверные значения");
        }
        Collections.addAll(list, str[0], str[1], str[2]); // Добавление элементов в лист,для более удобной работы

        if (!(allSigns.contains(list.get(1)))) { //Проверка на верный знак
            throw new Exception("Неверный знак");
        }
        if (!(allNumbers.contains(list.get(0))) || !(allNumbers.contains(list.get(2)))) { //Проверка на числа
            throw new Exception("Неверные числа");
        }

        if (arabianNumbers.contains(list.get(0)) && arabianNumbers.contains(list.get(2))) { //Проверка на арабские
            switch (list.get(1)) {
                case "+":
                    return String.valueOf(ArabianCalculate.plusArabian(list.get(0), list.get(2)));
                case "-":
                    return String.valueOf(ArabianCalculate.minusArabian(list.get(0), list.get(2)));
                case "*":
                    return String.valueOf(ArabianCalculate.multiplyArabian(list.get(0), list.get(2)));
                case "/":
                    return String.valueOf(ArabianCalculate.divideArabian(list.get(0), list.get(2)));
            }
        } else if (calculRomanNumbers.contains(list.get(0)) && calculRomanNumbers.contains(list.get(2))) {
            for (int i = 0; i < romanNumbers.size(); i++) { //Перевод арабскх чисел в римские
                if (list.get(0).equals(romanNumbers.get(i))) {
                    list.set(0, String.valueOf(i));
                }
                if (list.get(2).equals(romanNumbers.get(i))) {
                    list.set(2, String.valueOf(i));
                }
            }
            switch (list.get(1)) {
                case "+":
                    result = String.valueOf(RomanCalculate.plusRoman(list.get(0), list.get(2)));
                    return calculRomanNumbers.get(Integer.parseInt(result));
                case "-":
                    result = String.valueOf(RomanCalculate.minusRoman(list.get(0), list.get(2)));
                    return calculRomanNumbers.get(Integer.parseInt(result));
                case "*":
                    result = String.valueOf(RomanCalculate.multiplyRoman(list.get(0), list.get(2)));
                    return calculRomanNumbers.get(Integer.parseInt(result));
                case "/":
                    result = String.valueOf(RomanCalculate.divideRoman(list.get(0), list.get(2)));
                    return calculRomanNumbers.get(Integer.parseInt(result));
            }
        } else throw new Exception("Либо Арабские, либо Римские");

        return result;
    }
}