package com.grubhub.lite.demo.models;

import java.util.*;


/**
 * Class Customer
 */
public class Customer extends User {

  //
  // Fields
  //

  private String address;
  private List<Order> orderHistory;
  private List<Restaurant> favoriteRestaurants;
  private List<MenuItem> favoriteItems;
  
  //
  // Constructors
  //
  public Customer () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of address
   * @param newVar the new value of address
   */
  public void setAddress (String newVar) {
    address = newVar;
  }

  /**
   * Get the value of address
   * @return the value of address
   */
  public String getAddress () {
    return address;
  }

  /**
   * Set the value of orderHistory
   * @param newVar the new value of orderHistory
   */
  public void setOrderHistory (List<Order> newVar) {
    orderHistory = newVar;
  }

  /**
   * Get the value of orderHistory
   * @return the value of orderHistory
   */
  public List<Order> getOrderHistory () {
    return orderHistory;
  }

  /**
   * Set the value of favoriteRestaurants
   * @param newVar the new value of favoriteRestaurants
   */
  public void setFavoriteRestaurants (List<Restaurant> newVar) {
    favoriteRestaurants = newVar;
  }

  /**
   * Get the value of favoriteRestaurants
   * @return the value of favoriteRestaurants
   */
  public List<Restaurant> getFavoriteRestaurants () {
    return favoriteRestaurants;
  }

  /**
   * Set the value of favoriteItems
   * @param newVar the new value of favoriteItems
   */
  public void setFavoriteItems (List<MenuItem> newVar) {
    favoriteItems = newVar;
  }

  /**
   * Get the value of favoriteItems
   * @return the value of favoriteItems
   */
  public List<MenuItem> getFavoriteItems () {
    return favoriteItems;
  }

  //
  // Other methods
  //


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Customer customer = (Customer) o;

    if (!Objects.equals(address, customer.address)) return false;
    if (!Objects.equals(orderHistory, customer.orderHistory))
      return false;
    if (!Objects.equals(favoriteRestaurants, customer.favoriteRestaurants))
      return false;
    return Objects.equals(favoriteItems, customer.favoriteItems);
  }

  @Override
  public int hashCode() {
    int result = address != null ? address.hashCode() : 0;
    result = 31 * result + (orderHistory != null ? orderHistory.hashCode() : 0);
    result = 31 * result + (favoriteRestaurants != null ? favoriteRestaurants.hashCode() : 0);
    result = 31 * result + (favoriteItems != null ? favoriteItems.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Customer{" +
            "address='" + address + '\'' +
            ", orderHistory=" + orderHistory +
            ", favoriteRestaurants=" + favoriteRestaurants +
            ", favoriteItems=" + favoriteItems +
            '}';
  }
}
