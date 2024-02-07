package bah.tahi.tp3.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.istic.l3miage.morpion.AbstractTicTacToe;
import fr.istic.l3miage.morpion.Owner;
import fr.istic.l3miage.morpion.TicTacToeV7;

public class TicTacToeTest {
	AbstractTicTacToe morpions;
	public static final int TAILLE = AbstractTicTacToe.BOARD_WIDTH;
	public static final int NB_CASES = AbstractTicTacToe.BOARD_WIDTH * AbstractTicTacToe.BOARD_HEIGHT;

	@BeforeEach
	public void setUp() {
//		morpions = new TicTacToeV1();
//		morpions = new TicTacToeV2();
//		morpions = new TicTacToeV3();
//		morpions = new TicTacToeV4();
//		morpions = new TicTacToeV5();
//		morpions = new TicTacToeV6();
		morpions = new TicTacToeV7();
	}

	@Test
	public void testInit() {
		assertEquals(morpions.getTurn(), Owner.FIRST, "Le premier doit jouer");
		testInvariant();
		// ----------------------
		// SÉQUENCE À COMPLÉTER
		// ----------------------
	}

	/**
	 * Fonction à utiliser après chaque action, pour tester les conditions qui
	 * doivent toujours être vraies
	 */
	private void testInvariant() {
		assertTrue(morpions.numberOfRounds() >= 0, "Nombre de coups >= 0");
		assertTrue(morpions.numberOfRounds() <= NB_CASES, "Nombre de coups <= " + NB_CASES);
		// ----------------------
		// SÉQUENCE À COMPLÉTER
		// ----------------------
	}

	@Test
	public void testGetJoueur() {
		// scénarios vérifiant le bon fonctionnement de getTurn()
	}

	@Test
	public void testGetVainqueur() {
		// scénarios vérifiant le bon fonctionnement de getWinner()
		// et ainsi de suite pour numberOfRounds(), \dots ,
		// jusqu’à play()
	}

}
