void main() {
  print('Ejemplo: Los 7 Sacramentos de la Iglesia Católica\n');

  // Variables básicas
  final String religion = 'Católica';
  const String totalSacramentos = '7';
  print('Religión: $religion');
  print('Número total de sacramentos: $totalSacramentos\n');

  // Variable tipo String
  String sacramentoPrincipal = 'Bautismo';
  print('Sacramento principal: $sacramentoPrincipal');

  // Variable tipo bool
  bool esSacramentoInicial = true;
  print('¿Es el sacramento que inicia la vida cristiana? $esSacramentoInicial\n');

  // Variable tipo int
  int edadRecomendada = 0;
  print('Edad recomendada para recibir el $sacramentoPrincipal: $edadRecomendada años\n');

  // Lista de los 7 sacramentos
  List<String> sacramentos = [
    'Bautismo',
    'Confirmación',
    'Eucaristía',
    'Penitencia o Confesión',
    'Unción de los enfermos',
    'Orden sacerdotal',
    'Matrimonio'
  ];
  print('Lista de sacramentos: $sacramentos\n');

  // Categorías de los sacramentos
  final categorias = <String>[
    'Sacramentos de Iniciación',
    'Sacramentos de Sanación',
    'Sacramentos al servicio de la Comunidad'
  ];
  print('Categorías: $categorias\n');

  // Impresión en varias líneas
  print('''
  📜 Resumen general:
  Religión: $religion
  Total de sacramentos: $totalSacramentos
  Principal: $sacramentoPrincipal
  Categorías: $categorias
  Lista completa: $sacramentos
  ''');
}
