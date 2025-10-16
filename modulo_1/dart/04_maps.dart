void main(){
  
  print('Maps');
  final Map <String, dynamic> pokemon = {
    'name' : 'Ditton',
    'hp' : '100',
    'isAlive' : true,
    'abilites' : <String> ['impostor'],
    'sprites' : {
      1 : 'src/ditto1.jpg',
      2 : 'src/ditto2.jpg'
    }
  };
  print(pokemon);
  print(pokemon ['name']);
  print(pokemon ['sprites']);
  print(pokemon ['hp']);
  print(pokemon ['isAlive']);

  
}