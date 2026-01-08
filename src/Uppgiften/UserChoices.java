package Uppgiften;

public enum UserChoices {
    CHANGE_BUDGET("1", "Change budget"),
    ADD_EXPENSE("2", "Add expense"),
    EDIT_EXPENSE("3", "Edit expense"),
    CHECK_OVERVIEW("4", "Check overview"),
    EXIT("5", "Exit");

    private final String key;
    private final String description;

    UserChoices(String key, String description) {
        this.key = key;
        this.description = description;
    }

    public String getKey() {
        return key;
    }

    public String getDescription() {
        return description;
    }

    public static UserChoices fromInput(String key){
        for (UserChoices userChoice : values()){
            if (userChoice.getKey().equals(key)){
                return userChoice;
            }
        }
        return null;
    }

    public static void getAllDescriptions(){
        for (UserChoices userChoice : values()){
            System.out.println(userChoice.getKey() + " " + userChoice.getDescription());
        }
    }
}
