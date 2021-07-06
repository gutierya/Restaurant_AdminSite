import 'package:flutter/material.dart';
import 'package:grubhub_lite/backend/database.dart';
import 'package:grubhub_lite/components/menuList.dart';
import 'package:grubhub_lite/components/restaurantList.dart';
import 'package:grubhub_lite/models/menuItem.dart';
import 'package:grubhub_lite/models/restaurant.dart';

class RestaurantView extends StatefulWidget {
  _RestaurantViewState createState() => _RestaurantViewState();
}

class _RestaurantViewState extends State<RestaurantView> {
  List<Restaurant> restaurants = [];
  List<MenuItem> selectedRestaurantMenuItems = [];
  int _selectedIndex = 1;

  _RestaurantViewState() {
    getRestaurants().then((result) => setState(() => {restaurants = result}));
  }

  void tilePressed(int index) async {
    getMenuItems(restaurantId: restaurants[index].id)
        .then((items) => setState(() {
              selectedRestaurantMenuItems = items;
              _selectedIndex = index;
            }));
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text("Restaurant Administration"),
          backgroundColor: Colors.amber[900]!,
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
                    child: RestaurantList(
                      restaurants: restaurants,
                      tileOnTap: tilePressed,
                    ),
                  ),
                  SizedBox(
                    width: 20,
                  ),
                  if (this.selectedRestaurantMenuItems.length > 0)
                    Expanded(
                      child: MenuList(
                          restaurantID: restaurants[_selectedIndex].id,
                          items: selectedRestaurantMenuItems),
                    )
                ],
              ),
            ],
          ),
        ));
  }
}
