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
		this.grid[row][column] = this.currentPlayer;
	}

	@Override
	public boolean legalMove(int row, int column) { // OK
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
