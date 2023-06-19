import java.io.BufferedReader;
import java.io.FileReader;
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
//				- weight: double
//				-Power: double
//				-driveType: String
//				-tireType: String
//				-transmissionType: String
//				-filename: String
// Methods: 
//			+CreateVehicle():void
//			+CreateVehcileFromFile():void
//			
// 

public class VehicleCreator {
	private double weight;
	private double power;
	private String driveType;
	private String tireType;
	private String transmissionType;
	private String fileName;
	private String vehicleName;
	Vehicle Vehicle;
	private String vehicleFile = "cars.csv";
	
	Vehicle createVehicle() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter your vehicles name:");
		vehicleName = scan.nextLine();
		boolean validInput = false;
		System.out.println("Please enter your vehicles Drive type (FWD/RWD)");
		while(validInput == false) {
			driveType = scan.nextLine();
		if(driveType.toUpperCase().equals("RWD")) {
			validInput = true;
			System.out.println("Please enter your vehicles power in HP ");
			power = scan.nextDouble();
			
			System.out.println("Please enter your vehicles Weight in Lbs");
			weight = scan.nextDouble();
			scan.nextLine();
			System.out.println("Please enter your vehicles tireType (Performance/Street)");
			tireType = scan.nextLine();
			
			System.out.println("Please enter your vehicles transmission type (Automatic/Manual)");
			transmissionType = scan.nextLine();
			scan.nextLine();
			Vehicle = new RWDVehicle(vehicleName,weight, power,tireType,transmissionType);
		}
		else if (driveType.toUpperCase().equals("FWD")) {
			validInput = true;
			System.out.println("Please enter your vehicles power in HP ");
			power = scan.nextDouble();
			
			System.out.println("Please enter your vehicles Weight in Lbs");
			weight = scan.nextDouble();
			scan.nextLine();
			System.out.println("Please enter your vehicles tireType (Performance/Street)");
			tireType = scan.nextLine();
			
			System.out.println("Please enter your vehicles transmission type (Automatic/Manual)");
			transmissionType = scan.nextLine();
			scan.nextLine();
			 Vehicle = new FWDVehicle(vehicleName,weight, power,tireType,transmissionType);
		}
		else {
			System.out.println("Please enter a valid driveType");	
			scan.next();
			validInput = false;
			
		}
	}
		return Vehicle;
	}
	Vehicle createVehicleFromFile() {
		try {
			
			FileReader fr = new FileReader(vehicleFile);
			BufferedReader br = new BufferedReader(fr);
			
			String row;
			
			row = br.readLine();
			row = br.readLine();
			
			
			int numberOfColumns = 6;
			
			
			
			int arrayElement = 0;
			
			while (  ( row = br.readLine() ) != null     ) {
					
				String[] columns = row.split(",", numberOfColumns);
				
			
				String vehicleName = columns[0];
				String drivetype = columns[1];
				String transmissionType = columns[2];
				String tireType = columns[3];
				double weight = Double.parseDouble(columns[4]);
				double power = Double.parseDouble(columns[5]);
				
				if (drivetype == "RWD") {
				Vehicle = new RWDVehicle(vehicleName,weight, power,tireType,transmissionType);
				}
				else if(drivetype == "FWD") {
				Vehicle = new FWDVehicle(vehicleName,weight, power,tireType,transmissionType);
				}
				
				arrayElement++;
			}
			
			br.close();
			fr.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Vehicle;
	}
	
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getPower() {
		return power;
	}
	public void setPower(double power) {
		this.power = power;
	}
	public String getDriveType() {
		return driveType;
	}
	public void setDriveType(String driveType) {
		this.driveType = driveType;
	}
	public String getTireType() {
		return tireType;
	}
	public void setTireType(String tireType) {
		this.tireType = tireType;
	}
	public String getTransmissionType() {
		return transmissionType;
	}
	public void setTransmissionType(String transmissionType) {
		this.transmissionType = transmissionType;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}
