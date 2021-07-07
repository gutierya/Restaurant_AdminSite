import 'dart:convert';

import 'package:grubhub_lite/models/marshal.dart';
import 'package:http/http.dart' as http;
import 'package:firebase_auth/firebase_auth.dart';

final FirebaseAuth _auth = FirebaseAuth.instance;

final String _endPointPrefix = "http://localhost:8080/";

Future<UserCredential?> register(String email, String password) async {
  try {
    UserCredential registeredUser = await _auth.createUserWithEmailAndPassword(
        email: email, password: password);
    return registeredUser;
  } on FirebaseAuthException catch (exception) {
    print("Function Register: " + exception.message!);
    return null;
  }
}

Future<UserCredential?> login(String email, String password) async {
  try {
    UserCredential loggedUser = await _auth.signInWithEmailAndPassword(
        email: email, password: password);
    return loggedUser;
  } on FirebaseAuthException catch (exception) {
    print("Function Login: " + exception.message!);
    return null;
  }
}

Future<List<T>> get<T>({required String endPoint}) async {
  List<T> result = [];
  var composedEndPoint = _endPointPrefix + Marshal.getTypeEndPoint<T>();

  var response = await http.get(Uri.parse(composedEndPoint));

  print('Get ${Marshal.typeOf<T>()} Response: $response');
  if (response.statusCode == 200) {
    String jsonString = response.body;
    List<dynamic> body = json.decode(jsonString);
    result = body.map((element) => Marshal.fromJson<T>(element) as T).toList();
    return result;
  } else {
    print("Get $_endPointPrefix/$endPoint: Response ${response.statusCode}");
    return [];
  }
}

Future<void> add<T>({required String endPoint, required T object}) async {
  print(
      'Adding ${Marshal.typeOf<T>()}: ${json.encode(Marshal.toJson<T>(object))}');
  var composedEndPoint = _endPointPrefix + '$endPoint';

  var response = await http.post(Uri.parse(composedEndPoint),
      body: json.encode(Marshal.toJson<T>(object)),
      headers: {'Content-Type': 'application/json'});
  if (response.statusCode == 200) {
    print('${Marshal.typeOf<T>()} Added');
  } else {
    print(
        'Response Code: ${response.statusCode}, Response Headers: ${response.headers}');
  }
}

Future<void> delete<T>({required String endPoint, required T object}) async {
  print(
      'Deleting ${Marshal.typeOf<T>()}: ${json.encode(Marshal.toJson(object))}');
  var composedEndPoint = _endPointPrefix + '$endPoint';
  var response = await http.delete(Uri.parse(composedEndPoint));
  if (response.statusCode == 200) {
    print('${Marshal.typeOf<T>()} Deleted');
  } else {
    print(
        'Response Code: ${response.statusCode}, Response Headers: ${response.headers}');
  }
}

void removeSelected<T>(T selected) {
  delete<T>(
      endPoint:
          Marshal.getTypeEndPoint<T>() + Marshal.getID<T>(selected).toString(),
      object: selected);
}
