import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TestTaxVan {

    TaxVanCalculator taxCalculator = new TaxVanCalculator();

    @Test
    public void taxForVanLesTahn3500ShouldBe165Gbp(){
        Van van = getVan(2500);
        assertEquals(BigDecimal.valueOf(165L), taxCalculator.calculate(van));
    }

    @Test
    public void taxForVanMoreThan3500ShouldBe190Gbp(){
        Van van = getVan(4000);
        assertEquals(BigDecimal.valueOf(190L), taxCalculator.calculate(van));
    }

    @Test
    public void taxForVanEquals3500ShouldBe190Gbp(){
        Van van = getVan(3500);
        assertEquals(BigDecimal.valueOf(190L), taxCalculator.calculate(van));
    }

    private Van getVan(int weight) {
        Van van = mock(Van.class);
        when(van.getWeight()).thenReturn(weight);
        return van;
    }
}

