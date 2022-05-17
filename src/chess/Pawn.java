package chess;

public class Pawn extends ChessPiece{
    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if(isBoard(chessBoard, line, column, toLine, toColumn)) {
            if(isBoard(chessBoard, line, column, toLine, toColumn)) {
                return (isObstacleLine(chessBoard, line, column, toLine, toColumn));
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }

    @Override
    protected boolean isObstacleLine(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if(column == toColumn){
            return isMoveToForward(chessBoard, line, column, toLine, toColumn);
        }else {
            return isMoveEating(chessBoard, line, column, toLine, toColumn);
        }
    }

    /**Пешка двигается только вперед по одной колонке*/
    private boolean isMoveToForward (ChessBoard chessBoard, int line, int column, int toLine, int toColumn){
        int dir;
        int start;
        if(color.equals("White")){
            dir = 1;
            start = 1;
        }else{
            dir = -1;
            start = 6;
        }
        //можно ли сходть на последнюю клетку
        if(line + dir == toLine){
            return chessBoard.board[toLine][toColumn] == null;
        }
        if(line == start && line + 2 * dir == toLine){
            return chessBoard.board[toLine][toColumn] == null &&
                    chessBoard.board[line + dir][column] == null;
        }
        return false;
    }
    /**еда*/
    private boolean isMoveEating(ChessBoard chessBoard, int line, int column, int toLine, int toColumn){
        if( (Math.abs(column - toColumn) == 1) && (Math.abs(line - toLine) == 1) ) {
            return isEndPoint(chessBoard, toLine, toColumn);
        }
        return false;
    }

}
