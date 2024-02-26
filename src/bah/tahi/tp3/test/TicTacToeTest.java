package bah.tahi.tp3.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
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
		testEmptyGrid();
		assertEquals(Owner.FIRST, morpions.getTurn(), "Le premier doit jouer");
		assertEquals(Owner.NONE, morpions.getWinner(), "Il ne doit pas y avoir de gagnant au début de la partie");
		assertEquals(0, morpions.numberOfRounds(), "Il doit y avoir 0 coup joué au début de la partie");
		assertTrue(!morpions.gameOver(), "La partie ne doit pas être terminée au debut");
		testInvariant();
	}

	/**
	 * Fonction à utiliser après chaque action, pour tester les conditions qui
	 * doivent toujours être vraies
	 */
	private void testInvariant() { // Presque OK
		assertTrue(morpions.numberOfRounds() >= 0, "Nombre de coups >= 0");
		assertTrue(morpions.numberOfRounds() <= NB_CASES, "Nombre de coups <= " + NB_CASES);
		// Nos scénarios
		assertNotEquals(Owner.NONE, morpions.getTurn(), "Il doit avoir un joueur après chaque action");

		// 1. Tester si on a au moins 0 et au plus 1 pion dans une case (à compléter)
		// Compléter d'autres scénarios ...
	}

	/**
	 * Javadoc à compléter par Oumou
	 */
	private void testEmptyGrid() { // OK
		for (int i = 0; i < NB_CASES / TAILLE; i++) {
			for (int j = 0; j < TAILLE; j++) {
				assertEquals(Owner.NONE, morpions.getSquare(i, j), "La case doit être vide");
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
	public void testGetJoueur() { // OK
		// scénarios vérifiant le bon fonctionnement de getTurn()
		assertEquals(Owner.FIRST, morpions.getTurn(), "Dès le début du jeu, ça doit être au premier joueur de jouer");
		morpions.nextPlayer();

		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0) {
				assertEquals(Owner.SECOND, morpions.getTurn(), "ça doit être au deuxième joueur de jouer");
			} else {
				assertEquals(Owner.FIRST, morpions.getTurn(), "ça doit être au premier joueur de jouer");
			}
			morpions.nextPlayer();
		}
	}

	/**
	 * Javadoc à compléter par Oumou
	 */
	@Test
	public void testVictoire1() { // OK
		// FIRST joue dans la case (0,0)
		morpions.play(0, 0);
		testInvariant();

		// SECOND joue dans la case (1,1)
		morpions.play(1, 1);
		testInvariant();

		// FIRST joue dans la case (0,2)
		morpions.play(0, 2);
		testInvariant();

		// SECOND joue dans la case (2,1)
		morpions.play(2, 1);
		testInvariant();

		// FIRST joue dans la case (0,1)
		morpions.play(0, 1);
		testInvariant();

		// Vérifications
		assertEquals(5, morpions.numberOfRounds(), "Le nombre de coups joué n'est pas égal à 5");
		assertEquals(Owner.FIRST, morpions.getWinner(), "FIRST n'est pas le vainqueur");
		assertTrue(morpions.gameOver(), "La partie doit être terminée");
	}

	/**
	 * Javadoc à compléter par Oumou
	 */
	@Test
	public void testVictoire2() { // En cours
		// à compléter

	}

	/**
	 * Javadoc à compléter par Oumou
	 */
	@Test
	public void testMatchNul() { // En cours
		testEmptyGrid();

		// FIRST joue dans la case (0,0)
		morpions.play(2, 2);
		testInvariant();

		// SECOND joue dans la case (0,1)
		morpions.play(0, 1);
		testInvariant();

		// FIRST joue dans la case (0,2)
		morpions.play(1, 0);
		testInvariant();

		// SECOND joue dans la case (0,1)
		morpions.play(1, 2);
		testInvariant();

		// FIRST joue dans la case (0,2)
		morpions.play(0, 2);
		testInvariant();

		// SECOND joue dans la case (0,1)
		morpions.play(1, 1);
		testInvariant();

		// FIRST joue dans la case (0,2)
		morpions.play(2, 1);
		testInvariant();

		// SECOND joue dans la case (0,1)
		morpions.play(2, 0);
		testInvariant();

		// FIRST joue dans la case (0,2)
		morpions.play(0, 0);
		testInvariant();

		assertEquals(9, morpions.numberOfRounds(), "Le nombre de coups joué n'est pas égal à 9");
		assertEquals(Owner.NONE, morpions.getWinner(), "Il ne doit pas y avoir de vainqueur");
		assertTrue(morpions.gameOver(), "La partie doit être terminée");
	}

}
