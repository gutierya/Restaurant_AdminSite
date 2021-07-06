import 'package:flutter/material.dart';
import 'package:grubhub_lite/components/customerList.dart';
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
    getCustomers().then((_customers) => setState(() => customers = _customers));
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
            child: CustomerList(customers: customers),
          ),
        ));
  }
}
