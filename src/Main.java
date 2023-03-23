import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String expr = reader.readLine();
        System.out.println(calc(expr));
        reader.close();
    }


    public static String calc(String input) throws Exception {
        String[] expr = input.split(" ");
        if (expr.length == 3) {
            String fstOperand = expr[0];
            String sndOperand = expr[2];
            String operator = expr[1];

            try {
                int fst = Integer.parseInt(fstOperand);
                if (fst < 1 || fst > 10) throw new Exception();

                int snd = Integer.parseInt(sndOperand);
                if (snd < 1 || snd > 10) throw new Exception();

                return String.valueOf(count(fst, snd, operator));

            } catch (NumberFormatException e1) {
                if (RomanNumber.numbers.containsKey(fstOperand)) {
                    try {
                        Integer.parseInt(sndOperand);
                        throw new Exception();
                    } catch (NumberFormatException e2) {
                        if (RomanNumber.numbers.containsKey(sndOperand)) {
                            int tempResult = count(
                                    RomanNumber.numbers.get(fstOperand),
                                    RomanNumber.numbers.get(sndOperand),
                                    operator);
                            if (tempResult > 0) {
                                return IntegerConverter.intToRoman(tempResult);
                            } else throw new Exception();
                        } else throw new Exception();
                    }
                } else throw new Exception();
            }
        } else {
            throw new Exception();
        }
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

class RomanNumber {

    public final static Map<String, Integer> numbers = new HashMap<>();

    static {
        numbers.put("I", 1);
        numbers.put("II", 2);
        numbers.put("III", 3);
        numbers.put("IV", 4);
        numbers.put("V", 5);
        numbers.put("VI", 6);
        numbers.put("VII", 7);
        numbers.put("VIII", 8);
        numbers.put("IX", 9);
        numbers.put("X", 10);
    }

}

class IntegerConverter {

    public static String intToRoman(int number) {
        if (number > 100 || number < 0)
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