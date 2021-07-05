import 'package:grubhub_lite/models/enums.dart';
import 'package:enum_to_string/enum_to_string.dart';

class Payment {
  final int id;
  final PaymentType paymentType;
  PaymentStatus paymentStatus;

  Payment(
      {required this.id,
      required this.paymentType,
      required this.paymentStatus});

  Map<String, dynamic> toJson() {
    return {
      'paymentID': id,
      'paymentType': EnumToString.convertToString(paymentType),
      'paymentStatus': EnumToString.convertToString(paymentStatus)
    };
  }

  factory Payment.fromJson(Map<String, dynamic> json) {
    return Payment(
        id: json['paymentID'],
        paymentType: enumFromString(PaymentType.values, json['paymentType']),
        paymentStatus:
            enumFromString(PaymentStatus.values, json['paymentStatus']));
  }
}
