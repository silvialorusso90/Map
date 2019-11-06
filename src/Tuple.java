/*
classe che rappresenta una tupla come sequenza di coppie attributo-valore
 */

public class Tuple {

    //Attributi

    /**
     * array di oggetti di tipo Item, uno per ciascun attributo della tupla
     * */
    private Item [ ] tuple;

    //Metodi

    /**
     * costruisce l'oggetto riferito da tuple
     * @param size numero di item che costituirà la tupla
     */
    Tuple(int size) {
        tuple = new Item[size];
    }

    /**
     * restituisce tuple.length
     * @return lunghezza della tupla
     */
    int getLength(){
        return tuple.length;
    }

    /**
     * restituisce l'item in posizione i
     * @param i posiizione di un Item in Tuple
     * @return Item in posizione i di Tuple
     */
    Item get(int i){
        return tuple[i];
    }

    /**
     * memorizza c in tuple[i]
     * @param c Item da assegnare in posizione i di tuple
     * @param i posizione di un Item in tuple
     */
    void add(Item c,int i){
        tuple[i] = c;
    }

    /**
     * determina la distanza tra la tupla riferita da obj e la tupla corrente
     * (riferita da this). La distanza è ottenuta come la somma delle distanze
     * tra gli item in posizioni eguali nelle due tuple.
     * Fare uso di double distance(Object a) di Item
     * @param obj tupla per cui si vuole calcolare la distanza dalla tupla corrente
     * @return distanza tra la tupla obj e la tupla corrente
     */
    double getDistance(Tuple obj){
        double distance = 0;
        for (int i = 0; i < this.getLength(); i++)
            distance = distance + this.get(i).distance(obj.get(i));
        return distance;
    }

    /**
     * restituisce la media delle distanze tra la tupla corrente e quelle ottenibili
     * dalle righe della matrice in data aventi indice in clusteredData
     * @param data insieme di tuple
     * @param clusteredData array di indici delle tuple
     * @return distanza media tra la tupla corrente e le tuple in data aventi indice
     * in clusterData
     */
    double avgDistance(Data data, int clusteredData[]){
        double p = 0.0;
        double sumD = 0.0;
        for(int i = 0; i < clusteredData.length; i++){
            double d= getDistance(data.getItemSet(clusteredData[i]));
            sumD += d;
        }
        p = sumD / clusteredData.length;
        return p;
    }



}
