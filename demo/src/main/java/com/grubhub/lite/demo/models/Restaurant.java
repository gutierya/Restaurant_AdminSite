package com.grubhub.lite.demo.models;

import javax.persistence.*;
import java.util.*;


/**
 * Class Restaurant
 */
@Entity
@Table
public class Restaurant {

  //
  // Fields
  //

  private String name;
  private Short rating;
  private String address;
  private Boolean isOpen;
  private Date timeOpen;
  private Date timeClose;
  private Enums.Cuisine type;
  private Double averageWaitTime;
  private Enums.ValueProp valueProposition;
  @ElementCollection
  private List<Long> menu;
  @ElementCollection
  private List<Enums.DietaryRestrictions> dietaryRestrictions;
  private @Id
  @GeneratedValue
  Long id;
  private Boolean offersTakeout;
  @ElementCollection
  private List<String> categories;
  
  //
  // Constructors
  //
  public Restaurant () { };

  public Restaurant(String name, Short rating, String address, Boolean isOpen, Date timeOpen, Date timeClose,
                    Enums.Cuisine type, Double averageWaitTime, Enums.ValueProp valueProposition, List<Long> menu,
                    List<Enums.DietaryRestrictions> dietaryRestrictions, Boolean offersTakeout,
                    List<String> categories) {
    this.name = name;
    this.rating = rating;
    this.address = address;
    this.isOpen = isOpen;
    this.timeOpen = timeOpen;
    this.timeClose = timeClose;
    this.type = type;
    this.averageWaitTime = averageWaitTime;
    this.valueProposition = valueProposition;
    this.menu = menu;
    this.dietaryRestrictions = dietaryRestrictions;
    this.id = id;
    this.offersTakeout = offersTakeout;
    this.categories = categories;
  }

  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of name
   * @param newVar the new value of name
   */
  public void setName (String newVar) {
    name = newVar;
  }

  /**
   * Get the value of name
   * @return the value of name
   */
  public String getName () {
    return name;
  }

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
   * Set the value of isOpen
   * @param newVar the new value of isOpen
   */
  public void setIsOpen (Boolean newVar) {
    isOpen = newVar;
  }

  /**
   * Get the value of isOpen
   * @return the value of isOpen
   */
  public Boolean getIsOpen () {
    return isOpen;
  }

  /**
   * Set the value of timeOpen
   * @param newVar the new value of timeOpen
   */
  public void setTimeOpen (Date newVar) {
    timeOpen = newVar;
  }

  /**
   * Get the value of timeOpen
   * @return the value of timeOpen
   */
  public Date getTimeOpen () {
    return timeOpen;
  }

  /**
   * Set the value of timeClose
   * @param newVar the new value of timeClose
   */
  public void setTimeClose (Date newVar) {
    timeClose = newVar;
  }

  /**
   * Get the value of timeClose
   * @return the value of timeClose
   */
  public Date getTimeClose () {
    return timeClose;
  }

  /**
   * Set the value of type
   * @param newVar the new value of type
   */
  public void setType (Enums.Cuisine newVar) {
    type = newVar;
  }

  /**
   * Get the value of type
   * @return the value of type
   */
  public Enums.Cuisine getType () {
    return type;
  }

  /**
   * Set the value of averageWaitTime
   * @param newVar the new value of averageWaitTime
   */
  public void setAverageWaitTime (Double newVar) {
    averageWaitTime = newVar;
  }

  /**
   * Get the value of averageWaitTime
   * @return the value of averageWaitTime
   */
  public Double getAverageWaitTime () {
    return averageWaitTime;
  }

  /**
   * Set the value of valueProposition
   * @param newVar the new value of valueProposition
   */
  public void setValueProposition (Enums.ValueProp newVar) {
    valueProposition = newVar;
  }

  /**
   * Get the value of valueProposition
   * @return the value of valueProposition
   */
  public Enums.ValueProp getValueProposition () {
    return valueProposition;
  }

  /**
   * Set the value of menu
   * @param newVar the new value of menu
   */
  public void setMenu (List<Long> newVar) {
    menu = newVar;
  }

