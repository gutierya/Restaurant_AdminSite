import 'package:flutter/material.dart';
import 'package:grubhub_lite/components/customDropDown.dart';
import 'package:grubhub_lite/models/marshal.dart';

class RemoveDialog<T> extends StatefulWidget {
  final List<T> items;
  final action;

  RemoveDialog({required this.items, required this.action});

  _RemoveDialogState<T> createState() =>
      _RemoveDialogState<T>(items: this.items, action: this.action);
}

class _RemoveDialogState<T> extends State<RemoveDialog<T>> {
  final List<T> items;
  final action;
  late T selectedItem;

  _RemoveDialogState({required this.items, required this.action}) {
    selectedItem = items.first;
  }

  void handleAction() {
    action(selectedItem);
    Navigator.of(context).pop();
  }

  @override
  Widget build(BuildContext context) {
    return new AlertDialog(
        title: Text('Remove ${Marshal.typeOf<T>()}'),
        content: CustomDropDownMenu<T>(
          items: items,
          lineColor: Marshal.getTypeColor<T>(),
          updateFunction: (selected) => setState(() => selectedItem = selected),
        ),
        actions: <Widget>[
          FlatButton(
              color: Colors.red,
              child: Text('Remove ${Marshal.typeOf<T>()}'),
              onPressed: handleAction),
        ]);
  }
}
