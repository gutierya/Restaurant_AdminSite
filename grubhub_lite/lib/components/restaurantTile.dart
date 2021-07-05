import 'package:flutter/material.dart';

class RestaurantTile extends StatelessWidget {
  final restaurant;
  final onTap;
  final index;

  RestaurantTile({this.restaurant, this.index, this.onTap});

  void handleTap() {
    this.onTap(this.index);
  }

  @override
  Widget build(BuildContext context) {
    return ListTile(
      shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(20)),
      leading: Icon(Icons.restaurant),
      title: Text(this.restaurant.name),
      subtitle: Text(this.restaurant.address),
      trailing: this.restaurant.isOpen ? Text("Open") : Text("Closed"),
      onTap: handleTap,
    );
  }
}
