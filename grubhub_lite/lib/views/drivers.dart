import 'package:flutter/material.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';
import 'package:grubhub_lite/backend/database.dart';
import 'package:grubhub_lite/components/customList.dart';
import 'package:grubhub_lite/components/customListTile.dart';
import 'package:grubhub_lite/components/removeDialog.dart';
import 'package:grubhub_lite/dialogs/addDriverDialog.dart';
import 'package:grubhub_lite/models/driver.dart';
import 'package:grubhub_lite/models/enums.dart';

class Drivers extends StatefulWidget {
  _DriverState createState() => _DriverState();
}

class _DriverState extends State<Drivers> {
  List<Driver> drivers = [];

  _DriverState() {
    loadDrivers();
  }

  void loadDrivers() {
    get<Driver>(endPoint: Driver.driverPrefix)
        .then((drivers) => setState(() => this.drivers = drivers));
  }

  Widget buildDriverTile(
      {required dynamic parameter, dynamic index, dynamic onTap}) {
    return CustomListTile(
        leadingIcon: FontAwesomeIcons.car,
        title: 'Driver ID ${parameter.id}',
        subTitle: 'Behicle Type: ${toString(parameter.vehicleType)}',
        trailing: Text("Rating: ${parameter.rating}"),
        onTap: onTap);
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
            child: CustomList<Driver>(
              items: drivers,
              title: 'Drivers',
              widgetForItems: buildDriverTile,
              onTap: () => {},
              addElement: AddDriverDialog(),
              removeElement: RemoveDialog<Driver>(
                items: drivers,
                action: (selected) => removeSelected(selected),
              ),
            ),
          ),
        ));
  }
}
