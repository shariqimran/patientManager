package src;

public class Patient implements Comparable<Patient> {
	
	private String name;
	private int order;
	private int emergency; 

	
	public Patient(int order, String name, int priority) {
		this.order = order;
		this.name = name;
		this.emergency = priority;
	}

	
	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEmergency() {
		return emergency;
	}

	public void setEmergency(int emergency) {
		this.emergency = emergency;
	}

	public String toString() {
		return name;
	}

	
	public int compareTo(Patient next) {
		
		int result = 0;
		if (emergency < next.emergency) {
			result = 1;
		} else if (emergency > next.emergency) {
			result = -1;
		} else {
			if (order < next.order) {
				result = 1;
			} else if (order > next.order) {
				result = -1;
			}
		}
		return result;
	}
}
