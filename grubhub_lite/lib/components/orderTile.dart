import 'package:flutter/material.dart';
import 'package:grubhub_lite/models/order.dart';
import 'package:grubhub_lite/models/enums.dart';

class OrderTile extends StatelessWidget {
  final Order order;
  final int index;
  final onTap;

  OrderTile({required this.order, required this.index, required this.onTap});

  void handleTap() {
    this.onTap(index);
  }

  @override
  Widget build(BuildContext context) {
    return ListTile(
      shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(20)),
      leading: Icon(Icons.receipt),
      title: Text('Order ID: ${order.id}'),
      subtitle: Text('Order Status: ${toString(this.order.status)}'),
      trailing: Text('\$ ${order.orderTotal}'),
      onTap: handleTap,
    );
  }
}
