package org.rage.util.model.health;

import java.util.HashMap;

/**
 * @author <roar109@gmail.com> Hector Mendoza
 * 
 */
public class Project {
	private String projectContext;
	private HashMap<String, String> attributes = new HashMap<String, String>();
	private String targetVersion;
	private boolean sameVersion;

	public Project(final String projectContext) {
		this.projectContext = projectContext;
	}
	
	public Project(final String projectContext, final String targetVersion) {
		this.projectContext = projectContext;
		this.targetVersion = targetVersion;
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

	public String getProjectContext() {
		return projectContext;
	}

	public void setProjectContext(String projectContext) {
		this.projectContext = projectContext;
	}

}
