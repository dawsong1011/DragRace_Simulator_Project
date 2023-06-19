import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

//********************************************************* 
// Class: CS 225 
// Author: <Dawson Gomez> 
// Created: <3/23/23> 
// Modified: 
// 
// Purpose: Acts as the game controller for the maze game, houses the game elements in one place. 
// 
// Attributes:
//			-V1QuarterTime:double
//			-V2QuarterTime:double
//			-V1QuaterSpeed:double
//			-V2QuaterSpeed:double
// 			-V1EighthTime:double
// 			-V2EighthTime:double
// 			-V1EighthSpeed:double
//			-V2EighthSpeed:double
//			-V1_60Ft:double
//			-V2_60Ft:double
// Methods: 
//			+calculateVehicle1(Vehicle):void
//			+calculateVehicle2(Vehicle):void
//			+Race():void
// 			
// 
public class DragRace {
	private double V1QuarterTime;
	private double V2QuarterTime;
	private double V1QuarterSpeed;
	private double V2QuarterSpeed;
	private double V1EighthTime;
	private double V2EighthTime;
	private double V1EighthSpeed;
	private double V2EighthSpeed;
	private double V1_60Ft;
	private double V2_60Ft;
	private Vehicle vehicle1;
	private Vehicle vehicle2;
	
