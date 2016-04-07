package com.eagleairug.onlinepayment.controllers.admin;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public interface UIController {
	
	void initDefaultUI(DManagementUIController guid);
	void initFooter(Component comp);
	void attachCommandListener(VaadinRequest request);
	DManagementUIController getGeneralUIDesign();
	void setGeneralUIDesign(DManagementUIController guid);
	
	default void init(DManagementUIController guid) {
		setGeneralUIDesign(guid);
		initDefaultUI(guid);
		attachCommandListener(null);
		
	}
	
	default void swap(DManagementUIController guid, Component cuid){
		if(guid == null){
			System.out.println("Null.... returned.");
			return;
		}
		Component c =  guid.getComponent(1);
		VerticalLayout v1 = (VerticalLayout)c;
		HorizontalLayout h1 = (HorizontalLayout) v1.getComponent(0);
		v1 = (VerticalLayout)h1.getComponent(1);
		Panel p1 = (Panel)v1.getComponent(0);
		v1 = (VerticalLayout)p1.getContent();
		v1.replaceComponent(v1.getComponent(0), cuid);
		
	}
	
	
	
}
