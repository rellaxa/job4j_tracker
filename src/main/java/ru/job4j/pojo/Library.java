package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book first = new Book("The God Delusion", 1111);
        Book second = new Book("Clean code", 895);
        Book third = new Book("The Shining", 784);
        Book forth = new Book("Clever mind", 451);
        Book[] books = new Book[4];
        books[0] = first;
        books[1] = second;
        books[2] = third;
        books[3] = forth;
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println(book.getName() + " - " + book.getNumOfPages());
        }
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        System.out.println("Rearrange cell 0 and cell 3.");
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println(book.getName() + " - " + book.getNumOfPages());
        }
        System.out.println("Show only book: \"Clean code\"");
        for (Book book : books) {
            if ("Clean code".equals(book.getName())) {
                System.out.println(book.getName() + " - " + book.getNumOfPages());
            }
        }
    }
}