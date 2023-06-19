//********************************************************* 
// Class: CS 225 
// Author: <Dawson Gomez> 
// Created: <3/23/23> 
// Modified: 
// 
// Purpose: Acts as the game controller for the maze game, houses the game elements in one place. 
// 
// Attributes:
//				- FWDGripLossFactor:int
//				-FWDLaunchFactor:int
//				-FWD60FtFactor:int
// Methods: 
//		
//*********************************************************
public class FWDVehicle extends Vehicle {
	private double FWDGripLossFactor = (1500/getWeight());
	private double FWDLaunchFactor = ((getTireType().equals("Performance") ? 1 : 2)/4);
	private double FWD60FtFactor = (FWDGripLossFactor/3);
	public FWDVehicle(String vehicleName,double weight, double power, String tireType, String transmissionType) {
		super(vehicleName,weight,power,tireType,transmissionType);
	}
	public double calculateQuarterMileTime(Vehicle vehicle) {
		double result = 7.3571 * Math.pow((vehicle.getWeight()/vehicle.getPower()), 0.2574)+FWDLaunchFactor+FWDGripLossFactor;
		return result;
		
        
	}
	public double calculateEighthMileTime(Vehicle vehicle) {
		double result = ((7.3571 * Math.pow((vehicle.getWeight()/vehicle.getPower()), 0.2574)+FWDLaunchFactor+FWDGripLossFactor)/1.56);
		return result;
	}
	public double calculateSixtyFeetTime(Vehicle vehicle) {
		double result = ((7.3571 * Math.pow((vehicle.getWeight()/vehicle.getPower()), 0.2574)+FWDLaunchFactor+FWDGripLossFactor)*(.139))+FWD60FtFactor;
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
