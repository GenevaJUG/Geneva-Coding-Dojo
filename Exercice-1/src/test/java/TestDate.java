import junit.framework.Assert;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;

import java.util.Date;

public class TestDate {

    @Test
    public void testAfter() {

        Date dateBefore = new Date();
        
        Date dateAfter = DateUtils.addDays(dateBefore,  1);
        Assert.assertTrue(dateAfter.after(dateBefore));
        Assert.assertFalse(dateBefore.after(dateAfter));
    }
}