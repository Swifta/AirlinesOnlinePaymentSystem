package com.eagleairug.onlinepayment.controllers.admin;

import com.eagleairug.onlinepayment.views.admin.DManagementUIDesign;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.UI;

public class DManagementUIController extends DManagementUIDesign implements UIController {

	
	private static final long serialVersionUID = -3610153824639476015L;
	
	private DManagementUIController  guid;

	public DManagementUIController(){
		init(this);
	}
	
	@Override
	public void initDefaultUI(DManagementUIController guid) {
		swap(guid, new DDashboardUIController(guid));
		UI.getCurrent().setContent(guid);
	}

	@Override
	public void initFooter(Component comp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attachCommandListener(VaadinRequest request) {
		attachDashboard();
		attachNewUser();
		attachUsers();
		attachReports();
		
	}
	
	private void attachDashboard(){
		this.btnDashboard.addClickListener(new ClickListener(){
			private static final long serialVersionUID = 4209289701962087613L;

			@Override
			public void buttonClick(ClickEvent event) {
				new DDashboardUIController(guid);
			}
			
		});
	}
	
	
	private void attachNewUser(){
		
		this.btnNewUser.addClickListener(new ClickListener(){
			private static final long serialVersionUID = -4523991192877530736L;
			@Override
			public void buttonClick(ClickEvent event) {
				new DNewUserFormUIController(guid);
			}
			
		});
		
	}
	
	
	private void attachUsers(){
		
		this.btnUsers.addClickListener(new ClickListener(){

			/**
			 * 
			 */
			private static final long serialVersionUID = -4523991192877530736L;

			@Override
			public void buttonClick(ClickEvent event) {
				
				new DUserManagementUIController(guid);
				
			}
			
		});
		
		
	}
	
	private void attachReports(){
		
		this.btnReports.addClickListener(new ClickListener(){

			/**
			 * 
			 */
			private static final long serialVersionUID = -4523991192877530736L;

			@Override
			public void buttonClick(ClickEvent event) {
				
				new DReportsUIController(guid);
				
			}
			
		});
		
		
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
