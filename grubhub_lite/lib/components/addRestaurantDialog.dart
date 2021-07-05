import 'package:flutter/material.dart';
import 'package:grubhub_lite/models/enums.dart';

class AddRestaurantDialog extends StatefulWidget {
  _AddRestaurantDialogState createState() => _AddRestaurantDialogState();
}

class _AddRestaurantDialogState extends State<AddRestaurantDialog> {
  late String name;
  late String address;
  late int rating;
  late bool isOpen = false;
  late String timeOpen;
  late String timeClose;
  late Cuisine type = Cuisine.American;
  late double averageWaitTime;
  late ValueProp valueProp = ValueProp.Cheap;
  late List<int> menu = [];
  late List<DietaryRestrictions> restrictions = [DietaryRestrictions.NA];
  late bool offersTakeOut = false;
  late List<dynamic> categories = [];

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.center,
      mainAxisSize: MainAxisSize.min,
      children: [
        Text("Enter new restaurant Properties"),
        SizedBox(height: 5),
        Expanded(
          child: Padding(
            padding: const EdgeInsets.all(16.0),
            child: ListView(
              children: [
                TextField(
                  decoration: InputDecoration(hintText: "Restaurant Name...."),
                  onChanged: (value) => name = value,
                ),
                TextField(
                  decoration:
                      InputDecoration(hintText: "Restaurant Address...."),
                  onChanged: (value) => address = value,
                ),
                TextField(
                  decoration: InputDecoration(hintText: "Time Open..."),
                  onChanged: (value) => timeOpen = value,
                ),
                TextField(
                  decoration: InputDecoration(hintText: "Time Close..."),
                  onChanged: (value) => timeClose = value,
                ),
                TextField(
                  decoration:
                      InputDecoration(hintText: "Average Wait time...."),
                  onChanged: (value) => averageWaitTime = double.parse(value),
                ),
                TextField(
                  decoration:
                      InputDecoration(hintText: "Restaurant Raiting...."),
                  onChanged: (value) => rating = int.parse(value),
                ),
                DropdownButton<ValueProp>(
                    value: valueProp,
                    underline: Container(height: 2, color: Colors.indigo),
                    onChanged: (value) => setState(() => valueProp = value!),
                    items: [
                      DropdownMenuItem(
                        value: ValueProp.Cheap,
                        child: Text(ValueProp.Cheap.toString()),
                      ),
                      DropdownMenuItem(
                        value: ValueProp.Medium,
                        child: Text(ValueProp.Medium.toString()),
                      ),
                      DropdownMenuItem(
                        value: ValueProp.HighEnd,
                        child: Text(ValueProp.HighEnd.toString()),
                      ),
                      DropdownMenuItem(
                        value: ValueProp.Expensive,
                        child: Text(ValueProp.Expensive.toString()),
                      ),
                    ]),
                DropdownButton<DietaryRestrictions>(
                    value: restrictions.first,
                    underline: Container(height: 2, color: Colors.indigo),
                    onChanged: (value) =>
                        setState(() => restrictions.add(value!)),
                    items: [
                      DropdownMenuItem(
                        value: DietaryRestrictions.NA,
                        child: Text(DietaryRestrictions.NA.toString()),
                      ),
                      DropdownMenuItem(
                        value: DietaryRestrictions.DairyFree,
                        child: Text(DietaryRestrictions.DairyFree.toString()),
                      ),
                      DropdownMenuItem(
                        value: DietaryRestrictions.GlutenFree,
                        child: Text(DietaryRestrictions.GlutenFree.toString()),
                      ),
                      DropdownMenuItem(
                        value: DietaryRestrictions.Vegan,
                        child: Text(DietaryRestrictions.Vegan.toString()),
                      ),
                      DropdownMenuItem(
                        value: DietaryRestrictions.Vegetarian,
                        child: Text(DietaryRestrictions.Vegetarian.toString()),
                      )
                    ]),
                DropdownButton<Cuisine>(
                  value: type,
                  icon: const Icon(Icons.arrow_downward),
                  iconSize: 24,
                  elevation: 16,
                  underline: Container(
                    height: 2,
                    color: Colors.indigo,
                  ),
                  onChanged: (newValue) => setState(() => type = newValue!),
                  items: <Cuisine>[
                    Cuisine.American,
                    Cuisine.Chinese,
                    Cuisine.FastFood,
                    Cuisine.Hispanic,
                    Cuisine.Latin,
                    Cuisine.Japanese,
                    Cuisine.Japanese,
                    Cuisine.Korean,
                  ].map<DropdownMenuItem<Cuisine>>((Cuisine value) {
                    return DropdownMenuItem<Cuisine>(
                      value: value,
                      child: Text(value.toString()),
                    );
                  }).toList(),
                ),
                Row(
                  children: [
                    Text("Is Restaurant Open: "),
                    Switch(
                      value: isOpen,
                      onChanged: (value) => setState(() => isOpen = value),
                    ),
                  ],
                ),
                Row(
                  children: [
                    Text("Offers Takeout: "),
                    Switch(
                      value: offersTakeOut,
                      onChanged: (value) =>
                          setState(() => offersTakeOut = value),
                    ),
                  ],
                ),
              ],
            ),
          ),
        ),
      ],
    );
  }
}
