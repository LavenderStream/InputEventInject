package com.example.homedemo;

import com.example.homedemo.Events.InputDevice;

import android.graphics.Point;
import android.util.Log;

public class InputManager {

	static String LT = "InputManager";
	private static Events events = new Events();
	private static int m_nId = -1;
	public static boolean hasFind = false;
	public static String trendPath = "event7";
	public static InputDevice mdev;
	
	public static void init(){
		hasFind = false;
		Events.intEnableDebug(1);
		int res = events.Init();
		// debug results
		Log.i(LT, "Event files:" + res);
		for (InputDevice idev : events.m_Devs) {
			if(idev.getPath().contains(trendPath)){
				if(idev.Open(true)){
					mdev = idev;
					hasFind = true;
					m_nId = idev.getId();
				}
			}
		}
		if(!hasFind)
			Log.i(LT, "can't find event");
	}
	
	public static boolean tap(Point p){
		if(!hasFind)
			return false;
		Events.intSendEvent(m_nId,3,0x002f,0x00000001);//slot 1 (finger 1)
		Events.intSendEvent(m_nId,3,0x0039,0x00000148);
		Events.intSendEvent(m_nId,3,0x0035,p.x);
		Events.intSendEvent(m_nId,3,0x0036,p.y);
		Events.intSendEvent(m_nId,3,0x0030,0x0000000c);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0039,0xffffffff);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		return true;
	}
	public static void touchBegin(){
		if(!hasFind)
			return;
		Events.intSendEvent(m_nId,3,0x0039,0x0000015f);
//		Events.intSendEvent(m_nId,3,0x0030,0x00000005);
	}
	
	public static void touchOver(){
		if(!hasFind)
			return;
		Events.intSendEvent(m_nId,3,0x0039,0xffffffff);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
	}
	
	public static void touch(Point p){
		if(!hasFind)
			return;
		Events.intSendEvent(m_nId,3,0x0035,p.x);
		Events.intSendEvent(m_nId,3,0x0036,p.y);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		
	}
	
	public static void sendSlideUp(){
		if(!hasFind)
			return;
		Events.intSendEvent(m_nId,3,0x0039,0x0000166c);
		Events.intSendEvent(m_nId,3,0x0030,0x00000006);
		Events.intSendEvent(m_nId,3,0x0035,0x000001db);
		Events.intSendEvent(m_nId,3,0x0036,0x00000051);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x000001be);
		Events.intSendEvent(m_nId,3,0x0036,0x0000004f);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x00000187);
		Events.intSendEvent(m_nId,3,0x0036,0x00000052);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x0000014d);
		Events.intSendEvent(m_nId,3,0x0036,0x00000062);
		// ½áÊø·û
		/*Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0039,0xffffffff);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);*/
	}
	
	public static void slideM(){
		Events.intSendEvent(m_nId,3,0x0039,0x00001ae4);
		Events.intSendEvent(m_nId,3,0x0030,0x00000004);
		Events.intSendEvent(m_nId,3,0x0035,0x000001dd);
		Events.intSendEvent(m_nId,3,0x0036,0x00000192);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x000001da);
		Events.intSendEvent(m_nId,3,0x0036,0x00000193);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x000001ad);
		Events.intSendEvent(m_nId,3,0x0036,0x00000199);
		/*Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0039,0xffffffff);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);*/
	}
	
	public static void slideDown(){
		Events.intSendEvent(m_nId,3,0x0039,0x0000212f);
		Events.intSendEvent(m_nId,3,0x0030,0x00000005);
		Events.intSendEvent(m_nId,3,0x0035,0x000000b2);
		Events.intSendEvent(m_nId,3,0x0036,0x0000018e);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0030,0x00000007);
		Events.intSendEvent(m_nId,3,0x0035,0x000000d1);
		Events.intSendEvent(m_nId,3,0x0036,0x00000190);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x000000ec);
		Events.intSendEvent(m_nId,3,0x0036,0x00000193);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0030,0x00000008);
		Events.intSendEvent(m_nId,3,0x0035,0x0000010e);
		Events.intSendEvent(m_nId,3,0x0036,0x00000196);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x00000137);
		Events.intSendEvent(m_nId,3,0x0036,0x00000198);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x00000161);
		Events.intSendEvent(m_nId,3,0x0036,0x0000019b);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x00000181);
		Events.intSendEvent(m_nId,3,0x0036,0x0000019e);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x0000019a);
		Events.intSendEvent(m_nId,3,0x0036,0x000001a0);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x000001b2);
		Events.intSendEvent(m_nId,3,0x0036,0x000001a2);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x000001bb);
		Events.intSendEvent(m_nId,3,0x0036,0x000001a3);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x000001c4);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x000001c8);
		Events.intSendEvent(m_nId,3,0x0036,0x000001a4);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x000001cb);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x000001cd);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x000001ce);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x000001d0);
		Events.intSendEvent(m_nId,3,0x0036,0x000001a3);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x000001d1);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x000001d2);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x000001d4);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x000001d5);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0039,0xffffffff);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
	}
	
	public static void slideUp(){
		Events.intSendEvent(m_nId,3,0x0039,0x0000217f);
		Events.intSendEvent(m_nId,3,0x0030,0x00000008);
		Events.intSendEvent(m_nId,3,0x0035,0x000000e9);
		Events.intSendEvent(m_nId,3,0x0036,0x0000018e);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x000000db);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x000000c7);
		Events.intSendEvent(m_nId,3,0x0036,0x0000018c);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x000000b6);
		Events.intSendEvent(m_nId,3,0x0036,0x00000189);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x0000009c);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x00000084);
		Events.intSendEvent(m_nId,3,0x0036,0x00000188);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x0000006b);
		Events.intSendEvent(m_nId,3,0x0036,0x00000186);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x0000004d);
		Events.intSendEvent(m_nId,3,0x0036,0x00000185);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x00000033);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x00000015);
		Events.intSendEvent(m_nId,3,0x0036,0x00000183);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x00000012);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x0000000f);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x0000000e);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x0000000c);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x0000000b);
		Events.intSendEvent(m_nId,3,0x0036,0x00000184);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x00000009);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x00000008);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x00000006);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0039,0xffffffff);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
	}
	
	public static void slideLeft(){
		Events.intSendEvent(m_nId,3,0x0039,0x00002223);
		Events.intSendEvent(m_nId,3,0x0030,0x0000000c);
		Events.intSendEvent(m_nId,3,0x0035,0x000000ce);
		Events.intSendEvent(m_nId,3,0x0036,0x0000017e);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x000000cb);
		Events.intSendEvent(m_nId,3,0x0036,0x00000196);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x000000ca);
		Events.intSendEvent(m_nId,3,0x0036,0x000001a3);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0036,0x000001bf);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x000000cd);
		Events.intSendEvent(m_nId,3,0x0036,0x000001df);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x000000d1);
		Events.intSendEvent(m_nId,3,0x0036,0x00000201);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x000000d4);
		Events.intSendEvent(m_nId,3,0x0036,0x00000227);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x000000d7);
		Events.intSendEvent(m_nId,3,0x0036,0x0000024d);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x000000db);
		Events.intSendEvent(m_nId,3,0x0036,0x00000275);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x000000de);
		Events.intSendEvent(m_nId,3,0x0036,0x000002a0);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x000000df);
		Events.intSendEvent(m_nId,3,0x0036,0x000002c8);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x000000e0);
		Events.intSendEvent(m_nId,3,0x0036,0x000002ef);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0030,0x0000000b);
		Events.intSendEvent(m_nId,3,0x0035,0x000000e2);
		Events.intSendEvent(m_nId,3,0x0036,0x0000030c);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0030,0x0000000a);
		Events.intSendEvent(m_nId,3,0x0035,0x000000e1);
		Events.intSendEvent(m_nId,3,0x0036,0x00000311);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0039,0xffffffff);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
	}
	
	public static void slideRight(){
		Events.intSendEvent(m_nId,3,0x0039,0x00002255);
		Events.intSendEvent(m_nId,3,0x0030,0x0000000c);
		Events.intSendEvent(m_nId,3,0x0035,0x000000ca);
		Events.intSendEvent(m_nId,3,0x0036,0x00000196);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x000000c8);
		Events.intSendEvent(m_nId,3,0x0036,0x0000018c);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x000000c6);
		Events.intSendEvent(m_nId,3,0x0036,0x00000182);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x000000c5);
		Events.intSendEvent(m_nId,3,0x0036,0x00000175);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x000000c4);
		Events.intSendEvent(m_nId,3,0x0036,0x00000160);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x000000c3);
		Events.intSendEvent(m_nId,3,0x0036,0x0000014d);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x000000c5);
		Events.intSendEvent(m_nId,3,0x0036,0x00000130);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x000000c7);
		Events.intSendEvent(m_nId,3,0x0036,0x0000010f);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x000000c9);
		Events.intSendEvent(m_nId,3,0x0036,0x000000f0);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x000000ca);
		Events.intSendEvent(m_nId,3,0x0036,0x000000d0);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x000000cb);
		Events.intSendEvent(m_nId,3,0x0036,0x000000ac);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0035,0x000000cd);
		Events.intSendEvent(m_nId,3,0x0036,0x0000008a);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0036,0x00000065);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0036,0x00000043);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0030,0x0000000b);
		Events.intSendEvent(m_nId,3,0x0035,0x000000ca);
		Events.intSendEvent(m_nId,3,0x0036,0x00000016);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0030,0x0000000a);
		Events.intSendEvent(m_nId,3,0x0035,0x000000c7);
		Events.intSendEvent(m_nId,3,0x0036,0x0000000e);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
		Events.intSendEvent(m_nId,3,0x0039,0xffffffff);
		Events.intSendEvent(m_nId,0,0x0000,0x00000000);
	}
	
	
	
}
