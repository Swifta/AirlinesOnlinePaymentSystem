package com.eagleairug.onlinepayment.models.admin;

import org.apache.axis2.AxisFault;
import com.eagleairug.onlinepayment.ws.ds.DSOnlineAirlinePaymentStub;

public class DSStubInitializer {
	private static DSOnlineAirlinePaymentStub stub;
	
	static {
		setDSStub();
	}
	private static void setDSStub(){
		try {
			stub = new DSOnlineAirlinePaymentStub();
		} catch (AxisFault e) {
			e.printStackTrace();
		}
	}
	
	public static DSOnlineAirlinePaymentStub getDSStub(){
		return stub;
	}
	
	
}
