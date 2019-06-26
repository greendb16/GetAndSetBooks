

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
    private static ArrayList <String> descriptionInput = new ArrayList<>();
    private static ArrayList <String> descriptionIndex = new ArrayList<>();
    private static HashMap <Integer, Boolean> descripFinal = new HashMap<>();

    private static ArrayList<Book> bookList = new ArrayList<>();
    private ArrayList<Book> checkOut = new ArrayList<>();



    public Book(){

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

    public static Double getMax() {
        return max;
    }

    public static void setMax(Double max) {
        Book.max = max;
    }

    public static Double getMin() {
        return min;
    }

    public static void setMin(Double min) {
        Book.min = min;
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

    public String getDisplayText(){
        return "Author: " + author + "\nTitle: " + bookTitle + "\nDescription: " + description;
    }
    public String getBookTitle(){
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

    public String returnListTitles(ArrayList<Book> bookList){
        setBookList(bookList);
        String print = "";
        for(Book b: getBookList()){
           print += b.getBookTitle() + ", ";
        }
        return print;
    }

    public String returnListAuthors (ArrayList<Book> bookList){
        setBookList(bookList);
        String print = "";
        for(Book b: getBookList()){
            print += b.getAuthor() + ", ";
        }
        return print;
    }

    public String returnListPrice(ArrayList<Book> bookList){
        setBookList(bookList);
        String print = "";
        for(Book b: getBookList()){
            if(b.getPrice()< max &&  b.getPrice()>min){
                print += "\n" +b.getDisplayText() + "\n";
            }

        }
        return print;
    }

    public String returnListDescription(ArrayList<Book> bookList, HashMap<Integer, Boolean> descripFinal){
        setBookList(bookList);
        String print = "";
        for(int y:descripFinal.keySet()){
            descripFinal.put(y,false);
        }

        for(String word: input.split(" ")){
            descriptionInput.add(word);
        }
        for(int i=0; i<bookList.size(); i++){
            index = bookList.get(i).getDescription().toLowerCase();
            for(String word : (index).split(" ")){
                descriptionIndex.add(word);


                for(int j=0;j<descriptionInput.size();j++){
                    if(descriptionIndex.contains(descriptionInput.get(j))) {
                        descripFinal.put(i, true);
                    }
                }
            }
        }
        for(int b=0; b<descripFinal.size(); b++) {
            if (descripFinal.get(b)){
                print += bookList.get(b).getDisplayText() + ", ";
            }

        }
        return print;
    }
    public String returnListSKU(ArrayList<Book> bookList){
        setBookList(bookList);
        String print = "";
        for(Book b: getBookList()){
            if(b.getsKU().toLowerCase().equals(input)){
                print += "\n" +b.getDisplayText() + "\n";
            }

        }
        return print;
    }







    public String browseSelection(String choice, ArrayList<Book> bookList, HashMap <Integer, Boolean> descripFinal, Scanner scan){


        String answer = "";

        switch(choice){

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
                input =scan.nextLine().toLowerCase();
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

}}
