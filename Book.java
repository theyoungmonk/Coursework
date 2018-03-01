import java.util.*;
/**
 * Write a description of class Book here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Book
{
    // instance variables - replace the example below with your own
    private String title;
    private String author;
    private int numberCopies =0;
    private BookLoan loan;
    private final int bookId;
    private final int year;

    /**
     * Constructor for objects of class Book
     */
    public Book( int bookId, String title, String author,int year, int numberCopies)
    {
        this.title=title;
        this.author=author;
        this.year=year;
        this.bookId=bookId;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getTitle()
    {
        return this.title;
    }

    public String getAuthor()
    {   
        return author ;
    }

    public int getQty()
    {   
        return numberCopies;
    }

    public void changeQty(int numberCopies)
    {
        this.numberCopies=this.numberCopies+numberCopies;
    }

    public int checkQty(){
        int availiable= this.numberCopies - loan.booksOnLoan;
        return availiable;
    }

    public String toString()
    {
        String book= ("book"+title+ ", id"+Integer.toString(bookId)+ ", authors"+getAuthor()+", year"+this.year+"availiable copies"+Integer.toString(checkQty())+", quantity"+Integer.toString(numberCopies));
        return book;
    }

    public static ArrayList<Book> findBook (ArrayList<Book> books,String title) {
        ArrayList<Book> foundBooks = new ArrayList<>();
        Boolean exists= false;
        for(Book book: books)
        {
            if(book.getTitle().toLowerCase().contains(title.toLowerCase()))
            {
                foundBooks.add(book);
            }
        }
        if (!exists){
            System.out.println("Book not found");
            return null;}
        return foundBooks;

    }
}

