import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';

class TipsSummaryPage extends StatefulWidget {
  const TipsSummaryPage({super.key});

  @override
  State<TipsSummaryPage> createState() => _TipsSummaryPageState();
}

class _TipsSummaryPageState extends State<TipsSummaryPage> {
  String tablesCountText = '';
  int tablesCount = 0;

  final List<TextEditingController> consumptionControllers = [];
  final List<int> tipPercents = []; // 10, 12 o 15

  String resultText = '';

  void _generateTables() {
    final parsed = int.tryParse(tablesCountText) ?? 0;

    if (parsed <= 0 || parsed > 10) {
      setState(() {
        resultText = 'Ingrese un número de mesas entre 1 y 10.';
        tablesCount = 0;
        consumptionControllers.clear();
        tipPercents.clear();
      });
      return;
    }

    tablesCount = parsed;
    consumptionControllers.clear();
    tipPercents.clear();

    for (int i = 0; i < tablesCount; i++) {
      consumptionControllers.add(TextEditingController());
      tipPercents.add(10); // valor por defecto 10%
    }

    setState(() {
      resultText = 'Ingrese el consumo y la propina de cada mesa.';
    });
  }

  void _calculateTotals() {
    if (tablesCount == 0) {
      setState(() {
        resultText =
            'Primero indique cuántas mesas tiene y genere el formulario.';
      });
      return;
    }

    double totalConsumption = 0;
    double totalTips = 0;
    double grandTotal = 0;
    final List<String> lines = [];

    for (int i = 0; i < tablesCount; i++) {
      final double consumption = double.tryParse(
            consumptionControllers[i].text.trim().replaceAll(',', '.'),
          ) ??
          0.0;

      final int tipPercent = tipPercents[i];
      final double tipAmount = consumption * tipPercent / 100.0;
      final double mesaTotal = consumption + tipAmount;

      totalConsumption += consumption;
      totalTips += tipAmount;
      grandTotal += mesaTotal;

      lines.add(
        'Mesa ${i + 1}: Consumo \$${consumption.toStringAsFixed(2)} '
        '| Propina $tipPercent% = \$${tipAmount.toStringAsFixed(2)} '
        '| Total \$${mesaTotal.toStringAsFixed(2)}',
      );
    }

    setState(() {
      resultText =
          'Detalle por mesa:\n'
          '${lines.join('\n')}\n\n'
          'Total consumo: \$${totalConsumption.toStringAsFixed(2)}\n'
          'Total propinas: \$${totalTips.toStringAsFixed(2)}\n'
          'Total general: \$${grandTotal.toStringAsFixed(2)}';
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
        title: const Text('Mesas atendidas'),
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
                'Mesas Atendidas',
                style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
              ),
              const SizedBox(height: 12),

              TextField(
                decoration: const InputDecoration(
                  labelText: 'Cantidad de mesas (1-10)',
                  border: OutlineInputBorder(),
                ),
                keyboardType: TextInputType.number,
                onChanged: (value) {
                  tablesCountText = value;
                },
              ),

              const SizedBox(height: 12),
              ElevatedButton(
                onPressed: _generateTables,
                child: const Text('Generar Mesas'),
              ),

              const SizedBox(height: 16),

              if (tablesCount > 0)
                ListView.builder(
                  shrinkWrap: true,
                  physics: const NeverScrollableScrollPhysics(),
                  itemCount: tablesCount,
                  itemBuilder: (context, index) {
                    return Card(
                      margin: const EdgeInsets.symmetric(vertical: 6),
                      child: Padding(
                        padding: const EdgeInsets.all(8),
                        child: Column(
                          crossAxisAlignment: CrossAxisAlignment.start,
                          children: [
                            Text(
                              'Mesa ${index + 1}',
                              style: const TextStyle(
                                fontWeight: FontWeight.bold,
                              ),
                            ),
                            const SizedBox(height: 8),
                            Row(
                              children: [
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
                                      labelText: 'Propina %',
                                      border: OutlineInputBorder(),
                                    ),
                                    items: const [
                                      DropdownMenuItem(
                                        value: 10,
                                        child: Text('10%'),
                                      ),
                                      DropdownMenuItem(
                                        value: 12,
                                        child: Text('12%'),
                                      ),
                                      DropdownMenuItem(
                                        value: 15,
                                        child: Text('15%'),
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
              if (tablesCount > 0)
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
