import java.text.DecimalFormat;

/**
 * The letter counter class, provides a utility to record and display
 * information regarding the content of a given string.
 * 
 * @author Owen Resnikoff
 * @version 9/6/2025
 */
public class LetterCounter {
  final int ALPHABET_LENGTH = 26;
  final char LETTER_START = 'a';

  private int[] letterCounts; // created with length = ALPHABET_LENGTH
  public int totalCount; // the number of letters counted (equal to the sum of letterCounts)

  /**
   * Convert a given character to the corresponding index in the letter frequency
   * array.
   * 
   * @param ch the character to be converted.
   * @return the index of ch in the alphabet, indexed from 0. if the character is
   *         nonalphabetic return -1.
   */
  private int letterToIndex(char ch) {
    if (!Character.isAlphabetic(ch))
      return -1; // -1 acts as a sentry for noncounted characters

    ch = Character.toLowerCase(ch);
    return (ch - LETTER_START); // return a value such that 'a' = 0 and so on
  }

  /**
   * Find the largest number of times any given letter has been counted.
   * 
   * @return the largest value in letterCounts[].
   */
  private int getMaxCount() {
    int max = letterCounts[0];
    for (int n : letterCounts) {
      max = Math.max(n, max);
    }

    return max;
  }

  /**
   * Initialize the LetterCounter class.
   */
  public LetterCounter() {
    letterCounts = new int[ALPHABET_LENGTH];
    totalCount = 0;
  }

  /**
   * Count the number of occurances of each alphabetic character in the string.
   * update the internal letter frequency table accordingly.
   * 
   * @param text the string from which the letters are counted, passing in the
   *             value null results in no change.
   */
  public void countLetters(String text) {
    if (text == null)
      return; // in the case of null text nothing happens and program execution continues

    for (int i = 0; i < text.length(); i++) {
      int characterIndex = letterToIndex(text.charAt(i));
      if (characterIndex != -1) {
        letterCounts[characterIndex]++;
        totalCount++;
      }
    }
  }

  /**
   * Retrieve a count of ever alphabetic character encountered by the object.
   * 
   * @return the sum of each alphabetic character's individual count.
   */
  public int getTotalCount() {
    return totalCount;
  }

  /**
   * Reset the count of each letter to 0
   */
  public void reset() {
    // loop over letterCounts[] and set each value to 0
    for (int i = 0; i < ALPHABET_LENGTH; i++)
      letterCounts[i] = 0;

    totalCount = 0; // don't forget to reset totalCount
  }

  /**
   * Generate a histogram displaying letter frequency from the data collected by
   * this object
   * 
   * @return A histogram summarizing this object
   */
  public String toString() {
    DecimalFormat percentFormat = new DecimalFormat(".00"); // specify the format for printing decimal values
    /**
     * TLDR; I like the interface of StringBuilder, and under the hood it has some
     * benefits over generic String concatenation but it doesn't matter much in this
     * context.
     * 
     * I originally chose to use a StringBuilder here because I like having an
     * object I can push lines into and get out the concatenation of said lines
     * when I want (StringBuilder.toString()). After doing a little more reasearch,
     * and a little snooping within the source code for the StringBuilder class I
     * found
     * there is a genuine (although completely unimportant in the context of this
     * program) performance benefit to using StringBuilder when concatenating in a
     * loop. The way StringBuilder handles concatenation looks like this:
     * 
     * ------------------------
     * int len = str.length();
     * ensureCapacityInternal(count + len);
     * putStringAt(count, str);
     * count += len;
     * ------------------------
     * (It is essentially a dynamic array)
     * 
     * Because it has capacity, StringBuilder is made to handle repeated
     * concatenations with less reallocations! This is all well and good but mostly
     * irrelevant when you realize that String objects are immutable so it wouldn't
     * make any sense for them to have a sense of capacity to begin with. The real
     * benefit of StringBuilder over generic String concatenation(for repeated
     * concatenations, like in a loop) is that you don't get all the intermediate
     * garbage.
     * 
     * ------------------------
     * String foo = ""
     * for(int i = 0; i < 1000; i++){
     * foo += "bar";
     * }
     * System.out.println(foo);
     * ------------------------
     * (The above code will create 1000 Strings that never see the light of the
     * console)
     * 
     * All this being said, a function like this that only loops 26 times to produce
     * its output (each time concatenating a fairly short string) isn't really
     * affected by the benefits of StringBuilder. However, it is interesting to
     * think about what's happening under the hood and why one might choose to use
     * StringBuilder. At the very least this has influenced me to use StringBuilder
     * whenever I am accumulating strings in a loop.
     * 
     * Note: Generic String concatenation is pretty complicated in implementation
     * and the way in which it is done is determined at runtime since Java9
     * https://docs.oracle.com/javase/9/docs/api/java/lang/invoke/StringConcatFactory.html
     */
    StringBuilder sb = new StringBuilder();

    int maxCount = getMaxCount(); // the maximum value in the letterCounts array

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
