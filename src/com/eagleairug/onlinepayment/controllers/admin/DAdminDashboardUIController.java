package com.eagleairug.onlinepayment.controllers.admin;

import com.eagleairug.onlinepayment.controllers.main.UIController;
import com.eagleairug.onlinepayment.views.admin.DDashboardUIDesign;
import com.eagleairug.onlinepayment.views.main.DHomeUIDesign;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Component;
import com.vaadin.ui.UI;

public class DAdminDashboardUIController extends DDashboardUIDesign implements UIController {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = -3610153824639476015L;
	

	public DAdminDashboardUIController(){
		init(null);
	}
	
	@Override
	public void init(DHomeUIDesign guid){
		UI.getCurrent().setContent(this);
		attachCommandListener(null);
	}
	
	@Override
	public void initDefaultUI(DHomeUIDesign guid) {
		
	}

	@Override
	public void initFooter(Component comp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attachCommandListener(VaadinRequest request) {
		attachNewReservation();
		
	}
	
	private void attachNewReservation(){
		
	}
	
	

	@Override
	public DHomeUIDesign getGeneralUIDesign() {
		
		return null;
	}

	@Override
	public void setGeneralUIDesign(DHomeUIDesign guid) {
		
		
		
	}

}