	public void userInput1() {
		int input;
		Scanner inputScan = new Scanner(System.in);
		System.out.println("Please enter 0 to manualy create a vehicle, or 1 to create one from a file.");
		input = inputScan.nextInt();
		if (input == 0) {
			createVehicle1();
		}
		else if (input == 1) {
			createFileVehicle1();
		}
		else {
			System.out.println("Please enter a valid number");
		}
	}
	public void userInput2() {
		int input;
		Scanner inputScan = new Scanner(System.in);
		System.out.println("Please enter 0 to manualy create a vehicle, or 1 to create one from a file.");
		input = inputScan.nextInt();
		if (input == 0) {
			createVehicle2();
		}
		else if (input == 1) {
			createFileVehicle2();
		}
		else {
			System.out.println("Please enter a valid number");
		}
	}

	
	public void createVehicle1() {
		VehicleCreator creator = new VehicleCreator();
		vehicle1 = creator.createVehicle();
	}
	public void createVehicle2() {
		VehicleCreator creator2 = new VehicleCreator();
		vehicle2 = creator2.createVehicle();
	}
	public void createFileVehicle1() {
		VehicleCreator creator = new VehicleCreator();
		vehicle1 = creator.createVehicleFromFile();
	}
	public void createFileVehicle2() {
		VehicleCreator creator = new VehicleCreator();
		vehicle1 = creator.createVehicleFromFile();
	}
	public void calculateVehicle1() {
		V1QuarterTime = vehicle1.calculateQuarterMileTime(vehicle1);
		V1QuarterSpeed = vehicle1.calculateQuarterMileSpeed(vehicle1);
		V1EighthTime = vehicle1.calculateEighthMileTime(vehicle1);
		V1EighthSpeed = vehicle1.calculateEighthMileSpeed(vehicle1);
		V1_60Ft = vehicle1.calculateSixtyFeetTime(vehicle1);
	}
	public void calculateVehicle2() {
		V2QuarterTime = vehicle2.calculateQuarterMileTime(vehicle2);
		V2QuarterSpeed = vehicle2.calculateQuarterMileSpeed(vehicle2);
		V2EighthTime = vehicle2.calculateEighthMileTime(vehicle2);
		V2EighthSpeed = vehicle2.calculateEighthMileSpeed(vehicle2);
		V2_60Ft = vehicle2.calculateSixtyFeetTime(vehicle2);
	}
	public void race(){
		userInput1();
		userInput2();
		calculateVehicle1();
		calculateVehicle2();
		countdown();
		raceResults();
		
		
	}
	public void countdown() {
		for (int i = 3; i >= 1; i--) {
	        System.out.println(i);
	        try {
	            Thread.sleep(1000); // Pause for 1 second
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	    System.out.println("GO!");
	}
	public void raceResults() {
		 
		 if(V1_60Ft<V2_60Ft) {
		 try {
	            Thread.sleep((int)V1_60Ft*1000); // Pause for V1
	            System.out.println(vehicle1.getVehicleName()+" 60 Ft time:"+ V1_60Ft);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		 
	
		 try {
	            Thread.sleep(((int)V2_60Ft*1000)-((int)V1_60Ft*1000)); // Pause for V2
	            System.out.println(vehicle2.getVehicleName()+"60 Ft time:"+ V2_60Ft);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		 }
		 if(V1_60Ft>V2_60Ft) {
			 try {
		            Thread.sleep((int)V2_60Ft*1000); // Pause for V1
		            System.out.println(vehicle2.getVehicleName()+" 60 Ft time:"+ V2_60Ft);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
			 
		
			 try {
		            Thread.sleep(((int)V1_60Ft*1000)-((int)V2_60Ft*1000)); // Pause for V2
		            System.out.println(vehicle1.getVehicleName()+"60 Ft time:"+ V1_60Ft);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
			 }
		 if(V1EighthTime<V2EighthTime) {
			 
		 try {
	            Thread.sleep(((int)V1EighthTime*1000)-(((int)V2_60Ft*1000)-((int)V1_60Ft*1000))); // Pause for V1 
	            System.out.println(vehicle1.getVehicleName()+" 1/8th time:"+ V1EighthTime);
	            System.out.println(vehicle1.getVehicleName()+" 1/8th Speed:"+ V1EighthSpeed);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		 try {
	            Thread.sleep(((int)V2EighthTime*1000)-((int)V1EighthTime*1000)-(((int)V2_60Ft*1000)-((int)V1_60Ft*1000))); // Pause for V2
	            System.out.println(vehicle2.getVehicleName()+" 1/8th time:"+ V2EighthTime);
	            System.out.println(vehicle2.getVehicleName()+" 1/8th Speed:"+ V2EighthSpeed);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		 }
		 if(V1EighthTime>V2EighthTime) {
		
		 try {
	            Thread.sleep(((int)V2EighthTime*1000)-(((int)V2_60Ft*1000)-((int)V1_60Ft*1000))); // Pause for V1 
	            System.out.println(vehicle2.getVehicleName()+" 1/8th time:"+ V2EighthTime);
	            System.out.println(vehicle2.getVehicleName()+" 1/8th Speed:"+ V2EighthSpeed);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		 try {
	            Thread.sleep(((int)V1EighthTime*1000)-((int)V2EighthTime*1000)-(((int)V2_60Ft*1000)-((int)V1_60Ft*1000))); // Pause for V2
	            System.out.println(vehicle1.getVehicleName()+" 1/8th time:"+ V1EighthTime);
	            System.out.println(vehicle1.getVehicleName()+" 1/8th Speed:"+ V1EighthSpeed);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		 }
		 if(V1QuarterTime<V2QuarterTime) {
					 try {
	            Thread.sleep(((int)V1QuarterTime*1000)-(((int)V2EighthTime*1000)-((int)V1EighthTime*1000)-(((int)V2_60Ft*1000)-((int)V1_60Ft*1000)))); // Pause for V1
	            System.out.println(vehicle1.getVehicleName()+"1/4th Mile time:"+ V1QuarterTime);
	            System.out.println(vehicle1.getVehicleName()+"1/4th Mile Speed:"+ V1QuarterSpeed);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		 try {
	            Thread.sleep(((int)V2QuarterTime*1000)-(((int)V1QuarterTime*1000)-(((int)V2EighthTime*1000)-((int)V1EighthTime*1000)-(((int)V2_60Ft*1000)-((int)V1_60Ft*1000))))); // Pause for V2
	            System.out.println(vehicle2.getVehicleName()+" 1/4th Mile time"+ V2QuarterTime);
	            System.out.println(vehicle2.getVehicleName()+"1/4th Mile Speed:"+ V2QuarterSpeed);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		 System.out.println("The Winner Is: " + vehicle1.getVehicleName());
		 try {
		        FileWriter writer = new FileWriter("winningTicket.txt");
		        BufferedWriter bw = new BufferedWriter(writer);

		    
		            bw.write("Winner: "+ vehicle1.getVehicleName());
		            
		            bw.newLine();

		            bw.write("60Ft time "+ V1_60Ft);
		            
		            bw.newLine();
		            
		            bw.write("1/8th mile time: "+ V1EighthTime + "1/8th mile Speed:" + V1EighthSpeed);
		            
		            bw.newLine();
		            
		            bw.write("1/4 mile time: "+ V1QuarterTime + "1/4th mile Speed:" + V1QuarterSpeed);
		        
		       

		        bw.close();
		        writer.close();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		 }
		 if(V1QuarterTime>V2QuarterTime) {
			 
		 try {
	            Thread.sleep(((int)V2QuarterTime*1000)-(((int)V2EighthTime*1000)-((int)V1EighthTime*1000)-(((int)V2_60Ft*1000)-((int)V1_60Ft*1000)))); // Pause for V1
	            System.out.println(vehicle2.getVehicleName()+"1/4th Mile time:"+ V2QuarterTime);
	            System.out.println(vehicle2.getVehicleName()+"1/4th Mile Speed:"+ V2QuarterSpeed);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		 try {
	            Thread.sleep(((int)V1QuarterTime*1000)-(((int)V2QuarterTime*1000)-(((int)V2EighthTime*1000)-((int)V1EighthTime*1000)-(((int)V2_60Ft*1000)-((int)V1_60Ft*1000))))); // Pause for V2
	            System.out.println(vehicle1.getVehicleName()+" 1/4th Mile time"+ V1QuarterTime);
	            System.out.println(vehicle1.getVehicleName()+"1/4th Mile Speed:"+ V1QuarterSpeed);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		 System.out.println("The Winner Is: " + vehicle2.getVehicleName());
		 try {
		        FileWriter writer = new FileWriter("winningTicket.txt");
		        BufferedWriter bw = new BufferedWriter(writer);

		    
		            bw.write("Winner: "+ vehicle2.getVehicleName());
		            
		            bw.newLine();

		            bw.write("60Ft time "+ V2_60Ft);
		            
		            bw.newLine();
		            
		            bw.write("1/8th mile time: "+ V2EighthTime + "1/8th mile Speed:" + V2EighthSpeed);
		            
		            bw.newLine();
		            
		            bw.write("1/4 mile time: "+ V2QuarterTime + "1/4th mile Speed:" + V2QuarterSpeed);
		        
		       

		        bw.close();
		        writer.close();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		 }
		 }
	}

	


	
	
	
	
	
	
	
	


