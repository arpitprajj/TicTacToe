import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class TicTacToe {

    Deque<Players> players;
    Board gameBoard;

    public TicTacToe(){
        intialize();
    }

    private void intialize() {
       players=new LinkedList<>();
       PlayingPieceX pieceX=new PlayingPieceX();
       Players crossPlayers=new Players("Player1",pieceX );

       PlayingPieceO pieceO=new PlayingPieceO();
       Players zeroPlayers=new Players("Player2", pieceO);
       players.add(crossPlayers);
       players.add(zeroPlayers);
       gameBoard=new Board(3);
    }

    public String startGame(){
        boolean winner=true;

        while (winner) {
            gameBoard.printBoard();
            Players playing=players.removeFirst();
            if(!gameBoard.isEmpty()){
                winner=false;
                continue;
            }
            Scanner scanner=new Scanner(System.in);
            System.out.println(playing.playingPiece.pieceType+" Enter the row and column where u want to insert the Piece");
            String input=scanner.nextLine();
            String[] arr=input.split(",");
            int row=Integer.parseInt(arr[0]);
            int col=Integer.parseInt(arr[1]);

            if(!gameBoard.addPiece(row, col,playing.playingPiece)){
                System.out.println("This place is already occupied please enter other values");
                players.addFirst(playing);
                continue;
            }
            players.addLast(playing);
            if(checkWinner(row, col, playing.playingPiece)){
                
                return playing.name+" is Winner";
            }





            
            
        }

        return "Tie";
    }
    public boolean checkWinner(int row,int col,PlayingPiece piece){
        boolean diagonal=true;
        boolean antiDiagonal=true;
        boolean rows=true;
        boolean cols=true;

        for(int i=0;i<gameBoard.size;i++){
           if(gameBoard.matrix[i][col]==null|| gameBoard.matrix[i][col]!=piece) cols=false;
        }

        
        for(int i=0;i<gameBoard.size;i++){
            if(gameBoard.matrix[row][i]==null|| gameBoard.matrix[row][i]!=piece) rows=false;
         }

        for(int i=0;i<gameBoard.size;i++){
            if(gameBoard.matrix[i][i]==null || gameBoard.matrix[i][i]!=piece) diagonal=false;
        }
        for(int i=0;i<gameBoard.size;i++){
            if(gameBoard.matrix[i][gameBoard.size-1-i]==null || gameBoard.matrix[i][gameBoard.size-1-i]!=piece) antiDiagonal=false;
        }
        

        return rows||cols||diagonal||antiDiagonal;
    }
    
}
