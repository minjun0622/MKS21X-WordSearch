//Minjun Seo
import java.util.*;
import java.io.*;
public class WordSearch {
    private char[][]data;
  private int seed;
  private Random randgen;
  private ArrayList<String>wordsToAdd;
  private ArrayList<String>wordsAdded;

//Constructors
  public WordSearch( int rows, int cols, String fileName) {
    if (rows  < 0 || cols < 0) {
      throw new IllegalArgumentException("Rows or columns can't be negative.")
    }
      data = new char[rows][cols];
      wordsToAdd = new ArrayList();
      wordsAdded = new ArrayList();
      clear();
      randgen = new Random();
      seed = randgen.nextInt();
      try {
        File f = new File(fileName);
        Scanner s = new Scanner(f);
        while (s.isNext()) {
          String str = s.nextLine().toUpperCase();
          wordsToAdd.add(str);
          wordsAdded.add(str);
        }
      } catch (FileNotFoundException e ) {
        System.out.println("File not found: " + fileName);
        System.exit(1);
        }
      }

  public WordSearch( int rows, int cols, String fileName, int randSeed) {
    if (rows < 0 || cols < 0) {
      throw new IllegalArgumentException("Cannot take in negative rows / cols.");
    }
      data = new char[rows][cols];
    wordsToAdd = new ArrayList();
      wordsAdded = new ArrayList();
      randgen = new Random(randSeed);
      try {
        File f = new File(fileName);
        Scanner s = new Scanner(f);
        while (s.isNext()) {
          String str = s.nextLine().toUpperCase();
          wordsToAdd.add(str);
          wordsAdded.add(str);
        }
      } catch (FileNotFoundException e ) {
        System.out.println("File not found: " + fileName);
        System.exit(1);
      }
    }
/*
public WordSearch (filename, rows, coles, seed boolean key) {
  data = new[][];
  clear();

  if (!key {

  }
}
*/
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

    //Two Methods
    /**Attempts to add a given word to the specified position of the WordGrid.
   *The word is added in the direction rowIncrement,colIncrement
   *Words must have a corresponding letter to match any letters that it overlaps.
   *
   *@param word is any text to be added to the word grid.
   *@param row is the vertical locaiton of where you want the word to start.
   *@param col is the horizontal location of where you want the word to start.
   *@param rowIncrement is -1,0, or 1 and represents the displacement of each letter in the row direction
   *@param colIncrement is -1,0, or 1 and represents the displacement of each letter in the col direction
   *@return true when: the word is added successfully.
   *        false when: the word doesn't fit, OR  rowchange and colchange are both 0,
   *        OR there are overlapping letters that do not match
   */
private boolean addWord(int row, int col, String word, int rowIncrement, int colIncrement) {

if ( (colIncrement = 0 && rowIncrement = 0 )  {
  return false;
  //checks for negative row, col, and if rowIncrement and colIncrement are zero.
}
  if (col + (word.length() * colIncrement) > data[0].length){
        return false;
      }
  //checks if the word is greater than col.
  if (row + (word.length() * rowIncrement) > data.length){
        return false;
      }
      //checks rows.
  if (col + (word.length() * colIncrement) < 0 ){
        return false;
      }
      //checks col.
  if (row + (word.length() * rowIncrement) < 0 ){
        return false;
      }
      //checks col.
for (int i = 0; i < word.length(); i++) {
  if (data[row][col] = '_' || data[row][col] == word.charAt(i)) {
    data[row][col] = word.charAt(i);
    row += rowIncrement;
    col += colIncrement;
    }
    else {
      return false;
    }
  }
  return true;
}

private void addAllWords() {
    if (addWord(Random word, row, col, Random colIncrement, Random rowIncrement)) {
      //add the word to the place where all words are........
    }
    else {
      if (Word = )

    }

    }

  }

}


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
