package com.crissantos.helpdesk.api.enums;

public enum StatusEnum {
	
	New,
	Assigned,
	Resolved,
	Approveded,
	Disaproved,
	Closed;
	
	public static StatusEnum getStatus(String status) {
		switch (status) {
		case "New":return New;
		case "Resolved":return Resolved;
		case "Approveded":return Approveded;
		case "Disaproved":return Disaproved;
		case "Closed":return New;
		default:return New;			
		}
	}	
}
