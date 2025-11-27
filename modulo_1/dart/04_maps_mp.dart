void main() {
  print('Maps: Los 7 Sacramentos de la Iglesia Católica\n');

  final Map<String, dynamic> sacramento = {
    'nombre': 'Bautismo',
    'categoria': 'Sacramento de Iniciación',
    'esImportante': true,
    'simbolos': <String>['agua', 'vela', 'cruz', 'aceite'],
    'otrosSacramentos': <String>[
      'Confirmación',
      'Eucaristía',
      'Penitencia o Confesión',
      'Unción de los enfermos',
      'Orden sacerdotal',
      'Matrimonio'
    ],
    'imagenes': {
      1: 'src/bautismo1.jpg',
      2: 'src/bautismo2.jpg'
    }
  };

  // Impresiones individuales
  print('Mapa completo: $sacramento\n');
  print('Nombre del sacramento: ${sacramento['nombre']}');
  print('Categoría: ${sacramento['categoria']}');
  print('¿Es importante?: ${sacramento['esImportante']}');
  print('Símbolos usados: ${sacramento['simbolos']}');
  print('Otros sacramentos: ${sacramento['otrosSacramentos']}');
  print('Imágenes asociadas: ${sacramento['imagenes']}\n');

  // Acceso interno al mapa de imágenes
  final imagenes = sacramento['imagenes'] as Map<int, String>;
  print('Primera imagen: ${imagenes[1]}');
  print('Segunda imagen: ${imagenes[2]}');
}
