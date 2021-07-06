import 'package:grubhub_lite/models/User.dart';

class Customer extends User {
  final List<dynamic> orderHistory;
  final List<dynamic> favoriteRestaurants;
  final List<dynamic> favoriteItems;
  final String address;
  final String name;

  Customer(
      {required String uuid,
      required int id,
      this.favoriteItems = const [],
      this.orderHistory = const [],
      this.favoriteRestaurants = const [],
      required this.address,
      required this.name})
      : super(uuid: uuid, id: id);

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

  List<int> get previousOrders => orderHistory as List<int>;
  List<int> get likedRestaurants => favoriteRestaurants as List<int>;
  List<int> get likedItems => favoriteItems as List<int>;

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
