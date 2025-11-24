import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeddingComplex {
    public static Map<String, String> createBestCouple(Map<String, List<String>> first, Map<String, List<String>> second) {
        Map<String, String> engaged = new HashMap<>(); // second -> first (who second is engaged to)
        Map<String, Integer> nextProposal = new HashMap<>(); // tracks next person to propose to
        
        // Initialize proposal tracking
        for (String person : first.keySet()) {
            nextProposal.put(person, 0);
        }
        
        // Keep track of free people from first group
        java.util.Queue<String> freePeople = new java.util.LinkedList<>(first.keySet());
        
        while (!freePeople.isEmpty()) {
            String proposer = freePeople.poll();
            List<String> preferences = first.get(proposer);
            int nextIndex = nextProposal.get(proposer);
            
            // If proposer has exhausted all preferences, skip
            if (nextIndex >= preferences.size()) {
                continue;
            }
            
            String proposed = preferences.get(nextIndex);
            nextProposal.put(proposer, nextIndex + 1);
            
            if (!engaged.containsKey(proposed)) {
                // proposed is free, engage them
                engaged.put(proposed, proposer);
            } else {
                // proposed is already engaged, check if they prefer proposer
                String currentPartner = engaged.get(proposed);
                List<String> proposedPreferences = second.get(proposed);
                
                int proposerRank = proposedPreferences.indexOf(proposer);
                int currentRank = proposedPreferences.indexOf(currentPartner);
                
                if (proposerRank < currentRank) {
                    // proposed prefers proposer, break current engagement
                    engaged.put(proposed, proposer);
                    freePeople.add(currentPartner); // current partner becomes free
                } else {
                    // proposed prefers current partner, proposer stays free
                    freePeople.add(proposer);
                }
            }
        }
        
        // Convert to first -> second mapping
        Map<String, String> result = new HashMap<>();
        for (Map.Entry<String, String> entry : engaged.entrySet()) {
            result.put(entry.getValue(), entry.getKey());
        }
        
        return result;
    }
}