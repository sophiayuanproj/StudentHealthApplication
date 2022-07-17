class Exercise {
  final int exerciseid;
  final String exercisename;
  final String exercisetype;
  final double metabolicequivalentscore;

  Exercise({
    required this.exerciseid,
    required this.exercisename,
    required this.exercisetype,
    required this.metabolicequivalentscore,
  });

  factory Exercise.fromMap(Map exerciseMap){
    return Exercise(
      exerciseid: exerciseMap['exerciseid'],
      exercisename: exerciseMap['exercisename'],
      exercisetype: exerciseMap['exercisetype'],
      metabolicequivalentscore: exerciseMap['metabolicequivalentscore'],
    );
  }
}