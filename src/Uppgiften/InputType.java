package Uppgiften;

public enum InputType {
    FOR_A_INT("int"),
    FOR_A_DOUBLE("double"),
    FOR_A_STRING("string");

    private final String input;

    InputType(String input) {
        this.input = input;
    }

    public String getType(){
        return input;
    }
}
