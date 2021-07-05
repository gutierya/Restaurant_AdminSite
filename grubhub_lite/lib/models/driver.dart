import 'package:grubhub_lite/models/enums.dart';

import 'User.dart';

class Driver extends User {
  int rating;
  VehicleType vehicleType;
  DateTime estimatedArrivalTime;

  Driver(
      {required String uuid, required int id, required this.rating,
        required this.vehicleType,
        required this.estimatedArrivalTime
      }) : super(uuid: uuid, id: id);

  int get driverRating  => rating;
  VehicleType get vehicle => vehicleType;
  DateTime get arrivalTime => estimatedArrivalTime;

  Map<String, dynamic> toJson() {
    return {
      'uuid': super.uuid,
      'id': super.id,
      'rating' : rating,
      'vehicleType': vehicleType,
      'estimatedArrivalTime': estimatedArrivalTime
    };
  }
}

Driver fromJson(Map<String, dynamic> json) {
  return Driver(
    uuid: json['uuid'],
    id: json['id'],
    rating: json['rating'],
    vehicleType: json['vehicleType'],
    estimatedArrivalTime: json['estimatedArrivalTime']
  );
}