import 'package:flutter/material.dart';
import 'package:grubhub_lite/backend/database.dart';
import 'package:grubhub_lite/components/removeDialog.dart';
import 'package:grubhub_lite/models/marshal.dart';

class CustomList<T> extends StatelessWidget {
  final String title;
  final List<T> items;
  final onTap;
  final Widget Function(
      {required dynamic parameter,
      dynamic index,
      dynamic onTap}) widgetForItems;
  final Widget? addElement;
  final Widget? removeElement;

  CustomList(
      {required this.title,
      required this.items,
      required this.onTap,
      required this.widgetForItems,
      this.addElement,
      this.removeElement});

  List<Widget> buildBodyWidgets() {
    List<Widget> widgets = [];
    for (var i = 0; i < this.items.length; i++) {
      widgets.add(this.widgetForItems(
          parameter: this.items[i], index: i, onTap: this.onTap));
    }
    return widgets;
  }

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.center,
      crossAxisAlignment: CrossAxisAlignment.center,
      children: [
        Text(title,
            style: TextStyle(fontSize: 24, color: Marshal.getTypeColor<T>())),
        SizedBox(
          height: 10,
        ),
        Row(
          mainAxisAlignment: MainAxisAlignment.center,
          mainAxisSize: MainAxisSize.max,
          children: [
            if (addElement != null)
              FlatButton(
                  color: Colors.green,
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: [Icon(Icons.add), Text('${Marshal.typeOf<T>()}')],
                  ),
                  onPressed: () => {
                        showDialog(
                            context: context, builder: (context) => addElement!)
                      }),
            SizedBox(
              width: 50,
            ),
            removeElement != null
                ? FlatButton(
                    color: Colors.red,
                    child: Row(
                      mainAxisAlignment: MainAxisAlignment.center,
                      children: [
                        Icon(Icons.remove),
                        Text('${Marshal.typeOf<T>()}')
                      ],
                    ),
                    onPressed: () => showDialog(
                        context: context, builder: (context) => removeElement!))
                : SizedBox(
                    height: 25,
                  ),
          ],
        ),
        SizedBox(
          height: 20,
        ),
        Container(
            height: 720,
            decoration: BoxDecoration(
                borderRadius: BorderRadius.circular(20),
                border: Border.all(color: Colors.grey[700]!)),
            padding: const EdgeInsets.all(10),
            child: ListView(
              children: buildBodyWidgets(),
            )),
      ],
    );
  }
}
