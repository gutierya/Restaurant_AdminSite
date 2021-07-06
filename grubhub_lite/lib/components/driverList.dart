import 'package:flutter/material.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';
import 'package:grubhub_lite/dialogs/addDriverDialog.dart';
import 'package:grubhub_lite/dialogs/removeDriver.dart';
import 'package:grubhub_lite/models/driver.dart';

class DriverList extends StatelessWidget {
  final List<Driver> drivers;

  DriverList({required this.drivers});

  Widget driverTile({required Driver driver}) {
    return Padding(
      padding: const EdgeInsets.all(8.0),
      child: Card(
        child: Row(
            mainAxisAlignment: MainAxisAlignment.spaceAround,
            children: <Widget>[
              FaIcon(FontAwesomeIcons.car),
              Column(children: [
                SizedBox(height: 10),
                Text('Driver ID: ${driver.id}'),
                Text('Rating: ${driver.rating}'),
                Text('Driver Vehicle Type: ${driver.vehicleType}'),
                Text('estimatedArrivalTime: ${driver.estimatedArrivalTime}'),
                SizedBox(height: 10),
              ])
            ]),
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.center,
      crossAxisAlignment: CrossAxisAlignment.center,
      children: [
        Text("Drivers",
            style: TextStyle(fontSize: 24, color: Colors.cyan[900]!)),
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
                  children: [Icon(Icons.add), Text("Driver")],
                ),
                onPressed: () => showDialog(
                    context: context, builder: (context) => AddDriverDialog())),
            SizedBox(
              width: 50,
            ),
            FlatButton(
                color: Colors.red,
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [Icon(Icons.remove), Text("Driver")],
                ),
                onPressed: () => showDialog(
                    context: context,
                    builder: (context) => RemoveDriverDialog(
                          drivers: drivers,
                        ))),
          ],
        ),
        SizedBox(
          height: 20,
        ),
        Container(
            height: 700,
            width: 500,
            decoration: BoxDecoration(
                borderRadius: BorderRadius.circular(20),
                border: Border.all(color: Colors.grey[700]!)),
            padding: const EdgeInsets.all(10),
            child: ListView.builder(
                itemCount: drivers.length,
                itemBuilder: (_, index) => driverTile(
                      driver: drivers[index],
                    ))),
      ],
    );
  }
}
