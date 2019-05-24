package ch7.concurrency.A_introducing_threads;

/*
INTRODUCTION
============
As you shall learn in Chapter 8 , “IO,” and Chapter 10, “JDBC,” computers are capable of reading and writing data to external resources.
Unfortunately, as compared to CPU operations, these disk/network operations tend to be extremely slow. So slow, in fact,
that if your computer’s operating system were to stop and wait for every disk or network operation to finish, your computer would appear to freeze or lock up constantly.

Luckily, all modern operating systems support what is known as multi-threaded processing. The idea behind multi-threaded processing is to allow an application or group
of applications to execute multiple tasks at the same time. This allows tasks waiting for other resources to give way to other processing requests.
(den paso a otras solicitudes de procesamiento).

Since its early days, Java has supported multi-threading programming using the Thread class. In 2004, Java 5 was released and the Concurrency API was introduced in the
java.util.concurrent package. It included numerous classes for performing complex thread-based tasks. The idea was simple: managing complex thread interactions is quite
difficult for even the most skilled developers; therefore a set of reusable features was created. The Concurrency API has grown over the years to include numerous classes and
frameworks to assist you in developing complex, multi-threaded applications.

In this chapter, we will introduce you to the concept of threads and provide numerous ways to manage threads using the Concurrency API.
Threads and concurrency tend to be one of the more challenging topics for many programmers to grasp, as problems with threads can be frustrating even for veteran
developers to understand. In practice, concurrency issues are among the most difficult problems to diagnose and resolve.

========================
 el examen OCP 8 se basa en gran medida en tu conocimiento de la API de concurrencia.
 Ya que creemos que debe caminar antes de poder ejecutar, proporcionamos una descripción general básica de los hilos en la primera parte de este capítulo,
 ya que creemos que le ayudará a comprender mejor la API de concurrencia utilizada en el resto del capítulo.
 ======================
 */

//==========================================================

/*
We begin this chapter by reviewing common terminology associated with threads.
A thread.- is the smallest unit of execution that can be scheduled by the operating system.
A process.- is a group of associated threads that execute in the same, shared environment.
It follows, then, that a single-threaded process is one that contains exactly one thread, whereas a multi-threaded process is one that contains one or more threads.
By shared environment,.- we mean that the threads in the same process share the same memory space and can communicate directly with one another.

Yes, you will finally see how static variables can be useful for performing complex, multi-threaded tasks! Remember from your OCA studies that static methods and variables are defined on a single class object that all instances share.
For example, if one thread updates the value of a static object, then this information is immediately available for other threads within the process to read.
In this chapter, we will talk a lot about tasks and their relationships to threads.
A task is a single unit of work performed by a thread. Throughout this chapter, a task will commonly be implemented as a lambda expression.
A thread can complete multiple independent tasks but only one task at a time.

Una descripción general de los threads y su entorno compartido dentro de un proceso.

                                 ________________________________________

                                        Process (Java program)

                                     -------------------------------
                                              Shared Memory
                                     -------------------------------

                                        |          |           |
                                     Thread     Thread      Thread
                                 ________________________________________
                                        |           |           |
                                        V           V           V
                                 ________________________________________
                                           OS Thread Scheduler
                                 ________________________________________


                                    CPU1   CPU2 ............CPUn

 */

public class A_DistinguishingThreadTypes {

/*
Are all multi-threaded.
Even a simple Java application that prints Hello World to the screen is multi-threaded.
To help you understand this, we introduce the concepts of
        - system threads and
        - user-defined threads.

A system thread is created by the JVM and runs in the background of the application.
For example, the garbage-collection thread is a system thread that is created by the JVM and runs in the background, helping to free memory that is no longer in use
the execution of system-defined threads is invisible to the application developer.
When a system-defined thread encounters a problem and cannot recover, such as running out of memory, it generates a Java Error , as opposed to an Exception.

Alternatively, a user-defined thread is one created by the application developer to accomplish a specific task.
All of the applications that we have created up to this point have been multi-threaded, but they contained only one user-defined thread, which calls the main() method.
For simplicity, we commonly refer to threads that contain only a single user-defined thread as a single-threaded application, since we are often uninterested in the system threads.

Aunque no se requieren conocimientos para el examen, un "daemon thread" es uno que no evitará que la JVM salga cuando finalice el programa.
Un "Java application" termina cuando los únicos "threads" que se están ejecutando son "daemon threads".
Por ejemplo, si el "garbage-collection thread" es el único que queda en ejecución, la JVM se cerrará automáticamente.
Tanto los threads del sistema como los definidos por el usuario se pueden marcar como "daemon threads".
*/

}
