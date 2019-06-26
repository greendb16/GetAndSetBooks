import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static Scanner scan = new Scanner(System.in);
    private static ArrayList<Book> gallery =new ArrayList<>();
    private static String input = "";
//    private static Double max;
//    private static Double min;
//    private static String index;
//    private static ArrayList <String> descriptionInput = new ArrayList<>();
//    private static ArrayList <String> descriptionIndex = new ArrayList<>();
    private static HashMap <Integer, Boolean> descripContents = new HashMap<>();

    public static void main(String[]args){



        //
       Book book1 = new Book();
        book1.setAuthor("J.K. Rowling");
        book1.setBookTitle("Harry Potter");
        book1.setDescription("Yer a wizard 'arry");
        book1.setPrice(5.25);
        book1.setInStock(true);
        gallery.add(book1);
        descripContents.put(1,false);


        Book book2 = new Book("Lord of the Rings", "Tolkien", "Hobbits and Rings and Orcs oh my!", 21.95, true,"Fant1001");
        gallery.add(book2);
        descripContents.put(2,false);

        Book book3 = new Book("The Best Book", "D. Green", "Its just the best.", 36.99, true,"Classics2008");
        gallery.add(book3);
        descripContents.put(3,false);

        Book book4 = new Book("Alice in Wonderland", "C.S. Lewis", "Bunny Rabbits and Queens", 17.35, true, "Fant1006");
        gallery.add(book4);
        descripContents.put(4,false);

        Book book5 = new Book("Pokemon 2: The quest for more pokemon", "N. Tendo", "Now with more Pokemon", 23.36,true,"Classics1151");
        gallery.add(book5);
        descripContents.put(5,false);

        Book book6 = new Book("Head First Java", "Kathy Sierra and Bert Bates", "Easy to read Java workbook", 47.50, true, "Java1001");
        gallery.add(book6);
        descripContents.put(6,false);

        Book book7 = new Book("Thinking in Java", "Bruce Eckel", "Details about Java under the hood", 20.00, true, "Java1002");
        gallery.add(book7);
        descripContents.put(7,false);

        Book book8 = new Book("OCP: Oracle Certified Professional Java SE", "Jeanne Boyarsky", "Everything you need to know in one place", 45.00, true, "Orcl1003");
        gallery.add(book8);
        descripContents.put(8,false);

        Book book9 = new Book("Automate the Boring Stuff with Python", "Al Sweigart", "Fun with Python", 10.50, true, "Python1004");
        gallery.add(book9);
        descripContents.put(9,false);

        Book book10 = new Book("The Makers Guide to the Zombie Apocalypse", "Simon Monk", "Defend Your Base with Simple Circuits, Arduino and Raspberry Pi", 16.50, true, "Zombie1005");
        gallery.add(book10);
        descripContents.put(10,false);

        Book book11 = new Book("Raspberry Pi Projects for the Evil Genius", "Donald Norris", "A Dozen fiendishly fun projects for the Raspberry Pi!", 14.75, true, "Rasp1006");
        gallery.add(book11);
        descripContents.put(11,false);

        while(!input.equals("n")) {
            //Prompt for browse type
            System.out.println("\nHow would you like to browse? (Titles, Authors, Price, Description, or SKU)?");
            input = scan.nextLine().toLowerCase();

            //return query
            System.out.println(book1.browseSelection(input, gallery, descripContents, scan));

            //Ask to loop
            System.out.println("\nWould you like to search again? (Y/N)");
            input = scan.nextLine().toLowerCase();
        }
    }
}
