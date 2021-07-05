package com.grubhub.lite.demo.models;

import jdk.jfr.Enabled;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;

/**
 * Class Driver
 */
@Entity
@Table
public class Driver extends User {

  //
  // Fields
  //

  private Short rating;
  private Enums.VehicleType vehicle;
  private Date estimatedArrivalTime;
  
  //
  // Constructors
  //
  public Driver () { };

  public Driver(Short rating, Enums.VehicleType vehicle, Date estimatedArrivalTime, String UUID) {
    super(UUID);
    this.rating = rating;
    this.vehicle = vehicle;
    this.estimatedArrivalTime = estimatedArrivalTime;
  }

  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of rating
   * @param newVar the new value of rating
   */
  public void setRating (Short newVar) {
    rating = newVar;
  }

  /**
   * Get the value of rating
   * @return the value of rating
   */
  public Short getRating () {
    return rating;
  }

  /**
   * Set the value of vehicle
   * @param newVar the new value of vehicle
   */
  public void setVehicle (Enums.VehicleType newVar) {
    vehicle = newVar;
  }

  /**
   * Get the value of vehicle
   * @return the value of vehicle
   */
  public Enums.VehicleType getVehicle () {
    return vehicle;
  }

  /**
   * Set the value of estimatedArrivalTime
   * @param newVar the new value of estimatedArrivalTime
   */
  public void setEstimatedArrivalTime (Date newVar) {
    estimatedArrivalTime = newVar;
  }

  /**
   * Get the value of estimatedArrivalTime
   * @return the value of estimatedArrivalTime
   */
  public Date getEstimatedArrivalTime () {
    return estimatedArrivalTime;
  }

  //
  // Other methods
  //


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Driver driver = (Driver) o;

    if (!Objects.equals(rating, driver.rating)) return false;
    if (vehicle != driver.vehicle) return false;
    return Objects.equals(estimatedArrivalTime, driver.estimatedArrivalTime);
  }

  @Override
  public int hashCode() {
    int result = rating != null ? rating.hashCode() : 0;
    result = 31 * result + (vehicle != null ? vehicle.hashCode() : 0);
    result = 31 * result + (estimatedArrivalTime != null ? estimatedArrivalTime.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Driver{" +
            "rating=" + rating +
            ", vehicle=" + vehicle +
            ", estimatedArrivalTime=" + estimatedArrivalTime +
            '}';
  }
}
