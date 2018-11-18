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
      throw new IllegalArgumentException("Rows or columns can't be negative.");
    }
      data = new char[rows][cols];
      clear();
      wordsToAdd = new ArrayList<String>();
      wordsAdded = new ArrayList<String>();
      seed = Math.abs((int)(Math.random() * 10000));
      randgen = new Random(seed);
      getWords(fileName);
      addAllWords();

  public WordSearch( int rows, int cols, String fileName, int randSeed) {
    if (rows < 0 || cols < 0) {
      throw new IllegalArgumentException("Cannot take in negative rows / cols.");
    }
      data = new char[rows][cols];
      clear();
      wordsToAdd = new ArrayList<String>();
      wordsAdded = new ArrayList<String>();
      seed = randSeed;
      randgen = new Random(seed);
      getWords(fileName);
      addAllWords();
    }

    public void getWords (String fileName) {
      try {
        File f = new File(fileName);
        Scanner q = new Scanner(f);
        while (q.hasNext()) {
          wordsToAdd.add(word.toUpperCase());
      }
    }
  catch (FileNotFoundException e) {
    System.out.println("The following file does not exist: " + fileName) ;
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

    public String toString(){
        String s = "" ;
        for (int i = 0 ; i < data.length ; ++i) {
          s += "|" ;
          for (int x = 0 ; x < data[i].length ; ++x) {
            if (x < data[i].length-1) {
              s += data[i][x] + " ";
            }
            else {
              s += data[i][x];
            }
          }
          s+= "|\n";
        }
        return s;
      }

public boolean addWord(int row, int col, String word, int rowIncrement, int colIncrement) {

if (colIncrement == 0 && rowIncrement == 0)  {
  return false;
  //checks for negative row, col, and if rowIncrement and colIncrement are zero.
}
if (rowIncrement < -1 || rowIncrement > 1 || colIncrement < -1 || colIncrement > 1) {
  return false;
}
for (int i = 0; i < word.length(); i++) {
  if ( (i + row)  * rowIncrement  < 0  || (i + col) * colIncrement < 0) {
    return false;
  }
  //checks if the word is too small to go on the row / col.
  if ( (i + row) * rowIncrement <= word.length() || (i + col) * colIncrement <= data[(row + i) * rowIncrement].length) {
    return false;
  }
  if ( (data[(row + i) * rowIncrement][(col + i) * colIncrement] != '_') && data[(row + i) * (rowIncrement][(col + i) * colIncrement] != word.charAt(i))) {
    return false;
  }
}
for (int x = 0; x < word.length(); x++) {
  data[(x * row) + rowIncrement][(col * x) + colIncrement] = word.charAt(x);
}
  return true;
}
/*get random word, random increments. Use while loop and then try a lot of times.
if the same word doesn't fit, get another word and try a set number of times.
not every position.
*/
private void addAllWords() {
  int x = 0;
  while (wordsToAdd.size() > 0 && x < 30) {
    int x2 = 0;
    int index = Math.abs(randgen.nextInt() % wordsToAdd.size());
    int rowIncrement = randgen.nextInt(3) - 1;
    int colIncrement = randgen.nextInt(3) - 1;
    int row = randgen.nextInt() % data.length;
    int col = randgen.nextInt() % data[0].length;
    String word = wordsToAdd.get(index);
      while (x2 < 1000) {
        if (addWord(word, row, col, rowIncrement, colIncrement) ) {
            wordsAdded.add(word);
            wordsToAdd.remove(index);
              x2 = 1000;
            }
            else {
              row = randgen.nextInt() % data.length ;
              col = randgen.nextInt() % data[0].length ;
              rowIncrement = randgen.nextInt(3) - 1;
              colIncrement = randgen.nextInt(3) - 1;
              x2++;
            }
          }
          x++;
        }
      }

public static void main(String args[]) {


}
   }
