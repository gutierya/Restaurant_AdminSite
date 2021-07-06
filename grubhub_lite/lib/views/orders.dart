import 'package:flutter/material.dart';
import 'package:grubhub_lite/backend/database.dart';
import 'package:grubhub_lite/components/menuList.dart';
import 'package:grubhub_lite/components/orderItemsList.dart';
import 'package:grubhub_lite/components/orderList.dart';
import 'package:grubhub_lite/models/menuItem.dart';
import 'package:grubhub_lite/models/order.dart';

class Orders extends StatefulWidget {
  _OrderState createState() => new _OrderState();
}

class _OrderState extends State<Orders> {
  List<Order> orders = [];
  List<MenuItem> selectedOrderMenuItems = [];
  int _selectedIndex = 1;

  _OrderState() {
    loadOrders();
  }

  void loadOrders() {
    getOrders().then((result) => setState(() => {orders = result}));
  }

  void tilePressed(int index) async {
    getOrderItems(order: orders[index]).then((items) => setState(() {
          selectedOrderMenuItems = items;
          _selectedIndex = index;
        }));
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text("Orders"),
          backgroundColor: Colors.blue[900]!,
        ),
        body: Padding(
          padding: const EdgeInsets.all(20.0),
          child: Column(
            children: [
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                crossAxisAlignment: CrossAxisAlignment.center,
                children: [
                  Expanded(
                    child: OrderList(
                      orders: orders,
                      tileOnTap: tilePressed,
                    ),
                  ),
                  SizedBox(
                    width: 20,
                  ),
                  if (this.selectedOrderMenuItems.length > 0)
                    Expanded(
                        child: OrderItemList(
                            orderID: orders[_selectedIndex].id,
                            items: selectedOrderMenuItems))
                ],
              ),
            ],
          ),
        ));
  }
}
