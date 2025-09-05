import java.text.DecimalFormat;

/**
 * The letter counter class, provides a utility to record and display
 * information regarding the content of a given string.
 * 
 * @author Owen Resnikoff
 * @version 9/4/2025
 */
public class LetterCounter {
  final int ALPHABET_LENGTH = 26;
  final char LETTER_START = 'a';

  private int[] letterCounts; // created with length = ALPHABET_LENGTH

  /**
   * convert a given character to the corresponding index in the letter frequency
   * array
   * 
   * @param ch the character to be converted
   * @return the index of ch in the alphabet, indexed from 0. if the character is
   *         nonalphabetic return -1
   */
  private int letterToIndex(char ch) {
    if (!Character.isAlphabetic(ch))
      return -1; // -1 acts as a sentry for noncounted characters

    ch = Character.toLowerCase(ch);
    return (ch - LETTER_START); // return a value such that 'a' = 0 and so on
  }

  /**
   * find the largest number of times any given letter has been counted
   * 
   * @return the largest value in letterCounts[]
   */
  private int getMaxCount() {
    int max = letterCounts[0];
    for (int n : letterCounts) {
      max = Math.max(n, max);
    }

    return max;
  }

  public LetterCounter() {
    letterCounts = new int[ALPHABET_LENGTH];
  }

  /**
   * count the number of occurances of each alphabetic character in the string.
   * update the internal letter frequency table accordingly.
   * 
   * @param text the string from which the letters are counted, passing in the
   *             value null results in no change
   */
  public void countLetters(String text) {
    if (text == null)
      return; // in the case of null text nothing happens and program execution continues

    for (int i = 0; i < text.length(); i++) {
      int characterIndex = letterToIndex(text.charAt(i));
      if (characterIndex != -1)
        letterCounts[characterIndex]++;
    }
  }

  /**
   * retrieve a count of ever alphabetic character encountered by the object
   * 
   * @return the sum of each alphabetic character's individual count
   */
  public int getTotalCount() {
    int count = 0;
    for (int n : letterCounts)
      count += n;
    return count;
  }

  /**
   * reset the count of each letter to 0
   */
  public void reset() {
    // loop over letterCounts[] and set each value to 0
    for (int i = 0; i < ALPHABET_LENGTH; i++)
      letterCounts[i] = 0;
  }

  public String toString() {
    DecimalFormat percentFormat = new DecimalFormat(".00"); // specify the format for printing decimal values
    StringBuilder sb = new StringBuilder(); // a string build is used to accumulate each line of the histogram

    /**
     * these values are unaffected by the letter index, and thus are only computed
     * once outside of the loop
     */
    int maxCount = getMaxCount(); // the maximum value in the letterCounts array
    int totalCount = getTotalCount(); // the sum of the letterCounts array

    for (int i = 0; i < ALPHABET_LENGTH; i++) {
      char ch = (char) (LETTER_START + i); // find character cooresponding to i'th letter in the alphabet
      int counti = letterCounts[i];

      /**
       * the length of a given bar is such that the number with the a count equal to
       * maxCount will be of length 60
       * 
       * Note: in the case that maxCount is zero the equation will evaulate to NaN,
       * because the value is casted to an integer NaN will become 0 which is
       * incidentally the desired value
       */
      int barLength = (int) ((counti * 60.) / maxCount);
      String barString = "#".repeat(barLength); // the character # repeated barLength times

      // calculate the percentage or frequency at which the letter appeared
      double percentage = (counti * 100.) / Math.max(totalCount, 1); // the max function is used here to avoid
                                                                     // divsion by 0

      /**
       * A string of the format
       * ch: barString (percentage%)
       * 
       * Example:
       * ch = 'a'
       * barLength = 5
       * percentage = 1.32
       * 
       * a: ##### (1.32%)
       */
      String lineString = String.format("%c:  %s  (%s%%)\n", ch, barString, percentFormat.format(percentage));

      sb.append(lineString);
    }

    return sb.toString();
  }
}
