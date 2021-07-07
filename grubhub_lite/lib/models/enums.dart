import 'package:enum_to_string/enum_to_string.dart';
import 'package:flutter/material.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';

enum Cuisine { American, Chinese, Japanese, Korean, Latin, Hispanic, FastFood }
enum ValueProp { Cheap, Medium, HighEnd, Expensive }
enum DietaryRestrictions { NA, DairyFree, GlutenFree, Vegan, Vegetarian }
enum VehicleType { Scooter, Bicycle, Car }
enum OrderStatus {
  Received,
  PaymentReceived,
  Cooking,
  AwaitingPickUp,
  InTransit,
  Delivered,
  Cancelled
}
enum PaymentType { CreditCard, PayPal, GooglePay, ApplePay }
enum PaymentStatus { Completed, InProgress, Error, Declined }

T enumFromString<T>(Iterable<T> values, String value) {
  return values.firstWhere((type) => type.toString().split(".").last == value,
      orElse: () => throw new Exception("Invalid value: " + value));
}

String toString<T>(T type) {
  return type.toString().split(".").last;
}

IconData getPaymentTypeIcon(PaymentType type) {
  if (type == PaymentType.CreditCard)
    return FontAwesomeIcons.creditCard;
  else if (type == PaymentType.ApplePay) {
    return FontAwesomeIcons.applePay;
  } else if (type == PaymentType.GooglePay) {
    return FontAwesomeIcons.googlePay;
  } else if (type == PaymentType.PayPal) {
    return FontAwesomeIcons.paypal;
  } else
    return FontAwesomeIcons.cashRegister;
}
