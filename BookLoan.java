import java.time.LocalDate;
 

public class BookLoan {
    private final int id, bookId, memberId;
    private final LocalDate borrowDate;
    public int booksOnLoan;
    
    
    public BookLoan(int id, int bookId, int memberId, LocalDate BorrowDate){
        this.id = id;
        this.bookId = bookId;
        this.memberId = memberId;
        this.borrowDate = LocalDate.now();
    }

    public void showLoan(){
        System.out.printf("%d %d %d %d",this.id,this.bookId,this.memberId,this.borrowDate);
    }
	public void borrowBook(){
		
		
	}
	
}