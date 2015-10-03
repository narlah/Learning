package exercise.library;

public interface BookServiceInterface
{
    public Book retrieveBook(String isbn) throws BookNotFoundException, BookWrongISBNInputException;
    public String getBookSummary(String isbn) throws BookNotFoundException, BookWrongISBNInputException;
}
