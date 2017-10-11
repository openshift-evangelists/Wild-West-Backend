package com.openshift.kwww.models;

public class PlatformObject {

	private String objectID;
	private String objectName;
	
	public String getObjectID() {
		return objectID;
	}
	public void setObjectID(String objectID) {
		this.objectID = objectID;
	}
	public String getObjectType() {
		return objectName;
	}
	public void setObjectType(String objectType) {
		this.objectName = objectType;
	}
}
