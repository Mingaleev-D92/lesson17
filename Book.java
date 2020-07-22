package ru.innopolis.university.mingaleev.homework_17;

public class Book {
    private String name;
    private String author;
    private int yearOfPublishing;

    Book(String name, String author, int yearOfPublishing) {
        this.name = name;
        this.author = author;
        this.yearOfPublishing = yearOfPublishing;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public String toString() {
        return ("Book name ='" + name + "'  author ( " + author + " )\tyear of publishing " + yearOfPublishing + "\n");
    }


}
