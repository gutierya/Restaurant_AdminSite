import 'dart:math';
import 'dart:io';
import 'dart:convert';

import 'package:grubhub_lite/models/customer.dart';
import 'package:grubhub_lite/models/driver.dart';
import 'package:grubhub_lite/models/menuItem.dart';
import 'package:grubhub_lite/models/order.dart';
import 'package:grubhub_lite/models/payment.dart';
import 'package:http/http.dart' as http;
import 'package:firebase_auth/firebase_auth.dart';
import 'package:grubhub_lite/models/restaurant.dart';

final FirebaseAuth _auth = FirebaseAuth.instance;

Future<UserCredential?> register(String email, String password) async {
  try {
    UserCredential registeredUser = await _auth.createUserWithEmailAndPassword(
        email: email, password: password);
    return registeredUser;
  } on FirebaseAuthException catch (exception) {
    print("Function Register: " + exception.message!);
    return null;
  }
}

Future<UserCredential?> login(String email, String password) async {
  try {
    UserCredential loggedUser = await _auth.signInWithEmailAndPassword(
        email: email, password: password);
    return loggedUser;
  } on FirebaseAuthException catch (exception) {
    print("Function Login: " + exception.message!);
    return null;
  }
}

//Loads restarants from the database
Future<List<Restaurant>> getRestaurants() async {
  List<Restaurant> restaurants = [];
  var response =
      await http.get(Uri.parse('http://localhost:8080/restaurants/'));
  // print("Request Reponse: $response");
  // print("Request Body: ${response.body}");
  if (response.statusCode == 200) {
    String jsonString = response.body;
    List<dynamic> body = json.decode(jsonString);
    restaurants = body.map((element) => Restaurant.fromJson(element)).toList();
    return restaurants;
  } else {
    print("Get Restaurants: Response ${response.statusCode}");
    return [];
  }
}

Future<List<MenuItem>> getMenuItems({required int restaurantId}) async {
  List<MenuItem> menuItems = [];
  print('Getting menu for Restaurant ID: $restaurantId');
  var response = await http
      .get(Uri.parse('http://localhost:8080/restaurants/$restaurantId/menu'));
  if (response.statusCode == 200) {
    String jsonString = response.body;
    List<dynamic> body = json.decode(jsonString);
    menuItems = body.map((element) => MenuItem.fromJson(element)).toList();
    return menuItems;
  } else {
    print("Get Menu Items: Response ${response.statusCode}");
    return [];
  }
}

Future<List<Payment>> getPayments() async {
  List<Payment> payments = [];
  var response = await http.get(Uri.parse('http://localhost:8080/payments/'));
  print('Get Payments Response: ${response.toString()}');
  if (response.statusCode == 200) {
    String jsonString = response.body;
    List<dynamic> body = json.decode(jsonString);
    payments = body.map((element) => Payment.fromJson(element)).toList();
    return payments;
  } else {
    print("Get Payments: Response ${response.statusCode}");
    return [];
  }
}

Future<List<Customer>> getCustomers() async {
  List<Customer> customers = [];
  var response = await http.get(Uri.parse('http://localhost:8080/customers/'));
  print('Get Customers Response: ${response.toString()}');
  if (response.statusCode == 200) {
    String jsonString = response.body;
    List<dynamic> body = json.decode(jsonString);
    customers = body.map((element) => Customer.fromJson(element)).toList();
    return customers;
  } else {
    print("Get Customers: Response ${response.statusCode}");
    return [];
  }
}

Future<List<Driver>> getDrivers() async {
  List<Driver> drivers = [];
  var response = await http.get(Uri.parse('http://localhost:8080/drivers/'));
  print('Get Drivers Response: ${response.toString()}');
  if (response.statusCode == 200) {
    String jsonString = response.body;
    List<dynamic> body = json.decode(jsonString);
    drivers = body.map((element) => Driver.fromJson(element)).toList();
    return drivers;
  } else {
    print("Get Drivers: Response ${response.statusCode}");
    return [];
  }
}

