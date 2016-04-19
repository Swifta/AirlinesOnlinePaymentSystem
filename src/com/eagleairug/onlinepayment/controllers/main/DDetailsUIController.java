package com.eagleairug.onlinepayment.controllers.main;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;

import com.eagleairug.onlinepayment.controllers.thirdparty.MTNMomoClient;
import com.eagleairug.onlinepayment.views.main.DDetailsUIDesign;
import com.eagleairug.onlinepayment.ws.ds.DSOnlineAirlinePaymentStub.Details;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;

public class DDetailsUIController extends DDetailsUIDesign implements UIController {
	
	private static final long serialVersionUID = -8262218659427298935L;
	private DHomeUIController guid;
	
	DDetailsUIController(DHomeUIController guid, Details details){
		init(guid);
		setDetails(details);
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
				
				new DHomeUIController();
				
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
				
				String narration = "Paying Eagle Air for: "+lbName.getValue()+". Ref:BU20160417AW01 Fair: $600.00. Ex. Rate: 3320/= ";
				String msisdn = fMSISDN.getValue();
				String msisdnNum = "FRI:&lt "+msisdn+" &gt/MSISDN";
				String bf = lbBookingRef.getValue();
				String acctRef = "FRI:&lt "+bf+" &gt/SP";
				String dueAmt = lbCostUGX.getValue();
				
				HashMap<String, String> mapNamVal = new HashMap<String, String>();
				mapNamVal.put("narration", narration);
				mapNamVal.put("msisdn", msisdnNum);
				mapNamVal.put("acctRef", acctRef);
				mapNamVal.put("dueAmt", dueAmt);
				
				MTNMomoClient momo = new MTNMomoClient();
				
				if(!momo.sendRequestPaymentRequest(mapNamVal)){
					lbErrorMsg.setValue("Error occured. Please try again later.");
					return;
				}
					
				
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
	public DHomeUIController getGeneralUIDesign() {
		
		return this.guid;
	}

	@Override
	public void setGeneralUIDesign(DHomeUIController guid) {
		this.guid = guid;
		
	}
	
	private void setDetails(Details details){
		NumberFormat fm = NumberFormat.getCurrencyInstance(Locale.US);
		
		DecimalFormat dfm = (DecimalFormat) fm;
		DecimalFormatSymbols dfms = dfm.getDecimalFormatSymbols();
		dfms.setCurrencySymbol("USD ");
		dfm.setDecimalFormatSymbols(dfms);
		
		this.lbName.setValue(details.getClient_name());
		this.lbBookingRef.setValue(details.getBooking_ref());
		this.lbCostUSD.setValue(dfm.format(BigDecimal.valueOf(Double.valueOf(details.getCost()))));
		
		
		dfms = dfm.getDecimalFormatSymbols();
		dfms.setCurrencySymbol("UGX ");
		dfm.setDecimalFormatSymbols(dfms);
		
		this.lbRate.setValue(dfm.format(BigDecimal.valueOf(Double.valueOf(details.getRate()))));
		this.lbCostUGX.setValue(dfm.format(BigDecimal.valueOf(Double.parseDouble(details.getCost())*Double.parseDouble(details.getRate()))));
		UI.getCurrent().getSession().setAttribute("rate_id", details.getRate_id());
	
	}
}
