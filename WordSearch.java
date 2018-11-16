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
  if (data[row][col] == '_' || data[row][col] == word.charAt(i)) {
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
  needAdd = getWord(fileName);

  }
