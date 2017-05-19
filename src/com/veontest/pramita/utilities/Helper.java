package com.veontest.pramita.utilities;

import java.io.IOException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class Helper {
	public static void StartAppiumServer(
			String serverAddress,
			String serverPort,
			String boostrapPort, 
			String phoneUUID, 
			String appiumLogPath) {

		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec("cmd.exe /c start cmd.exe /k \"appium -a "
									+ serverAddress 
									+" -p "+ serverPort  
								    +" -bp "+ boostrapPort
								    +" -U "+ phoneUUID
								    +" --log "+ appiumLogPath
								    +" --session-override \"");
			Thread.sleep(10000);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void StopAppiumServer() {
		KillProcess("node.exe");
		KillProcess("cmd.exe");
	}
	
	public static void GetPhoneLog(String appLogPath,
									String packageName) {

		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec("cmd.exe /c start cmd.exe /k \"adb logcat -d > " + appLogPath+"\"");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void KillProcess(String processName) {
		try{
			Runtime.getRuntime().exec("TASKKILL /F /IM "+ processName);
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}
    }

	public static String getTime(){
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		return date.format(formatter);
	}
}
