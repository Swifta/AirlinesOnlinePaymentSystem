package com.eagleairug.onlinepayment.controllers.main;

import com.eagleairug.onlinepayment.views.main.DGeneralUIDesign;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Component;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public interface UIControllerInterface {
	
	void initDefaultUI(DGeneralUIDesign guid);
	void initFooter(Component comp);
	void attachCommandListener(VaadinRequest request);
	DGeneralUIDesign getGeneralUIDesign();
	void setGeneralUIDesign(DGeneralUIDesign guid);
	
	default void init(DGeneralUIDesign guid) {
		setGeneralUIDesign(guid);
		initDefaultUI(guid);
		attachCommandListener(null);
		
	}
	
	default void swap(DGeneralUIDesign guid, Component cuid){
		Component c =  guid.getComponent(1);
		Panel p = (Panel)c;
		VerticalLayout v = (VerticalLayout) p.getContent();
		v = (VerticalLayout) v.getComponent(0);
		v.replaceComponent(v.getComponent(0), cuid);
		
	}
	
	
	
}
