import java.util.ArrayList;
import java.util.List;

public class Character {
    // --- Existing Attributes ---
    protected String name;
    protected int maxHealth;
    protected int currentHealth;

    // --- NEW: Static List to Track All Characters ---
    private static List<Character> allCharacters = new ArrayList<>();

    // --- Constructor (Modified) ---
    public Character(String name, int maxHealth) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        // Add the newly created character to the static list
        allCharacters.add(this); 
    }
    
    // --- NEW: Static printStatus Method ---
    public static String printStatus() {
        StringBuilder status = new StringBuilder();
        
        status.append("------------------------------------------\n");
        status.append("Characters currently fighting : \n");

        for (Character character : allCharacters) {
            // Append the result of the character's toString method
            status.append(" - ").append(character.toString()).append("\n");
        }
        
        status.append("------------------------------------------\n");
        
        return status.toString();
    }

    // --- You will also need a basic toString() in Character for non-Sorcerer instances ---
    @Override
    public String toString() {
        // This format is used for simple Characters like "Frodon : 16/20"
        return this.name + " : " + this.currentHealth + "/" + this.maxHealth;
    }
    
    // --- Other methods like fight(Character c1, Character c2) go here ---
    // ...
}