package com.eagleairug.onlinepayment.models.main;

import java.rmi.RemoteException;

import com.eagleairug.onlinepayment.ws.ds.DSOnlineAirlinePaymentStub;
import com.eagleairug.onlinepayment.ws.ds.DSOnlineAirlinePaymentStub.Client;
import com.eagleairug.onlinepayment.ws.ds.DSOnlineAirlinePaymentStub.ClientE;
import com.eagleairug.onlinepayment.ws.ds.DSOnlineAirlinePaymentStub.Details;
import com.eagleairug.onlinepayment.ws.ds.DSOnlineAirlinePaymentStub.Validate_booking_ref;
import com.eagleairug.onlinepayment.ws.ds.DataServiceFault;

public class MBookingRef extends MBackendClient{
	public static Details validateBookingRef(String bf){
		if(stub == null){
			System.err.println("DS not initialized.");
			return null;
		}
		
		Validate_booking_ref vbf = new DSOnlineAirlinePaymentStub.Validate_booking_ref();
		vbf.setBooking_ref(bf);
		try {
			ClientE clientE = stub.validate_booking_ref(vbf);
			Client client = clientE.getClient();
			Details[] details = client.getDetails();
			return details[0];
	
		} catch (RemoteException | DataServiceFault | NullPointerException e) {
			e.printStackTrace();
		}
		
		return null;
		
		
	}
}
