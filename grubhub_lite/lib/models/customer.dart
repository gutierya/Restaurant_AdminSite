import 'package:grubhub_lite/models/User.dart';

class Customer extends User {
  final List<int> orderHistory;
  final List<int> favoriteRestaurants;
  final List<int> favoriteItems;

  Customer(
      {required String uuid, required int id, this.favoriteItems = const [],
        this.orderHistory = const [], this.favoriteRestaurants = const [] })
      : super(uuid: uuid, id: id);

  Map<String, dynamic> toJson() {
    return {
      'uuid': super.uuid,
      'id': super.id,
      'orderHistory': orderHistory,
      'favoriteRestaurants': favoriteRestaurants,
      'favoriteItems': favoriteItems
    };
  }

  List<int> get previousOrders => orderHistory;
  List<int> get likedRestaurants => favoriteRestaurants;
  List<int> get likedItems => favoriteItems;

}


Customer fromJson(Map<String, dynamic> json) {
  return Customer(
    uuid: json['uuid'],
    id: json['id'],
    favoriteItems: json['favoriteItems'],
    orderHistory: json['orderHistory'],
    favoriteRestaurants: json['favoriteRestaurants']
  );
}

