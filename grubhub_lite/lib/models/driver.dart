import 'package:grubhub_lite/models/enums.dart';

import 'User.dart';

class Driver extends User {
  int rating;
  VehicleType vehicleType;
  String estimatedArrivalTime;
  static final String driverPrefix = 'drivers/';

  Driver(
      {required String uuid,
      required int id,
      required this.rating,
      required this.vehicleType,
      required this.estimatedArrivalTime})
      : super(uuid: uuid, id: id);

  Map<String, dynamic> toJson() {
    return {
      'uniqueIdentifier': super.uuid,
      'userID': super.id,
      'rating': rating,
      'vehicle': toString(vehicleType),
      'estimatedArrivalTime': estimatedArrivalTime
    };
  }

  factory Driver.fromJson(Map<String, dynamic> json) {
    return Driver(
        uuid: json['uniqueIdentifier'],
        id: json['userID'],
        rating: json['rating'],
        vehicleType: enumFromString(VehicleType.values, json['vehicle']),
        estimatedArrivalTime: json['estimatedArrivalTime']);
  }
}
