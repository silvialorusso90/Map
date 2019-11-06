package mining;/*
classe che include l'implementazione dell'algoritmo QT
 */

import data.Data;
import mining.Cluster;
import mining.ClusterSet;


public class QTMiner {

    //Attributi

    /**
     * insieme dei cluster
     */
    private ClusterSet C;

    /**
     * raggio dei cluster
     */
    private double radius;

    //Metodi

    /**
     * Crea l'oggetto array riferito da C e inizializza radius
     * con il parametro passato come input
     * @param radius raggio del cluster
     */
    public QTMiner(double radius) {
        C = new ClusterSet();
        this.radius = radius;
    }

    /**
     * restituisce c
     * @return insieme dei cluster c
     */
    public ClusterSet getC() {
        return C;
    }

    /**
     * Esegue l'algoritmo QT eseguendo i passi dello pseudo-codice:
     * 1. Costruisce un cluster per ciascuna tupla non ancora clusterizzata, includendo
     * nel cluster i punti (non ancora clusterizzati in alcun cluster) che ricodano nel
     * vicinato sferico della tupla avente raggio radius;
     * 2. Salva il candidato cluster più popoloso e rimuove tutti punti di tale
     * cluster dall'elenco delle tuple ancora da clusterizzare;
     * 3. Ritorna al passo 1 finchè ci sono ancora tuple da assegnare ad un cluster
     * @param data insieme di tuple
     * @return numero di cluster scoperti
     */
    public int compute(Data data) throws ClusteringRadiusException{
        int numclusters = 0;
        boolean isClustered[] = new boolean[data.getNumberOfExamples()];
        for(int i = 0; i < isClustered.length; i++)
            isClustered[i] = false;
        int countClustered = 0;
        while(countClustered != data.getNumberOfExamples()) {
            //Ricerca cluster più popoloso
            Cluster c = buildCandidateCluster(data, isClustered);
            C.add(c);
            numclusters++;
            //Rimuovo tuple clusterizzate da dataset
            int clusteredTupleId[] = c.iterator();
            for(int i = 0; i < clusteredTupleId.length; i++) {
                isClustered[clusteredTupleId[i]] = true;
            }
            countClustered += c.getSize();
        }
        return numclusters;
    }

    /**
     * costruisce un cluster per ciascuna tupla di data non ancora clusterizzata
     * in un cluster di C e restituisce il cluster candidato più popoloso
     * @param data insieme di tuple da raggruppare in cluster
     * @param isClustered informazione booleana sullo stato di clusterizzazione di una tupla
     * (per esempio isClustered[i]=false se la tupla i-esima di data non è ancora
     * assegnata ad alcun cluster di C, true altrimenti)
     * @return cluster candidato più popoloso
     */
    Cluster buildCandidateCluster(Data data, boolean isClustered[]){
        Cluster ClusterMax = new Cluster(data.getItemSet(0));
        for(int i = 0; i < isClustered.length; i++){
            if(!isClustered[i]){
                Cluster c = new Cluster(data.getItemSet(i));
                for(int j = 0; j < isClustered.length; j++){
                    if(!isClustered[j]){
                        if(data.getItemSet(i).getDistance(data.getItemSet(j)) <= radius)
                            c.addData(j);
                    }
                }
                if(c.getSize() > ClusterMax.getSize())
                    ClusterMax = c;
            }
        }
        return ClusterMax;
    }
}
