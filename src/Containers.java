
public abstract class Containers {
	
	private String code;
	private String destination;
	
	public Containers(String code, String destination) {
		this.code = code;
		this.destination = destination;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public abstract double getCharge();
	

}
