public class Board {
   public int size;
  public  PlayingPiece[][] matrix;

   public Board(int size){
    this.size=size;
    this.matrix=new PlayingPiece[size][size];
   }

   public boolean addPiece(int row,int col,PlayingPiece piece){
         if(matrix[row][col]!=null) return false;
         else matrix[row][col]=piece;

      return true;
   }
public void printBoard(){
   for(int i=0;i<size;i++){
      for(int j=0;j<size;j++) {
         if(matrix[i][j]==null) System.out.print("|   | ");
         else
         System.out.print("| "+matrix[i][j].pieceType+" | ");
      }
      System.out.println();
   }
}
public boolean isEmpty(){
   for(int i=0;i<size;i++){
      for(int j=0;j<size;j++){
         if(matrix[i][j]==null) return true;
      }
   }
   return false;
}

    
}
