import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';

class DailyIncomePage extends StatefulWidget {
  const DailyIncomePage({super.key});

  @override
  State<DailyIncomePage> createState() => _DailyIncomePageState();
}

class _DailyIncomePageState extends State<DailyIncomePage> {
  String servicesCountText = '';
  int servicesCount = 0;

  final List<TextEditingController> consumptionControllers = [];
  final List<int> tipPercents = [];

  String resultText = '';

  void _generateServices() {
    final parsed = int.tryParse(servicesCountText) ?? 0;

    if (parsed <= 0 || parsed > 10) {
      setState(() {
        resultText = 'Ingrese un número de servicios en el día (1-10)';
        servicesCount = 0;
        consumptionControllers.clear();
        tipPercents.clear();
      });
      return;
    }

    servicesCount = parsed;
    consumptionControllers.clear();
    tipPercents.clear();

    for (int i = 0; i < servicesCount; i++) {
      consumptionControllers.add(TextEditingController());
      tipPercents.add(10); // valor por defecto 10%
    }

    setState(() {
      resultText = 'Ingrese el monto de cada servicio';
    });
  }


  String _getDayCategory(double grandTotal) {
    if (grandTotal < 200) {
      return 'Día flojo';
    } else if (grandTotal <= 500) {
      return 'Día aceptable';
    } else {
      return 'Día excelente';
    }
  }

  void _calculateTotals() {
    if (servicesCount == 0) {
      setState(() {
        resultText =
            'Primero indique cuántos servicios tiene y genere el formulario.';
      });
      return;
    }

    double totalConsumption = 0;
    double totalTips = 0;
    double grandTotal = 0;
    final List<String> lines = [];

    for (int i = 0; i < servicesCount; i++) {
      final double consumption = double.tryParse(
            consumptionControllers[i].text.trim().replaceAll(',', '.'),
          ) ??
          0.0;

      final int tipPercent = tipPercents[i];
      final double tipAmount = consumption * tipPercent / 100.0;
      final double serviceTotal = consumption + tipAmount;

      totalConsumption += consumption;
      totalTips += tipAmount;
      grandTotal += serviceTotal;

      lines.add(
        'Servicio ${i + 1}: Precio \$${consumption.toStringAsFixed(2)} '
        '| Servicio $tipPercent% = \$${tipAmount.toStringAsFixed(2)} '
        '| Total \$${serviceTotal.toStringAsFixed(2)}',
      );
    }

    final String dayCategory = _getDayCategory(grandTotal);

    setState(() {
      resultText =
          'Servicios atendidos: $servicesCount\n\n'
          'Detalle por servicio:\n'
          '${lines.join('\n')}\n\n'
          'Total consumo: \$${totalConsumption.toStringAsFixed(2)}\n'
          'Total Gastos: \$${totalTips.toStringAsFixed(2)}\n'
          'Total general del día: \$${grandTotal.toStringAsFixed(2)}\n'
          'Clasificación del día: $dayCategory';
    });
  }

  @override
  void dispose() {
    for (final c in consumptionControllers) {
      c.dispose();
    }
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Servicios atendidos'),
        leading: IconButton(
          icon: const Icon(Icons.arrow_back),
          onPressed: () => context.go('/'),
        ),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16),
        child: SingleChildScrollView(
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.stretch,
            children: [
              const Text(
                'Servicios Atendidos',
                style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
              ),
              const SizedBox(height: 12),

              // Cantidad de servicios
              TextField(
                decoration: const InputDecoration(
                  labelText: 'Cantidad de servicios (1-10)',
                  border: OutlineInputBorder(),
                ),
                keyboardType: TextInputType.number,
                onChanged: (value) {
                  servicesCountText = value;
                },
              ),

              const SizedBox(height: 12),
              ElevatedButton(
                onPressed: _generateServices,
                child: const Text('Generar servicios'),
              ),

              const SizedBox(height: 16),

              // Lista dinámica de servicios
              if (servicesCount > 0)
                ListView.builder(
                  shrinkWrap: true,
                  physics: const NeverScrollableScrollPhysics(),
                  itemCount: servicesCount,
                  itemBuilder: (context, index) {
                    return Card(
                      margin: const EdgeInsets.symmetric(vertical: 6),
                      child: Padding(
                        padding: const EdgeInsets.all(8),
                        child: Column(
                          crossAxisAlignment: CrossAxisAlignment.start,
                          children: [
                            Text(
                              'Servicio ${index + 1}',
                              style: const TextStyle(
                                fontWeight: FontWeight.bold,
                              ),
                            ),
                            const SizedBox(height: 8),
                            Row(
                              children: [
                                // Consumo
                                Expanded(
                                  flex: 2,
                                  child: TextField(
                                    controller: consumptionControllers[index],
                                    decoration: const InputDecoration(
                                      labelText: 'Consumo (\$)',
                                      border: OutlineInputBorder(),
                                    ),
                                    keyboardType:
                                        const TextInputType.numberWithOptions(
                                      decimal: true,
                                    ),
                                  ),
                                ),
                                const SizedBox(width: 8),
                                Expanded(
                                  child: DropdownButtonFormField<int>(
                                    value: tipPercents[index],
                                    decoration: const InputDecoration(
                                      labelText: 'Tipo de Servicio',
                                      border: OutlineInputBorder(),
                                    ),
                                    items: const [
                                      DropdownMenuItem(
                                        value: 10,
                                        child: Text('Cambio de Aceite'),
                                      ),
                                      DropdownMenuItem(
                                        value: 12,
                                        child: Text('Cambio de llantas'),
                                      ),
                                    ],
                                    onChanged: (value) {
                                      if (value == null) return;
                                      setState(() {
                                        tipPercents[index] = value;
                                      });
                                    },
                                  ),
                                ),
                              ],
                            ),
                          ],
                        ),
                      ),
                    );
                  },
                ),

              const SizedBox(height: 16),

              if (servicesCount > 0)
                ElevatedButton(
                  onPressed: _calculateTotals,
                  child: const Text('Calcular totales'),
                ),

              const SizedBox(height: 16),

              Text(resultText),
            ],
          ),
        ),
      ),
    );
  }
}
