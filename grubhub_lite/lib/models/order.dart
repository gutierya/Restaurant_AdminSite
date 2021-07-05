import 'package:grubhub_lite/models/enums.dart';

class Order {
  final int id;
  final DateTime createdTime;
  final DateTime expectedCompletion;
  final List<int> items;
  final OrderStatus status;
  final int deliveryDriverID;
  final destUserID;
  final double orderTotal;
  final double tax;
  final double orderSubTotal;
  final int customerID;
  final double tipAmount;
  final int paymentID;

  Order({required this.id,
    required this.createdTime,
    required this.expectedCompletion,
    required this.items,
    required this.status,
    required this.deliveryDriverID,
    required this.destUserID,
    required this.orderTotal,
    required this.tax,
    required this.orderSubTotal,
    required this.customerID,
    required this.tipAmount,
    required this.paymentID});


  Map<String, dynamic> toJson() {
    return {
      'id' : id,
      'createdTime': createdTime,
      'expectedCompletion': expectedCompletion,
      'items': items,
      'status': status,
      'deliveryDriverID' : deliveryDriverID,
      'destUserID': destUserID,
      'orderTotal': orderTotal,
      'tax' :  tax,
      'orderSubTotal' : orderSubTotal,
      'customerID' : customerID,
      'tipAmount' : tipAmount,
      'paymentID' : paymentID,
    };
  }
}

Order fromJson(Map<String, dynamic> json) {
  return Order(
    id: json['id'],
    createdTime: json['createdTime'],
    expectedCompletion: json['expectedCompletion'],
    items: json[ 'items'],
    status: json['status'],
    deliveryDriverID: json['deliveryDriverID'],
    destUserID: json[ 'destUserID'],
    orderTotal: json[ 'orderTotal'],
    tax: json[ 'tax' ],
    orderSubTotal: json['orderSubTotal'],
    customerID: json['customerID'],
    tipAmount: json['tipAmount'],
    paymentID: json['paymentID'],
  );
}