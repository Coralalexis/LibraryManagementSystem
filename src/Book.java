
public class Book extends MediaItem implements Loanable{
	protected String genre;
	protected String IBSN;
	
	public Book(int id, String name, String author, int year, String genre, String IBSN) {
		super(id, name, author, year);
		this.genre = genre;
		this.IBSN = IBSN;
		
		
		
	}
	@Override
	public String toString() {
		return String.format("[Book ID: B%03d  | Name: %s | Author: %s", id, name, author);
	}
	
	@Override
	public void checkOut() {
		if (checkedOut == false){
			checkedOut = true;}
		else {
			System.err.println("Error: Item is not currently available");
		}
	}
	
	@Override
	public void returnItem() {
		if (checkedOut == true) {
			checkedOut = false;}
		else {
			System.err.println("Error: Item is not currently checked out");
		}
	}
	
	public String getFullInfo() {
		return String.format("[DVD ID: D%03d  | Name: %s | Author: %s  |  Year of publication: %d  | Genre: %s |  IBSN: %s", id, name, author, year, genre, IBSN);
	}



	

}
