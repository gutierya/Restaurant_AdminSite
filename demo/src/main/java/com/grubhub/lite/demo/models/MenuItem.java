package com.grubhub.lite.demo.models;

import jdk.jfr.Enabled;
import org.springframework.stereotype.Component;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;
import java.util.Objects;

/**
 * Class MenuItem
 */
@Entity
public class MenuItem {

  //
  // Fields
  //

  private String itemName;
  private String description;
  @ElementCollection
  private List<String> ingredients;
  private Integer calories;
  private Boolean isInStock;
  private String imageUrl;
  private Double price;
  @ElementCollection
  private List<Enums.DietaryRestrictions> dietaryRestrictions;
  private @Id
  @GeneratedValue
  Long id;
  private String category;
  private Long restaurantID;
  
  //
  // Constructors
  //
  public MenuItem () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of itemName
   * @param newVar the new value of itemName
   */
  public void setItemName (String newVar) {
    itemName = newVar;
  }

  /**
   * Get the value of itemName
   * @return the value of itemName
   */
  public String getItemName () {
    return itemName;
  }

  /**
   * Set the value of description
   * @param newVar the new value of description
   */
  public void setDescription (String newVar) {
    description = newVar;
  }

  /**
   * Get the value of description
   * @return the value of description
   */
  public String getDescription () {
    return description;
  }

  /**
   * Set the value of ingridiants
   * @param newVar the new value of ingridiants
   */
  public void setIngredients(List<String> newVar) {
    ingredients = newVar;
  }

  /**
   * Get the value of ingridiants
   * @return the value of ingridiants
   */
  public List<String> getIngredients() {
    return ingredients;
  }

  /**
   * Set the value of calories
   * @param newVar the new value of calories
   */
  public void setCalories (Integer newVar) {
    calories = newVar;
  }

  /**
   * Get the value of calories
   * @return the value of calories
   */
  public Integer getCalories () {
    return calories;
  }

  /**
   * Set the value of isInStock
   * @param newVar the new value of isInStock
   */
  public void setIsInStock (Boolean newVar) {
    isInStock = newVar;
  }

  /**
   * Get the value of isInStock
   * @return the value of isInStock
   */
  public Boolean getIsInStock () {
    return isInStock;
  }

  /**
   * Set the value of imageUrl
   * @param newVar the new value of imageUrl
   */
  public void setImageUrl (String newVar) {
    imageUrl = newVar;
  }

  /**
   * Get the value of imageUrl
   * @return the value of imageUrl
   */
  public String getImageUrl () {
    return imageUrl;
  }

  /**
   * Set the value of price
   * @param newVar the new value of price
   */
  public void setPrice (Double newVar) {
    price = newVar;
  }

  /**
   * Get the value of price
   * @return the value of price
   */
  public Double getPrice () {
    return price;
  }

  /**
   * Set the value of diataryRestrictions
   * @param newVar the new value of diataryRestrictions
   */
  public void setDietaryRestrictions(List<Enums.DietaryRestrictions> newVar) {
    dietaryRestrictions = newVar;
  }

  /**
   * Get the value of diataryRestrictions
   * @return the value of diataryRestrictions
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
   * Set the value of category
   * @param newVar the new value of category
   */
  public void setCategory (String newVar) {
    category = newVar;
  }

  /**
   * Get the value of category
   * @return the value of category
   */
  public String getCategory () {
    return category;
  }

  /**
   * Set the value of resturantID
   * @param newVar the new value of resturantID
   */
  public void setRestaurantID(Long newVar) {
    restaurantID = newVar;
  }

  /**
   * Get the value of resturantID
   * @return the value of resturantID
   */
  public Long getRestaurantID() {
    return restaurantID;
  }

  //
  // Other methods
  //


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    MenuItem menuItem = (MenuItem) o;

    if (!Objects.equals(itemName, menuItem.itemName)) return false;
    if (!Objects.equals(description, menuItem.description)) return false;
    if (!Objects.equals(ingredients, menuItem.ingredients)) return false;
    if (!Objects.equals(calories, menuItem.calories)) return false;
    if (!Objects.equals(isInStock, menuItem.isInStock)) return false;
    if (!Objects.equals(imageUrl, menuItem.imageUrl)) return false;
    if (!Objects.equals(price, menuItem.price)) return false;
    if (!Objects.equals(dietaryRestrictions, menuItem.dietaryRestrictions))
      return false;
    if (!Objects.equals(id, menuItem.id)) return false;
    if (!Objects.equals(category, menuItem.category)) return false;
    return Objects.equals(restaurantID, menuItem.restaurantID);
  }

  @Override
  public int hashCode() {
    int result = itemName != null ? itemName.hashCode() : 0;
    result = 31 * result + (description != null ? description.hashCode() : 0);
    result = 31 * result + (ingredients != null ? ingredients.hashCode() : 0);
    result = 31 * result + (calories != null ? calories.hashCode() : 0);
    result = 31 * result + (isInStock != null ? isInStock.hashCode() : 0);
    result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
    result = 31 * result + (price != null ? price.hashCode() : 0);
    result = 31 * result + (dietaryRestrictions != null ? dietaryRestrictions.hashCode() : 0);
    result = 31 * result + (id != null ? id.hashCode() : 0);
    result = 31 * result + (category != null ? category.hashCode() : 0);
    result = 31 * result + (restaurantID != null ? restaurantID.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "MenuItem{" +
            "itemName='" + itemName + '\'' +
            ", description='" + description + '\'' +
            ", ingredients=" + ingredients +
            ", calories=" + calories +
            ", isInStock=" + isInStock +
            ", imageUrl='" + imageUrl + '\'' +
            ", price=" + price +
            ", dietaryRestrictions=" + dietaryRestrictions +
            ", id=" + id +
            ", category='" + category + '\'' +
            ", restaurantID=" + restaurantID +
            '}';
  }
}
