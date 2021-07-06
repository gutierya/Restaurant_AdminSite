import 'package:flutter/material.dart';
import 'package:grubhub_lite/components/addRestaurantDialog.dart';
import 'package:grubhub_lite/components/restaurantTile.dart';
import 'package:grubhub_lite/models/restaurant.dart';

class RestaurantList extends StatelessWidget {
  final List<Restaurant> restaurants;
  final tileOnTap;

  RestaurantList({required this.restaurants, this.tileOnTap});

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.center,
      crossAxisAlignment: CrossAxisAlignment.center,
      children: [
        Text("Restaurans Nearby",
            style: TextStyle(fontSize: 24, color: Colors.amber[900])),
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
                  children: [Icon(Icons.add), Text("Restaurant")],
                ),
                onPressed: () {}),
            SizedBox(
              width: 50,
            ),
            FlatButton(
                color: Colors.red,
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [Icon(Icons.remove), Text("Restaurant")],
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
                itemCount: restaurants.length,
                itemBuilder: (_, index) => RestaurantTile(
                    restaurant: restaurants[index],
                    index: index,
                    onTap: tileOnTap))),
      ],
    );
  }
}
