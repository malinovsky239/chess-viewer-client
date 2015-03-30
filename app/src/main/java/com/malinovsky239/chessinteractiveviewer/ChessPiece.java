package com.malinovsky239.chessinteractiveviewer;

import java.util.ArrayList;

public abstract class ChessPiece {

    private ChessBoard board;
    private ChessBoardCell pos;
    private Color color;

    public abstract ArrayList<Move> possibleMoves();

    public ChessPiece() {}

    public ChessPiece(ChessBoard b, ChessBoardCell cell, Color c) {
        board = b;
        pos = cell;
        color = c;
    }

    public void MakeMove(Move move) {
        if (possibleMoves().contains(move)) {
            pos = move.destination();
        }
    }

    public class Rook extends ChessPiece {

        public ArrayList<Move> possibleMoves() {
            ArrayList<Move> result = new ArrayList<Move>();
            for (int dx = -1; dx <= 1; dx++) {
                for (int dy = -1; dy <= 1; dy++) {
                    if (dx * dy == 0 && dx + dy != 0) {
                        result.addAll(moveUntilStop(pos, dx, dy));
                    }
                }
            }
            return result;
        }
    }

    public class Bishop extends ChessPiece {

        public ArrayList<Move> possibleMoves() {
            ArrayList<Move> result = new ArrayList<Move>();
            for (int dx = -1; dx <= 1; dx++) {
                for (int dy = -1; dy <= 1; dy++) {
                    if (dx * dy != 0) {
                        result.addAll(moveUntilStop(pos, dx, dy));
                    }
                }
            }
            return result;
        }
    }

    public class Queen extends ChessPiece {

        public ArrayList<Move> possibleMoves() {
            ArrayList<Move> result = new ArrayList<Move>();
            for (int dx = -1; dx <= 1; dx++) {
                for (int dy = -1; dy <= 1; dy++) {
                    if (dx != 0 || dy != 0) {
                        result.addAll(moveUntilStop(pos, dx, dy));
                    }
                }
            }
            return result;
        }
    }

    public class Knight extends ChessPiece {

        public ArrayList<Move> possibleMoves() {
            ArrayList<Move> result = new ArrayList<Move>();
            for (int dx = -2; dx <= 2; dx++) {
                for (int dy = -2; dy <= 2; dy++) {
                    if (Math.abs(dx * dy) == 2) {
                        // TODO: check cell
                        result.add(new Move(this, pos, dx, dy));
                    }
                }
            }
            return result;
        }
    }

    public class King extends ChessPiece {
        public ArrayList<Move> possibleMoves() {
            ArrayList<Move> result = new ArrayList<Move>();
            for (int dx = -1; dx <= 1; dx++) {
                for (int dy = -1; dy <= 1; dy++) {
                    if (dx != 0 || dy != 0) {
                        // TODO: check cell
                        result.add(new Move(this, pos, dx, dy));
                    }
                }
            }
            return result;
        }
    }

    public class Pawn extends ChessPiece {

        public ArrayList<Move> possibleMoves() {
            ArrayList<Move> result = new ArrayList<Move>();
            // TODO
            return result;
        }
    }

    private ArrayList<Move> moveUntilStop(ChessBoardCell curPos, int dx, int dy) {
        ArrayList<Move> result = new ArrayList<Move>();
        while (true) {
            curPos = (new Move(this, curPos, dx, dy)).destination();
            if (!validCell(curPos)) {
                break;
            }
            ChessPiece content = board.GetCellContent(curPos.GetX(), curPos.GetY());
            if (content != null && content.color == this.color) {
                break;
            }
            result.add(new Move(this, pos, dx, dy));
            if (content != null) {
                break;
            }
        }
        return result;
    }

    private boolean validCell(ChessBoardCell cell) {
        return validCoordinate(cell.GetX()) && validCoordinate(cell.GetY());
    }

    private boolean validCoordinate(int coord) {
        return (1 <= coord && coord <= 8);
    }
}
