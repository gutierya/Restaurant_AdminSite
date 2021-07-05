import 'package:flutter/material.dart';
import 'package:grubhub_lite/backend/database.dart';
import 'package:grubhub_lite/components/paymentList.dart';
import 'package:grubhub_lite/models/payment.dart';

class Payments extends StatefulWidget {
  _PaymentState createState() => new _PaymentState();
}

class _PaymentState extends State<Payments> {
  List<Payment> _payments = [];

  _PaymentState() {
    getPayments().then((values) => setState(() => _payments = values));
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text('Payments'),
          backgroundColor: Colors.green[900]!,
        ),
        body: Padding(
          padding: const EdgeInsets.all(20),
          child: Center(
            child: PaymentList(payments: _payments),
          ),
        ));
  }
}
