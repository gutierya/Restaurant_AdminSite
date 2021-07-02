package com.grubhub.lite.demo.models;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Class Order
 */
public class Order {

  //
  // Fields
  //

  private Long orderID;
  private Date createdTime;
  private Date expectedCompletion;
  private Long sourceRestaurantID;
  private List<Integer> items;
  private Enums.OrderStatus status;
  private Long deliveryDriverID;
  private Long destUserID;
  private Double orderTotal;
  private double tax;
  private double orderSubTotal;
  private Long customerID;
  private Double tipAmount;
  private Long paymentID;
  
  //
  // Constructors
  //
  public Order () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of orderID
   * @param newVar the new value of orderID
   */
  public void setOrderID (Long newVar) {
    orderID = newVar;
  }

  /**
   * Get the value of orderID
   * @return the value of orderID
   */
  public Long getOrderID () {
    return orderID;
  }

  /**
   * Set the value of createdTime
   * @param newVar the new value of createdTime
   */
  public void setCreatedTime (Date newVar) {
    createdTime = newVar;
  }

  /**
   * Get the value of createdTime
   * @return the value of createdTime
   */
  public Date getCreatedTime () {
    return createdTime;
  }

  /**
   * Set the value of expectedCompletion
   * @param newVar the new value of expectedCompletion
   */
  public void setExpectedCompletion (Date newVar) {
    expectedCompletion = newVar;
  }

  /**
   * Get the value of expectedCompletion
   * @return the value of expectedCompletion
   */
  public Date getExpectedCompletion () {
    return expectedCompletion;
  }

  /**
   * Set the value of sourceRestaurantID
   * @param newVar the new value of sourceRestaurantID
   */
  public void setSourceRestaurantID (Long newVar) {
    sourceRestaurantID = newVar;
  }

  /**
   * Get the value of sourceRestaurantID
   * @return the value of sourceRestaurantID
   */
  public Long getSourceRestaurantID () {
    return sourceRestaurantID;
  }

  /**
   * Set the value of items
   * @param newVar the new value of items
   */
  public void setItems (List<Integer> newVar) {
    items = newVar;
  }

  /**
   * Get the value of items
   * @return the value of items
   */
  public List<Integer> getItems () {
    return items;
  }

  /**
   * Set the value of status
   * @param newVar the new value of status
   */
  public void setStatus (Enums.OrderStatus newVar) {
    status = newVar;
  }

  /**
   * Get the value of status
   * @return the value of status
   */
  public Enums.OrderStatus getStatus () {
    return status;
  }

  /**
   * Set the value of deliveryDriverID
   * @param newVar the new value of deliveryDriverID
   */
  public void setDeliveryDriverID (Long newVar) {
    deliveryDriverID = newVar;
  }

  /**
   * Get the value of deliveryDriverID
   * @return the value of deliveryDriverID
   */
  public Long getDeliveryDriverID () {
    return deliveryDriverID;
  }

  /**
   * Set the value of destUserID
   * @param newVar the new value of destUserID
   */
  public void setDestUserID (Long newVar) {
    destUserID = newVar;
  }

  /**
   * Get the value of destUserID
   * @return the value of destUserID
   */
  public Long getDestUserID () {
    return destUserID;
  }

  /**
   * Set the value of orderTotal
   * @param newVar the new value of orderTotal
   */
  public void setOrderTotal (Double newVar) {
    orderTotal = newVar;
  }

  /**
   * Get the value of orderTotal
   * @return the value of orderTotal
   */
  public Double getOrderTotal () {
    return orderTotal;
  }

  /**
   * Set the value of tax
   * @param newVar the new value of tax
   */
  public void setTax (double newVar) {
    tax = newVar;
  }

  /**
   * Get the value of tax
   * @return the value of tax
   */
  public double getTax () {
    return tax;
  }

  /**
   * Set the value of orderSubTotal
   * @param newVar the new value of orderSubTotal
   */
  public void setOrderSubTotal (double newVar) {
    orderSubTotal = newVar;
  }

