package fit5042.tutex.calculator;

import java.util.ArrayList;

import javax.ejb.Stateful;
import javax.ejb.Stateless;

import fit5042.tutex.repository.constants.CommonInstance;
import fit5042.tutex.repository.entities.Property;

@Stateless
public class ComparePropertySessionBean implements CompareProperty {

	
	ArrayList<Property> compareList;
	
	
	public ComparePropertySessionBean() {
		
		compareList = new ArrayList<>();
	}
	
	
	@Override
	public void addProperty(Property p) {
		// TODO Auto-generated method stub
		
		
		compareList.add(p);
		
	}

	@Override
	public void removeProperty(Property p) {
		// TODO Auto-generated method stub
		
		
		
		if(compareList.size() > 0)
		{
			for(Property obj:compareList)
			{
				if(obj.getPropertyId() == p.getPropertyId())
					compareList.remove(p);
			}
		}
		else {
			System.out.println("not present");
		}
		
	}

	@Override
	public int bestPerRoom() {
		// TODO Auto-generated method stub
		
		Integer idBest = 0;
		int numberOfRooms;
		double price;
		double bestPerRoom = 100000000.00;
		
		for (Property p : compareList) {
			numberOfRooms = p.getNumberOfBedrooms();
			price = p.getPrice();
			if (price/numberOfRooms < bestPerRoom) {
				bestPerRoom = price/numberOfRooms;
				idBest = p.getPropertyId();
			}
		}
		return idBest;
	}

}
