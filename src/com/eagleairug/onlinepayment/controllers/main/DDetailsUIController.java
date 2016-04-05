package com.eagleairug.onlinepayment.controllers.main;

import com.eagleairug.onlinepayment.views.main.DDetailsUIDesign;
import com.eagleairug.onlinepayment.views.main.DHomeUIDesign;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;

public class DDetailsUIController extends DDetailsUIDesign implements UIControllerInterface {
	
	private static final long serialVersionUID = -8262218659427298935L;
	private DHomeUIDesign guid;
	
	DDetailsUIController(DHomeUIDesign guid){
		init(guid);
	}

	@Override
	public void initDefaultUI(DHomeUIDesign guid) {
		
		swap(guid, this);
		
	}

	@Override
	public void initFooter(Component comp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attachCommandListener(VaadinRequest request) {
		attachCancel();
		attachBack();
		attachNext();
	}
	
	private void attachCancel(){
		this.btnCancel.addClickListener(new ClickListener(){

			/**
			 * 
			 */
			private static final long serialVersionUID = 8256254316884293815L;

			@Override
			public void buttonClick(ClickEvent event) {
				
				new DPaymentUIController(guid);
				
			}
			
		});
	}
	
	private void attachBack(){
		
		this.btnBack.addClickListener(new ClickListener(){

			/**
			 * 
			 */
			private static final long serialVersionUID = 8256254316884293815L;

			@Override
			public void buttonClick(ClickEvent event) {
				
				new DBookingReferenceUIController(guid);
				
			}
			
		});
		
	}
	
	private void attachNext(){
		this.btnNext.addClickListener(new ClickListener(){

			/**
			 * 
			 */
			private static final long serialVersionUID = 8256254316884293815L;

			@Override
			public void buttonClick(ClickEvent event) {
				
				Window processingPopup = new Window("Processing...");
				processingPopup.setContent(new DPaymentStateUIController(guid));
				processingPopup.center();
				processingPopup.setClosable(false);
				processingPopup.setEnabled(false);
				processingPopup.setModal(true);
				processingPopup.setDraggable(false);
				processingPopup.setResizable(false);
				processingPopup.setSizeUndefined();
				UI.getCurrent().addWindow(processingPopup);
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
