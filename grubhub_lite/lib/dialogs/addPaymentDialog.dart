import 'package:flutter/material.dart';
import 'package:grubhub_lite/backend/database.dart';
import 'package:grubhub_lite/models/enums.dart';
import 'package:grubhub_lite/models/payment.dart';

class AddPaymentDialog extends StatefulWidget {
  _AddPaymentDialogState createState() => _AddPaymentDialogState();
}

class _AddPaymentDialogState extends State<AddPaymentDialog> {
  PaymentType _paymentType = PaymentType.CreditCard;
  PaymentStatus _paymentStatus = PaymentStatus.Completed;

  void createPayment() {
    final payment =
        new Payment(paymentType: _paymentType, paymentStatus: _paymentStatus);
    addPayment(payment: payment);
    Navigator.of(context).pop();
  }

  @override
  Widget build(BuildContext context) {
    return AlertDialog(
      title: Text('Add Payment'),
      content: Column(
        mainAxisSize: MainAxisSize.min,
        children: <Widget>[
          DropdownButton<PaymentType>(
            value: _paymentType,
            icon: const Icon(Icons.arrow_downward),
            iconSize: 24,
            elevation: 16,
            underline: Container(
              height: 2,
              color: Colors.green[900],
            ),
            onChanged: (newValue) => setState(() => _paymentType = newValue!),
            items: <PaymentType>[
              PaymentType.CreditCard,
              PaymentType.ApplePay,
              PaymentType.GooglePay,
            ].map<DropdownMenuItem<PaymentType>>((PaymentType value) {
              return DropdownMenuItem<PaymentType>(
                value: value,
                child: Text(toString(value)),
              );
            }).toList(),
          ),
          DropdownButton<PaymentStatus>(
            value: _paymentStatus,
            icon: const Icon(Icons.arrow_downward),
            iconSize: 24,
            elevation: 16,
            underline: Container(
              height: 2,
              color: Colors.green[900],
            ),
            onChanged: (newValue) => setState(() => _paymentStatus = newValue!),
            items: <PaymentStatus>[
              PaymentStatus.Completed,
              PaymentStatus.Declined,
              PaymentStatus.InProgress,
              PaymentStatus.Error,
            ].map<DropdownMenuItem<PaymentStatus>>((PaymentStatus value) {
              return DropdownMenuItem<PaymentStatus>(
                value: value,
                child: Text(toString(value)),
              );
            }).toList(),
          ),
        ],
      ),
      actions: [
        FlatButton(
            child: Text("Add Payment"),
            onPressed: createPayment,
            color: Colors.green)
      ],
    );
  }
}
