package javacity.world;

/**
 * A class to handle calculating metrics
 * about a city, such as population.
 * Essentially a load of global functions, so shoot me.
 * @author Tom
 */
public class Metrics {
    
    public static int population(City c)
    {
        return c.getTilesByType("occupied_r").size();
    }
    
    public static int availableJobs(City c)
    {
        return c.getTilesByType("zone_i").size() + 
               c.getTilesByType("zone_c").size();
    }
    
    public static int occupiedJobs(City c)
    {
        return c.getTilesByType("occupied_i").size() + 
               c.getTilesByType("occupied_c").size();        
    }
}
