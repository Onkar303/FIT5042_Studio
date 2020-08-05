/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.repository;

import fit5042.tutex.repository.entities.Property;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO Exercise 1.3 Step 2 Complete this class.
 * 
 * This class implements the PropertyRepository class. You will need to add the keyword
 * "implements" PropertyRepository. 
 * 
 * @author Onkar Kalpavriksha
 */
public class SimplePropertyRepositoryImpl implements PropertyRepository{

	private ArrayList<Property> listProperty;
	
    public SimplePropertyRepositoryImpl() {
    	listProperty = new ArrayList<>();
    }

	@Override
	public void addProperty(Property property) throws Exception {
		// TODO Auto-generated method stub
		if(property != null)
		{
			listProperty.add(property);
		}
		
		
	}

	@Override
	public Property searchPropertyById(int id) throws Exception {
		// TODO Auto-generated method stub
		
		for(Property p : listProperty)
		{
			if(p.getId() == id)
			{
				return p;
			}
		}
		
		return null;
	}

	@Override
	public List<Property> getAllProperties() throws Exception {
		// TODO Auto-generated method stub
		return listProperty;
	}
    
}
