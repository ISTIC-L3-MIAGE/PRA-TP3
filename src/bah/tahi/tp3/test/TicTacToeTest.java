package bah.tahi.tp3.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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
	public void testInit() { // OK
		testInvariant();
		testEmptyGrid();
		assertEquals(morpions.getTurn(), Owner.FIRST, "Le premier doit jouer");
		assertNull(morpions.getWinner(), "Il ne doit pas y avoir de gagnant au début de la partie");
		assertNull(morpions.numberOfRounds(), "Il doit y avoir 0 coup joué au début de la partie");
		assertTrue(!morpions.gameOver(), "La partie ne doit pas être terminée au debut");
	}

	/**
	 * Fonction à utiliser après chaque action, pour tester les conditions qui
	 * doivent toujours être vraies
	 */
	private void testInvariant() { // Presque OK
		assertTrue(morpions.numberOfRounds() >= 0, "Nombre de coups >= 0");
		assertTrue(morpions.numberOfRounds() <= NB_CASES, "Nombre de coups <= " + NB_CASES);
		// Nos scénarios
		assertNotEquals(morpions.getTurn(), null, "Il doit avoir un joueur après chaque action");

		// 1. Tester si on a au moins 0 et au plus 1 pion dans une case (à compléter)
		// Compléter d'autres scénarios ...
	}

	@Test
	private void testEmptyGrid() { // OK
		for (int i = 0; i < NB_CASES / TAILLE; i++) {
			for (int j = 0; j < TAILLE; j++) {
				assertNull(morpions.getSquare(i, j), "La case doit être vide");
				assertTrue(morpions.legalMove(i, j), "La case n'est  pas libre");
			}
		}
	}

	@Test
	public void testRestart() { // OK
		// On recommence la partie
		morpions.restart();
		// Et ensuite on test l'état de la partie
		testInit();

	}

	@Test
	public void testGetJoueur() { // En cours
		// scénarios vérifiant le bon fonctionnement de getTurn()
	}

	@Test
	public void testGetVainqueur() {
		// scénarios vérifiant le bon fonctionnement de getWinner()
		// et ainsi de suite pour numberOfRounds(), \dots ,
		// jusqu’à play()
	}

}
