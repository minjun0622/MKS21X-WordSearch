public class WordSearch {
    private char[][]data;

    /**Initialize the grid to the size specified
     *and fill all of the positions with '_'
     *@param row is the starting height of the WordSearch
     *@param col is the starting width of the WordSearch
     */
    public WordSearch(int rows, int cols){
        data = new char[rows][cols];
        clear();
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
        for (int x = 0; x < data[i].length; x++) {
          s += data[i][x];
        }
        s += "\n";
      }
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
      if (word.length() > data[row].length - col) {
        return false;
      }
        int col2 = col;
        for (int i = 0; i < word.length(); i++) {
          if (data[row][col2] != '_' && data[row][col2] != word.charAt(i)) {
            return false;
          }
          col2++;
        }
        for (int i = 0; i < word.length(); i++) {
          data[row][col] = word.charAt(i);
          col++;
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
      int row2 = row;
      for (int i = 0; i < word.length(); i++) {
        if (data[row2][col] != '_' && data[row2][col] != word.charAt(i)) {
          return false;
        }
        row2++;
      }
        for (int i = 0; i < word.length(); i++) {
          data[row][col] = word.charAt(i);
          row++;
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
          if (data [i + row][i + col] != '_' && data[i + row][i + col] != word.charAt()) {
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
  }
