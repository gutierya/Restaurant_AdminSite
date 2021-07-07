import 'package:flutter/material.dart';
import 'package:grubhub_lite/backend/database.dart';
import 'package:grubhub_lite/components/customList.dart';
import 'package:grubhub_lite/components/customListTile.dart';
import 'package:grubhub_lite/components/paymentTile.dart';
import 'package:grubhub_lite/components/removeDialog.dart';
import 'package:grubhub_lite/dialogs/addPaymentDialog.dart';
import 'package:grubhub_lite/models/enums.dart';
import 'package:grubhub_lite/models/payment.dart';

class Payments extends StatefulWidget {
  _PaymentState createState() => new _PaymentState();
}

class _PaymentState extends State<Payments> {
  List<Payment> _payments = [];

  _PaymentState() {
    loadPayments();
  }

  void loadPayments() {
    get<Payment>(endPoint: Payment.paymentsPrefix)
        .then((values) => setState(() => _payments = values));
  }

  Widget buildWidget(
      {required dynamic parameter, dynamic index, dynamic onTap}) {
    return CustomListTile(
      leadingIcon: getPaymentTypeIcon(parameter.paymentType),
      title: 'Payment ID: ${parameter.id}',
      subTitle: '${toString(parameter.paymentType)}',
      trailing: Text('${toString(parameter.paymentStatus)}'),
      onTap: () => onTap,
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
            title: Text('Payments'),
            backgroundColor: Colors.green[900]!,
            actions: [
              IconButton(
                icon: Icon(Icons.refresh),
                onPressed: () => loadPayments(),
              ),
            ]),
        body: Padding(
          padding: const EdgeInsets.all(20),
          child: Center(
            child: CustomList<Payment>(
              items: _payments,
              title: "Payments",
              onTap: () => {},
              widgetForItems: buildWidget,
              addElement: AddPaymentDialog(),
              removeElement: RemoveDialog<Payment>(
                  items: _payments,
                  action: (selected) => removeSelected(selected)),
            ),
          ),
        ));
  }
}
