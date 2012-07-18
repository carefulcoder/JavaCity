/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javacity.ui;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.util.HashMap;
import javacity.world.City;
import javacity.world.Tile;
import javax.imageio.ImageIO;

/**
 *
 * @author Tom
 */
public class GuiCanvas extends Canvas implements Runnable {
    
    private City c;
    private HashMap<String, Image> images;
    
    public GuiCanvas(City c)
    {
        super();
        this.c = c;
        
        try {
            images = new HashMap<String,Image>();
            images.put("zone_r", ImageIO.read(new File("zone_r.png")));
            images.put("zone_c", ImageIO.read(new File("zone_c.png")));
            images.put("zone_i", ImageIO.read(new File("zone_i.png")));   
            
            images.put("grass",  ImageIO.read(new File("grass.png")));   
            images.put("road",  ImageIO.read(new File("road.png")));   
            
            images.put("occupied_r", ImageIO.read(new File("occupied_r.png")));
            images.put("occupied_c", ImageIO.read(new File("occupied_c.png")));
            images.put("occupied_i", ImageIO.read(new File("occupied_i.png")));   
            
        } catch (Exception e) {
            System.out.println("fail");
        }
        

    }
    
    public void init()
    {
        this.setPreferredSize(new Dimension(c.getXSize()*32,c.getYSize()*32));
        this.setVisible(true);
        
        this.createBufferStrategy(2);
        this.setIgnoreRepaint(true);        
    }
    
    public void draw()
    {
        Graphics2D g2 = (Graphics2D)this.getBufferStrategy().getDrawGraphics();
        
        for (int x = 0; x < c.getXSize()*32; x+=32) {
            for (int y = 0; y < c.getYSize()*32; y+=32) {
                Tile t = c.getByLocation(x/32, y/32);
                
                if (this.images.containsKey(t.getType())) {
                    g2.drawImage(this.images.get(t.getType()),x,y,this);
                } else {
                    g2.setColor(Color.gray);
                    g2.fillRect(x, y, 32, 32);
                }
            }
        }
        

        
        this.getBufferStrategy().show();
    }
    
    /**
     * Run our animation thread
     * that constantly redraws the city.
     */
    @Override
    public void run()
    {
        while (true) {       
            //draw at a multiple of 100 FPS.
            if (System.currentTimeMillis() % 10 == 0) {
                draw();
            }
        }
    }
}
