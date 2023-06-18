import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public static String convert(int octal) {
        // Convert octal to decimal
        int decimal = convertOctalToDecimal(octal);

        // Convert decimal to hexadecimal
        return convertDecimalToHexadecimal(decimal);
    }

    public static int convertOctalToDecimal(int octal) {
        if (octal == 0) {
            return 0;
        } else {
            return (octal % 10) + 8 * convertOctalToDecimal(octal / 10);
        }
    }

    public static String convertDecimalToHexadecimal(int decimal) {
        if (decimal == 0) {
            return "";
        } else {
            int remainder = decimal % 16;
            String hexChar = getHexCharacter(remainder);
            return convertDecimalToHexadecimal(decimal / 16) + hexChar;
        }
    }

    public static String getHexCharacter(int digit) {
        if (digit >= 0 && digit <= 9) {
            return String.valueOf(digit);
        } else {
            switch (digit) {
                case 10:
                    return "A";
                case 11:
                    return "B";
                case 12:
                    return "C";
                case 13:
                    return "D";
                case 14:
                    return "E";
                case 15:
                    return "F";
                default:
                    return "";
            }
        }
    }
}

public class OctalToHexaDecimal {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // Reading N and K
        String str = bufferedReader.readLine().trim();
        int n = Integer.parseInt(str);

        Solution solution = new Solution();
        String result = solution.convert(n);
        System.out.println(result);
    }
}

