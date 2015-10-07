package tests;

import junit.framework.TestCase;
import minesweeper.MatrixRepresentation;

import org.junit.Test;

public class AllTestsTest extends TestCase {
	@Test
	public void testMatrixFill() {
		MatrixRepresentation matrix = new MatrixRepresentation(2);
		assertEquals(matrix.countMinesLeft(), 2);
	}

}
