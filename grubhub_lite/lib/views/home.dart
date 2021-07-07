import 'package:flutter/material.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';
import 'package:grubhub_lite/components/sectionButton.dart';
import 'package:grubhub_lite/views/customers.dart';
import 'package:grubhub_lite/views/drivers.dart';
import 'package:grubhub_lite/views/orders.dart';
import 'package:grubhub_lite/views/payments.dart';
import 'package:grubhub_lite/views/restaurants.dart';

class HomeScreen extends StatefulWidget {
  _HomeScreenState createState() => new _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  ScaffoldState _scaffoldState = new ScaffoldState();

  final List<String> buttonStrings = [
    'Restaurants',
    'Orders',
    'Payments',
    'Customers',
    'Drivers',
  ];
  final List<Color> buttonColors = [
    Colors.amber[900]!,
    Colors.blue[900]!,
    Colors.green[900]!,
    Colors.purple[900]!,
    Colors.cyan[900]!
  ];

  final List<IconData> buttonIcons = [
    Icons.restaurant,
    Icons.receipt,
    FontAwesomeIcons.dollarSign,
    FontAwesomeIcons.user,
    FontAwesomeIcons.car,
  ];
  final List<dynamic> buttonActions = [
    RestaurantView(),
    Orders(),
    Payments(),
    Customers(),
    Drivers()
  ];

  List<Widget> buildButtons() {
    List<Widget> buttons = [];
    for (int i = 0; i < this.buttonStrings.length; i++) {
      buttons.add(HomeScreenButton(
          text: buttonStrings[i],
          iconData: buttonIcons[i],
          color: buttonColors[i],
          onTap: () => Navigator.of(context).push(
              MaterialPageRoute(builder: (context) => buttonActions[i]))));
    }
    return buttons;
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(title: Text("GrubHub Lite Admin Panel")),
        //Grid view with 3 columns
        body: Padding(
          padding: const EdgeInsets.all(20.0),
          child: GridView.count(
              mainAxisSpacing: 20.0,
              crossAxisSpacing: 20.0,
              crossAxisCount: 5,
              children: buildButtons()),
        ));
  }
}
