import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class main {
    static void main() throws InterruptedException {


        List<Integer> lista = new ArrayList<>();
        Random rad = new Random();
        Integer jk = rad.nextInt(95)+5;
        for (int a = 0; a < jk; a++ ){
            lista.add(rad.nextInt(99)+1 );
        }
        System.out.println("Lista desordenada");
        System.out.println(lista);
        Nodo l = new Nodo(lista);
        l.start();
        l.join();
        System.out.println("Lista ordenada");
        System.out.println(l.getLista());
    }
}
