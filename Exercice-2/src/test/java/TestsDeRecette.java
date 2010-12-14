import org.fest.assertions.Assertions;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.fest.assertions.Assertions.*;

@RunWith(Theories.class)
public class TestsDeRecette {

    public static String christmasTree3lines =
            "  *\n" +
            " * *\n" +
            "* * *\n" +
            " |_|";

    public static String christmasTree4lines =
            "   *\n" +
            "  * *\n" +
            " * * *\n" +
            "* * * *\n" +
            "  |_|";

    public static String christmasTree5lines =
            "   *\n" +
            "  * *\n" +
            " * * *\n" +
            "* * * *\n" +
            " * * *\n" +
            "  |_|";

    public static String christmasTree8lines =
            "      *\n" +
            "     * *\n" +
            "    * * *\n" +
            "   * * * *\n" +
            "    * * *\n" +
            "   * * * *\n" +
            "  * * * * *\n" +
            " * * * * * *\n" +
            "    |___|";

	@DataPoint
    public static Data christmas_tree_3_lines = new Data(3, christmasTree3lines);

    @DataPoint
    public static Data christmas_tree_4_lines = new Data(4, christmasTree4lines);

    @DataPoint
    public static Data christmas_tree_5_lines = new Data(5, christmasTree5lines);

    @DataPoint
    public static Data christmas_tree_8_lines = new Data(8, christmasTree8lines);

	@Theory
	public void drawCristmasTree(Data data) {
        ChristmasTree christmasTree = new ChristmasTree(data.nbLine);

        assertThat(christmasTree.toString()).isEqualTo(data.expectedChristmasTree);
	}

    static class Data {
        int nbLine;
        String expectedChristmasTree;

        Data(int nbLine, String expectedChristmasTree) {
            this.nbLine = nbLine;
            this.expectedChristmasTree = expectedChristmasTree;
        }
    }
}