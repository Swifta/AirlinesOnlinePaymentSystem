package com.eagleairug.onlinepayment.controllers.main;

import com.eagleairug.onlinepayment.controllers.accounting.DAccountingDashboardUIController;
import com.eagleairug.onlinepayment.controllers.admin.DAdminDashboardUIController;
import com.eagleairug.onlinepayment.controllers.agent.DAgentDashboardUIController;
import com.eagleairug.onlinepayment.views.main.DHomeUIDesign;
import com.eagleairug.onlinepayment.views.main.DLoginUIDesign;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.UI;

public class DLoginUIController extends DLoginUIDesign implements UIController {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = -3610153824639476015L;
	

	DLoginUIController(){
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
		attachLogin();
		
	}
	
	private void attachLogin(){
		String sUsername = this.fUsername.getValue();
		String sPassword = this.fPassword.getValue();
		
		System.out.println("----------- "+sUsername+" --------------");
		
		this.btnLogin.setClickShortcut(KeyCode.ENTER, null);
		this.btnLogin.addClickListener(new ClickListener(){
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				if(sUsername != null & sPassword != null){
					
					if(sUsername.equals("admin"))
						new DAdminDashboardUIController();
					if(sUsername.equals("accountant"))
						new DAccountingDashboardUIController();
					if(sUsername.equals("agent"))
						new DAgentDashboardUIController();
					
				}
				
				//new DHomeUIController();
				
			}
			
		});
	}
	
	

	@Override
	public DHomeUIDesign getGeneralUIDesign() {
		
		return null;
	}

	@Override
	public void setGeneralUIDesign(DHomeUIDesign guid) {
		
		
		
	}

}
