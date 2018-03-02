import java.time.LocalDate;
import java.io.*;
import java.util.*;

/**
 * This is a library class.
 * @author Simba
 * @author Hong Xuan
 * @version 1.0
 */
public class Library {
    private ArrayList<Book> listBook = new ArrayList<>();
    private ArrayList<Member> listMember = new ArrayList<>();
    private ArrayList<BookLoan> listBookLoans = new ArrayList<>();

    public Library (String booksPath, String membersPath, String bookLoansPath) {
        this.importBooks(booksPath);
        this.importMembers(membersPath);
        this.importBookLoans(bookLoansPath);

    }

    /**
     * Initialise library by importing books, members and bookloans from txt
     * files given.
     * @param 
     * 
     */
    public void importBooks(String fileName) {
        String line = null;
        try {
            FileReader fileReader = new FileReader(fileName);// might throw FileExceptionError
            BufferedReader BufferedReader = new BufferedReader(fileReader); // might throw IOException
            line = BufferedReader.readLine();
            while (line != null) {
                String[] data = line.split(",");
                Book temp = new Book(Integer.parseInt(data[0]),data[1],data[2],Integer.parseInt(data[3]),Integer.parseInt(data[4]));
                this.listBook.add(temp);
                line = BufferedReader.readLine();
            }
            BufferedReader.close();
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void importMembers(String fileName) {
        String line = null;
        try {
            FileReader fileReader = new FileReader(fileName);// might throw FileExceptionError
            BufferedReader BufferedReader = new BufferedReader(fileReader); // might throw IOException
            line = BufferedReader.readLine();
            while (line != null) {
                String[] data = line.split(",");
                Member temp = new Member(Integer.parseInt(data[0]), data[1], data[2], data[3]);
                this.listMember.add(temp);
                line = BufferedReader.readLine();
            }
            BufferedReader.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void importBookLoans(String fileName) {
        String line = null;
        try {
            FileReader fileReader = new FileReader(fileName);// might throw FileExceptionError
            BufferedReader BufferedReader = new BufferedReader(fileReader); // might throw IOException
            line = BufferedReader.readLine();
            while (line != null) {
                String[] data = line.split(",");
                BookLoan temp = new BookLoan(Integer.parseInt(data[0]),Integer.parseInt(data[1]),Integer.parseInt(data[2]), LocalDate.parse(data[3]));
                this.listBookLoans.add(temp);
                line = BufferedReader.readLine();

            }
            BufferedReader.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void searchBook(String title){
        ArrayList<Book> foundBooks= Book.findBook(listBook,title);
        if (foundBooks!=null)
        { for(Book book:foundBooks)
                book.toString();
        }
    }

    public void searchMember(ArrayList<Member> members, String firstName,String lastName){
        Member foundMember= Member.findMember(members,firstName,lastName);
        if (foundMember!= null)
        { 
            foundMember.toString();
        }

    }

    public void showAllBooks() {
        System.out.println("------------------------");
        System.out.println("List of Books.");
        System.out.println("------------------------");
        for (Book book: listBook) 
        {
            System.out.printf("%s\n",book.getTitle());
        }
    }

    public void showAllMembers(){
        System.out.println("------------------------");
        System.out.println("List of Members.");
        System.out.println("------------------------");
        for (Member member: listMember) {
            System.out.printf("%s %s\n",member.getFirstName(),member.getLastName());
        }
    }

    public void showAllBookLoans(){
        System.out.println("------------------------");
        System.out.println("List of book loans.");
        System.out.println("------------------------");
        for (BookLoan bookloan: listBookLoans) {
            bookloan.showLoan();
        }
    }
    
    public void addNewBook(int bookId, String title, String author,int year, int numberCopies){
        Book newBook= new Book(bookId,title,author,year,numberCopies);
        listBook.add(newBook);
    }

    public void addNewMember(){
        Member newMember= new Member(id,firstName,lastName,LocalDate.now());
        listMember.add(newMember);
    }
    public void changeQuantity() {
        
        //userinput
        Boolean exists= false;
        for(Book book: listBook)
        {
            if(book.getTitle().toLowerCase()==title.toLowerCase())
            {
                   book.changeQty(change);
            }
        }
        if (!exists){
            System.out.println("Book not found");
            }
    }
}

