package interviews.Houzz;

public class ParseDouble {

    static class IllegalDoubleFormatException extends Exception {

    }

    double parse(String input) throws IllegalDoubleFormatException {

        // integer part
        boolean isNegative = false;
        Integer decimalPointIndex = null;
        long num = 0;
        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);
            if (cur == '+' || cur == '-') {
                if (i != 0) {
                    throw new IllegalDoubleFormatException();
                }
                if (cur == '-') {
                    isNegative = true;
                }
            } else if (Character.isDigit(cur)) {
                num = num * 10 + (cur - '0');
            } else if (cur == '.') {
                decimalPointIndex = i;
                break;
            } else {
                throw new IllegalDoubleFormatException();
            }
        }
        if (decimalPointIndex == null) {
            return isNegative ? -1.0 * num : 1.0 * num;
        }
        // decimal part
        double decimalPart = 0;
        for (int i = input.length() - 1; i > decimalPointIndex; i--) {
            if (Character.isDigit(input.charAt(i))) {
                decimalPart = decimalPart * 0.1 + 0.1 * (input.charAt(i) - '0');
            } else {
                throw new IllegalDoubleFormatException();
            }
        }
        return isNegative ? -(num + decimalPart) : (num + decimalPart);
    }

}
