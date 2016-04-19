package com.eagleairug.onlinepayment.models.agent;

import java.math.BigInteger;
import java.rmi.RemoteException;

import com.eagleairug.onlinepayment.models.admin.MBackendClient;
import com.eagleairug.onlinepayment.ws.ds.DSOnlineAirlinePaymentStub.BookFlight;
import com.eagleairug.onlinepayment.ws.ds.DSOnlineAirlinePaymentStub.UpdatedRowCount;
import com.eagleairug.onlinepayment.ws.ds.DSOnlineAirlinePaymentStub.UpdatedRowCountE;
import com.eagleairug.onlinepayment.ws.ds.DataServiceFault;

public class MReservation extends MBackendClient{
	
	public static boolean addNewReservation(BookFlight bookf){
		if(stub == null){
			System.err.println("Stub did not initialize");
			return false;
		}
		
		try {
			UpdatedRowCountE rcE = stub.bookFlight(bookf);
			UpdatedRowCount rc = rcE.getUpdatedRowCount();
			return rc.getValue() == BigInteger.valueOf(1);
		} catch (RemoteException | DataServiceFault | NullPointerException e) {
			
			e.printStackTrace();
		}
		return false;
	}
}
