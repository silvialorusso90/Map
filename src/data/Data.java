package data;

import data.Attribute;

//modella l'insieme di transazioni (tuple)
public class Data {

    /**
     * matrice nXm di tipo Object dove ogni riga modella una transazioni
     */
    private Object data[][];

    /**
     * cardinalità dell’insieme di transazioni (numero di righe in data)
     */
    private int numberOfExamples;

    /**
     * vettore degli attributi in ciascuna tupla (schema della tabella di dati)
     */
    private Attribute explanatorySet[];

    /**
     * - Inizializza la matrice data [ ][ ] con transazioni di esempio
     * - Inizializza explanatorySet creando cinque oggetti di tipo
     *   data.DiscreteAttribute, uno per ciascun attributo
     * - Inizializza numberOfExamples
     */
    public Data(){

        explanatorySet = new Attribute[5];

        String outLookValues[] = new String[3];
        outLookValues[0]="overcast";
        outLookValues[1]="rain";
        outLookValues[2]="sunny";
        explanatorySet[0] = new DiscreteAttribute("Outlook",0, outLookValues);

        String temperatureValues[] = new String[3];
        temperatureValues[0]="hot";
        temperatureValues[1]="mild";
        temperatureValues[2]="cool";
        explanatorySet[1] = new DiscreteAttribute("Temperature", 1, temperatureValues);

        String humidityValues[] = new String[2];
        humidityValues[0]="high";
        humidityValues[1]="normal";
        explanatorySet[2] = new DiscreteAttribute("Humidity", 2, humidityValues);

        String windValues[] = new String[2];
        windValues[0]="weak";
        windValues[1]="strong";
        explanatorySet[3] = new DiscreteAttribute("Wind",3, windValues);

        String playTennisValues[]=new String[2];
        playTennisValues[0]="yes";
        playTennisValues[1]="no";
        explanatorySet[4] = new DiscreteAttribute("PlayTennis",4, playTennisValues);

        numberOfExamples = 14;
        data = new Object [14][5];

        //primo esempio
        data[0][0]=((DiscreteAttribute)explanatorySet[0]).getAttributeValue(2);
        data[0][1]=((DiscreteAttribute)explanatorySet[1]).getAttributeValue(0);
        data[0][2]=((DiscreteAttribute)explanatorySet[2]).getAttributeValue(0);
        data[0][3]=((DiscreteAttribute)explanatorySet[3]).getAttributeValue(0);
        data[0][4]=((DiscreteAttribute)explanatorySet[4]).getAttributeValue(1);
        //secondo esempio
        data[1][0]=((DiscreteAttribute)explanatorySet[0]).getAttributeValue(2);
        data[1][1]=((DiscreteAttribute)explanatorySet[1]).getAttributeValue(0);
        data[1][2]=((DiscreteAttribute)explanatorySet[2]).getAttributeValue(0);
        data[1][3]=((DiscreteAttribute)explanatorySet[3]).getAttributeValue(1);
        data[1][4]=((DiscreteAttribute)explanatorySet[4]).getAttributeValue(1);
        //terzo esempio
        data[2][0]=((DiscreteAttribute)explanatorySet[0]).getAttributeValue(0);
        data[2][1]=((DiscreteAttribute)explanatorySet[1]).getAttributeValue(0);
        data[2][2]=((DiscreteAttribute)explanatorySet[2]).getAttributeValue(0);
        data[2][3]=((DiscreteAttribute)explanatorySet[3]).getAttributeValue(0);
        data[2][4]=((DiscreteAttribute)explanatorySet[4]).getAttributeValue(0);
        //quarto esempio
        data[3][0]=((DiscreteAttribute)explanatorySet[0]).getAttributeValue(1);
        data[3][1]=((DiscreteAttribute)explanatorySet[1]).getAttributeValue(1);
        data[3][2]=((DiscreteAttribute)explanatorySet[2]).getAttributeValue(0);
        data[3][3]=((DiscreteAttribute)explanatorySet[3]).getAttributeValue(0);
        data[3][4]=((DiscreteAttribute)explanatorySet[4]).getAttributeValue(0);
        //quinto esempio
        data[4][0]=((DiscreteAttribute)explanatorySet[0]).getAttributeValue(1);
        data[4][1]=((DiscreteAttribute)explanatorySet[1]).getAttributeValue(2);
        data[4][2]=((DiscreteAttribute)explanatorySet[2]).getAttributeValue(1);
        data[4][3]=((DiscreteAttribute)explanatorySet[3]).getAttributeValue(0);
        data[4][4]=((DiscreteAttribute)explanatorySet[4]).getAttributeValue(0);
        //sesto esempio
        data[5][0]=((DiscreteAttribute)explanatorySet[0]).getAttributeValue(1);
        data[5][1]=((DiscreteAttribute)explanatorySet[1]).getAttributeValue(2);
        data[5][2]=((DiscreteAttribute)explanatorySet[2]).getAttributeValue(1);
        data[5][3]=((DiscreteAttribute)explanatorySet[3]).getAttributeValue(1);
        data[5][4]=((DiscreteAttribute)explanatorySet[4]).getAttributeValue(1);
        //settimo esempio
        data[6][0]=((DiscreteAttribute)explanatorySet[0]).getAttributeValue(0);
        data[6][1]=((DiscreteAttribute)explanatorySet[1]).getAttributeValue(2);
        data[6][2]=((DiscreteAttribute)explanatorySet[2]).getAttributeValue(1);
        data[6][3]=((DiscreteAttribute)explanatorySet[3]).getAttributeValue(1);
        data[6][4]=((DiscreteAttribute)explanatorySet[4]).getAttributeValue(0);
        //otavo esempio
        data[7][0]=((DiscreteAttribute)explanatorySet[0]).getAttributeValue(2);
        data[7][1]=((DiscreteAttribute)explanatorySet[1]).getAttributeValue(1);
        data[7][2]=((DiscreteAttribute)explanatorySet[2]).getAttributeValue(0);
        data[7][3]=((DiscreteAttribute)explanatorySet[3]).getAttributeValue(0);
        data[7][4]=((DiscreteAttribute)explanatorySet[4]).getAttributeValue(1);
        //nono esempio
        data[8][0]=((DiscreteAttribute)explanatorySet[0]).getAttributeValue(2);
        data[8][1]=((DiscreteAttribute)explanatorySet[1]).getAttributeValue(2);
        data[8][2]=((DiscreteAttribute)explanatorySet[2]).getAttributeValue(1);
        data[8][3]=((DiscreteAttribute)explanatorySet[3]).getAttributeValue(0);
        data[8][4]=((DiscreteAttribute)explanatorySet[4]).getAttributeValue(0);
        //decimo esempio
        data[9][0]=((DiscreteAttribute)explanatorySet[0]).getAttributeValue(1);
        data[9][1]=((DiscreteAttribute)explanatorySet[1]).getAttributeValue(1);
        data[9][2]=((DiscreteAttribute)explanatorySet[2]).getAttributeValue(1);
        data[9][3]=((DiscreteAttribute)explanatorySet[3]).getAttributeValue(0);
        data[9][4]=((DiscreteAttribute)explanatorySet[4]).getAttributeValue(0);
        //undicesimo esempio
        data[10][0]=((DiscreteAttribute)explanatorySet[0]).getAttributeValue(2);
        data[10][1]=((DiscreteAttribute)explanatorySet[1]).getAttributeValue(1);
        data[10][2]=((DiscreteAttribute)explanatorySet[2]).getAttributeValue(1);
        data[10][3]=((DiscreteAttribute)explanatorySet[3]).getAttributeValue(1);
        data[10][4]=((DiscreteAttribute)explanatorySet[4]).getAttributeValue(0);
        //dodicesimo esempio
        data[11][0]=((DiscreteAttribute)explanatorySet[0]).getAttributeValue(0);
        data[11][1]=((DiscreteAttribute)explanatorySet[1]).getAttributeValue(1);
        data[11][2]=((DiscreteAttribute)explanatorySet[2]).getAttributeValue(0);
        data[11][3]=((DiscreteAttribute)explanatorySet[3]).getAttributeValue(1);
        data[11][4]=((DiscreteAttribute)explanatorySet[4]).getAttributeValue(0);
        //tredicesimo esempio
        data[12][0]=((DiscreteAttribute)explanatorySet[0]).getAttributeValue(0);
        data[12][1]=((DiscreteAttribute)explanatorySet[1]).getAttributeValue(0);
        data[12][2]=((DiscreteAttribute)explanatorySet[2]).getAttributeValue(1);
        data[12][3]=((DiscreteAttribute)explanatorySet[3]).getAttributeValue(0);
        data[12][4]=((DiscreteAttribute)explanatorySet[4]).getAttributeValue(0);
        //quatordicesimo esempio
        data[13][0]=((DiscreteAttribute)explanatorySet[0]).getAttributeValue(1);
        data[13][1]=((DiscreteAttribute)explanatorySet[1]).getAttributeValue(1);
        data[13][2]=((DiscreteAttribute)explanatorySet[2]).getAttributeValue(0);
        data[13][3]=((DiscreteAttribute)explanatorySet[3]).getAttributeValue(1);
        data[13][4]=((DiscreteAttribute)explanatorySet[4]).getAttributeValue(1);

    }

