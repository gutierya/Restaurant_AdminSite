import 'package:flutter/material.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';
import 'package:grubhub_lite/components/customList.dart';
import 'package:grubhub_lite/components/customListTile.dart';
import 'package:grubhub_lite/components/removeDialog.dart';
import 'package:grubhub_lite/dialogs/addCustomerDialog.dart';
import 'package:grubhub_lite/models/customer.dart';
import 'package:grubhub_lite/backend/database.dart';

class Customers extends StatefulWidget {
  _CustomerState createState() => _CustomerState();
}

class _CustomerState extends State<Customers> {
  List<Customer> customers = [];

  _CustomerState() {
    loadCustomers();
  }

  void loadCustomers() {
    get<Customer>(endPoint: Customer.customerPrefix)
        .then((value) => setState(() => customers = value));
  }

  Widget buildCustomerTile(
      {required dynamic parameter, dynamic index, dynamic onTap}) {
    return new CustomListTile(
        leadingIcon: FontAwesomeIcons.user,
        title: parameter.name,
        subTitle: parameter.address,
        trailing: Text('ID: ${parameter.id}'),
        onTap: onTap);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text('Customers'),
          backgroundColor: Colors.purple[900]!,
          actions: [
            IconButton(
                icon: Icon(Icons.refresh), onPressed: () => loadCustomers())
          ],
        ),
        body: Padding(
          padding: const EdgeInsets.all(20),
          child: Center(
            child: CustomList<Customer>(
              items: customers,
              title: 'Customers',
              widgetForItems: buildCustomerTile,
              onTap: () {},
              addElement: AddCustomerDialog(),
              removeElement: RemoveDialog<Customer>(
                items: customers,
                action: (selected) => removeSelected(selected),
              ),
            ),
          ),
        ));
  }
}
