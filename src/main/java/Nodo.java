import java.util.ArrayList;
import java.util.List;

public class Nodo extends Thread{
    private List<Integer> lista;

    Nodo(List<Integer> lista){
        this.lista= lista;
    }
    public List<Integer> getLista(){
        return this.lista;
    }

  private List<Integer> añade(List<Integer> lista, int d, int h) {
        List<Integer> rama = new ArrayList<>();
        for (int i = d; i < h; i++) {
            rama.add(lista.get(i));
        }
        return rama;
    }



  private List<Integer> mezcla(List<Integer> l1, List<Integer> l2) {
        List<Integer> resul=new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < l1.size() && j < l2.size()) {
            if (l1.get(i) <= l2.get(j)) {resul.add(l1.get(i));i++;
            } else {resul.add(l2.get(j));j++;}
        }
        while (i < l1.size()) {resul.add(l1.get(i++));}
        while (j < l2.size()) {resul.add(l2.get(j++));}

        return resul;
    }





    @Override
    public void run() {

        if (lista.size()<=1) {
            // al ser un elemento (o ninguno) el nodo ya esta acabado
           return;
        }

        int med =lista.size()/2;
        List<Integer> ramaA = añade(lista,0,med);
        List<Integer> ramaB = añade(lista,med,lista.size());
        Nodo nodoA = new Nodo(ramaA);
        Nodo nodoB = new Nodo(ramaB);
        nodoA.start();
        nodoB.start();
        try {
            nodoA.join();
            nodoB.join();
        } catch (InterruptedException e) {
            System.out.println("error en los nodos");
        }
        lista=mezcla(nodoA.getLista(), nodoB.getLista());
    }
}
