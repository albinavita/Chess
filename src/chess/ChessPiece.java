package chess;

public abstract class ChessPiece {

    protected String color;
    protected boolean check = true;

    public ChessPiece(String color) {
        this.color = color;
    }

    public abstract String getColor();
    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);
    public abstract String getSymbol();
    /**Есть ли фигуры между начальной и конечной точкой*/
    protected abstract boolean isObstacleLine(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    /**проверка, что не вышли за границу доски*/
    protected boolean isBoard(ChessBoard chessBoard, int line, int column, int toLine, int toColumn){
        return (chessBoard.checkPos(line) && chessBoard.checkPos(column) &&
                chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn));
    }
    /**Ходила ли куда-то фигура (для ладьи)*/
    protected boolean isMove(int line, int column, int toLine, int toColumn){
        return (line != toLine && column != toColumn);
    }
    /**Координата куда идем должна быть пустая
     * или может находиться фигура другого цвета*/
    protected boolean isEndPoint(ChessBoard chessBoard, int toLine, int toColumn){
        return ((chessBoard.board[toLine][toColumn] == null) ||
                !chessBoard.board[toLine][toColumn].color.equals(this.color));
    }

    /**Методы для слона и ферзи*/
    protected boolean isDownRight(ChessBoard chessBoard, int line, int column, int toLine, int toColumn){
        int number = 0;
        if((line > toLine) && (column < toColumn)) {
            for(int i = 0; i < Math.abs(line - toLine); i++) {
                if (chessBoard.board[line - i][column + i] == null){
                    number++;
                }
            }
            return ((number + 1) == Math.abs(line - toLine));
        }
        return  false;
    }
    /**Методы для слона и ферзи*/
    protected boolean isUpLeft(ChessBoard chessBoard, int line, int column, int toLine, int toColumn){
        int number = 0;
        if((line < toLine) && (column > toColumn)) {
            for(int i = 0; i < Math.abs(line - toLine); i++) {
                if (chessBoard.board[line + i][column - i] == null){
                    number++;
                }
            }
            return ((number + 1) == Math.abs(line - toLine));
        }
        return false;
    }
    /**Методы для слона и ферзи*/
    protected boolean isUpRight(ChessBoard chessBoard, int line, int column, int toLine, int toColumn){
        int number = 0;
        if((line < toLine) && (column < toColumn)) {
            for(int i = 0; i < Math.abs(line - toLine); i++) {
                if (chessBoard.board[line + i][column + i] == null){
                    number++;
                }
            }
            return ((number + 1) == Math.abs(line - toLine));
        }
        return false;
    }
    /**Методы для слона и ферзи*/
    protected boolean isDownLeft(ChessBoard chessBoard, int line, int column, int toLine, int toColumn){
        int number = 0;
        if((line > toLine) && (column > toColumn)) {
            for(int i = 0; i < Math.abs(line - toLine); i++) {
                if (chessBoard.board[line - i][column - i] == null){
                    number++;
                }
            }
            return ((number + 1) == Math.abs(line - toLine));
        }
        return false;
    }

    /**Для ферзи и туры*/
    protected boolean isMoveToLine(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        int count = 0;
        if ((line == toLine) && (column != toColumn)){
            if ((toColumn - column) > 0) {
                for (int i = column + 1; i < toColumn; i++) {
                    if (chessBoard.board[line][i] == null) {
                        count++;
                    }
                }
                return ((count + 1) == (Math.abs(column - toColumn)));
            } else {
                for (int i = column - 1; i > toColumn; i--) {
                    if (chessBoard.board[line][i] == null) {
                        count++;
                    }
                }
                return ((count + 1) == (Math.abs(column - toColumn)));
            }

        }
        return false;
    }
    /**Для ферзи и туры*/
    protected boolean isMoveToColumn(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        int count = 0;
        if ((column == toColumn) && (line != toLine)) {
            if ((toLine - line) > 0) {//идем вверх
                for (int i = line + 1; i < toLine; i++) {
                    if (chessBoard.board[i][column] == null) {
                        count++;
                    }
                }
                return ((count + 1) == (Math.abs(line - toLine)));
            } else {//идем вниз
                for (int i = line - 1; i > toLine; i--) {
                    if (chessBoard.board[i][column] == null) {
                        count++;
                    }
                }
                return ((count + 1) == (Math.abs(line - toLine)));
            }
        }
        return false;
    }
}

