import java.util.Deque;
import java.util.LinkedList;

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
            Players playing=players.removeFirst();
            
            
        }

        return "";
    }
    
}
