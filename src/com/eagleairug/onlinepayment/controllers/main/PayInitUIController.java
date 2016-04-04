package com.eagleairug.onlinepayment.controllers.main;

import com.eagleairug.onlinepayment.views.main.DGeneralUIDesign;
import com.eagleairug.onlinepayment.views.main.PayInitUIDesign;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Component;
import com.vaadin.ui.ProgressBar;
import com.vaadin.ui.UI;

public class PayInitUIController extends PayInitUIDesign implements UIControllerInterface{

	/**
	 * 
	 */
	
	private DGeneralUIDesign guid;
	private static final long serialVersionUID = 5890415980636611688L;

	PayInitUIController(DGeneralUIDesign guid){
		init(guid);
	}
	
	
	@Override
	public void initDefaultUI(DGeneralUIDesign guid) {
		guid.replaceComponent(guid.getComponent(1), this);
		animateProgressBar();
	}

	@Override
	public void initFooter(Component comp) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void attachCommandListener(VaadinRequest request) {
		
		
		
	}

	

	@Override
	public DGeneralUIDesign getGeneralUIDesign() {
		return this.guid;
	}

	@Override
	public void setGeneralUIDesign(DGeneralUIDesign guid) {
		this.guid = guid;
	}
	
	
	private void animateProgressBar(){
		
		this.barPayProccessState.setValue(0.1F);
		this.barPayProccessState.setVisible(true);
		this.btnPayProccessingClose.setVisible(true);
		
		UI.getCurrent().setPollInterval(250);
		ProgressTimer barThread = new ProgressTimer(this.barPayProccessState);
		barThread.start();
		
		
		
	}
	
	@SuppressWarnings("unused")
	private void changeProgressBarState(){
		System.out.println("-------------- Progress bar running-----");
		for(Float val = 0F; val < 1;){
			
			val = this.barPayProccessState.getValue()+0.000001F;
			this.barPayProccessState.setValue(val);
		}
		
		System.out.println("-------------- Progress bar stopped-----");
		
	}
	
	private class ProgressTimer extends Thread{
		private ProgressBar bar;
		private volatile double val;
		ProgressTimer(ProgressBar bar){
			bar.setValue(0F);
			bar.setVisible(true);
			this.bar = bar;
		}
			
		@Override
		public void run(){
			val = 0.0D;
			while(val < 1F){
			try {	
				sleep(50);	
				} catch (InterruptedException e) {
					System.out.println("-------------------------Interrupted...............");
				}
			
			UI.getCurrent().access(new Runnable(){
				@Override
				public void run() {
						val = bar.getValue()+0.00001;
						bar.setValue(new Float(val));
						
					}
					
				});
					
					
			}
			
			UI.getCurrent().setPollInterval(-1);
		
			
			
		}
		
		
	}
	
	
	
	


	

}
