package chess;
public class King extends ChessPiece {
    private String otherColor;

    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if(isBoard(chessBoard, line, column, toLine, toColumn)) {
            if (Math.abs(line - toLine) > 1 || Math.abs(column - toColumn) > 1) return  false;
                if ( !isUnderAttack(chessBoard, toLine, toColumn)) {
                    return isEndPoint(chessBoard, toLine, toColumn);
                }
        }
        return  false;
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    @Override
    protected boolean isObstacleLine(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        return false;
    }

    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        if (checkPos(line) && checkPos(column)) {
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    if (chessBoard.board[i][j] != null) {
                        if (!chessBoard.board[i][j].getColor().equals(color) && chessBoard.board[i][j].canMoveToPosition(chessBoard, i, j, line, column)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        } else return false;
    }

    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }
}
