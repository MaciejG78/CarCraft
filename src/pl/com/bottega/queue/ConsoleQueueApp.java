package pl.com.bottega.queue;

/**
 * Created by macie on 26.12.2016.
 * Zad - Kolejka
 Kolejką Queue<E> nazywamy generyczną strukturę danych, która przechowuje obiekty pewnego typu E i udostępnia 3 operacje:
 void enqueue(E e) -> wstawia element na koniec kolejki
 E dequeue() -> zwraca pierwszy element kolejki i usuwa go z kolejki
 boolean isEmpty() -> true gdy kolejka pusta, w przeciwnym razie false

 Stwórz generyczny interfejs Queue<E> z w. w. metodami i jego implementację LinkedQueue<E>.
 Implementacja powinna się opeirać o prywatną klasę wewnętrzną QueueLink<E> reprezentującą ogniowo kolejki. Ogniwo zawiera pole typu E przechowujące element kolejki oraz wskaźnik typu QueueLink<E> na następne ogniwo kolejki. Kolejka natomiast zawiera 2 pola firstLink i lastLink reprezentujące odpowiednio pierwsze i ostatnie ogniwo. Operacja enqueue powinna dowiązywać do ostatniego elementu nowe ogniwo. Operacja dequeue powinna usuwać pierwsze ogniwo i zastępować je jego następnikiem tj. drugim ogniwem. Obsłuż odpowiednio sytuacje brzegow, tj. kolejka pusta i kolejka z tylko jednym elementem.
 Stwórz metodę toString w kolejce któ©a przechodzi po wszystkich ogniwach i buduje wynikowy napis złożony z oddzielnoych spacjami wartości e.toString().
 Napisz program testujący działanie kolejki LinkedQueue<String> który dodaje/usuwa elementy kolejki i po każdej operacji printuje zawartość kolejki.
 Np.
 q.enqueue(1); q.enqueue(2); q.enqueue(3); q.enqueue(4); q.dequeue(); q.dequeue(); q.enqueue(5);
 powinno dać następujący stan kolejki:
 3 4 5
 */

public class ConsoleQueueApp {
    public static void main(String[] args) {

        LinkedQueue<String> q = new LinkedQueue<>();

        q.enqueue("1");
        System.out.println(q);
        q.enqueue("2");
        System.out.println(q);
        q.enqueue("3");
        System.out.println(q);
        q.enqueue("4");
        System.out.println(q);
        q.dequeue();
        System.out.println(q);
        q.dequeue();
        System.out.println(q);
        q.enqueue("5");
        System.out.println(q);
    }
}