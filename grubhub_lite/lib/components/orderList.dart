import 'package:flutter/material.dart';
import 'package:grubhub_lite/components/orderTile.dart';
import 'package:grubhub_lite/models/order.dart';

class OrderList extends StatelessWidget {
  final List<Order> orders;
  final tileOnTap;

  OrderList({required this.orders, required this.tileOnTap});

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.center,
      crossAxisAlignment: CrossAxisAlignment.center,
      children: [
        Text("Orders", style: TextStyle(fontSize: 24, color: Colors.blue[900])),
        SizedBox(
          height: 10,
        ),
        Row(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            FlatButton(
                color: Colors.green,
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [Icon(Icons.add), Text("Order")],
                ),
                onPressed: () {}),
            SizedBox(
              width: 50,
            ),
            FlatButton(
                color: Colors.red,
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [Icon(Icons.remove), Text("Order")],
                ),
                onPressed: () {}),
          ],
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
                itemCount: orders.length,
                itemBuilder: (_, index) => OrderTile(
                    order: orders[index], index: index, onTap: tileOnTap))),
      ],
    );
  }
}
