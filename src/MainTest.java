import data.Data;
import keyboardinput.Keyboard;
import mining.ClusteringRadiusException;
import mining.QTMiner;
import data.EmptyDatasetException;

public class MainTest {
    /**
     * consenta il test delle classi implementate, in particolare
     * permette la stampa dell'insieme di transazioni, e dell'insieme di cluster
     * @param args parametri del main
     */
    public static void main(String[] args) {
        try {
            Data data = new Data();
            System.out.println(data);
            double radius;
            String response;
            do {
                do {
                    System.out.println("Insert radius (> 0): ");
                    radius = Keyboard.readDouble();
                } while (Double.isNaN(radius) || radius <= 0);
                QTMiner qt = new QTMiner(radius);
                try {
                    int numIter=qt.compute(data);
                    System.out.println("Number of clusters: " + numIter + '\n');
                    System.out.println(qt.getC().toString(data));
                }catch (ClusteringRadiusException e){
                    System.out.println("" + data.getNumberOfExamples() + " tuples in one cluster!");
                }
                do{
                    System.out.println("New execution? (y/n)");
                    response = Keyboard.readString();
                }while(response.length() > 1 | (response.charAt(0) != 'y' && response.charAt(0) != 'n'));
            }while (response.charAt(0) == 'y');
        }catch (EmptyDatasetException e){
            System.out.println("Dataset is empty!");
        }
    }
}
