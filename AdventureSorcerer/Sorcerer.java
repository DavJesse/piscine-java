public class Sorcerer extends Character implements Healer {
    private int healCapacity;

    /**
     * Constructor for Sorcerer.
     * @param name The name of the sorcerer.
     * @param maxHealth The maximum health of the sorcerer.
     * @param healCapacity The amount of HP the sorcerer can heal per action.
     */
    public Sorcerer(String name, int maxHealth, int healCapacity) {
        // Call the parent Character constructor
        super(name, maxHealth); 
        this.healCapacity = healCapacity;
    }

    // --- Implementation of Healer Interface ---

    /**
     * Returns the sorcerer's heal capacity.
     * @return The heal capacity value.
     */
    @Override
    public int getHealCapacity() {
        return this.healCapacity;
    }

    /**
     * Heals the target character by adding healCapacity to their currentHealth.
     * currentHealth cannot exceed maxHealth.
     * @param character The Character object to be healed.
     */
    @Override
    public void heal(Character character) {
        // Calculate the new health
        int newHealth = character.currentHealth + this.healCapacity;
        
        // Ensure newHealth does not exceed the character's maxHealth
        // We can access character.currentHealth and character.maxHealth 
        // because we made them 'protected' in Character.java.
        if (newHealth > character.maxHealth) {
            character.currentHealth = character.maxHealth;
        } else {
            character.currentHealth = newHealth;
        }
        
        System.out.println(this.name + " heals " + character.name + " for " + this.healCapacity + " HP.");
    }

    // --- Override toString Method ---

    /**
     * Overrides the toString method to provide a custom string representation.
     */
    @Override
    public String toString() {
        if (this.currentHealth <= 0) {
            // Format for a dead sorcerer
            return this.name + " is a dead sorcerer. So bad, it could heal " + this.healCapacity + " HP.";
        } else {
            // Format for a living sorcerer
            return this.name + " is a sorcerer with " + this.currentHealth + " HP. It can heal " + this.healCapacity + " HP.";
        }
    }
}
