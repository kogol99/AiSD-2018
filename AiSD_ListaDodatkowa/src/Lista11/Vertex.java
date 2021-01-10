package Lista11;

public class Vertex {

    private int value;
    private int condition;
    private boolean infected;

    Vertex(int value){
        this.value = value;
        this.condition = 0;
        this.infected = false;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getCondition() {
        return condition;
    }

     /*
     * 0 - neutralny
     * 1 - zdrowy
     * 2 - chory
     *
     */
    public void setCondition(int condition) {
        this.condition = condition;
    }

    public boolean isInfected() {
        return infected;
    }

    public void setInfected(boolean infected) {
        this.infected = infected;
    }
}
