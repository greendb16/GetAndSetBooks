public class Main {
    public static void main(String[]args){

       Book book1 = new Book();
        book1.setAuthor("J.K. Rowling");
        book1.setBookTitle("Harry Potter");
        book1.setDescription("Yer a wizard 'arry");
        book1.setPrice(5.25);
        book1.setInStock(true);



        Book book2 = new Book("Tolkien", "Lord of the Rings", "Hobbits and Rings and Orcs oh my!", 10.35, true);


        System.out.println(book1.getDisplayText());
        System.out.println(book2.getDisplayText());

    }
}
