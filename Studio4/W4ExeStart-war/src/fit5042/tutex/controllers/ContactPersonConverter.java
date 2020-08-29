package fit5042.tutex.controllers;

import java.util.List;

import javax.el.ELContext;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import fit5042.tutex.mbeans.PropertyManagedBean;
import fit5042.tutex.repository.entities.ContactPerson;

@FacesConverter(forClass = fit5042.tutex.repository.entities.ContactPerson.class, value = "contactPerson")
public class ContactPersonConverter implements Converter {

	@ManagedProperty(value = "#{propertyManagedBean}")
	PropertyManagedBean propertyManagedBean;

	public List<ContactPerson> contactPersonList;

	public ContactPersonConverter() {
		try {
			ELContext elcontext = FacesContext.getCurrentInstance().getELContext();
			propertyManagedBean = (PropertyManagedBean) FacesContext.getCurrentInstance().getApplication()
					.getELResolver().getValue(elcontext, null, "propertyManagedBean");
			contactPersonList = propertyManagedBean.getAllContactPeople();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		// TODO Auto-generated method stub

		if (arg2.trim().equals(""))
			return null;
		else {
			try {
				int number = Integer.parseInt(arg2);

				for (ContactPerson cp : contactPersonList) {
					if (cp.getConactPersonId() == number)
						return cp;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		// TODO Auto-generated method stub
		
		if(arg2 == null || arg2.equals(""))
			return "";
		else
			return String.valueOf(((ContactPerson)arg2).getConactPersonId());
	}

}
