void main() {
  print('Tipo de variables en Dart');
  
  final String pokemon = 'Ditto';
  print(pokemon);
  
  String myName = 'Adriana';
  myName = 'Vargas';
  print(myName);
  
  const String elemento ='Fuego';
  print('elemento: ,$elemento');
  
  bool active = false;
  print('Es activo: $active');
  
  int hp = 1000;
  print('Caballos de fuerza: $hp');
  
  List<String> abilities=['impostor','correlon'];
  print('Habilidades: $abilities');
  
  final sprites = <String>['src/image1.png','image2'];
  print('Imagenes $sprites');
  
  print('Impresion en varias lineas');
  print('''
  $pokemon
  $hp
  $sprites
  $abilities
  ''');
}
