public class MainTest {
    /**
     * consenta il test delle classi implementate, in particolare
     * permette la stampa dell'insieme di transazioni, e dell'insieme di cluster
     * @param args parametri del main
     */
    public static void main(String[] args) {
        Data data =new Data();
        System.out.println(data);
        double radius = 2.0;
        QTMiner qt=new QTMiner(radius);
        int numIter=qt.compute(data);
        System.out.println("\nNumber of clusters: "+numIter);
        System.out.println(qt.getC().toString(data));


    }
}
