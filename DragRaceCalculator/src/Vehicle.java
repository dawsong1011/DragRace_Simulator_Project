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
//				-vehicleName: String
//				-tireType: String
//				-transmissionType: String
// Methods: 
//			+constructor
//			
// 
public class Vehicle {
	private double weight;
	private double power;
	private String tireType;
	private String transmissionType;
	private String vehicleName;
	
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
	

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public Vehicle(String vehicleName,double weight, double power, String tireType, String transmissionType) {
		super();
		this.weight = weight;
		this.power = power;
		this.tireType = tireType;
		this.transmissionType = transmissionType;
		this.vehicleName = vehicleName;
	}
	public double calculateQuarterMileTime(Vehicle vehicle) {
		double placeHolder = 0.0;
		return placeHolder;
	}
	public double calculateEighthMileTime(Vehicle vehicle) {
		double placeHolder = 0.0;
		return placeHolder;
	}
	public double calculateSixtyFeetTime(Vehicle vehicle) {
		double placeHolder = 0.0;
		return placeHolder;
	}
	public double calculateQuarterMileSpeed(Vehicle vehicle) {
		double placeHolder = 0.0;
		return placeHolder;
	}
	public double calculateEighthMileSpeed(Vehicle vehicle) {
		double placeHolder = 0.0;
		return placeHolder;
	}
}
