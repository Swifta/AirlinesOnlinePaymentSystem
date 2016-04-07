package com.eagleairug.onlinepayment.controllers.admin;

import com.eagleairug.onlinepayment.views.admin.DManagementUIDesign;
import com.eagleairug.onlinepayment.views.admin.DReportsUIDesign;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Component;

public class DReportsUIController extends DReportsUIDesign implements UIController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7499676505056564604L;
	
	private DManagementUIController guid;
	DReportsUIController(DManagementUIController guid){
		init(guid);
	}

	@Override
	public void initDefaultUI(DManagementUIController guid) {
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
	public DManagementUIController getGeneralUIDesign() {
		return guid;
	}

	@Override
	public void setGeneralUIDesign(DManagementUIController guid) {
		this.guid = guid;
		
	}

}
