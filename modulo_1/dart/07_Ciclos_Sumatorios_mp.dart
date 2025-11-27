void main() {
  print('Bucle for con los 7 Sacramentos de la Iglesia Católica\n');

  int totalSacramentos = 7;
  double contador = 0;

  for (int i = 1; i <= totalSacramentos; i++) {
    contador += 1;
    print('Sacramento número $i recibido.');
  }

  print('\nEl número total de sacramentos es: $contador');
  print('La suma simbólica representa la plenitud de la vida cristiana');
}
