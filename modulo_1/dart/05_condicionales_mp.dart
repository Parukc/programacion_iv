void main() {
  print('Condicionales con los 7 Sacramentos de la Iglesia Católica\n');

  // Ejemplo 1: Comprobación de edad para recibir un sacramento
  int edad = 7;

  if (edad > 7) {
    print('Edad mayor a 7: Puede prepararse para la Confirmación o Eucaristía.');
  }
  if (edad < 7) {
    print('Edad menor a 7: Solo puede recibir el Bautismo.');
  }
  if (edad == 7) {
    print('Edad ideal para la Primera Comunión.');
  }

  // Ejemplo 2: Uso de else
  if (edad >= 18) {
    print('Es adulto: puede recibir el Matrimonio o el Orden Sacerdotal.');
  } else {
    print('Aún no tiene edad para recibir sacramentos de compromiso.');
  }

  // Ejemplo 3: Comparación exacta
  String sacramento = 'Confirmación';

  if (sacramento == 'Bautismo') {
    print('Sacramento de Iniciación.');
  } else {
    print('No es el Bautismo.');
  }

  // Ejemplo 4: Uso de else if
  String tipo = 'Sanación';

  if (tipo == 'Iniciación') {
    print('Incluye Bautismo, Confirmación y Eucaristía.');
  } else if (tipo == 'Sanación') {
    print('Incluye Penitencia y Unción de los enfermos.');
  } else {
    print('Incluye Orden Sacerdotal y Matrimonio.');
  }

  // Ejemplo 5: Operador ternario
  bool estaCasado = true;
  String sacramentoRecibido =
      estaCasado ? 'Ha recibido el Sacramento del Matrimonio 💍' : 'No ha recibido el Matrimonio.';
  print(sacramentoRecibido);
}
