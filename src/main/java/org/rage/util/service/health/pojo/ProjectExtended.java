package org.rage.util.service.health.pojo;

import java.util.HashMap;

public class ProjectExtended extends Project {
	private HashMap<String, String> attributes = new HashMap<String,String>();
	private String targetVersion;
	private boolean sameVersion;

	public ProjectExtended(String serverName, int portValue, String value) {
		super(serverName, portValue, value);
	}
	
	public ProjectExtended(String serverName, int portValue, String value, String targetVersionValue) {
		super(serverName, portValue, value);
		this.targetVersion = targetVersionValue;
	}

	public ProjectExtended(Project project){
		super(project.getServer(),project.getPort(), project.getProjectContext());
	}
	
	public HashMap<String, String> getAttributes() {
		return attributes;
	}

	public void setAttributes(HashMap<String, String> attributes) {
		this.attributes = attributes;
	}

	public String getTargetVersion() {
		return targetVersion;
	}

	public void setTargetVersion(String targetVersion) {
		this.targetVersion = targetVersion;
	}

	public boolean isSameVersion() {
		return sameVersion;
	}

	public void setSameVersion(boolean sameVersion) {
		this.sameVersion = sameVersion;
	}
	
}
