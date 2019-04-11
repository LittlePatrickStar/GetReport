package com.cyy.report;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class getDeviceInfomation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getDeviceInfomation a=new getDeviceInfomation();
		System.out.print(a.getSN());
		System.out.print(a.getSDKVersion());
	}
	
	public String getSN() {
		StringBuilder sb=null;
		try {
			Process p=Runtime.getRuntime().exec(new String[] {"adb","devices"});
			BufferedReader in=new BufferedReader(new InputStreamReader(p.getInputStream()));
			sb = new StringBuilder();
			String result=null;
			while((result=in.readLine()) != null) {
				if(!result.contains("List")) {
					sb.append(result.replace("device", "").replaceAll("\\t", "")+"\n");
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}

	public String getSDKVersion() {
		StringBuilder sb=null;
		try {
			Process p=Runtime.getRuntime().exec(new String[] {"adb","shell","getprop","\"| grep version.sdk\""});
			BufferedReader in=new BufferedReader(new InputStreamReader(p.getInputStream()));
			sb = new StringBuilder();
			String result=null;
			while((result=in.readLine()) != null) {
				sb.append(result.replace("device", "").replaceAll("\\t", "")+"\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}
}
