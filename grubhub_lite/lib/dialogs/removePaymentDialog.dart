import 'package:flutter/material.dart';
import 'package:grubhub_lite/backend/database.dart';
import 'package:grubhub_lite/models/payment.dart';

class RemovePaymentDialog extends StatefulWidget {
  final List<Payment> payments;
  RemovePaymentDialog({required this.payments});
  _RemovePaymentDialogState createState() =>
      _RemovePaymentDialogState(payments: this.payments);
}

class _RemovePaymentDialogState extends State<RemovePaymentDialog> {
  late Payment _selectedPayment;
  List<Payment> payments;

  _RemovePaymentDialogState({required this.payments}) {
    _selectedPayment = payments[0];
  }

  void handleDelete() {
    deletePayment(payment: _selectedPayment);
    Navigator.of(context).pop();
  }

  @override
  Widget build(BuildContext context) {
    return AlertDialog(
      title: Text('Remove Payment'),
      content: Column(
        mainAxisSize: MainAxisSize.min,
        children: <Widget>[
          DropdownButton<Payment>(
            value: _selectedPayment,
            icon: const Icon(Icons.arrow_downward),
            iconSize: 24,
            elevation: 16,
            underline: Container(
              height: 2,
              color: Colors.green[900],
            ),
            onChanged: (newValue) =>
                setState(() => _selectedPayment = newValue!),
            items: payments.map<DropdownMenuItem<Payment>>((Payment value) {
              return DropdownMenuItem<Payment>(
                value: value,
                child: Text('Payment ID: ${value.id}'),
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
