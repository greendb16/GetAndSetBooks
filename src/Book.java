

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Book {

    private String bookTitle;
    private String author;
    private String description;
    private double price;
    private boolean inStock;
    private String sKU = "";
    private static String input;
    private static Double max;
    private static Double min;
    private static String index;
    private static ArrayList<String> descriptionInput = new ArrayList<>();
    private static ArrayList<String> descriptionIndex = new ArrayList<>();
    private static HashMap<Integer, Boolean> descripFinal = new HashMap<>();

    private static ArrayList<Book> bookList = new ArrayList<>();
    private ArrayList<Book> checkOut = new ArrayList<>();


    public Book() {

    }

    public Book(String bookTitle, String author, String description, double price, boolean inStock, String sKU) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.description = description;
        this.price = price;
        this.inStock = inStock;
        this.sKU = sKU;
    }

    public static String getInput() {
        return input;
    }

    public static void setInput(String input) {
        Book.input = input;
    }

    public static String getIndex() {
        return index;
    }

    public static void setIndex(String index) {
        Book.index = index;
    }

    public static ArrayList<String> getDescriptionInput() {
        return descriptionInput;
    }

    public static void setDescriptionInput(ArrayList<String> descriptionInput) {
        Book.descriptionInput = descriptionInput;
    }

    public static ArrayList<String> getDescriptionIndex() {
        return descriptionIndex;
    }

    public static void setDescriptionIndex(ArrayList<String> descriptionIndex) {
        Book.descriptionIndex = descriptionIndex;
    }

    public static HashMap<Integer, Boolean> getDescripFinal() {
        return descripFinal;
    }

    public static void setDescripFinal(HashMap<Integer, Boolean> descripFinal) {
        Book.descripFinal = descripFinal;
    }

    private String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public ArrayList<Book> getBookList() {
        return bookList;
    }

    public String getsKU() {
        return sKU;
    }

    public void setsKU(String sKU) {
        this.sKU = sKU;
    }

    public void setBookList(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    //Create Display text string from variables
    private String getDisplayText() {
        if (inStock) {
            return "Author: " + author + "\nTitle: " + bookTitle + "\nDescription: " + description + "\nIn Stock: Yes";
        } else {
            return "Author: " + author + "\nTitle: " + bookTitle + "\nDescription: " + description + "\nIn Stock: No";
        }
    }

    //Return List of Available tiltes
    public String returnListTitles(ArrayList<Book> bookList) {
        setBookList(bookList);
        String print = "";
        for (Book b : getBookList()) {
            print += b.getBookTitle() + ", ";
        }
        return print;
    }

    //Return List of available Authors
    public String returnListAuthors(ArrayList<Book> bookList) {
        setBookList(bookList);
        String print = "";
        for (Book b : getBookList()) {
            print += b.getAuthor() + ", ";
        }
        return print;
    }

    //Return Books based on price input
    public String returnListPrice(ArrayList<Book> bookList) {
        setBookList(bookList);
        String print = "";
        for (Book b : getBookList()) {
            if (b.getPrice() < max && b.getPrice() > min) {
                print += "\n" + b.getDisplayText() + "\n";
            }

        }
        return print;
    }

    //Return books based on key words in books description
    public String returnListDescription(ArrayList<Book> bookList, HashMap<Integer, Boolean> descripFinal) {
        setBookList(bookList);
        String print = "";
        descriptionInput.clear();

        //Reset Hashmap for repeat queries
        for (int y : descripFinal.keySet()) {
                descripFinal.replace(y,false);
        }

        //Create Array List from input words
        for (String word : input.split(" ")) {
            descriptionInput.add(word);
        }

        //Search each book for key words
        for (int i = 0; i < bookList.size(); i++) {

            index = bookList.get(i).getDescription().toLowerCase();
            descriptionIndex.clear();


            // Create ArrayList from book description words
            for (String word : index.split(" ")) {
                descriptionIndex.add(word);
            }

            //Compare input Arraylist and description Arraylist,  setting Hashmap with key = Book#(i) to true
            for (int j = 0; j < descriptionInput.size(); j++) {
                if (descriptionIndex.contains(descriptionInput.get(j))) {
                    descripFinal.replace(i+1, true);
                }
            }
        }

        //Create Return string form true hashmaps
        for (int b = 0; b < descripFinal.size(); b++) {
            if (descripFinal.get(b+1)) {
                print += "\n"+bookList.get(b).getDisplayText() + "\n";
            }
        }
        return print;
    }

    //Return books based on SKU
    public String returnListSKU(ArrayList<Book> bookList) {
        setBookList(bookList);
        String print = "";
        for (Book b : getBookList()) {
            if (b.getsKU().toLowerCase().equals(input)) {
                print += "\n" + b.getDisplayText() + "\n";
            }

        }
        return print;
    }

    //Determine how to browse inventory
    public String browseSelection(String choice, ArrayList<Book> bookList, HashMap<Integer, Boolean> descripFinal, Scanner scan) {


        String answer = "";

        switch (choice) {

            case "titles":
                answer = returnListTitles(bookList);
                break;


            case "authors":
                answer = returnListAuthors(bookList);
                break;

            case "price":
                System.out.println("What is you're maximum price?");
                max = scan.nextDouble();
                scan.nextLine();
                System.out.println("What is you're minimum price?");
                min = scan.nextDouble();
                scan.nextLine();
                answer = returnListPrice(bookList);
                break;

            case "description":

                System.out.println("What are some key words you are looking for?");
                setInput(scan.nextLine().toLowerCase());
                answer = returnListDescription(bookList, descripFinal);
                break;


            case "sku":
                System.out.println("Enter an SKU number:");
                input = scan.nextLine().toLowerCase();
                answer = returnListSKU(bookList);
                break;


            default:
                answer = "That is not an option.";
                break;

        }
        return answer;

    }
}
