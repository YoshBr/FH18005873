# README.md
## Bryan Obando - FH18005873
## Preguntas a responder:
- ¿Es posible implementar una solución equivalente pero de comportamiento iterativo?

R/Sí, completamente. Se puede reemplazar la recursión con un bucle while que aplique la misma lógica de división y residuo, acumulando el resultado en cada iteración.
- ¿Cree que hay alguna otra manera recursiva de generar el mismo resultado?

R/Sí, existen otros enfoques recursivos, como usar un método que calcule potencias de 10 para recomponer el número invertido, o incluso trabajar con cadenas de caracteres, aunque la solución actual es la más directa y puramente matemática.
- ¿Qué relación observa entre el algoritmo para invertir un número natural (calculando y utilizando los cocientes y residuos de las divisiones) con las estrategias para pasar de una base numérica a otra?

R/La relación es directa: ambos se basan en divisiones sucesivas por una base (10 para invertir, otra base para conversión) y el uso de los residuos para construir el resultado. La diferencia está en que al invertir se usan los residuos en el orden directo, mientras que en cambio de base suelen leerse en orden inverso.
