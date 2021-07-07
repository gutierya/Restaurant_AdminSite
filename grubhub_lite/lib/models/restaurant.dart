import 'package:grubhub_lite/models/enums.dart';

class Restaurant {
  final int id;
  final String name;
  int rating;
  final String address;
  bool isOpen;
  String timeOpen;
  String timeClose;
  Cuisine type;
  double averageWaitTime;
  ValueProp valueProposition;
  List<dynamic> menu;
  List<DietaryRestrictions> dietaryRestrictions;
  bool offersTakeOut;
  List<dynamic> categories;
  static final String restaurantPrefix = 'restaurants/';

  Restaurant(
      {required this.id,
      required this.name,
      required this.rating,
      required this.address,
      required this.isOpen,
      required this.timeOpen,
      required this.timeClose,
      required this.type,
      required this.averageWaitTime,
      required this.valueProposition,
      this.menu = const [],
      this.dietaryRestrictions = const [],
      required this.offersTakeOut,
      this.categories = const []});

  Map<String, dynamic> toJson() {
    List<String> restrictions = [];
    for (DietaryRestrictions restriction in this.dietaryRestrictions) {
      restrictions.add(toString(restriction));
    }
    return {
      'id': id,
      'name': name,
      'rating': rating,
      'address': address,
      'isOpen': isOpen,
      'timeOpen': timeOpen,
      'timeClose': timeClose,
      'type': toString(type),
      'averageWaitTime': averageWaitTime,
      'valueProposition': toString(valueProposition),
      'menu': menu,
      'dietaryRestrictions': restrictions.toString(),
      'offersTakeOut': offersTakeOut,
      'categories': categories
    };
  }

  factory Restaurant.fromJson(Map<String, dynamic> json) {
    List<DietaryRestrictions> _restrictions = [];
    List<dynamic> restrictionsJson = json['dietaryRestrictions'];
    for (var element in restrictionsJson) {
      _restrictions.add(enumFromString(DietaryRestrictions.values, element));
    }

    var id = json['id'];
    var name = json['name'];
    var rating = json['rating'];
    var address = json['address'];
    var isOpen = json['isOpen'];
    var timeOpen = json['timeOpen'];
    var timeClose = json['timeClose'];
    var type = enumFromString(Cuisine.values, json['type']);
    var averageWaitTime = json['averageWaitTime'];
    var valueProposition =
        enumFromString(ValueProp.values, json['valueProposition']);
    var offersTakeOut = json['offersTakeout'];
    var menu = json['menu'];
    var dietaryRestrictions = _restrictions;
    var categories = json['categories'] as List<dynamic>;

    return Restaurant(
        id: id,
        name: name,
        rating: rating,
        address: address,
        isOpen: isOpen,
        timeOpen: timeOpen,
        timeClose: timeClose,
        type: type,
        averageWaitTime: averageWaitTime,
        valueProposition: valueProposition,
        offersTakeOut: offersTakeOut,
        categories: categories,
        dietaryRestrictions: dietaryRestrictions,
        menu: menu);
  }
}