  /**
   * Get the value of menu
   * @return the value of menu
   */
  public List<Long> getMenu () {
    return menu;
  }

  /**
   * Set the value of diateryRestrictions
   * @param newVar the new value of diateryRestrictions
   */
  public void setDietaryRestrictions(List<Enums.DietaryRestrictions> newVar) {
    dietaryRestrictions = newVar;
  }

  /**
   * Get the value of diateryRestrictions
   * @return the value of diateryRestrictions
   */
  public List<Enums.DietaryRestrictions> getDietaryRestrictions() {
    return dietaryRestrictions;
  }

  /**
   * Set the value of id
   * @param newVar the new value of id
   */
  public void setId (Long newVar) {
    id = newVar;
  }

  /**
   * Get the value of id
   * @return the value of id
   */
  public Long getId () {
    return id;
  }

  /**
   * Set the value of offersTakeout
   * @param newVar the new value of offersTakeout
   */
  public void setOffersTakeout (Boolean newVar) {
    offersTakeout = newVar;
  }

  /**
   * Get the value of offersTakeout
   * @return the value of offersTakeout
   */
  public Boolean getOffersTakeout () {
    return offersTakeout;
  }

  /**
   * Set the value of categories
   * @param newVar the new value of categories
   */
  public void setCategories (List<String> newVar) {
    categories = newVar;
  }

  /**
   * Get the value of categories
   * @return the value of categories
   */
  public List<String> getCategories () {
    return categories;
  }

  //
  // Other methods
  //


  public Boolean getOpen() {
    return isOpen;
  }

  public void setOpen(Boolean open) {
    isOpen = open;
  }

  @Override
  public String toString() {
    return "Restaurant{" +
            "name='" + name + '\'' +
            ", rating=" + rating +
            ", address='" + address + '\'' +
            ", isOpen=" + isOpen +
            ", timeOpen=" + timeOpen +
            ", timeClose=" + timeClose +
            ", type=" + type +
            ", averageWaitTime=" + averageWaitTime +
            ", valueProposition=" + valueProposition +
            ", menu=" + menu +
            ", dietaryRestrictions=" + dietaryRestrictions +
            ", id=" + id +
            ", offersTakeout=" + offersTakeout +
            ", categories=" + categories +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Restaurant that = (Restaurant) o;

    if (!Objects.equals(name, that.name)) return false;
    if (!Objects.equals(rating, that.rating)) return false;
    if (!Objects.equals(address, that.address)) return false;
    if (!Objects.equals(isOpen, that.isOpen)) return false;
    if (!Objects.equals(timeOpen, that.timeOpen)) return false;
    if (!Objects.equals(timeClose, that.timeClose)) return false;
    if (type != that.type) return false;
    if (!Objects.equals(averageWaitTime, that.averageWaitTime))
      return false;
    if (valueProposition != that.valueProposition) return false;
    if (!Objects.equals(menu, that.menu)) return false;
    if (!Objects.equals(dietaryRestrictions, that.dietaryRestrictions))
      return false;
    if (!Objects.equals(offersTakeout, that.offersTakeout)) return false;
    return Objects.equals(categories, that.categories);
  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + (rating != null ? rating.hashCode() : 0);
    result = 31 * result + (address != null ? address.hashCode() : 0);
    result = 31 * result + (isOpen != null ? isOpen.hashCode() : 0);
    result = 31 * result + (timeOpen != null ? timeOpen.hashCode() : 0);
    result = 31 * result + (timeClose != null ? timeClose.hashCode() : 0);
    result = 31 * result + (type != null ? type.hashCode() : 0);
    result = 31 * result + (averageWaitTime != null ? averageWaitTime.hashCode() : 0);
    result = 31 * result + (valueProposition != null ? valueProposition.hashCode() : 0);
    result = 31 * result + (menu != null ? menu.hashCode() : 0);
    result = 31 * result + (dietaryRestrictions != null ? dietaryRestrictions.hashCode() : 0);
    result = 31 * result + (id != null ? id.hashCode() : 0);
    result = 31 * result + (offersTakeout != null ? offersTakeout.hashCode() : 0);
    result = 31 * result + (categories != null ? categories.hashCode() : 0);
    return result;
  }
}
