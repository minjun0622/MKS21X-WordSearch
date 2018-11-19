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
          data[i][x] = ' ';
        }
      }
    }
    public void randomize() {
      for (int i = 0; i <= data.length - 1; i++) {
        for (int x = 0; x <= data[i].length -1 ; x++) {
          if (data[i][x] == ' ') {
            data[i][x] = (char)((Math.abs(randgen.nextInt() % 25)) + 65);
          }
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
    if(data[row + i * rowIncrement][col + i * colIncrement] != ' ' && data[row + i * rowIncrement][col + i * colIncrement] != word.charAt(i)) {
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

    public static void main(String[] args) throws FileNotFoundException{
      try{
      if (args.length == 0) {
        System.out.println("WordSearch can be manipulated by adding numbers/words after. 1st number is the row, second is the col, third the textfile, (optional seed), (optional key)" +
        "\n" + "To get the answer, enter the seed and the key)" + "\n" +
        "Remember, seed is between 0 and 10,000 and row/col are greater than 0." + "\n" +
        "To access the answer, type the seed and (key) as the input.");
      }
        if (args.length == 3) {
          int row = Integer.parseInt(args[0]);
          int col = Integer.parseInt(args[1]);
          WordSearch ws = new WordSearch(row, col, args[2]);
          ws.randomize();
          System.out.println(ws);
        }
        if (args.length == 4) {
          int row = Integer.parseInt(args[0]);
          int col = Integer.parseInt(args[1]);
          WordSearch ws = new WordSearch(row, col, args[2], Integer.parseInt(args[3]));
          ws.randomize();
          System.out.println(ws);
        }
        if (args.length == 5) {
          int row = Integer.parseInt(args[0]);
          int col = Integer.parseInt(args[1]);
          WordSearch ws = new WordSearch(row, col, args[2], Integer.parseInt(args[3]));
          if (args[4].equals("key")) {
            System.out.println(ws);
          }
          else {
            ws.randomize();
            System.out.println(ws);
          }
          }
      }
          catch(NumberFormatException e) {
            System.out.println("Wrong format, can't convert Strings to int. " + "\n" +
            "Valid format: java WordSearch row col textFile seed key");
            System.exit(1);
          }
        }
        }
