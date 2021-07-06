import 'package:flutter/material.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';
import 'package:grubhub_lite/models/enums.dart';
import 'package:grubhub_lite/models/payment.dart';

class PaymentTile extends StatelessWidget {
  final Payment payment;

  PaymentTile({required this.payment});

  Widget leadingIcon() {
    if (payment.paymentType == PaymentType.CreditCard)
      return Icon(Icons.credit_card);
    else if (payment.paymentType == PaymentType.ApplePay) {
      return FaIcon(FontAwesomeIcons.apple);
    } else if (payment.paymentType == PaymentType.GooglePay) {
      return FaIcon(FontAwesomeIcons.google);
    } else if (payment.paymentType == PaymentType.PayPal) {
      return FaIcon(FontAwesomeIcons.paypal);
    } else
      return FaIcon(FontAwesomeIcons.cashRegister);
  }

  Widget build(BuildContext context) {
    return ListTile(
      shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(20)),
      leading: leadingIcon(),
      title: Text('Payment ID: ${payment.id}'),
      subtitle: Text('${toString(payment.paymentType)}'),
      trailing: Text('${toString(payment.paymentStatus)}'),
      onTap: () {},
    );
  }
}
