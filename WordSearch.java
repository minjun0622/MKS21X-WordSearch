//Minjun Seo

import java.util.*;
import java.io.*;
public class WordSearch {
  private char[][]data;
  private int seed;
  private Random randgen;
  private ArrayList<String>wordsToAdd;
  private ArrayList<String>wordsAdded;

// main time
public static void main (String[] args) {
  if (args.length() == 2 || args.legnth() == 1 || args.length() == 0) {
    System.out.println("Insufficinet number of arguments.");
  }
  if (Integer.parseInt(args[0]) <= 0 || Integer.parseInt(args[1]) <= 0) {
    System.out.println("The rows and the columns must be greater than 0.");
  }
  if (args.length() > 6) {
    System.out.println("Way too many arguments.");
  }
  if (Integer.parseInt(args[4]) < 0 || Integer.parseInt(args[4]) > 10000) {
    System.out.println("Seed must be greater than equal to 0 and less than or equal to 10,000.")
  }
  else {
    WordSearch ws = new WordSearch(1, 1, args[2]);
    if (args.length() == 3) {
      ws = new WordSearch(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]))
    }
  }
}
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
    }

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
          String word = q.next();
          wordsToAdd.add(word.toUpperCase());
      }
    }
  catch (FileNotFoundException e) {
    System.out.println("File does not exist: " + fileName) ;
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
        String s = "|";
        for (int i = 0 ; i < data.length ; ++i) {
          for (int x = 0 ; x < data[i].length ; ++x) {
            s += " " + data[i][x];
            }
            s += "|" + '\n' + "|";
          }
          s += '\n';
          s += "Words: " + wordsAdded;
          s += '\n';
          s += "(seed: " + seed + ")";
          return s;
        }

public boolean addWord(String word, int row, int col, int rowIncrement, int colIncrement) {
  for(int i = 0; i < word.length(); i++){
    if(row < 0 || col < 0 || rowIncrement == 0 && colIncrement == 0 || row + i * rowIncrement < 0 || col + i * colIncrement < 0){
      return false;
    }
    if(row + i * rowIncrement >= data.length || col + i * colIncrement >= data[row + i * rowIncrement].length){
      return false;
    }
    if(data[row + i * rowIncrement][col + i * colIncrement] != '_' && data[row + i * rowIncrement][col + i * colIncrement] != word.charAt(i)) {
      return false;
    }
  }
  for(int x = 0; x < word.length(); x++){
    data[row + x * rowIncrement][col + x * colIncrement] = word.charAt(x);
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
    }
