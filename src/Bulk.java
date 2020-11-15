
public class Bulk extends Containers{
	
	private int weight;

	public Bulk(String code, String destination, int weight) {
		super(code, destination);
		this.weight = weight;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public double getCharge() {
		return 10 * weight;
	}
	
}
