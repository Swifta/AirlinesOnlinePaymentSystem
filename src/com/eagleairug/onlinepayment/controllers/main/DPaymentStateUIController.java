package com.eagleairug.onlinepayment.controllers.main;

import com.eagleairug.onlinepayment.views.main.DPaymentStateUIDesign;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Component;

public class DPaymentStateUIController extends DPaymentStateUIDesign implements UIController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1557587995086450443L;
	private DHomeUIController guid;
	DPaymentStateUIController(DHomeUIController guid){
		init(guid);
	}
	@Override
	public void initDefaultUI(DHomeUIController guid) {
		swap(guid, this);
		
	}


	@Override
	public void initFooter(Component comp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attachCommandListener(VaadinRequest request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DHomeUIController getGeneralUIDesign() {
		
		return this.guid;
	}

	@Override
	public void setGeneralUIDesign(DHomeUIController guid) {
		this.guid = guid;
		
	}

}
