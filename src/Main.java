import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String expr = "I / 5";
//        System.out.println(calc(expr));
        System.out.println(IntegerConverter.intToRoman(765));
    }

    public static String calc(String input) throws Exception {
        String[] expr = input.split(" ");
        if (expr.length == 3) {
            String fstOperand = expr[0];
            String sndOperand = expr[2];
            String operator = expr[1];
            try {
                int fst = Integer.parseInt(fstOperand);
            } catch (NumberFormatException e) {
                IntegerConverter.intToRoman(56);
            }

         } else {
            throw new Exception();
        }





        int result = count(Integer.parseInt(fstOperand), Integer.parseInt(sndOperand), operator);

        return String.valueOf(result);

    }

    public static int count(int num1, int num2, String operator) throws Exception {
        if ("+".equals(operator)) {
            return num1 + num2;
        } else if ("-".equals(operator)) {
            return num1 - num2;
        } else if ("/".equals(operator)) {
            return num1 / num2;
        } else if ("*".equals(operator)) {
            return num1 * num2;
        } else {
            throw new Exception();
        }
    }

}

enum RomanNumber {
    I("1"), II("2"), III("3"), IV("4"), V("5"),
    VI("6"), VII("7"), VIII("8"), IX("9"), X("10");

    private final String value;

    RomanNumber(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    static boolean isRomanNumber(String number) {
        if ()
    }

}

class IntegerConverter {

    public static String intToRoman(int number) {
        if (number >= 4000 || number <= 0)
            return null;
        StringBuilder result = new StringBuilder();
        for(Integer key : units.descendingKeySet()) {
            while (number >= key) {
                number -= key;
                result.append(units.get(key));
            }
        }
        return result.toString();
    }

    private static final NavigableMap<Integer, String> units;
    static {
        NavigableMap<Integer, String> initMap = new TreeMap<>();
        initMap.put(1000, "M");
        initMap.put(900, "CM");
        initMap.put(500, "D");
        initMap.put(400, "CD");
        initMap.put(100, "C");
        initMap.put(90, "XC");
        initMap.put(50, "L");
        initMap.put(40, "XL");
        initMap.put(10, "X");
        initMap.put(9, "IX");
        initMap.put(5, "V");
        initMap.put(4, "IV");
        initMap.put(1, "I");
        units = Collections.unmodifiableNavigableMap(initMap);
    }
}