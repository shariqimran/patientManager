package src;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PatientManager {
	
	private PriorityQueue<Patient> waitingList;

	public void start() {
		
		Scanner input = new Scanner(System.in);
		String name;
		String emergency;
		String option;

		int order = 0;
		Patient patient;
		
		
		System.out.println("-------------------------------");
		System.out.println("(1) New Patient.");
		System.out.println("(2) Next Patient.");
		System.out.println("(3) Waiting List.");
		System.out.println("(4) Exit.");
		System.out.println("-------------------------------");
		
		
		while (true) {
			
			System.out.print("Please select an option from the list: ");
			option = input.next();
			
			switch (option) {
			
			case "1":
				
				System.out.print("        Enter patient's name: ");
				name = input.next();
				
				System.out.print("        Enter emergency [1 (low) to 5 (life-and-death)]: ");
				emergency = input.next();

				while (!emergency.equals("1") && !emergency.equals("2") && !emergency.equals("3")
						&& !emergency.equals("4") && !emergency.equals("5")) {
					System.out.print("        (x)Wrong Value. Try again: ");
					emergency = input.nextLine();
				}
				
				order++;
				
				patient = new Patient(order, name, Integer.parseInt(emergency));
				waitingList.add(patient);
				
				System.out.printf("        Patient %s added to the waiting list.%n", name);
				break;
				
				
			case "2":
				
				if (waitingList.isEmpty()) {
					System.out.println("        - No more patients.");
				} else {
					patient = waitingList.remove();
					System.out.println("        " + patient.getName() + " is treated.");
				}
				break;
				
				
			case "3":
				
				if (waitingList.size() == 0) {
					System.out.println("        Waiting list is empty!");
				} else {
					System.out.println("        Waiting list includes:");
					
					Iterator<Patient> iterator = waitingList.iterator();
					while (iterator.hasNext()) {
						patient = (Patient) iterator.next();
						System.out.println("         -" + patient.toString());
					}
				}
				break;
				
				
			case "4":
				
				System.out.println("Program terminated. Good bye!!");
				input.close();
				System.exit(0);
				break;
				
				
			default:
				System.out.println("(x) Wrong choice.");

			}

		}
	}

	public PatientManager() {
		waitingList = new PriorityQueue<Patient>();
	}
}
