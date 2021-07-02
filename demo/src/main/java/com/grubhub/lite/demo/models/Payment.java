package com.grubhub.lite.demo.models;

import java.util.Objects;

/**
 * Class Payment
 */
public class Payment {

  //
  // Fields
  //

  private Long paymentID;
  private Enums.PaymentType paymentType;
  private Enums.PaymentStatus paymentStatus;
  
  //
  // Constructors
  //
  public Payment () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

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

  /**
   * Set the value of paymentType
   * @param newVar the new value of paymentType
   */
  public void setPaymentType (Enums.PaymentType newVar) {
    paymentType = newVar;
  }

  /**
   * Get the value of paymentType
   * @return the value of paymentType
   */
  public Enums.PaymentType getPaymentType () {
    return paymentType;
  }

  /**
   * Set the value of paymentStatus
   * @param newVar the new value of paymentStatus
   */
  public void setPaymentStatus (Enums.PaymentStatus newVar) {
    paymentStatus = newVar;
  }

  /**
   * Get the value of paymentStatus
   * @return the value of paymentStatus
   */
  public Enums.PaymentStatus getPaymentStatus () {
    return paymentStatus;
  }

  //
  // Other methods
  //


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Payment payment = (Payment) o;

    if (!Objects.equals(paymentID, payment.paymentID)) return false;
    if (paymentType != payment.paymentType) return false;
    return paymentStatus == payment.paymentStatus;
  }

  @Override
  public int hashCode() {
    int result = paymentID != null ? paymentID.hashCode() : 0;
    result = 31 * result + (paymentType != null ? paymentType.hashCode() : 0);
    result = 31 * result + (paymentStatus != null ? paymentStatus.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Payment{" +
            "paymentID=" + paymentID +
            ", paymentType=" + paymentType +
            ", paymentStatus=" + paymentStatus +
            '}';
  }
}
