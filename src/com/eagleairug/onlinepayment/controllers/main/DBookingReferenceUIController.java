package com.eagleairug.onlinepayment.controllers.main;

import com.eagleairug.onlinepayment.models.main.MBookingRef;
import com.eagleairug.onlinepayment.views.main.DBookingReferenceUIDesign;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;

public class DBookingReferenceUIController extends DBookingReferenceUIDesign implements UIController {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = -3610153824639476015L;
	private DHomeUIController guid;

	DBookingReferenceUIController(DHomeUIController guid){
		init(guid);
	}
	
	@Override
	public void initDefaultUI(DHomeUIController guid) {
		swap(guid, this);
		
	}

	@Override
	public void initFooter(Component comp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attachCommandListener(VaadinRequest request) {
		attachCancel();
		attachNext();
		
	}
	
	private void attachCancel(){
		this.btnCancel.addClickListener(new ClickListener(){

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
	
	private void attachNext(){
		this.btnNext.addClickListener(new ClickListener(){

			
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				String bookingRef = fBookingRef.getValue();
				/*TODO
				 * Extra client side validation of the booking reference required.
				 */
				if(bookingRef == null)
					return;
				
				bookingRef = bookingRef.trim();
				if(bookingRef.isEmpty())
					return;
				
				if(MBookingRef.validateBookingRef(bookingRef) == null){
					System.err.println("Invalid booking ref. No data returned.");
					return;
				}
				
				new DDetailsUIController(guid, MBookingRef.validateBookingRef(bookingRef));
				System.out.println("Ref's next is fine.");
				
			}
			
		});
	}
	
	
	
	
	

	@Override
	public DHomeUIController getGeneralUIDesign() {
		
		return this.guid;
	}

	@Override
	public void setGeneralUIDesign(DHomeUIController guid) {
		
		this.guid = guid;
		
	}

}
