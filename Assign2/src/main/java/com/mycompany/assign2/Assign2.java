/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.assign2;

import java.lang.annotation.Retention;
import java.lang.*;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface BookInfo {
    String genre();
    String addedBy();
}

enum BookStatus {
    AVAILABLE("Book is available"),
    BORROWED("Book is borrowed"),
    RESERVED("Book is reserved"),
    LOST("Book is lost");

    private String message;

    BookStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

@BookInfo(genre = "Science Fiction", addedBy = "Admin")
class BookBean {
    private String title;
    private Double price;
    private BookStatus status;
    private int[] borrowCount = new int[12];

    // Getter and Setter for title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter and Setter for price
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    // Getter and Setter for status
    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    // Indexed Getter and Setter for borrowCount
    public int getBorrowCount(int index) {
        return borrowCount[index];
    }

    public void setBorrowCount(int index, int value) {
        borrowCount[index] = value;
    }
}



public class Assign2 {
    public static void main(String[] args) {

        // Create BookBean object
        BookBean book = new BookBean();
        book.setTitle("Dune");
        book.setPrice(499.99);

        // Change status to BORROWED
        book.setStatus(BookStatus.BORROWED);
        System.out.println("Status: " + book.getStatus().getMessage());

        // Set borrow count for months 1–3
        book.setBorrowCount(0, 5);  // January
        book.setBorrowCount(1, 8);  // February
        book.setBorrowCount(2, 3);  // March

        System.out.println("Borrow counts (Jan-Mar):");
        for (int i = 0; i < 3; i++) {
            System.out.println("Month " + (i + 1) + ": " + book.getBorrowCount(i));
        }

        // Use Reflection to read annotation
        Class<?> cls = book.getClass();

        if (cls.isAnnotationPresent(BookInfo.class)) {
            BookInfo info = cls.getAnnotation(BookInfo.class);
            System.out.println("\nAnnotation Details:");
            System.out.println("Genre: " + info.genre());
            System.out.println("Added By: " + info.addedBy());
        }
    }
}








