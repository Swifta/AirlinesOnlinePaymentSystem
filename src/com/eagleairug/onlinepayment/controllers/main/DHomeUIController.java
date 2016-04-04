package com.eagleairug.onlinepayment.controllers.main;

import com.eagleairug.onlinepayment.views.main.DGeneralUIDesign;
import com.eagleairug.onlinepayment.views.main.DHomeUIDesign;
import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;

public class DHomeUIController extends DHomeUIDesign implements UIControllerInterface {

	
	private static final long serialVersionUID = 7589904000143836097L;
	private DGeneralUIDesign guid;
	
	
	public DHomeUIController(DGeneralUIDesign guid){
		init(guid);
		
	}
	
	
	
	
	@Override
	public void initDefaultUI(DGeneralUIDesign guid){
		swap(guid, this);
	}
	
	
	
	@Override
	public void initFooter(Component comp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attachCommandListener(VaadinRequest request) {
		attachMTN();
		
	}
	
	private void attachMTN(){
		HorizontalLayout listItem = this.listItemMTN;
		
		listItem.addLayoutClickListener(new LayoutClickListener(){

			/**
			 * 
			 */
			private static final long serialVersionUID = 4856081838626048379L;

			@Override
			public void layoutClick(LayoutClickEvent event) {
				new DBookingReferenceUIController(guid);
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
