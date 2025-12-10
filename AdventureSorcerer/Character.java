// Assuming the original Character class structure
public class Character {
    protected String name;
    protected int maxHealth;
    // **CHANGE** private to protected
    protected int currentHealth; 

    // Constructor (no change needed unless your base class is different)
    public Character(String name, int maxHealth) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        // ... (other initialization)
    }

    // You may need a setter for currentHealth if you don't change it to protected,
    // but protected is more direct for this problem.
    // ... (other methods like fight, printStatus, etc.)
}
