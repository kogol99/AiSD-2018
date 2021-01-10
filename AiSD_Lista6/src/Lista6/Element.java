package Lista6;

public class Element {

    private String key;
    private int value;

    Element(){
        this.key = "";
        this.value = 0;
    }

    Element(String key, int value){
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
