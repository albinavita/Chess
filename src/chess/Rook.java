package chess;

public class Rook  extends ChessPiece {
    public Rook(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (isBoard(chessBoard, line, column, toLine, toColumn)) {
            if (((line == toLine) && (column != toColumn)) || ((column == toColumn) && (line != toLine))) {
                if(isObstacleLine(chessBoard, line, column, toLine, toColumn)) {
                    return (isEndPoint(chessBoard, line, column, toLine, toColumn));
                }
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "R";
    }

    //проверка нет ли препятствия на пути
    @Override
    protected boolean isObstacleLine(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        return isMoveToLine(chessBoard, line, column, toLine, toColumn) ||
                isMoveToColumn(chessBoard, line, column, toLine, toColumn);
    }

}

