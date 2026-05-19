import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class LibraryManagementSystem {

	    public static void main(String[] args) {
	    	//pull inventory from file
	        List<MediaItem> inventory = getItemDetails("inventory.txt");
	       
	       
	     // Display results
	        for (MediaItem item : inventory) {
	            System.out.println(item);
	        }
	 
	        // Sort using the natural order defined in MediaItem.compareTo
	        Collections.sort(inventory);
	 
	     // Display results
	        for (MediaItem item : inventory) {
	            System.out.println(item);
	        }
	        Scanner scnr = new Scanner(System.in);
	       
	        int search;
	        //keep running as long as user wants
	        while(true) {
	        	System.out.println();
	        	System.out.println("--------Menu options are as follows--------");
	 	        System.out.println("1. Check out media");
	 	        System.out.println("2. Return media");
	 	        System.out.println("3. Show full item details");
	 	        System.out.println("4. Exit");
	 	        System.out.print("Make selection here by typing number: ");
	 	        try {
	 	        	search = scnr.nextInt();
	 	        	scnr.nextLine();
	 	        }
	 	        
	 	        //exception handling
	 	        catch(InputMismatchException ime) {
	 	        	System.out.println();
	 	        	System.err.println("Invalid prompt, start over");
	 	        	scnr.nextLine();
	 	        	continue;
	 	        }
	 	        
	 	        //exit strat
	        	if(search == 4) {
	        		System.out.println("Program terminated!");
	        		break;
	        	}
	        	//skip if not valid prompt
	        	if(search!= 1 && search != 2 && search != 3 ) {
	        		System.out.println("Invalid prompt, start over ");
	        		continue;
	        		}
	        	
	        	System.out.print("Enter name of media: ");
	        	String media = scnr.nextLine().toLowerCase().trim();
	        	System.out.println();
	        	
	        	MediaItem found = null;
	        	
	        	//search inventory
	        	for(MediaItem item : inventory) {
	        		if(item.name.toLowerCase().equals(media)) {
	        			found = item;
	        			break;}}
	      
	        	if(found == null) {
	        		System.out.println("Media not found, start over");
	        		continue;

	        		
	        	}
	        	//find user defined option
	        	switch(search) {
	        	case 1:
	        		found.checkOut();
	        		System.out.println();
	        		System.out.println("Item checked out succesfully");
	        		break;
	        	
	        	case 2:
	        		found.returnItem();
	        		System.out.println();
	        		System.out.println("Item returned succesfully");
	        		break;
	        		
	        	case 3: 
	        		System.out.println();
	        		System.out.println(found.getFullInfo());
	        		break;
	        	
	        	}
	        }
	        	scnr.close();
	        
	    }
	    
	    //helper method to import item and details into database
	    public static List<MediaItem> getItemDetails(String fileName) {
	        List<MediaItem> inventory = new ArrayList<>();
	        
	        File importFile = new File(fileName);
	        try {
				Scanner fileScanner = new Scanner(importFile);
				while(fileScanner.hasNextLine()) {
					String line = fileScanner.nextLine();
					if(line.trim().isEmpty()) continue;
					String[] lineParts = line.split(", ");
					
					String type = lineParts[0].toLowerCase();
					
					
					//cuts off id in hopes to keep letter
					String ID = lineParts[1].trim().substring(1);
					int parsedID = Integer.parseInt(ID);
	
					String name = lineParts[2].trim();
					String author = lineParts[3].trim();
					int year = Integer.parseInt(lineParts[4].trim());
					
					switch (type) {
					case "book": {
						inventory.add(new Book(parsedID, name, author, year, lineParts[5], (lineParts[6])));
						break;
						
					}
					case "dvd": {
						inventory.add(new DVD(parsedID, name, author, year, Integer.parseInt(lineParts[5]), lineParts[6]));
						break;
					}
					
					case "magazine": {
						inventory.add(new Magazine(parsedID, name, author, year, Integer.parseInt(lineParts[5]), lineParts[6]));
						break;
					}
						
					//stops before crash
					default:
						throw new IllegalArgumentException("Unexpected value: " + type);
					}
				}
				fileScanner.close();
			}
	        
	        
	        catch (FileNotFoundException fnfe) {
				System.err.println("Error: File cannot be found");
			}
	    	return inventory;
	    }
}
	