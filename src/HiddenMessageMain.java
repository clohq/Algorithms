import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by sivragav on 7/11/16.
 *
 *
 */

public class HiddenMessageMain {

    public static void main(String[] args) {

        HiddenMessage firstRun = new HiddenMessage("-_****_*___***_-_*-_*-*___*--_*-_*-*_***___***_*-_--*_*-", "-*--_---_-**_*-");
        firstRun.findPaths();
        Set<String> firstSetResults = firstRun.getResults();
        System.out.println(firstSetResults.size());

        HiddenMessage secondRun = new HiddenMessage("-_****_*___***_-_*-_*-*___*--_*-_*-*_***___***_*-_--*_*-", "*-**_*_**_*-");
        for (String result : firstSetResults) {
            secondRun.setGiven(result);
            secondRun.findPaths();
        }
        secondRun.printResults();
    }
}

class HiddenMessage {

    private String given;
    private final String toRemove;
    private Set<String> results = new HashSet<>();

    HiddenMessage(String given, String toRemove) {
        this.given = given;
        this.toRemove = toRemove;
    }

    void setGiven(String given) {
        this.given = given;
    }

    void findPaths() {
        findPaths(given, 0, 0);
    }

    private void findPaths(String given, int i, int j) {
        if (i < given.length()) {
            if(j >= toRemove.length()) {
                results.add(given.replace("x", ""));
            } else if(given.charAt(i) == toRemove.charAt(j)) {
                findPaths(given, i + 1, j);
                StringBuilder updatedGiven = new StringBuilder(given);
                updatedGiven.setCharAt(i, 'x');
                findPaths(updatedGiven.toString(), i + 1, j + 1);
            } else {
                findPaths(given, i + 1, j);
            }
        }
    }

    void printResults() {
        System.out.println(results.size());
    }

    Set<String> getResults() {
        return results;
    }

}
