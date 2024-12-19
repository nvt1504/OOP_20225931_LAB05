package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class Book {
    // Fields
    private int id;
    private String title;
    private String category;
    private float price;
    private ArrayList<String> authors = new ArrayList<>();

    // Constructor
    public Book(int id, String title, String category, float price) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.price = price;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    // Methods to add and remove authors
    public boolean addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            return true;
        }
        System.out.println("Author already exists in the list.");
        return false;
    }

    public boolean removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            return true;
        }
        System.out.println("Author not found in the list.");
        return false;
    }

    // Optional: Display book details
    public void displayBookDetails() {
        System.out.println("Book ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Category: " + category);
        System.out.println("Price: " + price);
        System.out.println("Authors: " + String.join(", ", authors));
    }
    @Override
    public String toString() {
        return "Book[ID=" + getId() + ", Title=" + getTitle() + ", Category=" + getCategory() +
                ", Price=" + getPrice() + "]";
    }

}
