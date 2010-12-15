/**
 * Created by IntelliJ IDEA.
 * User: codingdojo
 * Date: 12/15/10
 * Time: 12:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class ChristmasBranch {

    private int nbOfStars;
    private String branch;

    public ChristmasBranch(int nbOfStars) {
        this.nbOfStars = nbOfStars;
        this.branch = generateBranch();
    }


    public String toString() {
        return this.branch;
    }

    private String generateBranch() {
        StringBuilder s = new StringBuilder();
        s .append("*");
        for (int i=1; i< nbOfStars; i++) {
           s.append(" *");
        }
        return s.toString();
    }
}