    /**
     * restituisce l'insieme di transazioni
     * @return numberOfExamples
     */
    public int getNumberOfExamples(){
        return numberOfExamples;
    }

    /**
     * restituisce la dimensione di explanatorySet
     * @return cardinalità dell'insieme degli attributi
     */
    public int getNumberOfExplanatoryAttributes(){
        return explanatorySet.length;
    }

    /**
     * restituisce explanatorySet
     * @return explanatorySet
     */
    Attribute[] getAttributeSchema(){
        return explanatorySet;
    }

    /**
     * restituisce valore assunto in data dall'attributo in posizione attributeIndex,
     * nella riga in posizione exampleIndex
     * @param exampleIndex indice di riga della matrice memorizzata in data
     * @param attributeIndex indice di colonna della matrice memorizzata in data
     * @return data[exampleIndex][attributeIndex]
     */
    public Object getAttributeValue(int exampleIndex, int attributeIndex){
        //TO DO
        return data[exampleIndex][attributeIndex];
    }

    /**
     * crea una stringa in cui memorizza lo schema della tabella (vedi explanatorySet) e
     * le transazioni memorizzate in data, opportunamente enumerate
     * @return stringa che modella lo stato dell'oggetto
     */
    @Override
    public String toString() {
        String s = "";
        for(int i = 0; i < explanatorySet.length; i++)
        {
            if(i != 0)
                s = s + ", ";
            s = s + explanatorySet[i];
        }
        s = s + "\n";
        for(int i = 0; i < data.length; i++)
        {
            if(i != 0)
                s = s + "\n";
            s = s + (i + 1) + ": ";
            for(int j = 0; j < data[i].length; j++)
            {
                if(j != 0)
                    s = s + ", ";
                s = s + data[i][j];
            }
        }
        return s;
    }

    /**
     * Crea e restituisce un oggetto di data.Tuple che modella come sequenza di coppie
     * Attributo-valore la i-esima riga in data
     * @param index indice di riga
     * @return tuple
     */
    public Tuple getItemSet(int index){
        Tuple tuple=new Tuple(explanatorySet.length);
        for(int i=0;i<explanatorySet.length;i++)
            tuple.add(new DiscreteItem(explanatorySet[i], (String)data[index][i]),i);
        return tuple;

    }
}