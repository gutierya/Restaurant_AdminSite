import 'package:flutter/material.dart';
import 'package:flutter_login/flutter_login.dart';
import 'package:grubhub_lite/backend/database.dart';
import 'package:grubhub_lite/views/home.dart';

class LoginScreen extends StatelessWidget {
  Future<String?> _authUser(LoginData _loginData) async {
    var authUser = await login(_loginData.name, _loginData.password);
    if (authUser != null) {
      return null;
    } else {
      return "Incorrect Email or Password";
    }
  }

  Future<String?> _recoveryPassword(String name) {
    print(name);
    return Future.delayed(Duration.zero).then((_) => "");
  }

  Future<String?> _register(LoginData _loginData) async {
    var newUser = await register(_loginData.name, _loginData.password);
    if (newUser == null) {
      return "Error Registering user";
    } else {
      return null;
    }
  }

  @override
  Widget build(BuildContext context) {
    return FlutterLogin(
      title: "GrubHub Lite",
      onLogin: _authUser,
      onSignup: _register,
      theme: LoginTheme(
        primaryColor: Colors.red,
      ),
      onRecoverPassword: _recoveryPassword,
      onSubmitAnimationCompleted: () {
        Navigator.of(context).pushReplacement(
            MaterialPageRoute(builder: (context) => HomeScreen()));
      },
    );
  }
}
