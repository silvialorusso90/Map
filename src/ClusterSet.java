/*
classe che rappresenta un insieme di cluster (determinati da QT)
 */
class ClusterSet {

    //Attributi

    /**
     * array di oggetti cluster
     */
    private Cluster C[] = new Cluster[0];

    //Metodi

    /**
     * costruttore dell'insieme di cluster
     */
    ClusterSet() {
    }

    /**
     * aggiunge il cluster c all'insieme di cluster
     * @param c cluster da aggiungere all'insieme di cluster
     */
    void add(Cluster c){
        Cluster tempC[] = new Cluster[C.length + 1];
        for(int i = 0; i < C.length; i++)
            tempC[i] = C[i];
        tempC[C.length] = c;
        C = tempC;
    }

    /**
     * restituisce C[i]
     * @param i indice del cluster alla posizione i dell'insieme di cluster
     * @return cluster alla posizione i dell'insieme di cluster
     */
    Cluster get(int i){
        return C[i];
    }

    public String toString(Data data ){
        String str = "";
        for(int i = 0; i < C.length; i++){
            if (C[i] != null){
                str += i + ":" + C[i].toString(data) + "\n";
            }
        }
        return str;
    }


}
