
public class Magazine extends MediaItem implements Loanable{
	protected int issueNum;
	protected String month;
	
	public Magazine(int id, String name, String author, int year, int issueNum,  String month) {
		super(id, name, author, year);
		this.issueNum = issueNum;
		this.month = month;
	}
	@Override
	public String toString() {
		return String.format("[Magazine ID: M%03d  | Name: %s | Author: %s", id, name, author);
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
		return String.format("[DVD ID: D%03d  | Name: %s | Author: %s  |  Year of publication: %d  |  Issue Number: %d  |  Month: %s", id, name, author, year, issueNum, month);
	}

}
