package com.malinovsky239.chessinteractiveviewer;

public class ChessBoard {

    static final int N = 8;

    private ChessBoardCell position[][] = new ChessBoardCell[N][N];

    public ChessPiece GetCellContent(int x, int y) {
        return position[x][y].GetPiece();
    }

    public ChessBoard(String FENString) {
        String[] lines = FENString.split("/");
        for (int i = 0; i < N; i++) {
            int y = 8 - i, x = 1;
            for (int j = 0; j < lines[i].length(); j++) {
                char symbol = lines[i].charAt(j);
                if (Character.isDigit(symbol)) {
                    x += Character.getNumericValue(symbol);
                }
                else {
                    switch (symbol) {
                        case 'K':
                            position[x][y].SetPiece(new ChessPiece.King(this, position[x][y], Color.WHITE));
                            break;


                    }
                }
            }
        }
    }
}