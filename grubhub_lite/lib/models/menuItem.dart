import 'package:grubhub_lite/models/enums.dart';

class MenuItem {
  final int id;
  final String itemName;
  final String description;
  final List<dynamic> ingredients;
  final int calories;
  bool isInStock;
  final String imageUrl;
  final double price;
  final DietaryRestrictions dietaryRestrictions;
  final String category;
  final int restaurantID;

  MenuItem({
    required this.id,
    required this.itemName,
    required this.description,
    required this.ingredients,
    required this.calories,
    required this.isInStock,
    required this.imageUrl,
    required this.price,
    required this.dietaryRestrictions,
    required this.category,
    required this.restaurantID,
  });

  Map<String, dynamic> toJson() {
    return {
      'itemName': itemName,
      'description': description,
      'ingredients': ingredients,
      'calories': calories,
      'isInStock': isInStock,
      'imageUrl': imageUrl,
      'price': price,
      'dietaryRestrictions': toString(dietaryRestrictions),
      'category': category,
      'restaurantID': restaurantID
    };
  }

  factory MenuItem.fromJson(Map<String, dynamic> json) {
    return MenuItem(
        id: json['id'],
        itemName: json['itemName'],
        description: json['description'],
        ingredients: json['ingredients'],
        calories: json['calories'],
        isInStock: json['isInStock'],
        imageUrl: json['imageUrl'],
        price: json['price'],
        dietaryRestrictions: enumFromString(
            DietaryRestrictions.values, json['dietaryRestrictions']),
        category: json['category'],
        restaurantID: json['restaurantID']);
  }
}
