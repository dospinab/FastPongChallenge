/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastpongchallenge;

import java.awt.Color;
import java.awt.Shape;

/**
 *
 * @author lospinas
 */
public abstract class Entity {
    
    private int posX;
    private int posY;
    private Color color;
    
    public abstract void update();
    public abstract Shape getRenderObject();
    
    public Color getColor() {
        return color;
    }
    
    public int getPosX() {
        return posX;
    }
    
    public int getPosY() {
        return posY;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    
}
