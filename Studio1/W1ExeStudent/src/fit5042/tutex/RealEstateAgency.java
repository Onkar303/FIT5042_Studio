package fit5042.tutex;

import fit5042.tutex.repository.PropertyRepository;
import fit5042.tutex.repository.PropertyRepositoryFactory;
import fit5042.tutex.repository.entities.Property;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * TODO Exercise 1.3 Step 3 Complete this class. Please refer to tutorial
 * instructions. This is the main driver class. This class contains the main
 * method for Exercise 1A
 * 
 * This program can run without the completion of Exercise 1B.
 * 
 * @author Onkar Kalpavriksha
 */
public class RealEstateAgency {
	private String name;
	private final PropertyRepository propertyRepository;

	public RealEstateAgency(String name) throws Exception {
		this.name = name;
		this.propertyRepository = PropertyRepositoryFactory.getInstance();
	}

	// this method is for initializing the property objects
	// complete this method
	public void createProperty() {
		Property property1 = new Property(1, "19 hourigan avnue,Clayton Vic 3168", 4, 150, 4200000);
		Property property2 = new Property(2, "20 prince avnue,Clayton Vic 3240", 1, 110, 4200000);
		Property property3 = new Property(3, "21 malvern avnue,Clayton Vic 3128 ", 5, 1530, 4200000);
		Property property4 = new Property(4, "22 mourmbina avnue,Clayton Vic 3165", 3, 120, 4200000);
		Property property5 = new Property(5, "23 hourigan avnue,Clayton Vic 2341", 2, 1540, 4200000);
		
		try
		{
			this.propertyRepository.addProperty(property1);
			this.propertyRepository.addProperty(property2);
			this.propertyRepository.addProperty(property3);
			this.propertyRepository.addProperty(property4);
			this.propertyRepository.addProperty(property5);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		System.out.println("5 properties added successfully");

	}

	// this method is for displaying all the properties
	// complete this method
	public void displayProperties() {
		try {
			List<Property> list = this.propertyRepository.getAllProperties();
			for (Property p : list) {
				System.out.println(p.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// this method is for searching the property by ID
	// complete this method
	public void searchPropertyById() {
		System.out.print("Enter the Id of the property you want to search : ");
		Scanner input = new Scanner(System.in);
		int id = input.nextInt();
		try {
			System.out.println(this.propertyRepository.searchPropertyById(id).toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		input.close();

	}

	public void run() {
		createProperty();
		System.out.println("********************************************************************************");
		displayProperties();
		System.out.println("********************************************************************************");
		searchPropertyById();
	}

	public static void main(String[] args) {
		try {
			new RealEstateAgency("FIT5042 Real Estate Agency").run();
		} catch (Exception ex) {
			System.out.println("Application fail to run: " + ex.getMessage());
		}
	}
}
