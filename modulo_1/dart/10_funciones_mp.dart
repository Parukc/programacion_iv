void main() {
  print(saludoGeneral());
  print(contarSacramentos(3, 4));
  print(sumarSimbolicamente(6, 8));
  print(sumarSimbolicamente(5)); // usa el valor opcional por defecto
  print(saludarSacramento(nombre: "Bautismo", mensaje: "Recibe la gracia del"));
}

String saludoGeneral() => 'Paz y bendiciones para todos ';

int contarSacramentos(int a, int b) => a + b;

int sumarSimbolicamente(int a, [int b = 0]) {
  return a + b;
}

String saludarSacramento({required String nombre, String mensaje = "Sacramento recibido:"}) {
  return '$mensaje $nombre ';
}
