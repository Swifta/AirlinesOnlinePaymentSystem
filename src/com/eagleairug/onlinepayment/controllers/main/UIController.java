package com.eagleairug.onlinepayment.controllers.main;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Component;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public interface UIController {
	
	void initDefaultUI(DHomeUIController guid);
	void initFooter(Component comp);
	void attachCommandListener(VaadinRequest request);
	DHomeUIController getGeneralUIDesign();
	void setGeneralUIDesign(DHomeUIController guid);
	
	default void init(DHomeUIController guid) {
		setGeneralUIDesign(guid);
		initDefaultUI(guid);
		attachCommandListener(null);
		
	}
	
	default void swap(DHomeUIController guid, Component cuid){
		Component c =  guid.getComponent(1);
		Panel p = (Panel)c;
		VerticalLayout v = (VerticalLayout) p.getContent();
		v = (VerticalLayout) v.getComponent(0);
		v.replaceComponent(v.getComponent(0), cuid);
		
	}
	
	
	
}
