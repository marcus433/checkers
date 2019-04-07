package edu.sjsu.cs.cs151.checkers.App;

public class Board {
	Board() {
	  this.checkers = new Checker[DEFAULT_SIZE][DEFAULT_SIZE];
	  this.generate();
	}

	public void selectPiece(Position position) {
		//TODO: implement selectPiece
	}

	public void movePiece(Position position) throws Error {
		// TODO
	}

	public void removePiece(Position position) {
		// TODO
	}

	private Checker checkerForPosition(Position position) {
		int rowMod = position.getRow() % 2;
		int positionMod = (position.getColumn() + rowMod) % 2;
		Piece piece = null;
		if (positionMod == 1) {
			int checkerIdx = (position.getRow() * DEFAULT_SIZE) + position.getColumn() + 1;
			if (checkerIdx <= PIECES_PER_SIDE * 2)
				piece = new Piece(TOP_COLOR);
			else if (checkerIdx >= ((DEFAULT_SIZE * DEFAULT_SIZE) - (PIECES_PER_SIDE * 2)) + 1)
				piece = new Piece(BOTTOM_COLOR);
		}
		return new Checker(positionMod == 1, piece);
	}

	private void generate() {
		for (int row = 0; row < this.checkers.length; row++) {
			for (int col = 0; col < this.checkers[row].length; col++) {
				this.checkers[row][col] = this.checkerForPosition(new Position(row, col));
			}
		}
	}

	// Getters and Setters
	
	public Piece[] getPieces() {
		return pieces;
	}
	
	public Piece getCurrentPiece() {
		return currentPiece;
	}
	
	// Public constants

	public static final int DEFAULT_SIZE = 8;
	public static final int PIECES_PER_SIDE = 12;
	public static final Piece.Color TOP_COLOR = Piece.Color.RED;
	public static final Piece.Color BOTTOM_COLOR = Piece.Color.BLACK;

	// Private fields

	private Checker[][] checkers;
}