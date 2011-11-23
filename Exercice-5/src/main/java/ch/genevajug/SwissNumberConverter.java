package ch.genevajug;

/**
 * Created by IntelliJ IDEA.
 * User: codingdojo
 * Date: 11/23/11
 * Time: 12:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class SwissNumberConverter {
    private static String[] literrals = {"un", "deux", "trois", "quatre", "cinq", "six", "sept",
            "huit", "neuf", "dix", "onze", "douze", "treize", "quatorze", "quinze", "seize"};

    private static String[] dizains = {"dix", "vingt", "trente", "quarante", "cinquante", "soixante", "septante", "huitante", "nonante"};

    public static String convert(int i) {
        if (i <= 16) {
            return literrals[i - 1];
        } else if (i%10 == 1) {
            return getDizaine(i) + "-et-un";
        } else if (i%10 == 0) {
            return getDizaine(i);
        }
        return getDizaine(i) + "-" + convert(i%10);
    }

    private static String getDizaine(int i) {
        return dizains[i/10-1];
    }
}
