import 'package:flutter/material.dart';

class HomeScreenButton extends StatelessWidget {
  final String text;
  final IconData iconData;
  final Color color;
  final onTap;

  HomeScreenButton(
      {required this.text,
      required this.iconData,
      required this.color,
      required this.onTap});

//Build Button
  @override
  Widget build(BuildContext context) {
    return new ElevatedButton(
      style: new ButtonStyle(
        backgroundColor: MaterialStateProperty.all<Color>(color),
      ),
      child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          crossAxisAlignment: CrossAxisAlignment.center,
          children: <Widget>[
            Icon(iconData),
            SizedBox(height: 5),
            Text(text),
          ]),
      onPressed: onTap,
    );
  }
}
