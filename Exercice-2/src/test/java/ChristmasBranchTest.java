import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by IntelliJ IDEA.
 * User: codingdojo
 * Date: 12/15/10
 * Time: 1:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class ChristmasBranchTest {


    @Test
    public void firstBranchShouldHave1Star() {
        ChristmasBranch branch = new ChristmasBranch(1);
        assertThat(branch.toString()).isEqualTo("*");
    }

    @Test
    public void secondBranchShouldHave2StarAnd1Space() {
        ChristmasBranch branch = new ChristmasBranch(2);
        assertThat(branch.toString()).isEqualTo("* *");
    }

    @Test
    public void thirdBranchShouldHave3StarAnd2Space() {
        ChristmasBranch branch = new ChristmasBranch(3);
        assertThat(branch.toString()).isEqualTo("* * *");
    }
}
