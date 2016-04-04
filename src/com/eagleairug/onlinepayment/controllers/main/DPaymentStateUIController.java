package com.eagleairug.onlinepayment.controllers.main;

import com.eagleairug.onlinepayment.views.main.DGeneralUIDesign;
import com.eagleairug.onlinepayment.views.main.DPaymentStateUIDesign;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Component;

public class DPaymentStateUIController extends DPaymentStateUIDesign implements UIControllerInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1557587995086450443L;
	private DGeneralUIDesign guid;
	DPaymentStateUIController(DGeneralUIDesign guid){
		init(guid);
	}
	@Override
	public void initDefaultUI(DGeneralUIDesign guid) {
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
	public DGeneralUIDesign getGeneralUIDesign() {
		
		return this.guid;
	}

	@Override
	public void setGeneralUIDesign(DGeneralUIDesign guid) {
		this.guid = guid;
		
	}

}
