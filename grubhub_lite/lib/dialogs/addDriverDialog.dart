import 'package:flutter/material.dart';
import 'package:grubhub_lite/backend/database.dart';
import 'package:grubhub_lite/models/driver.dart';
import 'package:grubhub_lite/models/enums.dart';

class AddDriverDialog extends StatefulWidget {
  _AddDriverState createState() => _AddDriverState();
}

class _AddDriverState extends State<AddDriverDialog> {
  String uuid = "";
  int rating = 0;
  VehicleType vehicleType = VehicleType.Car;
  String estimatedArrivalTime = "";

  void createDriver() {
    final driver = Driver(
        uuid: uuid,
        rating: rating,
        vehicleType: vehicleType,
        estimatedArrivalTime: estimatedArrivalTime,
        id: 0);
    addDriver(driver: driver);
    Navigator.of(context).pop();
  }

  @override
  Widget build(BuildContext context) {
    return AlertDialog(
      title: Text('Add Driver'),
      content: Column(
        mainAxisSize: MainAxisSize.min,
        children: <Widget>[
          TextField(
              decoration: InputDecoration(hintText: "Driver UUID...."),
              onChanged: (value) => uuid = value),
          TextField(
              decoration: InputDecoration(hintText: "Driver Rating..."),
              onChanged: (value) {
                rating = int.parse(value);
              }),
          TextField(
              decoration:
                  InputDecoration(hintText: "Arrival Time (Java Date Plz)...."),
              onChanged: (value) {
                estimatedArrivalTime = value;
              }),
          DropdownButton<VehicleType>(
            value: vehicleType,
            icon: const Icon(Icons.arrow_downward),
            iconSize: 24,
            elevation: 16,
            underline: Container(
              height: 2,
              color: Colors.cyan[900],
            ),
            onChanged: (newValue) => setState(() => vehicleType = newValue!),
            items: VehicleType.values
                .map<DropdownMenuItem<VehicleType>>((VehicleType value) {
              return DropdownMenuItem<VehicleType>(
                value: value,
                child: Text(toString(value)),
              );
            }).toList(),
          ),
        ],
      ),
      actions: [
        FlatButton(
            child: Text("Add Driver"),
            onPressed: createDriver,
            color: Colors.green)
      ],
    );
  }
}
