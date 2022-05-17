package chess;

public class Horse extends ChessPiece{

    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if(isBoard(chessBoard, line, column, toLine, toColumn)) {
            if (isMove(line, column, toLine, toColumn)) {
                if( (Math.abs(line - toLine) == 2 && Math.abs(column - toColumn) == 1) ||
                     Math.abs(column - toColumn) == 2 && Math.abs(line - toLine) == 1){
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
        return "H";
    }
    //коню препятствия не страшны он через них перепрыгивает
    @Override
    protected boolean isObstacleLine(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        return true;
    }
}