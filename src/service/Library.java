package service;

import model.Book;
import model.User;
import java.util.*;

public class Library {
    private List<Book> books;
    private Map<Integer, Integer> borrowedBooks; // Book ID → User ID

    public Library() {
        books = new ArrayList<>();
        borrowedBooks = new HashMap<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
            return;
        }
        System.out.println("\nLibrary Books:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void searchBook(String query) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(query) || book.getAuthor().equalsIgnoreCase(query)) {
                System.out.println("Found: " + book);
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void borrowBook(int bookId, User user) {
        for (Book book : books) {
            if (book.getId() == bookId) {
                if (book.isAvailable()) {
                    book.borrowBook();
                    borrowedBooks.put(bookId, user.getId());
                    System.out.println(user.getName() + " borrowed: " + book.getTitle());
                } else {
                    System.out.println("Book is already borrowed.");
                }
                return;
            }
        }
        System.out.println("Book ID not found.");
    }

    public void returnBook(int bookId, User user) {
        if (borrowedBooks.containsKey(bookId) && borrowedBooks.get(bookId) == user.getId()) {
            for (Book book : books) {
                if (book.getId() == bookId) {
                    book.returnBook();
                    borrowedBooks.remove(bookId);
                    System.out.println(user.getName() + " returned: " + book.getTitle());
                    return;
                }
            }
        }
        System.out.println("Invalid return request.");
    }
}
