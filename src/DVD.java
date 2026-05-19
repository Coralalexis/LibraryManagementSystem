
public class DVD extends MediaItem implements Loanable{
	protected int duration;
	protected String rating;
	public DVD(int id, String name, String author, int year, int duration, String rating) {
		super(id, name, author, year); 
		this.duration = duration;
		this.rating = rating;
	}
	@Override
	public String toString() {
		return String.format("[DVD ID: D%03d  | Name: %s | Author: %s", id, name, author);
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
		return String.format("[DVD ID: D%03d  | Name: %s | Author: %s  |  Year of publication: %d  |  Duration: %d  |  Rating: %s", id, name, author, year, duration, rating);
	}


}

