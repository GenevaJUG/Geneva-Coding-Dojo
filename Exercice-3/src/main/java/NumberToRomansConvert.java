public class NumberToRomansConvert {
    public String convert(int number) {
        return convertRecursive(number, 0);
    }

    private String convertRecursive(int number, int power) {
        StringBuilder sb = new StringBuilder();
        if (number > 0) {
            if (number == 1000) {
                sb.append("M");
            } else if (number == 500) {
                sb.append("D");
            } else if (number == 100) {
                sb.append("C");
            } else if (number == 50) {
                sb.append("L");
            } else if (number >= 10) {
                sb.append(convertRecursive(number / 10, 1)).append(convertRecursive(number%10,power));
            } else if (number == 9 || number == 4) {
                sb.append(convertRecursive(1,power)).append(convertRecursive(number + 1,power));
            } else if (number >= 5) {
                sb.append(convertToRomanNumberWithPowerOf10Mult5(power)).append(convertRecursive(number - 5, power));
            } else {
                sb.append(convertToRomanNumberWithPowerOf10(power)).append(convertRecursive(number - 1, power));
            }
        }
        return sb.toString();
    }


    /**
     * 1 * 10^power
     * @param power
     * @return
     */
    private String convertToRomanNumberWithPowerOf10(int power)  {
        switch (power) {
            case 0: return "I";
            case 1: return "X";
            case 2: return "C";
            case 3: return "M";
        default:
            throw new IllegalArgumentException("not valide power");
        }
    }

    /**
     * 5 * 10^power
     * @param power
     * @return
     */
    private String convertToRomanNumberWithPowerOf10Mult5(int power)  {
        switch (power) {
            case 0: return "V";
            case 1: return "L";
            case 2: return "D";
        default:
            throw new IllegalArgumentException("not valide power");
        }
    }



    private boolean isMultipleOf10(int number) {
        return number % 10 == 0;
    }

    private boolean isMulitpleOf5(int number) {
        return number % 5 == 0;
    }


}
