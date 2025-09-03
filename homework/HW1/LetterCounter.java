/**
 * The letter counter class, provides a utility to record and displa information regarding
 * the content of a given string.
 * 
 * @author Owen Resnikoff
 * @version 0.1
*/
public class LetterCounter {
  final int ALPHABET_LENGTH = 26;
  final char LETTER_START = 'a';

  private int[] letterFrequency; //created with length = ALPHABET_LENGTH

  /**
   * convert a given character to the corresponding index in the letter frequency array
   * @param ch the character to be converted
   * @return the index of ch in the alphabet, indexed from 0. if the character is nonalphabetic return -1
  */
  private int letterToIndex(char ch){
    if(!Character.isAlphabetic(ch))
      return -1; //-1 acts as a sentry for noncounted characters
    
    ch = Character.toLowerCase(ch);
    return (ch - LETTER_START); // return a value such that 'a' = 0 and so on
  }

  /**
   * find the largest number of times any given letter has been counted
   * @return the largest Count in the array if letter counts
  */
  private int getMaxCount(){
    int max = letterFrequency[0];
    for(int n : letterFrequency){
      max = Math.max(n, max);
    }

    return max;
  }

  public LetterCounter(){
    letterFrequency = new int[ALPHABET_LENGTH];
  }

  /**
   * count the number of occurances of each alphabetic character in the string.
   * update the internal letter frequency table accordingly.
   * @param text the string from which the letters are counted
  */
  public void countLetters(String text){
    for(int i = 0; i < text.length(); i++){
      int characterIndex = letterToIndex(text.charAt(i));
      if(characterIndex != -1)
        letterFrequency[characterIndex]++;
    }
  }

  /**
   * retrieve a count of ever alphabetic character encountered by the object
   * @return the sum of each alphabetic character's individual count
  */
  public int getTotalCount(){
    int count = 0;
    for(int n : letterFrequency)
      count += n;
    return count;
  }

  /**
   * reset the count of each letter to 0
  */
  public void reset(){
    for(int i = 0; i < ALPHABET_LENGTH; i++)
      letterFrequency[i] = 0;
  }

  public String toString(){
    StringBuilder sb = new StringBuilder();
    int totalCount = getTotalCount();
    totalCount = Math.max(totalCount, 1); // we need to make sure this isn't 0 or else we risk a division by 0 error

    for(int i = 0; i < ALPHABET_LENGTH; i++){
      char ch = (char)(LETTER_START + i); //find character cooresponding to i'th letter in the alphabet
      int letterCount = letterFrequency[i];

      int barLength = Math.round((float)letterCount/getMaxCount() * 60); //length of the bar in the histogram
      String barString = "#".repeat(barLength);
      float percentage = 100.f*(letterFrequency[i] / (float)totalCount);
     
      String lineString = String.format("%c:    %s    (%.2f%%)\n", ch, barString, percentage);
      sb.append(lineString);
    }
    
    return sb.toString();
  }
}
