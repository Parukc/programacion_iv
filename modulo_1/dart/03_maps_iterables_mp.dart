void main() {
  print('Iterables con los 7 Sacramentos de la Iglesia Católica\n');

  final sacramentos = [
    'Bautismo',
    'Confirmación',
    'Eucaristía',
    'Penitencia o Confesión',
    'Unción de los enfermos',
    'Orden sacerdotal',
    'Matrimonio'
  ];

  print('Lista Original: $sacramentos');
  print('Cantidad total: ${sacramentos.length}');
  print('Sacramento en índice 3: ${sacramentos[3]}');
  print('Primer sacramento: ${sacramentos.first}');
  print('Último sacramento: ${sacramentos.last}');
  print('Reverso de la lista (Iterable): ${sacramentos.reversed}');

  final reversedSacramentos = sacramentos.reversed;
  print('Lista invertida: ${reversedSacramentos.toList()}');
  print('Set (sin duplicados): ${reversedSacramentos.toSet()}');

  print('\nIteración individual:');
  for (var s in sacramentos) {
  }

  print('\nImpresión general en varias líneas:');
  print('''  
   Sacramentos de la Iglesia:
  $sacramentos

   En orden inverso:
  ${reversedSacramentos.toList()}

   Categorías:
  - Iniciación Cristiana: Bautismo, Confirmación, Eucaristía
  - Sanación: Penitencia, Unción de los enfermos
  - Servicio a la Comunidad: Orden sacerdotal, Matrimonio
  ''');
}
