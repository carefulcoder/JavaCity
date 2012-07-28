package javacity.world;
import javacity.lib.Point;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * A city can be thought of as a map for the city to reside in.
 * A city consists of a grid of tiles, which start out as grass tiles but
 * can become zones or roads by the player actions. Game logic objects
 * run each tick of the game loop on an instance of this Map class
 * which provides methods for finding tiles to calculate things
 * @author Tom
 */
public class Map
{
    private Tile[][] grid;
    private Building[] buildings;
    
    /**
     * Construct our city.
     */
    public Map(int xsize, int ysize)
    {    
        this.grid = new Tile[xsize][ysize];

        for (int x = 0; x < xsize; x++) {
            for (int y = 0; y < ysize; y++) {
                Tile t = new Tile();
                this.grid[x][y] = t;
            }
        }
    }
    
    /**
     * Get tiles from the world by their type
     * @param string type the type of the tile
     * @return ArrayList<Tile>
     */
    public ArrayList<Tile> getTiles(Type type, boolean occupied)
    {
        ArrayList<Tile> tiles = new ArrayList<Tile>();
        /*for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                Tile t = grid[i][j];
                if(t.getBuilding().getType() == type) {
                    boolean occ = t.hasBuilding() && t.getBuilding().isOccupied();
                    if (occ == occupied) {
                        tiles.add(t);                    
                    }
                }            
            }
        }*/
        return tiles;
    }
    
    /**
     * Get the location of a tile in the game world.
     * @param Tile t The tile to get location of
     * @return Point2D the location
     */

    
    /**
     * Get tiles by their location
     * @param location
     * @return 
     */
    public Tile getByLocation(Point location)
    {
        return this.getByLocation(location.getX(), location.getY());
    }
    
    /**
     * Get tiles by X & Y co-ordinates
     * @param int x
     * @param int y
     * @return 
     */
    public Tile getByLocation(int x, int y)
    {
        return this.grid[x][y];
    }
    
    /**
     * Test whether a location is within the city limits
     * @param int x
     * @param int y
     * @return bool
     */
    public Boolean isValidLocation(int x, int y)
    {
        return (x >= 0 && x < this.grid.length && y >= 0 && y < this.grid[0].length);
    }
    
    /**
     * Get the size of our city
     * @return int
     */
    public int getXSize()
    {
        return this.grid.length;
    }
    
    public int getYSize()
    {
        return this.grid[0].length;
    }
    
    /**
     * Get neighbours of a particular tile for a given radius
     * @param t The tile to get neighbours of
     * @param int radius the radius to find
     * @return ArrayList<Tile> of tiles
     */
    /*public ArrayList<Tile> getNeighbours(Tile t, int radius)
    {
        ArrayList<Tile> ret = new ArrayList<Tile>();
        Point loc = this.getLocationOfTile(t);
        for(int x = loc.getX()-radius; x<= loc.getX()+radius; x++) {
            for (int y = loc.getY()-radius; y <= loc.getY()+radius; y++) {
                if (this.isValidLocation(x, y) && (y != loc.getY() || x != loc.getX())) {
                    ret.add(this.getByLocation(x, y));
                }
            }
        }
        return ret;
    }
    
    /**
     * Get the direct neighbours of a given tile
     * @param t The tile to get neigbours of
     * @return 
     */
    /*public ArrayList<Tile> getNeighbours(Tile t)
    {
        return this.getNeighbours(t, 1);
    } */   
}
