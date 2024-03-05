Poniższy program jest rozwiązaniem problemu pisarzy i czytelników. Dąrzyłam do znalezienia rozwiązania, które nie daje pierwszeństwa ani pisarzom, ani czytelnikom i dąrzy do zachowania balansu. Pomysł zaczerpnęłam z artykułu:

https://arxiv.org/ftp/arxiv/papers/1309/1309.4507.pdf

Jest on następujący: czytelnicy wchodzą do czytelni do momentu, gdy jakikolwiek pisarz nie wyśle komunikatu, że sam chciałby dołączyć. Od tej pory żaden nowy czytelnik nie jest wpuszczany. Ostatni czytelnik opuszczający czytelnię wysyła sygnał do pisarza, że może on dołączyć.

Szczegółowe omówienie działania programu i metod zostało umieszczone w dokumentacji klas w folderze JavaDoc.

Ograniczenia:
- czas czytania/pisania: 1-3 sekundy;
- czas między wyjściem z czytelni a kolejną próbą wejścia: 2-5 sekund

Uruchomienie:
- program uruchamia się poprzez uruchomienie klasy Main.java z 2 możliwymi parametrami (1. to ilość pisarzy, 2. czytelników podawane po spacji). Domyślnie, bez podania parametrów te wartości to 3 pisarzy i 10 czytelników.