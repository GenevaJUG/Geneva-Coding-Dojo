import org.fest.assertions.Assertions;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by IntelliJ IDEA.
 * User: codingdojo
 * Date: 3/23/11
 * Time: 12:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestNumberToRomans {

    class Data {
        int decimal;
        String result;

        Data(int decimal, String result) {
            this.decimal = decimal;
            this.result = result;
        }

    }
    Data[] datas = { new Data(1, "I"), //
     new Data(2, "II"),
            new Data(3, "III"),
            new Data(4, "IV"),
            new Data(5, "V"),
            new Data(6, "VI"),
            new Data(7, "VII"),
            new Data(8, "VIII"),
            new Data(9, "IX"),
            new Data(10, "X"),
            new Data(11, "XI"),
            new Data(12, "XII"),
            new Data(14, "XIV"),
            new Data(15, "XV"),
            new Data(19, "XIX"),
            new Data(20, "XX"),
            new Data(24, "XXIV"),
            new Data(29, "XXIX"),
            new Data(30, "XXX"),
            new Data(31, "XXXI"),
            new Data(40, "XL"),
            new Data(41, "XLI"),
            new Data(44, "XLIV"),
            new Data(49, "XLIX"),
            new Data(50, "L"),
            new Data(100, "C"),
            new Data(500, "D"),
            new Data(1000, "M")
    };

    @Test
    public void convertShouldRespectTheSamples() {
        NumberToRomansConvert converter = new NumberToRomansConvert();
        for (Data data : datas) {
            assertThat(converter.convert(data.decimal)).isEqualTo(data.result).as("Error with " + data.decimal);
        }
    }

}
