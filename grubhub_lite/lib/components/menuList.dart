import 'package:flutter/material.dart';
import 'package:grubhub_lite/components/menuTile.dart';
import 'package:grubhub_lite/models/menuItem.dart';

class MenuList extends StatelessWidget {
  final int restaurantID;
  final onTap;
  final List<MenuItem> items;

  MenuList({required this.restaurantID, this.onTap, required this.items});

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.center,
      crossAxisAlignment: CrossAxisAlignment.center,
      children: [
        Text("Menu for Restaurant $restaurantID",
            style: TextStyle(fontSize: 24, color: Colors.amber[900])),
        SizedBox(
          height: 10,
        ),
        Row(
          mainAxisAlignment: MainAxisAlignment.center,
          mainAxisSize: MainAxisSize.max,
          children: [
            FlatButton(
                color: Colors.green,
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [Icon(Icons.add), Text("Menu Item")],
                ),
                onPressed: () {}),
            SizedBox(
              width: 50,
            ),
            FlatButton(
                color: Colors.red,
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [Icon(Icons.remove), Text("Menu Item")],
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
                itemCount: items.length,
                itemBuilder: (_, index) => MenuItemTile(item: items[index]))),
      ],
    );
  }
}
