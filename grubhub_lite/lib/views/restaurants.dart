import 'package:flutter/material.dart';
import 'package:grubhub_lite/backend/database.dart';
import 'package:grubhub_lite/components/customList.dart';
import 'package:grubhub_lite/components/menuTile.dart';
import 'package:grubhub_lite/components/removeDialog.dart';
import 'package:grubhub_lite/components/restaurantTile.dart';
import 'package:grubhub_lite/models/menuItem.dart';
import 'package:grubhub_lite/models/restaurant.dart';

class RestaurantView extends StatefulWidget {
  _RestaurantViewState createState() => _RestaurantViewState();
}

class _RestaurantViewState extends State<RestaurantView> {
  List<Restaurant> restaurants = [];
  List<MenuItem> selectedRestaurantMenuItems = [];
  int _selectedIndex = 0;

  _RestaurantViewState() {
    loadRestaurants();
  }

  void loadRestaurants() {
    get<Restaurant>(endPoint: Restaurant.restaurantPrefix)
        .then((restaurants) => setState(() {
              this.restaurants = restaurants;
            }));
  }

  void tilePressed(int index) async {
    get<MenuItem>(
            endPoint:
                Restaurant.restaurantPrefix + '${restaurants[index].id}/menu')
        .then((items) => setState(() {
              selectedRestaurantMenuItems = items;
              _selectedIndex = index;
            }));
  }

  Widget buildMenuItem(
      {required dynamic parameter, dynamic index, dynamic onTap}) {
    return new MenuItemTile(item: parameter);
  }

  Widget buildRestaurantTile(
      {required dynamic parameter, dynamic index, dynamic onTap}) {
    return RestaurantTile(
      restaurant: parameter,
      index: index,
      onTap: onTap,
    );
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
                    child: CustomList<Restaurant>(
                      items: this.restaurants,
                      title: 'Restaurants',
                      widgetForItems: buildRestaurantTile,
                      onTap: (index) => tilePressed(index),
                      removeElement: RemoveDialog(
                        items: restaurants,
                        action: (selected) => removeSelected(selected),
                      ),
                    ),
                  ),
                  SizedBox(
                    width: 20,
                  ),
                  if (this.selectedRestaurantMenuItems.length > 0)
                    Expanded(
                        child: CustomList<MenuItem>(
                      items: selectedRestaurantMenuItems,
                      title:
                          'Menu For Restaurant ID: ${restaurants[_selectedIndex].id}',
                      widgetForItems: buildMenuItem,
                      removeElement: RemoveDialog<MenuItem>(
                          items: selectedRestaurantMenuItems,
                          action: (selected) => removeSelected(selected)),
                      onTap: () => {},
                    ))
                ],
              ),
            ],
          ),
        ));
  }
}
