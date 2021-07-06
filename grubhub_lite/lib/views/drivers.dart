import 'package:flutter/material.dart';
import 'package:grubhub_lite/backend/database.dart';
import 'package:grubhub_lite/components/driverList.dart';
import 'package:grubhub_lite/models/driver.dart';

class Drivers extends StatefulWidget {
  _DriverState createState() => _DriverState();
}

class _DriverState extends State<Drivers> {
  List<Driver> drivers = [];

  _DriverState() {
    loadDrivers();
  }

  void loadDrivers() {
    getDrivers().then((values) => setState(() => drivers = values));
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
            title: Text('Drivers'),
            backgroundColor: Colors.cyan[900]!,
            actions: <Widget>[
              IconButton(
                  icon: Icon(Icons.refresh), onPressed: () => loadDrivers())
            ]),
        body: Padding(
          padding: const EdgeInsets.all(20),
          child: Center(
            child: DriverList(drivers: drivers),
          ),
        ));
  }
}
