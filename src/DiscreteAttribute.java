//classe concreta che modella un attributo discreto (numerico)
public class DiscreteAttribute extends Attribute {

    /**
     * array di oggetti String, uno per ciascun valore del dominio discreto.
     * I valori del dominio sono memorizzati in values seguendo un ordine lessicografico
     */
    String values[ ];

    /**
     * Invoca il costruttore della classe madre e inizializza il membro values con il parametro in input
     * @param name nome dell'attributo
     * @param index indice numerico dell'attributo
     * @param values array di stringhe rappresentanti il dominio dell'attributo
     */
    public DiscreteAttribute(String name, int index, String[] values) {
        super(name, index);
        this.values = values;
    }

    /**
     * restituisce la dimensione di values
     * @return numero di valori discreti nel dominio dell'attributo
     */
    int getNumberOfDistinctValues(){
        return values.length;
    }

    /**
     * restituisce value[i]
     * @param i posizione di un valore in values
     * @return valore discreto in posizione i di values
     */
    String getAttributeValue(int i){
        return values[i];
    }
}
