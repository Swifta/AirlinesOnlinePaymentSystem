package com.eagleairug.onlinepayment.controllers.main;

import com.eagleairug.onlinepayment.views.main.DGeneralUIDesign;
import com.eagleairug.onlinepayment.views.main.DHomeUIDesign;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Component;

public class DHomeUIController  extends DHomeUIDesign implements UIControllerInterface {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	DHomeUIController(){
		attachCommandListener(null);
	}
	@Override
	public void initDefaultUI(DGeneralUIDesign guid) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setGeneralUIDesign(DGeneralUIDesign guid) {
		// TODO Auto-generated method stub
		
	}

}
