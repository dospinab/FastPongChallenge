/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastpongchallenge;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

/**
 *
 * @author lospinas
 */
public class Window extends JFrame {
    
    public static final int GAMEWIDTH = 800;
    public static final int GAMEHEIGHT = 600;
    
    public Canvas canvas;
    public static Graphics2D g;
    
    private BufferStrategy bufferStrategy;
    
    public Window() {
        this.setSize(GAMEWIDTH, GAMEHEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setResizable(false);
        this.setVisible(true);
        
        canvas = new Canvas();
        canvas.setSize(GAMEWIDTH, GAMEHEIGHT);
        this.add(canvas);
        canvas.createBufferStrategy(2);
        
    }
    
    public BufferStrategy getBufferStrategy() {
        if (bufferStrategy == null) bufferStrategy = canvas.getBufferStrategy();
        return bufferStrategy;
    }
}
