class RomanCalculate {

    public static int plusRoman(String num1, String num2) throws Exception {
        int result = Integer.parseInt(num1) + Integer.parseInt(num2);
        if (result < 1) throw new Exception("Результат меньше единицы");
        return result;
    }

    public static int minusRoman(String num1, String num2) throws Exception {
        int result = Integer.parseInt(num1) - Integer.parseInt(num2);
        if (result < 1) throw new Exception("Результат меньше единицы");
        return result;
    }

    public static int multiplyRoman(String num1, String num2) {
        return Integer.parseInt(num1) * Integer.parseInt(num2);
    }

    public static int divideRoman(String num1, String num2) {
        return Integer.parseInt(num1) / Integer.parseInt(num2);
    }
}
