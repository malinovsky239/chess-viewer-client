package com.malinovsky239.chessinteractiveviewer;

public class ChessBoardCell {
    private ChessPiece containsPiece = null;
    private int x, y;

    public int GetX() {
        return x;
    }

    public int GetY() {
        return y;
    }

    public ChessPiece GetPiece() {
        return containsPiece;
    }

    public void SetPiece(ChessPiece piece) {
        containsPiece = piece;
    }
}
