package com.eagleairug.onlinepayment.controllers.thirdparty.mtn;

import com.eagleairug.onlinepayment.thirdparty.MTNSoapClient;

public class MTNMobileMoney {
	public static void main(String arg[]){
		MTNSoapClient mtnSoapClient = new MTNSoapClient();
		System.out.println(mtnSoapClient.hello("Pounds"));
	}
}
