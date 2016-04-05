package com.eagleairug.onlinepayment.controllers.main;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
@Theme("eagle")
public class EagleAirUGUI extends UI {
	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = EagleAirUGUI.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		
   DHomeUIController guid = new DHomeUIController();
   UI.getCurrent().setContent(guid);
   
		
		
		
		//UI.getCurrent().setContent(new PanelUIDesign());
		//UI.getCurrent().setContent(new BookingFormUIDesign());
		
		//VerticalLayout l = new BookingReportUIDesign();
		//l.addListener(eventType, target, method);
		
		//Button btn = new Button();
		
		
		//UI.getCurrent().setContent(new BookingReportUIDesign());
		
		
		
		
		
	}
	
	


	
}