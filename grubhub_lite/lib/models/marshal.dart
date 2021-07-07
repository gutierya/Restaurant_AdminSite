import 'package:flutter/material.dart';
import 'package:grubhub_lite/models/customer.dart';
import 'package:grubhub_lite/models/driver.dart';
import 'package:grubhub_lite/models/menuItem.dart';
import 'package:grubhub_lite/models/order.dart';
import 'package:grubhub_lite/models/payment.dart';
import 'package:grubhub_lite/models/restaurant.dart';

import 'User.dart';

class Marshal {
  static Type typeOf<T>() => T;

  static Map<String, dynamic> toJson<T>(T object) {
    switch (typeOf<T>()) {
      case User:
        return (object as User).toJson();
      case Customer:
        return (object as Customer).toJson();
      case Driver:
        return (object as Driver).toJson();
      case Restaurant:
        return (object as Restaurant).toJson();
      case Order:
        return (object as Order).toJson();
      case MenuItem:
        return (object as MenuItem).toJson();
      case Payment:
        return (object as Payment).toJson();
      default:
        throw new Exception('Unsupported type: ${object.runtimeType}');
    }
  }

  static dynamic fromJson<T>(Map<String, dynamic> json) {
    switch (typeOf<T>()) {
      case User:
        return User.fromJson(json);
      case Customer:
        return Customer.fromJson(json);
      case Driver:
        return Driver.fromJson(json);
      case Restaurant:
        return Restaurant.fromJson(json);
      case Order:
        return Order.fromJson(json);
      case MenuItem:
        return MenuItem.fromJson(json);
      case Payment:
        return Payment.fromJson(json);
      default:
        throw new Exception('Unsupported type: ${T.runtimeType}');
    }
  }

  static int getID<T>(T object) {
    switch (typeOf<T>()) {
      case User:
        return (object as User).id;
      case Customer:
        return (object as Customer).id;
      case Driver:
        return (object as Driver).id;
      case Restaurant:
        return (object as Restaurant).id;
      case Order:
        return (object as Order).id;
      case MenuItem:
        return (object as MenuItem).id;
      case Payment:
        return (object as Payment).id;
      default:
        throw new Exception('Unsupported type: ${T.runtimeType}');
    }
  }

  static Color getTypeColor<T>() {
    switch (typeOf<T>()) {
      case User:
        return Colors.white;
      case Customer:
        return Colors.purple[900]!;
      case Driver:
        return Colors.cyan[900]!;
      case Restaurant:
        return Colors.amber[900]!;
      case Order:
        return Colors.blue[900]!;
      case MenuItem:
        return Colors.amber[900]!;
      case Payment:
        return Colors.green[900]!;
      default:
        throw new Exception('Unsupported type: ${T.runtimeType}');
    }
  }

  static String getTypeEndPoint<T>() {
    switch (typeOf<T>()) {
      case User:
        return 'users/';
      case Customer:
        return Customer.customerPrefix;
      case Driver:
        return Driver.driverPrefix;
      case Restaurant:
        return Restaurant.restaurantPrefix;
      case Order:
        return Order.ordersPrefix;
      case MenuItem:
        return MenuItem.menuItemPrefix;
      case Payment:
        return Payment.paymentsPrefix;
      default:
        throw new Exception('Unsupported type: ${T.runtimeType}');
    }
  }
}
