import static org.fest.assertions.Assertions.*;

import org.junit.Ignore;
import org.junit.Test;

public class ChristmasTreeTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAcceptLessThan3() {
        new ChristmasTree(2);
    }

    @Test
    @Ignore
    public void shouldHaveOddNumberOfStarsInEachLine() {
        ChristmasTree tree = new ChristmasTree(3);
        String asciiTree = tree.toString();
        String[] lines = asciiTree.split("[\r\n]");
        for (String line : lines) {
            assertThat(line.length() % 2).isEqualTo(1);
        }

    }

    @Test
    public void shouldHaveThreeLinesForChristmasTree3() {
        ChristmasTree tree = new ChristmasTree(3);
        assertThat(tree.getBranches()).hasSize(3);

    }


}
