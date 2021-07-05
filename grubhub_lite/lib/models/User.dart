class User {
  final String uuid;
  final int id;

  User({required this.uuid, required this.id});

  String get uniqueIdentified => uuid;
  int get databaseKey => id;

  Map<String, dynamic> toJson() {
    return {
      'uuid': uuid,
      'id': id,
    };
  }

}

User fromJson(Map<String, dynamic> json) {
  return User(uuid: json['uuid'], id: json['id']);
}