import 'package:enum_to_string/enum_to_string.dart';

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
  return EnumToString.convertToString(type);
}
