import 'package:flutter/material.dart';
import 'package:grubhub_lite/backend/database.dart';
import 'package:grubhub_lite/models/customer.dart';

class AddCustomerDialog extends StatefulWidget {
  _AddCustomerState createState() => _AddCustomerState();
}

class _AddCustomerState extends State<AddCustomerDialog> {
  String uuid = "";
  String name = "";
  String address = "";
  List<int> favoriteItems = [];
  List<int> favoriteRestaurants = [];
  List<int> orderHistory = [];

  void createCustomer() {
    final customer = Customer(
        address: address,
        name: name,
        uuid: uuid,
        favoriteItems: favoriteItems,
        favoriteRestaurants: favoriteRestaurants,
        orderHistory: orderHistory,
        id: 0);
    addCustomer(customer: customer);
    Navigator.of(context).pop();
  }

  @override
  Widget build(BuildContext context) {
    return AlertDialog(
      title: Text('Add Customer'),
      content: Column(
        mainAxisSize: MainAxisSize.min,
        children: <Widget>[
          TextField(
              decoration: InputDecoration(hintText: "Customer name...."),
              onChanged: (value) => name = value),
          TextField(
              decoration: InputDecoration(hintText: "Customer address...."),
              onChanged: (value) => address = value),
          TextField(
              decoration: InputDecoration(hintText: "Customer UUID...."),
              onChanged: (value) => uuid = value),
          TextField(
              decoration:
                  InputDecoration(hintText: "Favorite items ids (start at 12)"),
              onChanged: (value) {
                favoriteItems = value.split(',').map(int.parse).toList();
              }),
          TextField(
              decoration: InputDecoration(
                  hintText: "Favorite restaurants ids (start at 63)"),
              onChanged: (value) {
                favoriteRestaurants = value.split(',').map(int.parse).toList();
              }),
          TextField(
              decoration:
                  InputDecoration(hintText: "Order history ids (start at 42)"),
              onChanged: (value) {
                orderHistory = value.split(',').map(int.parse).toList();
              }),
        ],
      ),
      actions: [
        FlatButton(
            child: Text("Add Customer"),
            onPressed: createCustomer,
            color: Colors.green)
      ],
    );
  }
}
