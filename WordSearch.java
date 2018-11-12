import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception
public class WordSearch {
    private char[][]data;
    //the random seed used to produce this WordSearch
  private int seed;

  //a random Object to unify your random calls
  private Random randgen;

  //all words from a text file get added to wordsToAdd, indicating that they have not yet been added
  private ArrayList<String>wordsToAdd;

  //all words that were successfully added get moved into wordsAdded.
  private ArrayList<String>wordsAdded;

  //Two Constructors:
//: choose a randSeed using the clock random
  public WordSearch( int rows, int cols, String fileName) throws FileNotFoundException {


  public WordSearch( int rows, int cols, String fileName, int randSeed)
  /*
      Both will read in the word text file, then run addAllWords(). Do not fill in random letters after.

  //toString should print in the following format:
  //use '|' as left/right boundaries of the grid.
  //One long line of comma separated words after the string "Words: "

  |_ _ F _|
  |_ A I _|
  |D _ S _|
  |M E H _|
  Words: FAD, FISH, MEH
  */

    /**Initialize the grid to the size specified
     *and fill all of the positions with '_'
     *@param row is the starting height of the WordSearch
     *@param col is the starting width of the WordSearch
     */
    public WordSearch(int rows, int cols){
        data = new char[rows][cols];
        clear();
        addAllWords();
          }

    /**Set all values in the WordSearch to underscores'_'*/
    private void clear(){
      for (int i = 0; i < data.length; i++) {
        for (int x = 0; x < data[i].length; x++) {
          data[i][x] = '_';
        }
      }
    }

    /**Each row is a new line, there is a space between each letter
     *@return a String with each character separated by spaces, and rows
     *separated by newlines.
     */
    public String toString(){
      String s = "";
      for (int i = 0; i < data.length; i++) {
          s += '|'
          for (int x = 0; x < data[i].length; x++) {
            s += data[i][x];
            if (x != data[i].length - 1) {
              s += "";
            }
          }
          s += '|';
          if (i != data.length - 1) {
            s += "\n";
          }
        }
        s += "\n" + "Words: " + wordsAdded + " (Seed: " + seed + ")";
        return s;
      }  



    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from left to right, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     * or there are overlapping letters that do not match, then false is returned
     * and the board is NOT modified.
     */
    public boolean addWordHorizontal(String word, int row, int col){
      if (word.length() + col > data[0].length) {
      return false;
    }
        for (int i = 0; i < word.length(); i++) {
          if (data[row][col + i] != '_' && data[row][col + i] != word.charAt(i)) {
            return false;
        }
      }
        for (int x = 0; x < word.length(); x++) {
          data[row][col + x] = word.charAt(x);
        }
        return true;
      }

   /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from top to bottom, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     *and the board is NOT modified.
     */
    public boolean addWordVertical(String word, int row, int col){
      if (row + word.length() > data.length || row < 0 || col < 0|| col > data[0].length) {
        return false;
      }
      if (word.length() > data.length - row) {
        return false;
      }
      for (int i = 0; i < word.length(); i++) {
        if (data[row + i][col] != '_' && data[row+ i][col] != word.charAt(i)) {
          return false;
        }
      }
        for (int x = 0; x < word.length(); x++) {
          data[row + x][col] = word.charAt(x);
        }
        return true;
      }

      public boolean addWordDiagonal (String word, int row, int col) {
        if (row < 0 || col < 0) {
          return false;
        }
        if (row >= data.length || col >= data[row].length) {
          return false;
        }
        if (data.length - row >= word.length() && data[row].length - col >= word.length()) {
          for (int i = 0; i < data.length && i < word.length(); i++) {
          if (data [i + row][i + col] != '_' && data[i + row][i + col] != word.charAt(i)) {
          return false;
        }
        }
        for (int x = 0; x < data.length && x < data[row].length; x++) {
          if (x < word.length()) data[row +x][col + x] = word.charAt(x);
        }
        return true;
      }
      return false;
    }


    //Two Methods
private boolean addWord( int r, int c, String word, int rowIncrement, int colIncrement)
if (colIncrement  = 0 && rowIncrement = 0) {
  return false;
}
    /*-when colIncrement and rowIncrement are both 0, return false.
    -when you successfully add a word, move the word from wordsToAdd to wordsAdded, then return true.
    -return false otherwise.
    */
private boolean addAllWords()
  /*-Attempt to add all of the words from the wordsToAdd list using the following algorithm:
    1-Choose a random word, and a random direction (rowIncrement/colIncrement)
    2-Trying to add that word to different starting positions until:
        --you successfully add the word,
        --or you run out of positional tries*
      Each positional try only changes the position of the start, not the direction or word.
      *(Experiment with how many positional tries, maybe 100 is enough, maybe 1000.)
    3-Repeat this process until you added all of the words, or you tried to add unsuccessfully too many times* in a row. (experiment how many is sufficient to add most of the words)

    4-OPTIONAL
    Optimize your addAllWords such that:
    -You do not try to add words to positions that would not fit the word on the board.
    -Use the rowIncrement/colIncrement to decide what the range of valid row/col should be.
    e.g.
    A five letter word that is meant to be added across to the right should not START in the last 4 columns of the board
*/

  }
