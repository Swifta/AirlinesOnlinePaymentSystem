package com.eagleairug.onlinepayment.controllers.main;

import com.eagleairug.onlinepayment.views.main.DHomeUIDesign;
import com.eagleairug.onlinepayment.views.main.DPaymentStateUIDesign;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Component;

public class DPaymentStateUIController extends DPaymentStateUIDesign implements UIController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1557587995086450443L;
	private DHomeUIDesign guid;
	DPaymentStateUIController(DHomeUIDesign guid){
		init(guid);
	}
	@Override
	public void initDefaultUI(DHomeUIDesign guid) {
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
	public DHomeUIDesign getGeneralUIDesign() {
		
		return this.guid;
	}

	@Override
	public void setGeneralUIDesign(DHomeUIDesign guid) {
		this.guid = guid;
		
	}

}
