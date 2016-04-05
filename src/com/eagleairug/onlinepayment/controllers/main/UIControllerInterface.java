package com.eagleairug.onlinepayment.controllers.main;

import com.eagleairug.onlinepayment.views.main.DHomeUIDesign;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Component;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public interface UIControllerInterface {
	
	void initDefaultUI(DHomeUIDesign guid);
	void initFooter(Component comp);
	void attachCommandListener(VaadinRequest request);
	DHomeUIDesign getGeneralUIDesign();
	void setGeneralUIDesign(DHomeUIDesign guid);
	
	default void init(DHomeUIDesign guid) {
		setGeneralUIDesign(guid);
		initDefaultUI(guid);
		attachCommandListener(null);
		
	}
	
	default void swap(DHomeUIDesign guid, Component cuid){
		Component c =  guid.getComponent(1);
		Panel p = (Panel)c;
		VerticalLayout v = (VerticalLayout) p.getContent();
		v = (VerticalLayout) v.getComponent(0);
		v.replaceComponent(v.getComponent(0), cuid);
		
	}
	
	
	
}
