import ch.genevajug.SwissNumberConverter;
import org.fest.assertions.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by IntelliJ IDEA.
 * User: codingdojo
 * Date: 11/23/11
 * Time: 12:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class SwissNumberConverterTest {


    @DataProvider(name = "intToLiteralDP")
    public Object[][] getIntLiterralArray(){
        return new Object[][] {
               {1,"un"},
               {2,"deux"},
               {3,"trois"},
               {16,"seize"},
               {17,"dix-sept"},
               {18,"dix-huit"},
               {19,"dix-neuf"},
               {20,"vingt"},
               {21,"vingt-et-un"},
               {22,"vingt-deux"},
                {23,"vingt-trois"},
                {29,"vingt-neuf"},
                {30,"trente"},
                {31,"trente-et-un"},
                {32,"trente-deux"},
                {33,"trente-trois"},
                {39,"trente-neuf"},
                {40,"quarante"},
                {41,"quarante-et-un"},
                {42,"quarante-deux"},
                {43,"quarante-trois"},
                {49,"quarante-neuf"},
                {50,"cinquante"},
                {51,"cinquante-et-un"},
                {52,"cinquante-deux"},
                {53,"cinquante-trois"},
                {59,"cinquante-neuf"},
                {60,"soixante"},
                {70,"septante"},
                {80,"huitante"},
                {90,"nonante"},
                {91,"nonante-et-un"},
                {92,"nonante-deux"},
                {99,"nonante-neuf"},


        };
    }
    @Test(dataProvider = "intToLiteralDP")
    public void shouldReturnLitteral(int i, String litteral){
        Assertions.assertThat(SwissNumberConverter.convert(i)).isEqualTo(litteral);
    }
}
