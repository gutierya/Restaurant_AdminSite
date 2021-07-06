import 'package:flutter/material.dart';
import 'package:grubhub_lite/backend/database.dart';
import 'package:grubhub_lite/models/driver.dart';

class RemoveDriverDialog extends StatefulWidget {
  final List<Driver> drivers;
  RemoveDriverDialog({required this.drivers});
  _RemoveDriverDialogState createState() =>
      _RemoveDriverDialogState(drivers: this.drivers);
}

class _RemoveDriverDialogState extends State<RemoveDriverDialog> {
  late Driver _selectedDriver;
  List<Driver> drivers;

  _RemoveDriverDialogState({required this.drivers}) {
    _selectedDriver = drivers[0];
  }

  void handleDelete() {
    deleteDriver(driver: _selectedDriver);
    Navigator.of(context).pop();
  }

  @override
  Widget build(BuildContext context) {
    return AlertDialog(
      title: Text('Remove Driver'),
      content: Column(
        mainAxisSize: MainAxisSize.min,
        children: <Widget>[
          DropdownButton<Driver>(
            value: _selectedDriver,
            icon: const Icon(Icons.arrow_downward),
            iconSize: 24,
            elevation: 16,
            underline: Container(
              height: 2,
              color: Colors.cyan[900],
            ),
            onChanged: (newValue) =>
                setState(() => _selectedDriver = newValue!),
            items: drivers.map<DropdownMenuItem<Driver>>((Driver value) {
              return DropdownMenuItem<Driver>(
                value: value,
                child: Text('Driver ID: ${value.id}'),
              );
            }).toList(),
          ),
        ],
      ),
      actions: [
        FlatButton(
            child: Text("Delete Driver"),
            onPressed: handleDelete,
            color: Colors.red)
      ],
    );
  }
}
