package com.malinovsky239.chessinteractiveviewer;

public class Move {
    private ChessPiece who;
    private ChessBoardCell fromCell;
    private int dX, dY;

    public Move(ChessPiece piece, ChessBoardCell cell, int dx, int dy) {
        who = piece;
        fromCell = cell;
        dX = dx;
        dY = dy;
    }

    public ChessBoardCell destination() {
        return new ChessBoardCell();
    }
}
