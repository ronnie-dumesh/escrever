//https://stackoverflow.com/questions/8811815/is-it-possible-to-assign-numeric-value-to-an-enum-in-java
/** Delay objects are enums that are assigned to integers
 *  representing millisecond values of time.
 * 
 * AGAIN is ten minutes
 * EASY is 12 hours
 * MEDIUM is 24 hours
 * HARD is 36 hours
 */
public enum Delay {
    AGAIN(600000), EASY(43200000), MEDIUM(129600000), HARD(216000000);

    private int numVal;

    Delay(int numVal) {
        this.numVal = numVal;
    }

    public int getNumVal() {
        return numVal;
    }
}