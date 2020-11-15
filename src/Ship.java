import java.util.ArrayList;

public class Ship {
	
	private String name;
	private int capacity;
	private ArrayList<Containers> containers = new ArrayList<Containers>();	
	
	
	public Ship(String name, int capacity) {
		this.name = name;
		this.capacity = capacity;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getCapacity() {
		return capacity;
	}


	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public void addContainer(Containers aContainer) {
		if(capacity > containers.size() ) {
			containers.add(aContainer);
		}
		else 
			System.out.println("Sorry the ship is full");
	}
	
	public double getTotalCharge() {
		double totalCharge = 0;
		for(Containers container : containers) {
			totalCharge += container.getCharge();
		}
		return totalCharge;
	}
	
	

}
