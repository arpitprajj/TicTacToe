public class Board {
   public int size;
  public  PlayingPiece[][] matrix;

   public Board(int size){
    this.size=size;
    this.matrix=new PlayingPiece[size][size];
   }

   boolean addPiece(int row,int col,PlayingPiece piece){
         if(matrix[row][col]!=null) return false;
         else matrix[row][col]=piece;

      return true;
   }

    
}
