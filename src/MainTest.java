import data.Data;
import keyboardinput.Keyboard;
import mining.QTMiner;

import data.EmptyDatasetException;
import java.io.FileNotFoundException;
import java.io.IOException;
import mining.ClusteringRadiusException;

public class MainTest {

    private int menu(){
        int answer;
        do {
            System.out.println("(1) Load Clusters from File");
            System.out.println("(2) Load Data");
            System.out.print("(1/2): ");
            answer=Keyboard.readInt();
        } while(answer<=0 || answer>2);
        return answer;
    }

    private QTMiner learningFromFile() throws FileNotFoundException, IOException, ClassNotFoundException{
        String fileName="";
        System.out.print("File name: ");
        fileName=Keyboard.readString();
        return new QTMiner(fileName+".dmp");
    }

    /**
     * consente il test delle classi implementate, in particolare permette il caricamento e
     * la stampa dei cluster da un file o la stampa dell'insieme di transazioni da una tabella
     * della base di dati, poi permette di acquisire da tastiera il numero real radius che
     * rappresenta il raggio dei cluster da scoprire. Permette, inoltre, di salvare i cluster
     * in un file e permette di decidere di ripetere l'esecuzione di QT con valori di radius
     * differenti
     * @param args parametri del main
     * @throws EmptyDatasetException se il dataset è vuoto
     */
    public static void main(String[] args) throws EmptyDatasetException {
        MainTest main = new MainTest();
		do {
        int menuAnswer=main.menu();
        switch(menuAnswer) {
            case 1:
                try {
                    QTMiner qt=main.learningFromFile();
                    System.out.println(qt.getC().toString());
                } catch (FileNotFoundException e1) {
                    System.out.println(e1.getMessage());
                } catch (IOException e1) {
                    System.out.println(e1.getMessage());
                } catch (ClassNotFoundException e1) {
                    System.out.println(e1.getMessage());
                }
                break;
            case 2:
                System.out.println("\nInsert table name");
                String table = Keyboard.readString();
                Data data = new Data(table);
                System.out.println(data);
                char answer='y';
                do {
                    double radius=1.0;
                    do {
                        System.out.print("Insert radius (>0): ");
                        radius=Keyboard.readDouble();
                    } while(radius<=0);
                    QTMiner qt=new QTMiner(radius);
                    try {
                        int numC=qt.compute(data);
                        System.out.println("Number of clusters: "+numC);
                        System.out.println(qt.getC().toString(data));
                        System.out.print("Backup file name: ");
                        String fileName=Keyboard.readString()+".dmp";
                        System.out.println("Saving clusters in "+fileName);
                        try {
                            qt.salva(fileName);
                        } catch (FileNotFoundException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        System.out.println("Saving transaction ended!");
                    }
                    catch(EmptyDatasetException | ClusteringRadiusException e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.print("New execution? (y/n) ");
                    answer=Keyboard.readChar();
                }
                while(Character.toUpperCase(answer)=='Y');
                break;
            default:
                System.out.println("Invalid option!");
        }
        System.out.print("Would you choose another option from the menu? (y/n) ");
        if(Character.toUpperCase(Keyboard.readChar())!='Y')
            break;
            System.out.println();
    }
		while(true);
}
    /**
     * consenta il test delle classi implementate, in particolare
     * permette la stampa dell'insieme di transazioni, e dell'insieme di cluster
     * @param args parametri del main
     */
    /*
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
    }*/
}