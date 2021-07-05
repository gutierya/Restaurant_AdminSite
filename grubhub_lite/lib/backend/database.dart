import 'dart:math';
import 'dart:io';
import 'dart:convert';

import 'package:grubhub_lite/models/menuItem.dart';
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
