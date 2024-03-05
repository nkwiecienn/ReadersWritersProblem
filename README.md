# Writers and Readers Problem Solution

This program is a solution to the writers and readers problem. I aimed to find a solution that does not prioritize either writers or readers and seeks to maintain balance. The idea was inspired by the article:

[Link to the article](https://arxiv.org/ftp/arxiv/papers/1309/1309.4507.pdf)

It works as follows: readers enter the reading room until any writer sends a message that they would like to join. From that moment on, no new reader is allowed in. The last reader leaving the reading room sends a signal to the writer that they can join.

Detailed discussion of the program's operation and methods is provided in the class documentation in the JavaDoc folder.

Limitations:
- Reading/Writing time: 1-3 seconds
- Time between leaving the reading room and the next attempt to enter: 2-5 seconds

Execution:
- The program is executed by running the Main.java class with 2 possible parameters (1. the number of writers, 2. readers provided after a space). By default, without parameters, these values are 3 writers and 10 readers.
