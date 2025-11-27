void main() {
  // Instancias individuales (como en tu ejemplo)
  final Sacramento bautismo = Sacramento(nombre: 'Bautismo', signo: 'Agua y Luz');
  print(bautismo);
  print(bautismo.nombre);
  print(bautismo.signo);

  print('\nLista completa de los 7 Sacramentos:\n');

  // Lista de sacramentos
  final List<Sacramento> sacramentos = [
    Sacramento(nombre: 'Bautismo', signo: 'Agua y vela'),
    Sacramento(nombre: 'Confirmación', signo: 'Aceite y Espíritu Santo'),
    Sacramento(nombre: 'Eucaristía', signo: 'Pan y vino'),
    Sacramento(nombre: 'Penitencia o Confesión', signo: 'Absolución y arrepentimiento'),
    Sacramento(nombre: 'Unción de los enfermos', signo: 'Aceite y oración'),
    Sacramento(nombre: 'Orden sacerdotal', signo: 'Imposición de manos'),
    Sacramento(nombre: 'Matrimonio', signo: 'Consentimiento y unión')
  ];

  // Recorre la lista con un bucle
  for (var s in sacramentos) {
    print(' ${s.nombre} - Signo: ${s.signo}');
  }

  print('\nTotal de sacramentos: ${sacramentos.length}');
}

class Sacramento {
  String nombre = "";
  String signo = "";

  Sacramento({required this.nombre, this.signo = "Sin signo visible"});

  @override
  String toString() {
    return "$nombre - $signo";
  }
}
