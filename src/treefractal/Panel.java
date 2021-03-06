/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treefractal;

import java.awt.Graphics;

/**
 *
 * @author 348676487
 */
public class Panel extends javax.swing.JPanel {

    //The angle factor
    static double angleFactor = Math.PI / 4;
    //The size factor
    static double sizeFactor = 0.592;
    //The number of times to repeat the pattern
    static int depth = 8;
    //The length of a tree's trunck
    static int trunkHeight = 400;

    /**
     * Creates new form Panel
     */
    public Panel() {
        initComponents();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Draw a tree fractal pattern
        treeFractal(g, depth, this.getWidth() / 2, this.getHeight(), 0.4 * this.getHeight(), Math.PI / 2);
    }

    /**
     * Given the number of iterations, the coordinates of the tree parts, the
     * length of the trunk, and the angle of the branch, draw a tree fractal
     * pattern.
     *
     * @param g The Graphics object to protect
     * @param depth Number of times to repeat the pattern.
     * @param x The x coordinate of the tree part.
     * @param y The y coordinate of the tree part.
     * @param length The length of the trunk.
     * @param angle The angle of the branch.
     */
    public void treeFractal(Graphics g, int depth, int x, int y, double length, double angle) {
        //Calculate the ending x,y coordinates for this line segment.
        //As we are moving up, we subtract from the current base coordinates 
        //The formula used to determine end points by definition of sin and cos
        int x1 = x - (int) (Math.cos(angle) * length);
        int y1 = y - (int) (Math.sin(angle) * length);
        //Actually draw the line
        g.drawLine(x, y, x1, y1);
        //If we have more depth to go, recurse
        if (depth > 0) {
            treeFractal(g, depth - 1, x1, y1, length * sizeFactor, angle + angleFactor);
            treeFractal(g, depth - 1, x1, y1, length * sizeFactor, angle - angleFactor);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
