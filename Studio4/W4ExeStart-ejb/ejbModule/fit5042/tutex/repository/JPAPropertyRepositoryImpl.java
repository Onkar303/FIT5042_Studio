package fit5042.tutex.repository;

import fit5042.tutex.repository.entities.ContactPerson;
import fit5042.tutex.repository.entities.Property;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;

import org.glassfish.ha.store.criteria.Criteria;

/**
 *
 * @author Eddie Leung
 */
@Stateless
public class JPAPropertyRepositoryImpl implements PropertyRepository {

    //insert code (annotation) here to use container managed entity manager to complete these methods
	@PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addProperty(Property property) throws Exception {
        List<Property> properties = entityManager.createNamedQuery(Property.GET_ALL_QUERY_NAME).getResultList();
        property.setPropertyId(properties.get(0).getPropertyId() + 1);
        entityManager.persist(property);
    }

    @Override
    public Property searchPropertyById(int id) throws Exception {
        Property property = entityManager.find(Property.class, id);
        property.getTags();
        return property;
    }

    @Override
    public List<Property> getAllProperties() throws Exception {
        return entityManager.createNamedQuery(Property.GET_ALL_QUERY_NAME).getResultList();
    }

    @Override
    public Set<Property> searchPropertyByContactPerson(ContactPerson contactPerson) throws Exception {
        contactPerson = entityManager.find(ContactPerson.class, contactPerson.getConactPersonId());
        contactPerson.getProperties().size();
        entityManager.refresh(contactPerson);

        return contactPerson.getProperties();
    }

    @Override
    public List<ContactPerson> getAllContactPeople() throws Exception {
        return entityManager.createNamedQuery(ContactPerson.GET_ALL_QUERY_NAME).getResultList();
    }

    @Override
    public void removeProperty(int propertyId) throws Exception {
    	
//    	CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//    	
//    	CriteriaQuery<Property> query = criteriaBuilder.createQuery(Property.class);
//    	
//    	
//    	Root<Property> p = query.from(Property.class);
//    	
    	
//    	criteriaBuilder.equal("propertyId",String.valueOf(propertyId));
//    	
//    	criteriaBuilder.equal("propertyId",String.valueOf(propertyId));
    	
    	Property property = entityManager.find(Property.class, propertyId);
    	EntityTransaction entityTransaction = entityManager.getTransaction();
    	try {
    		entityTransaction.begin();
    		
    		if(property != null)
    			entityManager.remove(property);    		
    		entityTransaction.commit();
    		
    	}catch(Exception e) {
    		entityTransaction.rollback();
    	}
    	    	 	
    }

    @Override
    public void editProperty(Property property) throws Exception {
        try {
            entityManager.merge(property);
        } catch (Exception ex) {

        }
    }

    @Override
    public List<Property> searchPropertyByBudget(double budget) throws Exception {
        //complete this method using Criteria API
    	
    	
//    	CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//    	
//    	CriteriaQuery query = builder.createQuery(Property.class);
//    	
//    	Root<Property> r = query.from(Property.class);
//    	
//    	Predicate predicate = builder.lessThanOrEqualTo(r.get("price"), 0);
//    	
//    	query.where(predicate);
//    	
//    	return entityManager.createQuery(query).getResultList();\
    	
    	
    	
    	CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    	
    	CriteriaQuery<Property> query = cb.createQuery(Property.class);
    	
    	Root<Property> p = query.from(Property.class);
    	
//    	Predicate predicate = cb.lessThan(from.get("price"),String.valueOf(budget));
    	
    	query.select(p).where(cb.lessThanOrEqualTo(p.get("price").as(Double.class), budget));
    	
    	return entityManager.createQuery(query).getResultList();
    	

    }
}
