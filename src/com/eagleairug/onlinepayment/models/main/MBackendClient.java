package com.eagleairug.onlinepayment.models.main;

import com.eagleairug.onlinepayment.ws.ds.DSOnlineAirlinePaymentStub;

public class MBackendClient implements MBackendClientInitializable {
	protected static DSOnlineAirlinePaymentStub stub;
	static {
		setDS();
	}
	private static void setDS(){
		stub = DSStubInitializer.getDSStub();
	}
	
}
