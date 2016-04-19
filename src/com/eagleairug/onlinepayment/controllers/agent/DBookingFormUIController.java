package com.eagleairug.onlinepayment.controllers.agent;

import com.eagleairug.onlinepayment.controllers.admin.DDashboardUIController;
import com.eagleairug.onlinepayment.controllers.admin.DManagementUIController;
import com.eagleairug.onlinepayment.controllers.admin.UIController;
import com.eagleairug.onlinepayment.models.agent.MReservation;
import com.eagleairug.onlinepayment.views.agent.DBookingFormUIDesign;
import com.eagleairug.onlinepayment.ws.ds.DSOnlineAirlinePaymentStub;
import com.eagleairug.onlinepayment.ws.ds.DSOnlineAirlinePaymentStub.BookFlight;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;

public class DBookingFormUIController extends DBookingFormUIDesign implements UIController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7499676505056564604L;
	
	private DManagementUIController guid;
	public DBookingFormUIController(DManagementUIController guid){
		init(guid);
	}

	@Override
	public void initDefaultUI(DManagementUIController guid) {
		swap(guid, this);
	}

	@Override
	public void initFooter(Component comp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attachCommandListener(VaadinRequest request) {
		attachCancel();
		attachSave();
		
	}
	
	private void attachCancel(){
		this.btnCancel.addClickListener(new ClickListener(){
			private static final long serialVersionUID = 3061729744640691786L;

			@Override
			public void buttonClick(ClickEvent event) {
				
				new DDashboardUIController(guid);
				
			}
			
		});
	}
	
	private void attachSave(){
		
		this.btnAdd.addClickListener(new ClickListener(){
			
			private static final long serialVersionUID = 1161782940713725548L;

			@Override
			public void buttonClick(ClickEvent event) {
				/*TODO
				 * Extra validation
				 * @Live
				 * 
				 */
				
				BookFlight bookf = new DSOnlineAirlinePaymentStub.BookFlight();
				bookf.setClient_name(fName.getValue());
				bookf.setBooking_ref(fBookingRef.getValue());
				bookf.setCost(Double.valueOf(fCost.getValue()));
				bookf.setDate_added(fDate.getValue().toString());
				bookf.setUser_id(3);
				bookf.setStatus((byte) 0);
				
				if(!MReservation.addNewReservation(bookf))
					return;
				
				new DDashboardUIController(guid);
				
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
