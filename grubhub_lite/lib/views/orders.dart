import 'package:flutter/material.dart';
import 'package:grubhub_lite/backend/database.dart';
import 'package:grubhub_lite/components/customList.dart';
import 'package:grubhub_lite/components/menuTile.dart';
import 'package:grubhub_lite/components/orderTile.dart';
import 'package:grubhub_lite/components/removeDialog.dart';
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
    get<Order>(endPoint: Order.ordersPrefix)
        .then((orders) => setState(() => {this.orders = orders}));
  }

  void tilePressed(int index) async {
    get<MenuItem>(endPoint: Order.ordersPrefix + '${orders[index].id}/items')
        .then((items) => setState(() {
              selectedOrderMenuItems = items;
              _selectedIndex = index;
            }));
  }

  Widget buildOrderListWidget(
      {required dynamic parameter, dynamic index, dynamic onTap}) {
    return OrderTile(order: parameter, index: index, onTap: onTap);
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
                      child: CustomList<Order>(
                    items: orders,
                    title: 'Orders',
                    widgetForItems: buildOrderListWidget,
                    onTap: (index) => tilePressed(index),
                    removeElement: RemoveDialog<Order>(
                      action: (selected) => removeSelected(selected),
                      items: orders,
                    ),
                  )),
                  SizedBox(
                    width: 20,
                  ),
                  if (this.selectedOrderMenuItems.length > 0)
                    Expanded(
                        child: CustomList<MenuItem>(
                      items: selectedOrderMenuItems,
                      title: 'Menu For Order ID: ${orders[_selectedIndex].id}',
                      widgetForItems: buildMenuItem,
                      onTap: () => {},
                    ))
                ],
              ),
            ],
          ),
        ));
  }

  Widget buildMenuItem({index, onTap, required parameter}) {
    return MenuItemTile(item: parameter);
  }
}
