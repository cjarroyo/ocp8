package ch7.concurrency.A_introducing_threads;

public class B_UnderstandingThreadConcurrency {
/*
The property of executing multiple threads and processes at the same time is referred to as concurrency .
Of course, with a single-core CPU system, only one task is actually executing at a given time.
Even in multi-core or multi-CPU systems, there are often far more threads than CPU processors available.

How does the system decide what to execute when there are multiple threads available?

Operating systems use a thread scheduler to determine which threads should be currently executing, as shown in Figure 7.1 .
For example, a thread scheduler may employ a round-robin (Turno rotativo) schedule in which each available thread receives an equal number of CPU cycles
with which to execute, with threads visited in a circular order. If there are 10 available threads, they might each get 100 milliseconds in which to execute,
with the process returning to the first thread after the last thread has executed.

Cuando el tiempo asignado de un "thread" se completa pero el "thread" no ha terminado de procesarse, se produce un "context switch".
Un "context switch" es el proceso de almacenar el estado actual de un "thread" y luego restaurar el estado del "thread" para continuar la ejecución.
Tenga en cuenta que a menudo hay un costo asociado con un "context switch" por la pérdida de tiempo y la recarga del estado de un "thread".

Finalmente, un "thread" puede interrumpir o reemplazar otro "thread" si tiene una prioridad de "thread" más alta que el otro "thread".
Un "thread priority" es un valor numérico asociado con un "thread" que es tomado en cuenta por el "thread scheduler"  al determinar qué "thread" se debe ejecutar actualmente.
En Java, las "thread priorities" se especifican como valores enteros.
La clase Thread incluye tres constantes estáticas importantes, como se muestra en la Tabla 7.1. De forma predeterminada,
los "user-defined threads" reciben un valor de "thread priority" de Thread.NORM_PRIORITY.
Si tiene un "thread" que debe ejecutarse de inmediato, puede aumentar este valor a 6 o superior o usar el valor Thread.MAX_PRIORITY.
Si dos "threads" tienen la misma prioridad, el "thread scheduler" elegirá arbitrariamente el que se procesará primero en la mayoría de las situaciones.


Table 7.1 Java thread priority constants
_________________________________________
Constant Variable           Value
_________________________________________
Thread.MIN_PRIORITY           1
Thread.NORM_PRIORITY          5
Thread.MAX_PRIORITY           10
_________________________________________

The Importance of Thread Scheduling
===================================
Aunque las CPU "multi-core" son bastante comunes en estos días, las CPU "single-core" fueron el estándar en la informática personal durante muchas décadas.
Durante este tiempo, los sistemas operativos desarrollaron complejos algoritmos de "thread-scheduling" y "context switch" que permitieron a los usuarios ejecutar
docenas o incluso cientos de "threads" en un sistema de CPU "single-core". Estos algoritmos de programación permitieron a los usuarios experimentar la ilusión de que se estaban
realizando múltiples tareas al mismo tiempo dentro de un sistema de una sola CPU. Por ejemplo, un usuario
Podía escuchar música mientras escribía un artículo y recibir notificaciones de nuevos mensajes.
Dado que la cantidad de "threads" a menudo es mucho mayor que la cantidad de procesadores disponibles incluso en sistemas "multi-core", estos algoritmos de programación de "threads"
todavía se emplean en los sistemas operativos actuales.

 */
}
