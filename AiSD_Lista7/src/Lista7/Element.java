package Lista7;

public class Element {

    private int value;
    private String color;
    private int size;

    Element(){
        this.value = 0;
        this.color = "";
        this.size = 0;
    }

    Element(int value, String color, int size){
        this.value = value;
        this.color = color;
        this.size = size;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Element - value: " + this.value + "; color: " + this.color + "; size: " + this.size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
