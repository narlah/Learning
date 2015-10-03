package exercise.junitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import exercise.library.Book;
import exercise.library.BookNotFoundException;
import exercise.library.BookServiceImpl;
import exercise.library.BookWrongISBNInputException;

public class RepositoryServiceImplTestGetBook {

	private BookServiceImpl bookService = new BookServiceImpl();

	@Test(expected = BookWrongISBNInputException.class)
	public void testGetBookEmptyIsbn() throws BookNotFoundException, BookWrongISBNInputException {
		bookService.retrieveBook("");
	}

	@Test(expected = BookWrongISBNInputException.class)
	public void testGetBookWrongIsbn() throws BookNotFoundException, BookWrongISBNInputException {
		bookService.retrieveBook("INVALID-TEXT");
	}

	@Test(expected = BookNotFoundException.class)
	public void testGetBookMissingBook() throws BookNotFoundException, BookWrongISBNInputException {
		bookService.retrieveBook("ISBN-777");
	}

	@Test(expected = BookNotFoundException.class)
	public void testGetBookOnlyIsbn() throws BookNotFoundException, BookWrongISBNInputException {
		bookService.retrieveBook("ISBN-");
	}

	@Test
	public void testGetBookRightIsbn() throws BookNotFoundException, BookWrongISBNInputException {
		Book book1 = bookService.retrieveBook("ISBN-001");
		assertTrue(book1.getTitle().equals("Harry Potter and the Deathly Hallows"));
		assertFalse(book1.getTitle().equals("Harry Potter and the Dark Riders"));

		Book book2 = bookService.retrieveBook("ISBN-002");
		assertTrue(book2.getTitle().equals("The Player of Games"));
		assertFalse(book2.getTitle().equals("The Player of Thrones"));

		Book book3 = bookService.retrieveBook("ISBN-003");
		assertTrue(book3.getTitle().equals("Genius: Richard Feynman and Modern Physics"));
		assertFalse(book3.getTitle().equals("Genius: Richard Feynman and Dark Ages Physics"));
	}
}
