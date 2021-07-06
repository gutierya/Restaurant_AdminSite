import 'package:flutter/material.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';
import 'package:grubhub_lite/dialogs/addCustomerDialog.dart';
import 'package:grubhub_lite/dialogs/removeCustomerDialog.dart';
import 'package:grubhub_lite/models/customer.dart';

class CustomerList extends StatelessWidget {
  final List<Customer> customers;

  CustomerList({required this.customers});

  Widget customerTile({required Customer customer}) {
    return Padding(
      padding: const EdgeInsets.all(8.0),
      child: GestureDetector(
          child: Card(
            child: Row(
                mainAxisAlignment: MainAxisAlignment.spaceAround,
                children: <Widget>[
                  FaIcon(FontAwesomeIcons.user),
                  Column(children: [
                    SizedBox(height: 10),
                    Text('Customer Name: ${customer.name}'),
                    Text('Customer Address: ${customer.address}'),
                    Text(
                        'Favorite Restaurants IDs: ${customer.favoriteRestaurants}'),
                    Text('Favorite MenuItems: ${customer.favoriteItems}'),
                    Text('Previous Order IDs: ${customer.orderHistory}'),
                    SizedBox(height: 10),
                  ])
                ]),
          ),
          onTap: () {}),
    );
  }

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.center,
      crossAxisAlignment: CrossAxisAlignment.center,
      children: [
        Text("Customers",
            style: TextStyle(fontSize: 24, color: Colors.purple[200])),
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
                  children: [Icon(Icons.add), Text("Customer")],
                ),
                onPressed: () => showDialog(
                    context: context,
                    builder: (context) => AddCustomerDialog())),
            SizedBox(
              width: 50,
            ),
            FlatButton(
                color: Colors.red,
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [Icon(Icons.remove), Text("Customer")],
                ),
                onPressed: () => showDialog(
                    context: context,
                    builder: (context) =>
                        RemoveCustomerDialog(customers: customers))),
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
                itemCount: customers.length,
                itemBuilder: (_, index) => customerTile(
                      customer: customers[index],
                    ))),
      ],
    );
  }
}
