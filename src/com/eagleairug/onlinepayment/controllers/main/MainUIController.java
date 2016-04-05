package com.eagleairug.onlinepayment.controllers.main;

import java.io.Serializable;

import com.eagleairug.onlinepayment.views.main.DHomeUIDesign;
import com.eagleairug.onlinepayment.views.main.HomeUIDesign;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.UI;

public class MainUIController extends HomeUIDesign implements UIControllerInterface, Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 7589904000143836097L;
	private DHomeUIDesign guid;
	
	
	public MainUIController(DHomeUIDesign guid){
		init(guid);
		
	}
	
	
	
	
	@Override
	public void initDefaultUI(DHomeUIDesign guid){
		swap(guid, this);
	}
	
	
	
	@Override
	public void initFooter(Component comp){
		
		/*
		 * Set footer
		 * @Live
		 * */
		
		/*MainUIController home = this;
		int cYear = Calendar.getInstance().get(Calendar.YEAR);
		home.footerPlatformBoss.setValue("Eagle Air Uganda");
		if(cYear > 2017){
			home.footerCurretYr.setValue(cYear+"");
		}else {
			home.footerCurretYr.setVisible(false);
			home.footerYearSeparator.setVisible(false);
		}*/
		
	}

	

	@Override
	public void attachCommandListener(VaadinRequest request) {
		
		
		MainUIController home = this;
		Button btnPayment = home.btnPayment;
		
		System.out.println("------Payment Button initialized-------");
		
		btnPayment.addClickListener(new ClickListener(){

			private static final long serialVersionUID = 3032369415094039615L;

			@Override
			public void buttonClick(ClickEvent event) {
				
				/*
				 *  Following functions MUST be called the the order specified below.
				 *  1- setUIComponents();
				 *  2- setUIButtons();
				 *  3- attachCommandListener();
				 *  
				 *  to avoid NullPointerExceptions
				 *  
				 * @Live
				 */
				

				
				//
				
				
				
				//				controller.setMainUI(mui);
				//				controller.setUIComponents(home.contentHome, home.cBookingRef, home.cPaymentDetails);
				//				controller.setUIButtons(btns);
				//				controller.attachCommandListener(request);
				
				
				
				new BookingReferenceUIController(guid);
				
				UI.getCurrent().getPage().setUriFragment("Payment", false);
				UI.getCurrent().getPage().setTitle("Online Payment | Booking Reference");
			
				
				
			}
			
		});
		
		
	}



	@Override
	public DHomeUIDesign getGeneralUIDesign() {
		return this.guid;
	}


	@Override
	public void setGeneralUIDesign(DHomeUIDesign guid) {
		this.guid = guid;
		
	}




	


	


	

	

	
}
