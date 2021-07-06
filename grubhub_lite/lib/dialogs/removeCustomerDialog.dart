import 'package:flutter/material.dart';
import 'package:grubhub_lite/backend/database.dart';
import 'package:grubhub_lite/models/customer.dart';

class RemoveCustomerDialog extends StatefulWidget {
  final List<Customer> customers;
  RemoveCustomerDialog({required this.customers});
  _RemoveCustomerDialogState createState() =>
      _RemoveCustomerDialogState(customers: this.customers);
}

class _RemoveCustomerDialogState extends State<RemoveCustomerDialog> {
  late Customer _selectedCustomer;
  List<Customer> customers;

  _RemoveCustomerDialogState({required this.customers}) {
    _selectedCustomer = customers[0];
  }

  void handleDelete() {
    deleteCustomer(customer: _selectedCustomer);
    Navigator.of(context).pop();
  }

  @override
  Widget build(BuildContext context) {
    return AlertDialog(
      title: Text('Remove Customer'),
      content: Column(
        mainAxisSize: MainAxisSize.min,
        children: <Widget>[
          DropdownButton<Customer>(
            value: _selectedCustomer,
            icon: const Icon(Icons.arrow_downward),
            iconSize: 24,
            elevation: 16,
            underline: Container(
              height: 2,
              color: Colors.purple[900],
            ),
            onChanged: (newValue) =>
                setState(() => _selectedCustomer = newValue!),
            items: customers.map<DropdownMenuItem<Customer>>((Customer value) {
              return DropdownMenuItem<Customer>(
                value: value,
                child: Text('Customer ID: ${value.id}'),
              );
            }).toList(),
          ),
        ],
      ),
      actions: [
        FlatButton(
            child: Text("Delete Payment"),
            onPressed: handleDelete,
            color: Colors.red)
      ],
    );
  }
}
