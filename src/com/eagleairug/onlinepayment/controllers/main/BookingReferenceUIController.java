package com.eagleairug.onlinepayment.controllers.main;

import com.eagleairug.onlinepayment.views.main.BookingRefenceUIDesign;
import com.eagleairug.onlinepayment.views.main.DHomeUIDesign;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Component;
import com.vaadin.ui.UI;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class BookingReferenceUIController extends BookingRefenceUIDesign implements UIControllerInterface{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3730661596655826077L;
	
	
	private DHomeUIDesign guid;
	
	public BookingReferenceUIController(DHomeUIDesign guid){
		
		init(guid);
	}


	
	@Override
	public void initDefaultUI(DHomeUIDesign guid) {
		guid.replaceComponent(guid.getComponent(1), this);
	}

	@Override
	public void initFooter(Component comp) {
		
		
	}


	@Override
	public void attachCommandListener(VaadinRequest request) {
		
		
		
		
		
	
		
		this.btnPaymentCancel.addClickListener(new ClickListener(){

			private static final long serialVersionUID = 3032369415094039615L;

			@Override
			public void buttonClick(ClickEvent event) {
				
				new DHomeUIController();
				UI.getCurrent().getPage().setUriFragment("Home", false);
				UI.getCurrent().getPage().setTitle("Online Payment | Home");
				
				
				
				
			}
			
		});
		
		this.btnPaymentProceed.addClickListener(new ClickListener(){

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				new PaymentDetailsUIController(guid);
			}
			
		});
	}

	
	@Override
	public DHomeUIDesign getGeneralUIDesign() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setGeneralUIDesign(DHomeUIDesign guid) {
		// TODO Auto-generated method stub
		
	}


	
}
