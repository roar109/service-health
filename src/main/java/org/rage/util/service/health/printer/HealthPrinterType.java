package org.rage.util.service.health.printer;

public enum HealthPrinterType {
	VERSION(1),
	PROJECT_HEALTH(2),
	SERVICE_HEALTH(3);
	
	private int value;
	
	HealthPrinterType(int value){
		this.value = value;
	}
	
	public static int getCount(){
		return 3;
	}
	
	public int getValue(){
		return this.value;
	}
}
