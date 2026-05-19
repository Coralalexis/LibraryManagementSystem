abstract class MediaItem implements Comparable<MediaItem> {
    protected String name;
    protected String author;
    protected int id;
    protected int year;
    protected boolean checkedOut;
 
    public MediaItem(int id, String name, String author, int year) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.year = year;
        checkedOut = false;
    }
 
 // Standard compareTo using logic instead of ::
    @Override
    public int compareTo(MediaItem other) {
    	// compare book vs dvd etc
    	int typeComp = this.getClass().getSimpleName().compareTo(other.getClass().getSimpleName());
    	
    	
    	//see if they are different
    	if(typeComp != 0) {
    		return typeComp;
    	}
        // Sort by name alphabetically
        //return this.name.compareTo(other.name); - > to sort by name
    	return Integer.compare(this.id, other.id); // -> to sort by id
    }
   
 
    @Override
    public String toString() {
        return String.format("[%s] ID: %d | Name: %s | Author: %s", 
                             this.getClass().getSimpleName(),
                             this.getClass().getSimpleName().charAt(0),
                             id, name, author);
    }
    //abstracts to be taken over by children
	protected abstract void returnItem();

	protected abstract void checkOut();
	
	protected abstract String getFullInfo();


    

    
   

}
 

 
