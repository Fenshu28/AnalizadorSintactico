/** ***************************************************
 * Autor: Cristopher Alexis Zarate Valencia           *
 * Fecha de creación: 14 jun 2023                     *
 * Fecha de actualización: 14 jun 2023                *
 * Descripción: Clase para
 **************************************************** */
package entity;

import java.util.*;

public class Conjunto {

    public static void main(String[] args) {
        // Definir las reglas de producción de la gramática
        Map<String, List<String>> producciones = new HashMap<>();
        producciones.put("A", Arrays.asList("BC"));
//        producciones.put("A", Arrays.asList("a", "ε"));
        producciones.put("B", Arrays.asList("ε","m"));
        producciones.put("C", Arrays.asList("ε", "s"));

        // Calcular el conjunto primero
        Map<String, Set<String>> conjuntoPrimero = calcularConjuntoPrimero(producciones);

        // Calcular el conjunto siguiente
        Map<String, Set<String>> conjuntoSiguiente = calcularConjuntoSiguiente(producciones, conjuntoPrimero);

        // Calcular el conjunto de predicción
        Map<String, Set<String>> conjuntoPrediccion = calcularConjuntoPrediccion(producciones, conjuntoPrimero, conjuntoSiguiente);

        // Imprimir los conjuntos
        System.out.println("Conjunto Primero:");
        imprimirConjunto(conjuntoPrimero);

        System.out.println("\nConjunto Siguiente:");
        imprimirConjunto(conjuntoSiguiente);

        System.out.println("\nConjunto Predicción:");
        imprimirConjunto(conjuntoPrediccion);
    }

    public static Map<String, Set<String>> calcularConjuntoPrimero(Map<String, List<String>> producciones) {
        Map<String, Set<String>> conjuntoPrimero = new HashMap<>();

        for (String noTerminal : producciones.keySet()) {
            calcularConjuntoPrimeroRecursivo(noTerminal, producciones, conjuntoPrimero, new HashSet<>());
        }

        return conjuntoPrimero;
    }

    private static void calcularConjuntoPrimeroRecursivo(String simbolo, Map<String, List<String>> producciones,
            Map<String, Set<String>> conjuntoPrimero,
            Set<String> visitados) {
        if (visitados.contains(simbolo)) {
            return;
        }

        visitados.add(simbolo);

        if (!conjuntoPrimero.containsKey(simbolo)) {
            conjuntoPrimero.put(simbolo, new HashSet<>());
        }

        List<String> reglas = producciones.get(simbolo);

        for (String regla : reglas) {
            char primerCaracter = regla.charAt(0);

            if (Character.isUpperCase(primerCaracter)) {
                calcularConjuntoPrimeroRecursivo(String.valueOf(primerCaracter), producciones, conjuntoPrimero, visitados);

                Set<String> primeros = conjuntoPrimero.get(String.valueOf(primerCaracter));
                conjuntoPrimero.get(simbolo).addAll(primeros);
            } else {
                conjuntoPrimero.get(simbolo).add(String.valueOf(primerCaracter));
            }
        }
    }

    public static Map<String, Set<String>> calcularConjuntoSiguiente(Map<String, List<String>> producciones,
            Map<String, Set<String>> conjuntoPrimero) {
        Map<String, Set<String>> conjuntoSiguiente = new HashMap<>();

        for (String noTerminal : producciones.keySet()) {
            conjuntoSiguiente.put(noTerminal, new HashSet<>());
        }

        conjuntoSiguiente.get("A").add("$");

        boolean cambio;

        do {
            cambio = false;

            for (String noTerminal : producciones.keySet()) {
                List<String> reglas = producciones.get(noTerminal);

                for (String regla : reglas) {
                    for (int i = 0; i < regla.length(); i++) {
                        char simbolo = regla.charAt(i);

                        if (Character.isUpperCase(simbolo)) {
                            String siguiente = regla.substring(i + 1);

                            if (i < regla.length() - 1 && siguiente.length() > 0) {
                                Set<String> primeros = calcularPrimeros(siguiente, conjuntoPrimero);
                                primeros.remove("epsilon");

                                if (!primeros.isEmpty()) {
                                    cambio |= conjuntoSiguiente.get(String.valueOf(simbolo)).addAll(primeros);
                                } else {
                                    cambio |= conjuntoSiguiente.get(String.valueOf(simbolo)).addAll(
                                            conjuntoSiguiente.get(noTerminal));
                                }
                            } else {
                                cambio |= conjuntoSiguiente.get(String.valueOf(simbolo)).addAll(
                                        conjuntoSiguiente.get(noTerminal));
                            }
                        }
                    }
                }
            }
        } while (cambio);

        return conjuntoSiguiente;
    }

    private static Set<String> calcularPrimeros(String simbolo, Map<String, Set<String>> conjuntoPrimero) {
        Set<String> primeros = new HashSet<>();

        if (Character.isUpperCase(simbolo.charAt(0))) {
            primeros.addAll(conjuntoPrimero.get(String.valueOf(simbolo.charAt(0))));
        } else {
            primeros.add(String.valueOf(simbolo.charAt(0)));
        }

        return primeros;
    }

    public static Map<String, Set<String>> calcularConjuntoPrediccion(Map<String, List<String>> producciones,
            Map<String, Set<String>> conjuntoPrimero,
            Map<String, Set<String>> conjuntoSiguiente) {
        Map<String, Set<String>> conjuntoPrediccion = new HashMap<>();

        for (String noTerminal : producciones.keySet()) {
            List<String> reglas = producciones.get(noTerminal);

            for (String regla : reglas) {
                Set<String> primeros = calcularPrimeros(regla, conjuntoPrimero);

                if (primeros.contains("epsilon")) {
                    primeros.remove("epsilon");
                    primeros.addAll(conjuntoSiguiente.get(noTerminal));
                }

                conjuntoPrediccion.put(noTerminal + " -> " + regla, primeros);
            }
        }

        return conjuntoPrediccion;
    }

    private static void imprimirConjunto(Map<String, Set<String>> conjunto) {
        for (String clave : conjunto.keySet()) {
            System.out.print(clave + ": { ");
            Set<String> elementos = conjunto.get(clave);

            for (String elemento : elementos) {
                System.out.print(elemento + " ");
            }

            System.out.println("}");
        }
    }
}
