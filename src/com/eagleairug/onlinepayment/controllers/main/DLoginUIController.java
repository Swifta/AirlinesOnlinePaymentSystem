package com.eagleairug.onlinepayment.controllers.main;

import com.eagleairug.onlinepayment.views.main.DHomeUIDesign;
import com.eagleairug.onlinepayment.views.main.DLoginUIDesign;
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
		attachLogin();
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
		this.btnLogin.addClickListener(new ClickListener(){

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				
				new DHomeUIController();
				
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
