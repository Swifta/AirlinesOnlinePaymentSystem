package com.eagleairug.onlinepayment.controllers.main;

import com.eagleairug.onlinepayment.controllers.admin.DManagementUIController;
import com.eagleairug.onlinepayment.views.main.DLoginUIDesign;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.UI;

public class DLoginUIController extends DLoginUIDesign implements UIController {

	
	private static final long serialVersionUID = -3610153824639476015L;
	
	

	DLoginUIController(VaadinRequest request){
		init(null);
	}
	
	@Override
	public void init(DHomeUIController guid){
		UI.getCurrent().setContent(this);
		attachCommandListener(null);
		
	}
	
	@Override
	public void initDefaultUI(DHomeUIController guid) {
		
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
		
		this.btnLogin.setClickShortcut(KeyCode.ENTER, null);
		
		
		this.btnLogin.addClickListener(new ClickListener(){
			
			private static final long serialVersionUID = -8066548934073593566L;
			
			@Override
			public void buttonClick(ClickEvent event) {
				String sUsername = fUsername.getValue();
				String sPassword = fPassword.getValue();
				if(sUsername != null && sPassword != null && !sUsername.isEmpty()){	
					new DManagementUIController();
				}
				
			}
			
		});
	}
	
	

	@Override
	public DHomeUIController getGeneralUIDesign() {
		return null;
	}

	@Override
	public void setGeneralUIDesign(DHomeUIController guid) {
		
		
		
	}

}
