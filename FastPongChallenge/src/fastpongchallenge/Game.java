/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastpongchallenge;

import fastpongchallenge.Entities.Ball;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

/**
 *
 * @author lospinas
 */
public class Game{
    
    private static Window game;
    private Thread thread;
    private Entity ent = new Ball();
    
    private boolean running = false;
    /**
     * @param args the command line arguments
     */
    
    public Game() {
        game = new Window();
        start();
    }
    public static void main(String[] args) {
        new Game();
    }
    
    public void start() {
        if (running) return;
        running = true;
        run();
    }

    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 30.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                updates++;
                delta--;
            }
            render();
            frames++;
   
            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println("FPS: " + frames + " TICKS: " + updates);
                frames = 0;
                updates = 0;
            }
        }
    }

    public void render() {
        BufferStrategy bs = game.getBufferStrategy();
        Graphics2D g = (Graphics2D) bs.getDrawGraphics();
        ///////////
        //DIBUJAR
        g.fillRect(0, 0, Window.GAMEWIDTH, Window.GAMEHEIGHT);
        renderEntity(ent, g);
        ///////////
        g.dispose();
        bs.show();
        
    }

    private void tick() {
        ent.update();
    }

    private void renderEntity(Entity ent, Graphics2D g) {
        g.setColor(ent.getColor());
        g.draw(ent.getRenderObject());
    }
    
}
