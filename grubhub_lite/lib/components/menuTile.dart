import 'package:flutter/material.dart';
import 'package:grubhub_lite/models/menuItem.dart';

class MenuItemTile extends StatelessWidget {
  final MenuItem item;

  MenuItemTile({required this.item});

  @override
  Widget build(BuildContext context) {
    return Card(
      elevation: 20,
      child: Row(
          mainAxisSize: MainAxisSize.min,
          mainAxisAlignment: MainAxisAlignment.start,
          children: <Widget>[
            SizedBox(
              height: 100,
              width: 150,
              child: FittedBox(
                fit: BoxFit.contain,
                child: Image.network(
                  item.imageUrl,
                ),
              ),
            ),
            SizedBox(
              width: 10,
            ),
            Flexible(
              child: Container(
                child: Column(
                  mainAxisAlignment: MainAxisAlignment.start,
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    SizedBox(height: 20),
                    Text(
                      '${item.itemName}',
                      overflow: TextOverflow.ellipsis,
                    ),
                    SizedBox(
                      height: 10,
                    ),
                    Text('${item.description}',
                        softWrap: false, overflow: TextOverflow.ellipsis),
                    SizedBox(
                      height: 10,
                    ),
                    Text('${item.ingredients}',
                        softWrap: false, overflow: TextOverflow.ellipsis),
                    SizedBox(
                      height: 10,
                    ),
                    Text('Calories: ${item.calories}',
                        softWrap: false, overflow: TextOverflow.ellipsis),
                    SizedBox(
                      height: 10,
                    ),
                    Text('Price : \$ ${item.price}',
                        overflow: TextOverflow.ellipsis),
                    SizedBox(height: 20),
                  ],
                ),
              ),
            )
          ]),
    );
  }
}
