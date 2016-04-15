package com.eagleairug.onlinepayment.models.main;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import com.eagleairug.onlinepayment.ws.ds.DSOnlineAirlinePaymentStub;
import com.eagleairug.onlinepayment.ws.ds.DSOnlineAirlinePaymentStub.User;
import com.eagleairug.onlinepayment.ws.ds.DSOnlineAirlinePaymentStub.Users;
import com.eagleairug.onlinepayment.ws.ds.DSOnlineAirlinePaymentStub.UsersE;
import com.eagleairug.onlinepayment.ws.ds.DataServiceFault;

public class MLogin {
	private DSOnlineAirlinePaymentStub stub = null;
	public MLogin(){
		try {
			stub = new DSOnlineAirlinePaymentStub();
		} catch (AxisFault e) {
			e.printStackTrace();
		}
	}
	public boolean login(String username, String pass){
		if(stub == null){
			System.err.println("DS stub has not been initialized.");
			return false;
		}
		DSOnlineAirlinePaymentStub.LoginUser loginUser = new DSOnlineAirlinePaymentStub.LoginUser();
		loginUser.setUsername(username);
		loginUser.setPassword(pass);
		try {
			UsersE usersE = stub.loginUser(loginUser);
			Users users = usersE.getUsers();
			User[] userArr = users.getUser();
			
			if(userArr != null && userArr.length == 1)
				return true;
			else return false;
			
		} catch (RemoteException | DataServiceFault e) {
			
			e.printStackTrace();
			return false;
		}
		
	}
}
