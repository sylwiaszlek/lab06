package magazyn.lab2;

public enum ItemCondition {

    NEW("NEW"),
    USED("USED"),
    REFURBISHED("REFURBISHED");

    private String condition;

    ItemCondition(String condition) {
        this.condition = condition;
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
