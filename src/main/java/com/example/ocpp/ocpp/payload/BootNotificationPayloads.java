package com.example.ocpp.ocpp.payload;

public class BootNotificationPayloads {
    public static class Req { public String chargePointVendor; public String chargePointModel; public String firmwareVersion; }
    public static class Res { public String status; public String currentTime; public int interval; public Res(String s,String t,int i){status=s;currentTime=t;interval=i;} }
}
