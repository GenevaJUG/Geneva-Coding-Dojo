/**
 * Created by IntelliJ IDEA.
 * User: maximenowak
 * Date: 20 oct. 2010
 * Time: 12:23:29
 * To change this template use File | Settings | File Templates.
 */
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class TestTaxVan {

    @Test
    public void taxForVanLesTahn3500ShouldBe165Gbp(){
        Van van = new Van();
        van.setWeight(2500);
        TaxCalculator taxCalculator = new TaxCalculator();
        assertEquals(BigDecimal.valueOf(165L), taxCalculator.calculate(van));


    }

    @Test
    public void taxForVanMoreThan3500ShouldBe190Gbp(){
        Van van = new Van();
        van.setWeight(4000);
        TaxCalculator taxCalculator = new TaxCalculator();
        assertEquals(BigDecimal.valueOf(190L), taxCalculator.calculate(van));
    }

    @Test
    public void taxForVanEquals3500ShouldBe190Gbp(){

        Van van = new Van();
        van.setWeight(3500);
        TaxCalculator taxCalculator = new TaxCalculator();
        assertEquals(BigDecimal.valueOf(190L), taxCalculator.calculate(van));
    }
}

