package ru.job4j.pojo;

public class Library {

    public static Book[] createBookArray() {
        Book java12e = new Book("Java. A Complete Guide. 12th Edition", 1244);
        Book sorcerersStone = new Book("Harry Potter and the Sorcerer's Stone", 368);
        Book code = new Book("Clean Code", 464);
        Book utopia = new Book("1984", 384);
        return new Book[]{java12e, sorcerersStone, code, utopia};
    }

    public static void bookPrint(Book book) {
        System.out.println("Book: " + book.getName() + ", pages: " + book.getPages());
    }

    public static void printBooks(Book[] shelf) {
        for (int i = 0; i < shelf.length; i++) {
            bookPrint(shelf[i]);
        }
    }

    public static void searchBooks(Book[] shelf, String desired) {
        for (int i = 0; i < shelf.length; i++) {
            if (desired.equals(shelf[i].getName())) {
                bookPrint(shelf[i]);
            }
        }
    }

    public static void swapBooks(Book[] shelf, int index1, int index2) {
        Book tmp = shelf[index1];
        shelf[index1] = shelf[index2];
        shelf[index2] = tmp;
    }

    public static void main(String[] args) {
        Book[] shelf = createBookArray();
        printBooks(shelf);
        swapBooks(shelf, 0, 3);
        searchBooks(shelf, "Clean Code");
    }
}
