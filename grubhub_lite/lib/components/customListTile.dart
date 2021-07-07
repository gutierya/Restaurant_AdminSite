import 'package:flutter/material.dart';

class CustomListTile extends StatelessWidget {
  final IconData leadingIcon;
  final String title;
  final String subTitle;
  final Widget trailing;
  final onTap;

  CustomListTile(
      {required this.leadingIcon,
      required this.title,
      required this.subTitle,
      required this.trailing,
      required this.onTap});

  @override
  Widget build(BuildContext context) {
    return ListTile(
        shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(20)),
        leading: Icon(leadingIcon),
        title: Text(title),
        subtitle: Text(subTitle),
        trailing: trailing,
        onTap: onTap);
  }
}
