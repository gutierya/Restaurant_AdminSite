import 'dart:html';

import 'package:flutter/material.dart';
import 'package:grubhub_lite/models/marshal.dart';

class CustomDropDownMenu<T> extends StatefulWidget {
  final List<T> items;
  final Color lineColor;
  final updateFunction;
  CustomDropDownMenu(
      {required this.items,
      required this.updateFunction,
      this.lineColor = Colors.black});

  _CustomDropDownMenuState<T> createState() => _CustomDropDownMenuState<T>(
      items: items, updateFunction: updateFunction, lineColor: lineColor);
}

class _CustomDropDownMenuState<T> extends State<CustomDropDownMenu<T>> {
  final List<T> items;
  late T selectedItem;
  final Color lineColor;
  final updateFunction;

  _CustomDropDownMenuState(
      {required this.items,
      required this.updateFunction,
      this.lineColor = Colors.black}) {
    selectedItem = items.first;
  }

  @override
  Widget build(BuildContext context) {
    return DropdownButton<T>(
      value: selectedItem,
      icon: const Icon(Icons.arrow_downward),
      iconSize: 24,
      elevation: 16,
      underline: Container(
        height: 2,
        color: lineColor,
      ),
      onChanged: (newValue) {
        setState(() {
          selectedItem = newValue!;
        });
        updateFunction(newValue);
      },
      items: items.map<DropdownMenuItem<T>>((T value) {
        return DropdownMenuItem<T>(
          value: value,
          child: Text('${Marshal.typeOf<T>()} ID: ${Marshal.getID<T>(value)}'),
        );
      }).toList(),
    );
  }
}
