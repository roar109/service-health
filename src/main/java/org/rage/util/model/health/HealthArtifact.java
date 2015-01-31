package org.rage.util.model.health;

/**
 * @author <roar109@gmail.com> Hector Mendoza
 * 
 */
public class HealthArtifact {
	private String server;
	private int port;
	private boolean status;
	private transient String completePath;
	private Project project;

	public HealthArtifact(String server, int port){
		this.server = server;
		this.port = port;
	}
	
	
	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getCompletePath() {
		return completePath;
	}

	public void setCompletePath(String completePath) {
		this.completePath = completePath;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}
