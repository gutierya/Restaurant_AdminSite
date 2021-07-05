package com.grubhub.lite.demo.models;



public interface Enums {

    public enum Cuisine {
        American, Chinese, Japanese, Korean, Latin, Hispanic, FastFood
    }

    public enum ValueProp {
        Cheap, Medium, HighEnd, Expensive
    }

    public enum DietaryRestrictions {
        DairyFree, GlutenFree, Vegan, Vegetarian, NA
    }

    public enum VehicleType {
        Scooter, Bicycle, Car
    }

    public enum OrderStatus{
        Received,  PaymentReceived, Cooking, AwaitingPickUp, InTransit, Delivered, Cancelled,
    }

    public enum PaymentType {
        CreditCard, PayPal, GooglePay, ApplePay
    }

    public enum PaymentStatus  {
        Completed, InProgress, Error, Declined
    }





}
