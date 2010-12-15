import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ChristmasTree {

    private String asciiTree;
    private List<ChristmasBranch> branches;

    public ChristmasTree(int nbLine) {
        if (nbLine < 3) {
            throw new IllegalArgumentException("nbLine < 3 : "+nbLine);
        }
        branches = new ArrayList<ChristmasBranch>(nbLine);
        createBranches(nbLine);

        //To change body of created methods use File | Settings | File Templates.
    }

    private void createBranches(int numberOfBranches) {
        for (int i=1; i<=numberOfBranches; i++) {
              branches.add(new ChristmasBranch(i));
        }
    }

    @Override
    public String toString() {
        return asciiTree;
    }

    public List<ChristmasBranch> getBranches() {
        return branches;
    }
}
