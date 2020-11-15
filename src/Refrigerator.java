
public class Refrigerator extends Containers {
	
	private double power;

	public Refrigerator(String code, String destination, double power) {
		super(code, destination);
		this.power = power;
	}

	public double getPower() {
		return power;
	}

	public void setPower(double power) {
		this.power = power;
	}

	public double getCharge() {
		return 2000 * power;
	}

}
