package chess;

public class Bishop extends ChessPiece {
    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if(isBoard(chessBoard, line, column, toLine, toColumn)) {
            if (isMove(line, column, toLine, toColumn)) {
                if (Math.abs(line - toLine) == Math.abs(column - toColumn)) {
                    if(isObstacleLine(chessBoard, line, column, toLine, toColumn)){
                        return (isEndPoint(chessBoard, line, column, toLine, toColumn));
                    }
                }
            }
        }
        return  false;
    }

    @Override
    public String getSymbol() {
        return "B";
    }

    @Override
    protected boolean isObstacleLine(ChessBoard chessBoard, int line, int column, int toLine, int toColumn){

        return isDownRight(chessBoard, line, column, toLine, toColumn) ||
               isUpLeft(chessBoard, line, column, toLine, toColumn)    ||
               isUpRight(chessBoard, line, column, toLine, toColumn)   ||
                isDownLeft(chessBoard, line, column, toLine, toColumn);
    }

}

