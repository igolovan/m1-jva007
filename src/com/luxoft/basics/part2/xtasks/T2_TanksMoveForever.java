package com.luxoft.basics.part2.xtasks;

import javax.swing.*;
import java.awt.*;

public class T2_TanksMoveForever extends JPanel {
    int tankX = 0;
    int tankY = 0;
    String side = "right";
    String tankQuadrant = getTankQuadrant(tankX, tankY);

    void runTheGame() {
        while (true == true) {
            if (side.equals("right")) {
                moveForward();
            } else {
                moveBackward();
            }

            tankQuadrant = getTankQuadrant(tankX, tankY);

            if (tankQuadrant.equals("A_1") && tankX == 0) {
                side = "right";
            } else if (tankQuadrant.equals("I_1") && tankX == 512){
                side = "left";
            }
        }
    }

    void moveBackward() {
        //int cellWidth = 2;
        tankX--;
        tankY = tankY;
        repaint();
        sleep(50);
    }

    void moveForward() {
        //int cellWidth = 2;
        tankX++;
        tankY = tankY;
        repaint();
        sleep(50);
    }

    String getTankQuadrant(int x, int y) {
        String letters = " ABCDEFGHI";
        char xValue = letters.charAt(x / 64 + 1);
        int yValue = y / 64 + 1;

        String result = "" + xValue + "_" + yValue;
        return result;
    }

    // Magic bellow. Do not worry about this now, you will understand everything in this course.
    // Please concentrate on your tasks only.

    final int BF_WIDTH = 576 + 25;
    final int BF_HEIGHT = 576 + 25;

    public static void main(String[] args) throws Exception {
        T2_TanksMoveForever bf = new T2_TanksMoveForever();
        bf.runTheGame();
    }

    public T2_TanksMoveForever() throws Exception {
        JFrame frame = new JFrame("MOVE TANK FORWARD");
        frame.setLocation(500, 150);
        frame.setMinimumSize(new Dimension(BF_WIDTH, BF_HEIGHT + 22));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);
    }

    void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {

        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        paintBF(g);

        g.setColor(new Color(255, 0, 0));
        g.fillRect(tankX, tankY, 64, 64);
    }

    private void paintBF(Graphics g) {
        super.paintComponent(g);

        int i = 0;
        Color cc;
        for (int v = 0; v < 9; v++) {
            for (int h = 0; h < 9; h++) {
                if (i % 2 == 0) {
                    cc = new Color(252, 241, 177);
                } else {
                    cc = new Color(233, 243, 255);
                }
                i++;
                g.setColor(cc);
                g.fillRect(h * 64, v * 64, 64, 64);
            }
        }
    }

}