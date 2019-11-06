/*
classe che modella il dato astratto insieme di interi e ne fornisce una realizzazione
basata su vettore di booleani
 */
import java.util.Arrays;

class ArraySet {

    //Attributi

    /**
     * array di booleani in cui l'elemento i-esimo dell'array vale true
     * se quell'elemento appartiene all'insieme
     */
    private boolean set[];

    /**
     *
     */
    private int size = 0;

    /**
     * cardinalità dell'ArraySet
     */
    private int cardinality = 0;


    //Metodi

    /**
     * crea un array di 50 booleani inizializzati a false
     */
    ArraySet (){
        set = new boolean[50];
        for(int i = 0; i < set.length; i++)
            set[i] = false;
    }

    /**
     * restituisce true se l'aggiunta cambia l'ArraySet
     * @param i indice dell'elemento nell'ArraySet
     * @return true se l'aggiunta cambia l'ArraySet
     */
    boolean add(int i){
        if(i >= set.length) {
            //enlarge the set
            boolean temp[] = new boolean[set.length * 2];
            Arrays.fill(temp,false);
            System.arraycopy(set, 0, temp, 0, set.length);
            set = temp;
        }
        boolean added = set[i];
        set[i] = true;
        if(i >= size)
            size = i + 1;
        if(!added)
            cardinality++;
        return !added;
    }

    /**
     *
     * @param i
     * @return
     */
    boolean delete(int i){
        if(i < size){
            boolean deleted = set[i];
            set[i] = false;
            if(i == size - 1){
                //update size
                int j;
                for(j = size - 1; j >= 0 && !set[j]; j--);
                size = j + 1;
            }
            if(deleted)
                cardinality--;
            return deleted;
        }
        return false;
    }

    /**
     *
     * @param i
     * @return
     */
    boolean get(int i){
        return set[i];
    }

    /**
     *
     * @return
     */
    int size (){
        return cardinality;
    }

    /**
     *
     * @return
     */
    int[] toArray(){
        int a[] = new int[0];
        for(int i = 0; i < size; i++){
            if(get(i)){
                int temp[] = new int[a.length + 1];
                System.arraycopy(a, 0, temp, 0, a.length);
                a = temp;
                a[a.length - 1] = i;
            }
        }
        return a;
    }
}