import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scaner = new Scanner(System.in);
        String vvodnyeCifry = scaner.nextLine();
        String[] list = razdelit(vvodnyeCifry);


        if (esliRimCifry(list[0]) != esliRimCifry(list[2])) {
            throw new Exception();
        }
        boolean rimCifry = esliRimCifry(list[0]);
        if (rimCifry) {
            System.out.println(rimskiCalculator(list));
        }
        else {
            System.out.println(arabicCalc(list));
        }
    }
    public static String[] razdelit(String input) throws Exception {
        String[] m = input.split(" ");
        if (m.length != 3) {
            throw new Exception();
        }
        if (m[0].contains(".") || m[0].contains(",") || m[2].contains(".") || m[2].contains(",")) {
            throw new Exception();
        }
        return m;
    }

    public static boolean esliRimCifry(String number) {
        String[] romanNumbers  = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        List<String> romanNumbersList = new ArrayList<>(Arrays.asList(romanNumbers));

        return romanNumbersList.contains(number);
    }
    public static Byte arabicCalc(String[] input) throws Exception {

        if (Byte.valueOf(input[0]) > 10||Byte.valueOf(input[2]) > 10||Byte.valueOf(input[0]) < 1||Byte.valueOf(input[2]) < 1) {
            throw new Exception();
        }
        byte result = 0;
        switch (input[1]) {
            case  ("+"):
                result = (byte) (Byte.valueOf(input[0]) + Byte.valueOf(input[2]));
                break;
            case ("-"):
                result = (byte) (Byte.valueOf(input[0]) - Byte.valueOf(input[2]));
                break;
            case ("*"):
                result = (byte) (Byte.valueOf(input[0]) * Byte.valueOf(input[2]));
                break;
            case ("/"):
                result = (byte) (Byte.valueOf(input[0]) / Byte.valueOf(input[2]));
                break;
            default:
                throw new Exception();

        }
        return result;
    }
    public static String rimskiCalculator(String[] input) throws Exception {
        //преобразование римских чисел в арабские
        String[] romanNumbers  = {"dlya_0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        input[0] = String.valueOf(Arrays.asList(romanNumbers).indexOf(input[0]));
        input[2] = String.valueOf(Arrays.asList(romanNumbers).indexOf(input[2]));

        return Matematika.intToRoman(arabicCalc(input));
    }
}
