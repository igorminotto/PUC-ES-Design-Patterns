package br.puc.se.designPatterns.structural.nativelibrary.drivers;

public class ScannerConfig {

	private String system;
	
	private String vendor;
	
	private boolean started;
	
	private boolean configured;

	public ScannerConfig(String system, String vendor, boolean started, boolean configured) {
		this.system = system;
		this.vendor = vendor;
		this.started = started;
		this.configured = configured;
	}

	public String getSystem() {
		return system;
	}

	public String getVendor() {
		return vendor;
	}

	public boolean isStarted() {
		return started;
	}

	public boolean isConfigured() {
		return configured;
	}
	
	public void start() {
		this.started = true;
	}
	
	public void configure() {
		this.configured = true;
	}
	
}
