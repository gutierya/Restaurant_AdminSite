import 'package:grubhub_lite/models/User.dart';

class Customer extends User {
  final List<dynamic> orderHistory;
  final List<dynamic> favoriteRestaurants;
  final List<dynamic> favoriteItems;
  final String address;
  final String name;
  static final String customerPrefix = 'customers/';

  Customer(
      {required String uuid,
      required int id,
      this.favoriteItems = const [],
      this.orderHistory = const [],
      this.favoriteRestaurants = const [],
      required this.address,
      required this.name})
      : super(uuid: uuid, id: id);

  @override
  Map<String, dynamic> toJson() {
    return {
      'uniqueIdentifier': super.uuid,
      'orderHistory': orderHistory,
      'favoriteRestaurants': favoriteRestaurants,
      'favoriteItems': favoriteItems,
      'address': address,
      'name': name,
      'userID': 0
    };
  }

  factory Customer.fromJson(Map<String, dynamic> json) {
    return Customer(
        uuid: json['uniqueIdentifier'],
        id: json['userID'],
        favoriteItems: json['favoriteItems'],
        orderHistory: json['orderHistory'],
        favoriteRestaurants: json['favoriteRestaurants'],
        address: json['address'],
        name: json['name']);
  }
}