  /**
   * Get the value of orderSubTotal
   * @return the value of orderSubTotal
   */
  public double getOrderSubTotal () {
    return orderSubTotal;
  }

  /**
   * Set the value of customerID
   * @param newVar the new value of customerID
   */
  public void setCustomerID (Long newVar) {
    customerID = newVar;
  }

  /**
   * Get the value of customerID
   * @return the value of customerID
   */
  public Long getCustomerID () {
    return customerID;
  }

  /**
   * Set the value of tipAmount
   * @param newVar the new value of tipAmount
   */
  public void setTipAmount (Double newVar) {
    tipAmount = newVar;
  }

  /**
   * Get the value of tipAmount
   * @return the value of tipAmount
   */
  public Double getTipAmount () {
    return tipAmount;
  }

  /**
   * Set the value of paymentID
   * @param newVar the new value of paymentID
   */
  public void setPaymentID (Long newVar) {
    paymentID = newVar;
  }

  /**
   * Get the value of paymentID
   * @return the value of paymentID
   */
  public Long getPaymentID () {
    return paymentID;
  }

  //
  // Other methods
  //


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Order order = (Order) o;

    if (Double.compare(order.tax, tax) != 0) return false;
    if (Double.compare(order.orderSubTotal, orderSubTotal) != 0) return false;
    if (!Objects.equals(orderID, order.orderID)) return false;
    if (!Objects.equals(createdTime, order.createdTime)) return false;
    if (!Objects.equals(expectedCompletion, order.expectedCompletion))
      return false;
    if (!Objects.equals(sourceRestaurantID, order.sourceRestaurantID))
      return false;
    if (!Objects.equals(items, order.items)) return false;
    if (status != order.status) return false;
    if (!Objects.equals(deliveryDriverID, order.deliveryDriverID))
      return false;
    if (!Objects.equals(destUserID, order.destUserID)) return false;
    if (!Objects.equals(orderTotal, order.orderTotal)) return false;
    if (!Objects.equals(customerID, order.customerID)) return false;
    if (!Objects.equals(tipAmount, order.tipAmount)) return false;
    return Objects.equals(paymentID, order.paymentID);
  }

  @Override
  public int hashCode() {
    int result;
    long temp;
    result = orderID != null ? orderID.hashCode() : 0;
    result = 31 * result + (createdTime != null ? createdTime.hashCode() : 0);
    result = 31 * result + (expectedCompletion != null ? expectedCompletion.hashCode() : 0);
    result = 31 * result + (sourceRestaurantID != null ? sourceRestaurantID.hashCode() : 0);
    result = 31 * result + (items != null ? items.hashCode() : 0);
    result = 31 * result + (status != null ? status.hashCode() : 0);
    result = 31 * result + (deliveryDriverID != null ? deliveryDriverID.hashCode() : 0);
    result = 31 * result + (destUserID != null ? destUserID.hashCode() : 0);
    result = 31 * result + (orderTotal != null ? orderTotal.hashCode() : 0);
    temp = Double.doubleToLongBits(tax);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    temp = Double.doubleToLongBits(orderSubTotal);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    result = 31 * result + (customerID != null ? customerID.hashCode() : 0);
    result = 31 * result + (tipAmount != null ? tipAmount.hashCode() : 0);
    result = 31 * result + (paymentID != null ? paymentID.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Order{" +
            "orderID=" + orderID +
            ", createdTime=" + createdTime +
            ", expectedCompletion=" + expectedCompletion +
            ", sourceRestaurantID=" + sourceRestaurantID +
            ", items=" + items +
            ", status=" + status +
            ", deliveryDriverID=" + deliveryDriverID +
            ", destUserID=" + destUserID +
            ", orderTotal=" + orderTotal +
            ", tax=" + tax +
            ", orderSubTotal=" + orderSubTotal +
            ", customerID=" + customerID +
            ", tipAmount=" + tipAmount +
            ", paymentID=" + paymentID +
            '}';
  }
}
