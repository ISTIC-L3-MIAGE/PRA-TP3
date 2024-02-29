package bah.tahi.tp3;

import fr.istic.l3miage.morpion.Owner;

public class TicTacToeModel implements AbstractTicTacToe {

	private Owner[][] grid;
	private Owner currentPlayer;
	private Owner winner;
	private int round;
	private boolean over;

	public TicTacToeModel() {
		this.init();
	}

	private void init() {
		this.grid = new Owner[BOARD_HEIGHT][BOARD_WIDTH];
		this.currentPlayer = Owner.FIRST;
		this.winner = Owner.NONE;
		this.round = 0;
		this.over = false;

		for (int i = 0; i < BOARD_HEIGHT; i++) {
			for (int j = 0; j < BOARD_WIDTH; j++) {
				this.grid[i][j] = Owner.NONE;
			}
		}
	}

	@Override
	public void restart() { // OK
		this.init();
	}

	@Override
	public Owner getTurn() { // OK
		return this.currentPlayer;
	}

	@Override
	public Owner getSquare(int row, int column) { // OK
		// Gestion d'exception à faire: Vérifier les coords
		return this.grid[row][column];
	}

	@Override
	public Owner getWinner() { // OK
		return this.winner;
	}

	@Override
	public boolean validSquare(int row, int column) { // OK
		return 0 <= row && row < BOARD_HEIGHT && 0 <= column && column < BOARD_WIDTH;
	}

	@Override
	public void nextPlayer() { // OK
		this.currentPlayer = this.currentPlayer.equals(Owner.FIRST) ? Owner.SECOND : Owner.FIRST;
	}

	@Override
	public void play(int row, int column) { // OK
		// Gestion d'exception à faire:
		// 1. Vérifier les coords
		// 2. Partie pas finie
		// 3. round <= nb de cases

		this.grid[row][column] = this.currentPlayer;
		this.round++;

		// Vérifier s'il y a un gagnant: Algo de détection de victoire
		if (this.numberOfRounds() >= 5 && this.hasWinCase()) {
			this.over = true;
		}

		this.nextPlayer();
	}

	private boolean hasWinCase() {
		boolean verticalWin = false, horizontalWin = false, diagonalWin = false;

		for (int i = 0; i < BOARD_HEIGHT; i++) {
			for (int j = 0; j < BOARD_WIDTH; j++) {
				if (j > 0 && !this.grid[i][j].equals(this.grid[i][j - 1])) {
				}
			}
		}

		/*
		 * while (i < BOARD_HEIGHT && (!verticalWin && !horizontalWin)) { while (j <
		 * BOARD_WIDTH && (!verticalWin && !horizontalWin)) { // Checking horizontal win
		 * case if (j > 0 && !this.grid[i][j].equals(this.grid[i][j - 1])) {
		 * 
		 * } } }
		 */
		return verticalWin || horizontalWin || diagonalWin;
	}

	@Override
	public boolean legalMove(int row, int column) { // OK
		// Gestion d'exception à faire: Vérifier les coords
		return this.getSquare(row, column).equals(Owner.NONE) && !this.gameOver();
	}

	@Override
	public int numberOfRounds() { // OK
		return this.round;
	}

	@Override
	public boolean gameOver() { // OK
		return this.over;
	}

}
