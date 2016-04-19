package com.eagleairug.onlinepayment.controllers.thirdparty;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMXMLBuilderFactory;
import org.apache.axis2.AxisFault;
import org.apache.axis2.Constants;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;

import com.ibm.icu.math.BigDecimal;

public class MTNMomoClient {
	private InputStream in = null;
	private File getRequestPaymentXML(){
		URL urlPaymentRequest = getClass().getResource("mtnRequestPayment.xml");
		return new File(urlPaymentRequest.getPath());
	}
	
	private void closeXMLFile(){
		
		try {
			in.close();
		} catch (IOException | NullPointerException e) {
			
			e.printStackTrace();
		}
			
	}
	
	private OMElement getXMLObject(File f){
		if(f == null)
			return null;
		
		in = null;
		OMElement root = null;
		try {
			in = new FileInputStream(f);
			root = OMXMLBuilderFactory.createOMBuilder(in).getDocumentElement();
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return root;
	}
	
	private OMElement initializeRequestPaymentSoapMessageParameters(HashMap<String, String> mp){
		OMElement root = getXMLObject(getRequestPaymentXML());
		if(root == null)
			return root;
		
		
		OMElement omeProcess = root.getFirstChildWithName(new QName(root.getQName().getNamespaceURI(), "Body")).getFirstElement();
		OMElement omeN;
		OMElement omeV;
		
		
		 Iterator<?> itrOME = omeProcess.getChildElements();
		   while(itrOME.hasNext()){
			   OMElement omeP = (OMElement) itrOME.next();
			   if(!omeP.getQName().equals(new QName("parameter")))
				  continue;
			   
			   
			   omeN = omeP.getFirstChildWithName(new QName("name"));
			   System.err.println(omeN.getText());
			   
			  
			   
			   if(omeN.getText().equals("DueAmount")){
					  omeV = omeP.getFirstChildWithName(new QName("value"));
					  System.err.println(omeV.getText());
					 omeV.setText(mp.get("dueAmt"));
					  System.out.println(omeV.getText());					 
					  continue;
			  }
			   
			   if(omeN.getText().equals("MSISDNNum")){
					  omeV = omeP.getFirstChildWithName(new QName("value"));
					  System.err.println(omeV.getText());
					  omeV.setText(mp.get("msisdnNum"));
					  System.out.println(omeV.getText());					 
					  continue;
			  }
			   
			   if(omeN.getText().equals("AcctRef")){
					  omeV = omeP.getFirstChildWithName(new QName("value"));
					  System.err.println(omeV.getText());
					  omeV.setText(mp.get("acctRef"));
					  System.out.println(omeV.getText());					 
					  continue;
			  }
			  
			   if(omeN.getText().equals("Narration")){
					
					  omeV = omeP.getFirstChildWithName(new QName("value"));
					  System.err.println(omeV.getText());
					  omeV.setText(mp.get("narration"));
					  System.out.println(omeV.getText());
	
					 
				   }
			   
			  
			   
			   
			  
		   }
		   
		   
		
		return root;
		
	}
	
	public boolean sendRequestPaymentRequest(HashMap<String, String> mp){
		if(mp == null)
			return false;
		OMElement ome = initializeRequestPaymentSoapMessageParameters(mp);
		return sendRequest(ome, getMTNRequestPaymentEP());
		
	}
	
	private String getMTNRequestPaymentEP(){
		URL urlPro = this.getClass().getResource("mtnMomo.properties");
		File f = new File(urlPro.getPath());
		try {
			FileInputStream fs = new FileInputStream(f);
			Properties prop = new Properties();
			prop.load(fs);
			
			if(prop.getProperty("mode").equals("1"))
				return prop.getProperty("productionEPR");
			else
				return prop.getProperty("testEPR");
				
			
			
			
		} catch (IOException e) {
		
			e.printStackTrace();
			return null;
		}
		
	}
	
	private boolean sendRequest(OMElement ome, String target){
		EndpointReference targetEPR = new EndpointReference(target);
		//EndpointReference targetEPR = new EndpointReference("http://54.209.44.17:9764/services/hyperswift?wsdl");
		Options opt = new Options();
		
		opt.setTo(targetEPR);
		//opt.setFrom(fromEPR);
		opt.setTransportInProtocol(Constants.TRANSPORT_HTTP);
		
		
		try {
			ServiceClient client = new ServiceClient();
			client.fireAndForget(ome);
			closeXMLFile();
			
		} catch (AxisFault e) {
			
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public static void main(String[] args){
		
		MTNMomoClient momo = new MTNMomoClient();
	   
	    String narration = "Paying Eagle Air for: Amanda Rose. Ref:BU20160417AW01 Fair: $600.00. Ex. Rate: 3320/= ";
		String msisdn = "0778583921";
		String msisdnNum = "FRI:&lt "+msisdn+" &gt/MSISDN";
		String bf = "BU20160417AW01";
		String acctRef = "FRI:&lt "+bf+" &gt/SP";
		
		BigDecimal dueAmt = BigDecimal.valueOf(2002000.00D);
		
		HashMap<String, String> mp = new HashMap<String, String>();
		
		
		mp.put("narration", narration);
		mp.put("msisdnNum", msisdnNum);
		mp.put("acctRef", acctRef);
		mp.put("dueAmt", String.valueOf(dueAmt));
	   
		momo.sendRequestPaymentRequest(mp);
		
	  
	   
	    
		
		
	}
}
