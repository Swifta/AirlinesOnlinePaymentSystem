package com.eagleairug.onlinepayment.controllers.main;

import com.eagleairug.onlinepayment.views.main.DGeneralUIDesign;
import com.eagleairug.onlinepayment.views.main.PaymentDetailsUIDesign;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.UI;

public class PaymentDetailsUIController extends PaymentDetailsUIDesign implements UIControllerInterface{

	/**
	 * 
	 */
	
	private DGeneralUIDesign guid;
	private static final long serialVersionUID = 5890415980636611688L;

	PaymentDetailsUIController(DGeneralUIDesign guid){
		init(guid);
	}
	
	
	@Override
	public void initDefaultUI(DGeneralUIDesign guid) {
		guid.replaceComponent(guid.getComponent(1), this);
		
	}

	@Override
	public void initFooter(Component comp) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void attachCommandListener(VaadinRequest request) {
		
		this.btnPayInitiate.addClickListener(new ClickListener(){

			
			private static final long serialVersionUID = 168478388995956862L;

			@Override
			public void buttonClick(ClickEvent event) {
				
				new PayInitUIController(guid);
				
			}
			
		});
		
		this.btnDetailsCancel.addClickListener(new ClickListener(){

			
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				
				new MainUIController(guid);
				UI.getCurrent().getPage().setUriFragment("Home", false);
				UI.getCurrent().getPage().setTitle("Online Payment | Home");
			}
			
		});
		
		this.btnDetailsBack.addClickListener(new ClickListener(){

			
			private static final long serialVersionUID = 168478388995956862L;

			@Override
			public void buttonClick(ClickEvent event) {
				
				new BookingReferenceUIController(guid);
				
			}
			
		});
		
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
