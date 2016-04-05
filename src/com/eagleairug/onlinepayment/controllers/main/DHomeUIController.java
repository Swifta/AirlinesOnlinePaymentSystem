package com.eagleairug.onlinepayment.controllers.main;

import com.eagleairug.onlinepayment.views.main.DHomeUIDesign;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.UI;

public class DHomeUIController  extends DHomeUIDesign implements UIController {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DHomeUIDesign guid;

	DHomeUIController(){
		 init(null);
	}
	
	@Override 
	public void init(DHomeUIDesign guid){
		UI.getCurrent().setContent(this);
		this.guid = this;
		attachCommandListener(null);
		
	}
	@Override
	public void initDefaultUI(DHomeUIDesign guid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initFooter(Component comp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attachCommandListener(VaadinRequest request) {
		
		this.btnGetStarted.addClickListener(new ClickListener(){

			/**
			 * 
			 */
			private static final long serialVersionUID = -2145343495982704951L;

			@Override
			public void buttonClick(ClickEvent event) {
				
				new DPaymentUIController(guid);
				
			}
			
		});
		
	}

	@Override
	public DHomeUIDesign getGeneralUIDesign() {
		return guid;
	}

	@Override
	public void setGeneralUIDesign(DHomeUIDesign guid) {
		
	}

}
