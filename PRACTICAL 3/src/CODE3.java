// Custom exception for unavailable books
class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String message) {
        super(message);
    }
}

// Custom exception for invalid book addition
class InvalidBookAdditionException extends Exception {
    public InvalidBookAdditionException(String message) {
        super(message);
    }
}

// Library class
class Library {
    private int books;

    public Library(int initialBooks) {
        if (initialBooks < 0) {
            this.books = 0;
        } else {
            this.books = initialBooks;
        }
    }

    // Method to add books
    public void addBooks(int count) throws InvalidBookAdditionException {
        if (count <= 0) {
            throw new InvalidBookAdditionException("Number of books to add must be greater than zero.");
        }
        books += count;
        System.out.println("Successfully added " + count + " books.");
    }

    // Method to issue books
    public void issueBooks(int count) throws BookNotAvailableException {
        if (count > books) {
            throw new BookNotAvailableException("Not enough books available in the library.");
        }
        books -= count;
        System.out.println("Successfully issued " + count + " books.");
    }

    // Method to display available books
    public void displayBooks() {
        System.out.println("Available books: " + books);
    }
}

// Main class
public class CODE3 {
    public static void main(String[] args) {

        Library library = new Library(100); // Initial books

        try {
            library.displayBooks();
            library.addBooks(20);
            library.issueBooks(150);
        } catch (InvalidBookAdditionException e) {
            System.out.println("Addition Error: " + e.getMessage());
        } catch (BookNotAvailableException e) {
            System.out.println("Issue Error: " + e.getMessage());
        }

        try {
            library.addBooks(-10);     // Invalid addition (throws exception)
        } catch (InvalidBookAdditionException e) {
            System.out.println("Addition Error: " + e.getMessage());
        }

        library.displayBooks();
    }
}