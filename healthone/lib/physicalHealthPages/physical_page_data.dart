import 'package:flutter/material.dart';
import 'exercise_type_page.dart';
import 'meditation_type_page.dart';
import 'sleep_page.dart';
import 'nutrition_page.dart';

class PhysicalData {
  static final getData = [
  {
  'name': 'Exercise',
  'page': ExerciseTypePage(exercisetype: "Aerobic"),

},
{
  'name': 'Meditation',
  'page': MeditationTypePage(meditationtype: "Guided"),
},
    {
      'name': 'Sleep',
      'page': SleepPage(),
    },
    {
      'name': 'Nutrition',
      'page': NutritionPage(),
    },
];
}