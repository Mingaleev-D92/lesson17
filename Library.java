package ru.innopolis.university.mingaleev.homework_17;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Library {
    static String filePath = "D:\\test\\library.txt";
    static File f = new File(filePath);

    public void addBook(String data) {
        try (FileWriter fw = new FileWriter(filePath, true)) {
            fw.write(data, 0, data.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readBooks() {
        char[] buffer = null;
        try (FileReader r = new FileReader(f)) {
            buffer = new char[(int) f.length()];
            r.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(buffer);
    }

    public static void main(String[] args) {

        Library library = new Library();
        try {
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        do {
            Scanner in = new Scanner(System.in);
            System.out.println("\nЧто хотите сделать ? Выберите пункт []\nдобавить книгу [1]\tпоказать cписок [2]" +
                    "\tвыход[q]");
            String userChoice = in.next();

            if (userChoice.equals("q")) {
                System.out.println("Завершаем работу!");
                break;
            }

            switch (userChoice) {
                case "1": {
                    try {
                        System.out.println("Введите название книги:");
                        String userBookName = in.next();
                        System.out.println("Введите автора книги:");
                        String userBookAuthor = in.next();
                        System.out.println("Введите год издания книги:");
                        int userYearOfPublishing = in.nextInt();

                        Book book = new Book(userBookName, userBookAuthor, userYearOfPublishing);
                        library.addBook(book.toString());
                        System.out.println("Добавили книгу, наша библиотека пополнена:\n"
                                + library.readBooks());
                    } catch (Exception e) {
                        System.out.println("Exception" + e);
                    }
                }
                break;
                case "2": {
                    System.out.println("Cписок книг в библиотеке:\n" + library.readBooks());
                }
                break;
                default:
                    System.out.println("Пожалуйста сделайте один из выборов [1,2,3,q]");
            }
        } while (true);
    }
}
