package chess;

public class Queen extends ChessPiece {
    public Queen(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if(isBoard(chessBoard, line, column, toLine, toColumn)) {
           if(isMoveQueen(chessBoard, line, column, toLine, toColumn)){
               if(isObstacleLine(chessBoard, line, column, toLine, toColumn)){
                   return (isEndPoint(chessBoard, toLine, toColumn));
               }
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }

    @Override
    protected boolean isObstacleLine(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        return  isDownRight(chessBoard, line, column, toLine, toColumn)  ||
                isUpLeft(chessBoard, line, column, toLine, toColumn)     ||
                isUpRight(chessBoard, line, column, toLine, toColumn)    ||
                isDownLeft(chessBoard, line, column, toLine, toColumn)   ||
                isMoveToLine(chessBoard, line, column, toLine, toColumn) ||
                isMoveToColumn(chessBoard, line, column, toLine, toColumn);
    }

    private boolean isMoveQueen(ChessBoard chessBoard, int line, int column, int toLine, int toColumn){
        if(((line == toLine) && (column != toColumn))||
                ((column == toColumn) && (line != toLine)) ||
                (Math.abs(line - toLine) == Math.abs(column - toColumn)) ) {
            return true;
        }
        return  false;
    }
}
