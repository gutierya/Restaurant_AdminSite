import 'package:flutter/material.dart';
import 'package:grubhub_lite/components/menuTile.dart';
import 'package:grubhub_lite/models/menuItem.dart';

class OrderItemList extends StatelessWidget {
  final int orderID;
  final List<MenuItem> items;

  OrderItemList({required this.orderID, required this.items});

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.center,
      crossAxisAlignment: CrossAxisAlignment.center,
      children: [
        Text("Menu for Oreder: $orderID",
            style: TextStyle(fontSize: 24, color: Colors.blue[900])),
        SizedBox(
          height: 10,
        ),
        SizedBox(
          height: 20,
        ),
        SizedBox(
          height: 20,
        ),
        Container(
            height: 720,
            decoration: BoxDecoration(
                borderRadius: BorderRadius.circular(20),
                border: Border.all(color: Colors.grey[700]!)),
            padding: const EdgeInsets.all(10),
            child: ListView.builder(
                itemCount: items.length,
                itemBuilder: (_, index) => MenuItemTile(item: items[index]))),
      ],
    );
  }
}
