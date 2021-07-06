import 'package:flutter/material.dart';
import 'package:grubhub_lite/components/paymentTile.dart';
import 'package:grubhub_lite/dialogs/addPaymentDialog.dart';
import 'package:grubhub_lite/dialogs/removePaymentDialog.dart';
import 'package:grubhub_lite/models/payment.dart';

class PaymentList extends StatelessWidget {
  final List<Payment> payments;

  PaymentList({required this.payments});

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.center,
      crossAxisAlignment: CrossAxisAlignment.center,
      children: [
        Text("Payment History",
            style: TextStyle(fontSize: 24, color: Colors.green[900])),
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
                  children: [Icon(Icons.add), Text("Payment")],
                ),
                onPressed: () => showDialog(
                    context: context,
                    builder: (context) => AddPaymentDialog())),
            SizedBox(
              width: 50,
            ),
            FlatButton(
                color: Colors.red,
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [Icon(Icons.remove), Text("Payment")],
                ),
                onPressed: () => showDialog(
                    context: context,
                    builder: (context) => RemovePaymentDialog(
                          payments: payments,
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
                itemCount: payments.length,
                itemBuilder: (_, index) => PaymentTile(
                      payment: payments[index],
                    ))),
      ],
    );
  }
}
