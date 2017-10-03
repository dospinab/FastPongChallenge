/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastpongchallenge.Entities;

import fastpongchallenge.Entity;
import fastpongchallenge.Window;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Shape;

/**
 *
 * @author lospinas
 */
public class Ball extends Entity{
    
    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;
    private int speedX = 5;
    private int speedY = 3;
    
    public Ball() {
        setPosX(100);
        setPosY(100);
        super.setColor(Color.WHITE);
    }
    @Override
    public void update() {
        this.setPosX(getPosX() + speedX);
        this.setPosY(getPosY() + speedY);
        checkBoundaries();
    }

    @Override
    public Shape getRenderObject() {
        Rectangle rect = new Rectangle(getPosX(), getPosY(), WIDTH, HEIGHT);
        return rect;
    }

    private void checkBoundaries() {
        if (this.getPosX() > Window.GAMEWIDTH - WIDTH) speedX *= -1;
        if (this.getPosX() < 0) speedX *= -1;
        if (this.getPosY() > Window.GAMEHEIGHT - 2*HEIGHT) speedY *= -1;
        if (this.getPosY() < 0) speedY *= -1;
    }
    
}
