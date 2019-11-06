/*
classe che modella un cluster
 */

class Cluster {

    //Attributi

    /**
     * tupla centroide del cluster
     */
    private Tuple centroid;

    /**
     * array di tuple clusterizzate, l'elemento i-esimo dell'array
     * vale true se se l'i-esima tupla appartiene al cluster
     */
    private ArraySet clusteredData;


    //Metodi

    /**
     * inizializza il centroide del cluster e crea un array vuoto di tuple
     * @param centroid centroide del cluster
     */
    Cluster(Tuple centroid){
        this.centroid = centroid;
        clusteredData = new ArraySet();

    }

    /**
     * restituisce il centroide del cluster
     * @return centroide del cluster
     */
    Tuple getCentroid(){
        return centroid;
    }

    /**
     * restituisce true se la tupla sta cambiando cluster, false altrimenti
     * @param id identificatore numerico della tupla
     * @return true se la tupla ha cambiato cluster
     */
    boolean addData(int id){
        return clusteredData.add(id);

    }

    /**
     * verifica se una transazione è clusterizzata nell'array corrente
     * @param id identificatore numerico della tupla
     * @return true se la tupla appartiene all'array corrente, false altrimenti
     */
    boolean contain(int id){
        return clusteredData.get(id);
    }

    /**
     * elimina la tupla che ha cambiato cluster
     * @param id identificatore numerico della tupla
     */
    void removeTuple(int id){
        clusteredData.delete(id);

    }

    /**
     * restitusice clusteredData.size()
     * @return dimensione del cluster
     */
    int  getSize(){
        return clusteredData.size();
    }

    /**
     *
     * @return
     */
    int[] iterator(){
        return clusteredData.toArray();
    }

    /**
     * restituisce una stringa composta dagli item del cluster
     * @return stringa rappresentante il centroide del cluster
     */
    public String toString(){
        String str = "Centroid = (";
        for(int i=0; i < centroid.getLength(); i++)
            str += centroid.get(i);
        str += ")";
        return str;
    }

    /**
     * restitusice una stringa fatta dal centroide del cluster, da tutte le tuple
     * appartenenti al cluster e la distanza media delle tuple dal centroide
     * @return stringa rappresentante lo stato del cluster
     */
    public String toString(Data data){
        String str = "Centroid = (";
        for(int i = 0; i < centroid.getLength(); i++)
            str += centroid.get(i) + " ";
        str += ")\nExamples:\n";
        int array[] = clusteredData.toArray();
        for(int i = 0; i < array.length; i++){
            str += "[";
            for(int j = 0; j < data.getNumberOfExplanatoryAttributes(); j++)
                str += data.getAttributeValue(array[i], j) + " ";
            str += "]  dist = " + getCentroid().getDistance(data.getItemSet(array[i])) + "\n";
        }
        str += "AvgDistance = " + getCentroid().avgDistance(data, array) + "\n";
        return str;
    }
}
