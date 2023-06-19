//********************************************************* 
// Class: CS 225 
// Author: <Dawson Gomez> 
// Created: <3/23/23> 
// Modified: 
// 
// Purpose: Acts as the game controller for the maze game, houses the game elements in one place. 
// 
// Attributes:
//				- driveTrainLoss: int
//				
// Methods: 
//			
// 
public class RWDVehicle extends Vehicle {
	double driveTrainLoss = .8;
	public RWDVehicle(String vehicleName,double weight, double power, String tireType, String transmissionType) {
		super(vehicleName,weight,power,tireType,transmissionType);
	}
	
	public double calculateQuarterMileTime(Vehicle vehicle) {
		double result = (7.3571 * Math.pow((vehicle.getWeight()/vehicle.getPower()), 0.2574)+driveTrainLoss)-(getTireType().equals("Performance") ? .5 : 0);
		return result;
	}
	public double calculateEighthMileTime(Vehicle vehicle) {
		double result = ((7.3571 * Math.pow((vehicle.getWeight()/vehicle.getPower()), 0.2574)+driveTrainLoss)/1.56)-(getTireType().equals("Performance") ? .26 : 0);
		return result;
	}
	public double calculateSixtyFeetTime(Vehicle vehicle) {
		double result = ((7.3571 * Math.pow((vehicle.getWeight()/vehicle.getPower()), 0.2574)+driveTrainLoss)*.139)-(getTireType().equals("Performance") ? .1 : 0);
		return result;
	}
	public double calculateQuarterMileSpeed(Vehicle vehicle) {
		double result = 215.39 * Math.pow((vehicle.getPower()/vehicle.getWeight()), 0.3018)+(getTireType().equals("Performance") ? 11 : 0);
		return result;
		
	}
	public double calculateEighthMileSpeed(Vehicle vehicle) {
		double result = (215.39 * Math.pow((vehicle.getPower()/vehicle.getWeight()), 0.3018)/1.26)+(getTireType().equals("Performance") ? 5.2 : 0);
		return result;
	}
}