Future<void> addPayment({required Payment payment}) async {
  //print('Adding Payment: ${payment.toString()}');
  print('Payment Json: ${json.encode(payment.toJson())}');
  var response = await http.post(Uri.parse('http://localhost:8080/payments/'),
      body: json.encode(payment.toJson()),
      headers: {'Content-Type': 'application/json'});

  if (response.statusCode == 200) {
    print('Payment Added');
  } else {
    print(
        'Response Code: ${response.statusCode}, Response Headers: ${response.headers}');
  }
}

Future<void> deletePayment({required Payment payment}) async {
  print('Deleting Payment: ${payment.toString()}');
  var response = await http
      .delete(Uri.parse('http://localhost:8080/payments/${payment.id}'));
  if (response.statusCode == 200) {
    print('Payment Deleted');
  } else {
    print(
        'Response Code: ${response.statusCode}, Response Headers: ${response.headers}');
  }
}

Future<void> addCustomer({required Customer customer}) async {
  print('Adding Customer: ${json.encode(customer.toJson())}');
  var response = await http.post(Uri.parse('http://localhost:8080/customers/'),
      body: json.encode(customer.toJson()),
      headers: {'Content-Type': 'application/json'});
  if (response.statusCode == 200) {
    print('Customer Added');
  } else {
    print(
        'Response Code: ${response.statusCode}, Response Headers: ${response.headers}');
  }
}

Future<void> deleteCustomer({required Customer customer}) async {
  print('Deleting Customer: ${customer.toString()}');
  var response = await http.delete(
      Uri.parse('http://localhost:8080/customers/${customer.id}'),
      headers: {'Content-Type': 'application/json'});
  if (response.statusCode == 200) {
    print('Customer Deleted');
  } else {
    print(
        'Response Code: ${response.statusCode}, Response Headers: ${response.headers}');
  }
}

Future<List<Order>> getOrders() async {
  List<Order> orders = [];
  var response = await http.get(Uri.parse('http://localhost:8080/orders/'));
  print('Get Orders Response: ${response.toString()}');
  if (response.statusCode == 200) {
    String jsonString = response.body;
    List<dynamic> body = json.decode(jsonString);
    orders = body.map((element) => Order.fromJson(element)).toList();
    return orders;
  } else {
    print("Get Orders: Response ${response.statusCode}");
    return [];
  }
}

Future<List<MenuItem>> getOrderItems({required Order order}) async {
  List<MenuItem> menuItems = [];
  print('Getting menu for Order ID: ${order.id}');
  var response = await http
      .get(Uri.parse('http://localhost:8080/orders/${order.id}/items'));
  if (response.statusCode == 200) {
    String jsonString = response.body;
    List<dynamic> body = json.decode(jsonString);
    menuItems = body.map((element) => MenuItem.fromJson(element)).toList();
    return menuItems;
  } else {
    print("Get Menu Items: Response ${response.statusCode}");
    return [];
  }
}

Future<void> addDriver({required Driver driver}) async {
  print('Adding Driver: ${json.encode(driver.toJson())}');
  var response = await http.post(Uri.parse('http://localhost:8080/drivers/'),
      body: json.encode(driver.toJson()),
      headers: {'Content-Type': 'application/json'});
  if (response.statusCode == 200) {
    print('Driver Added');
  } else {
    print(
        'Response Code: ${response.statusCode}, Response Headers: ${response.headers}');
  }
}

Future<void> deleteDriver({required Driver driver}) async {
  print('Deleting Driver: ${driver.toString()}');
  var response = await http.delete(
      Uri.parse('http://localhost:8080/drivers/${driver.id}'),
      headers: {'Content-Type': 'application/json'});
  if (response.statusCode == 200) {
    print('Driver Deleted');
  } else {
    print(
        'Response Code: ${response.statusCode}, Response Headers: ${response.headers}');
  }
}
