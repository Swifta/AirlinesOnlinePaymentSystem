package com.eagleairug.onlinepayment.controllers.main;

import com.eagleairug.onlinepayment.controllers.admin.DManagementUIController;
import com.eagleairug.onlinepayment.models.main.MLogin;
import com.eagleairug.onlinepayment.views.main.DLoginUIDesign;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.UI;

public class DLoginUIController extends DLoginUIDesign implements UIController {

	
	private static final long serialVersionUID = -3610153824639476015L;
	
	

	public DLoginUIController(VaadinRequest request){
		init(null);
	}
	
	
	@Override
	public void initDefaultUI(DHomeUIController guid) {
		UI.getCurrent().setContent(this);
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
				
				if(sUsername.equals(null) || sPassword.equals(null))	
					return;
				
				
				sUsername = sUsername.trim();
				sPassword = sPassword.trim();
				
				if(sUsername.isEmpty() || sPassword.isEmpty())
					return;
				
				MLogin mLogin = new MLogin();
				
				if(!mLogin.login(sUsername, sPassword))
					return;
				
				UI.getCurrent().getSession().setAttribute("username", sUsername);
				new DManagementUIController();
				
				
				
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
