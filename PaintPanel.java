package paint;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PaintPanel extends JPanel implements MouseListener, MouseMotionListener {
    private final static int BLACK = 2, BLUE = 3, GREEN = 4, MAGENTA = 5, RED = 6, YELLOW = 7, CYAN = 8;
    private final static int LINE = 0, OVAL = 1, RECT = 2;
    private int currentColour = BLACK;
    private int currentShape = LINE;
    private int value = 47;
    private int size;

    private Color color;
    private boolean dragShape, eraser;

    private int old_X, current_X;
    private int old_Y, current_Y;
    private int diameter = 20;
    private boolean drag;
    private Graphics2D graphics;

    public PaintPanel() {
        setPreferredSize(new Dimension(900, 600));
        setBackground(Color.white);
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        size = 1;

    }

    public int getSizeFromPaint()
    {
        return size;
    }

    public void setSizeForPaint(int size)
    {
        this.size = size;
    }



    public void chooseShape(int shape) {
        Graphics graphics = getGraphics();
        int width = getWidth();

        graphics.setColor(Color.GRAY);
        ((Graphics2D)graphics).setStroke(new BasicStroke(3));
        graphics.drawRect(width - (11 + currentShape) * value - 2, 5, 45, 39);
        currentShape = shape;
        graphics.setColor(Color.WHITE);
        graphics.drawRect(width - (11 + currentShape) * value - 2, 5, 45, 39);
    }



    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        /**Contur pentru fereastra de desenat*/
        int width = getWidth();
        int height = getHeight();
        graphics.setColor(Color.GRAY);
        ((Graphics2D)graphics).setStroke(new BasicStroke(3));

        graphics.fillRect(0, 0, width, 50);

        graphics.setColor(Color.BLACK);
        ((Graphics2D)graphics).setStroke(new BasicStroke(1));
        graphics.drawLine(width / 2, 0, width / 2, 49);


        /**CLEAR 'Button'*/
        graphics.setColor(Color.WHITE);
        graphics.fillRect(width - value, 7, 40, 35);
        graphics.setColor(Color.BLACK);
        graphics.drawRect(width - value, 7, 40, 35);
        graphics.drawString("CLEAR", width - 46, 28);

        /**BLACK*/
        graphics.setColor(Color.BLACK);
        graphics.fillRect(width - 2 * value, 7, 40, 35);

        /**BLUE*/
        graphics.setColor(Color.BLUE);
        graphics.fillRect(width - 3 * value, 7, 40, 35);

        /**GREEN*/
        graphics.setColor(Color.GREEN);
        graphics.fillRect(width - 4 * value, 7, 40, 35);

        /**MAGENTA*/
        graphics.setColor(Color.MAGENTA);
        graphics.fillRect(width - 5 * value, 7, 40, 35);

        /**RED*/
        graphics.setColor(Color.RED);
        graphics.fillRect(width - 6 * value, 7, 40, 35);

        /**YELLOW*/
        graphics.setColor(Color.YELLOW);
        graphics.fillRect(width - 7 * value, 7, 40, 35);

        /**CYAN*/
        graphics.setColor(Color.CYAN);
        graphics.fillRect(width - 8 * value, 7, 40, 35);

        /**ELIPSE*/
        graphics.setColor(Color.BLACK);
        graphics.drawOval(width - 12 * value, 7, 40, 35);

        /**LINE*/
        graphics.setColor(Color.BLACK);
        graphics.drawLine(width - 11 * value, 42, width - 11 * value + 40, 7);

        /**RECT*/
        graphics.setColor(Color.BLACK);
        graphics.drawRect(width - 13 * value, 7, 40, 34);

        /**ERASER*/
        graphics.setColor(Color.BLACK);
        graphics.drawRect(width - 9 * value, 20, 20, 20);

        graphics.setColor(Color.WHITE);
        ((Graphics2D)graphics).setStroke(new BasicStroke(3));
        graphics.drawRect(width - currentColour * value - 2, 5, 45, 39);
        graphics.drawRect(width - (11 + currentShape) * value - 2, 5, 45, 39);


    }



    public void newColour(int colour) {
        int width = getWidth();
        Graphics graphics = getGraphics();
        if(colour == 9)
        {
            graphics.setColor(Color.GRAY);
            ((Graphics2D)graphics).setStroke(new BasicStroke(3));
            graphics.drawRect(width - (11 + currentShape) * value - 2, 5, 45, 39);
            graphics.setColor(Color.WHITE);
            graphics.drawRect(width - 9 * value - 3 , 17, 27, 27);
        }

        if (colour > 8 || colour < 2) {
            return;
        }

        graphics.setColor(Color.GRAY);
        ((Graphics2D)graphics).setStroke(new BasicStroke(3));
        graphics.drawRect(width - currentColour * value - 2, 5, 45, 39);
        currentColour = colour;
        graphics.setColor(Color.WHITE);
        graphics.drawRect(width - currentColour * value - 2, 5, 45, 39);

    }

    public void newShapeColour(int shape) {
        int width = getWidth();
        Graphics graphics = getGraphics();
        if(eraser == true)
        {
            ((Graphics2D)graphics).setStroke(new BasicStroke(3));
            graphics.setColor(Color.GRAY);
            graphics.drawRect(width - 9 * value - 3 , 17, 27, 27);
            currentShape = shape;
            graphics.setColor(Color.WHITE);
            graphics.drawRect(width - (11 + currentShape) * value - 2, 5, 45, 39);

        }
        if (shape < 0 || shape > 2) {
            return;
        }

        graphics.setColor(Color.GRAY);
        ((Graphics2D)graphics).setStroke(new BasicStroke(3));
        graphics.drawRect(width - (11 + currentShape) * value - 2, 5, 45, 39);
        currentShape = shape;
        graphics.setColor(Color.WHITE);
        graphics.drawRect(width - (11 + currentShape) * value - 2, 5, 45, 39);
    }

    public void setColour() {
        graphics = (Graphics2D)getGraphics();
        switch (currentColour) {
            case BLACK:
                graphics.setColor(Color.BLACK);
                break;
            case BLUE:
                graphics.setColor(Color.BLUE);
                break;
            case GREEN:
                graphics.setColor(Color.GREEN);
                break;
            case MAGENTA:
                graphics.setColor(Color.MAGENTA);
                break;
            case RED:
                graphics.setColor(Color.RED);
                break;
            case YELLOW:
                graphics.setColor(Color.YELLOW);
                break;
            case CYAN:
                graphics.setColor(Color.CYAN);
                break;
        }

    }

    /**
     * MouseListener
     */
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int width = getWidth();
        int height = getHeight();

        int current_X = e.getX();
        int current_Y = e.getY();

        if (drag == true) {
            return;
        }
        if (current_Y > 7 && current_Y < 42) {
            if (current_X > width - value && current_X < width - 10) {
                eraser = false;
                repaint();
            } else {
                if (current_X > width - 2 * value && current_X < width - value) {
                    newColour(BLACK);
                    return;
                }

                if (current_X > width - 3 * value && current_X < width - 2 * value) {
                    newColour(BLUE);
                    return;
                }

                if (current_X > width - 4 * value && current_X < width - 3 * value) {
                    newColour(GREEN);
                    return;
                }

                if (current_X > width - 5 * value && current_X < width - 4 * value) {
                    newColour(MAGENTA);
                    return;
                }

                if (current_X > width - 6 * value && current_X < width - 5 * value) {
                    newColour(RED);
                    return;
                }

                if (current_X > width - 7 * value && current_X < width - 6 * value) {
                    newColour(YELLOW);
                    return;
                }

                if (current_X > width - 8 * value && current_X < width - 7 * value) {
                    newColour(CYAN);
                    return;
                }

                if (current_X > width - 9 * value && current_Y < width - 8 * value) {
                    eraser = true;
                    newColour(9);
                    return;
                }

                if (current_X > width - 11 * value && current_X < width - 10 * value) {
                    newShapeColour(LINE);
                    eraser = false;
                    return;
                }

                if (current_X > width - 12 * value && current_X < width - 11 * value) {
                    newShapeColour(OVAL);
                    eraser = false;
                    return;
                }

                if (current_X > width - 13 * value && current_X < width - 12 * value) {
                    newShapeColour(RECT);
                    eraser = false;
                    return;
                }
            }
        } else {
            if (current_X > 3 && current_X < width - value && current_Y > 42 && current_Y < height - 3) {
                old_X = current_X;
                old_Y = current_Y;
                drag = true;
                setColour();
            }
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (drag == false) {
            return;
        }
        drag = false;
        if (dragShape == true) {
            if (currentShape == OVAL) {

                if(size == 1) {
                    graphics.setColor(color);
                    graphics.setStroke(new BasicStroke(1));
                    graphics.drawOval(old_X, old_Y, diameter + current_X - old_X, diameter + current_Y - old_Y);
                    dragShape = false;
                    return;
                }
                else if(size == 2){
                    graphics.setColor(color);
                    graphics.setStroke(new BasicStroke(3));
                    graphics.drawOval(old_X, old_Y, diameter + current_X - old_X, diameter + current_Y - old_Y);
                    dragShape = false;
                    return;
                }
                else if(size == 3){
                    graphics.setColor(color);
                    graphics.setStroke(new BasicStroke(5));
                    graphics.drawOval(old_X, old_Y, diameter + current_X - old_X, diameter + current_Y - old_Y);
                    dragShape = false;
                    return;
                }
                else if(size == 4){
                    graphics.setColor(color);
                    graphics.setStroke(new BasicStroke(7));
                    graphics.drawOval(old_X, old_Y, diameter + current_X - old_X, diameter + current_Y - old_Y);
                    dragShape = false;
                    return;
                }
            }

            if (currentShape == RECT) {
                if(size == 1) {
                    graphics.setColor(color);
                    graphics.setStroke(new BasicStroke(1));
                    graphics.drawRect(old_X, old_Y, diameter + current_X - old_X, diameter + current_Y - old_Y);
                    dragShape = false;
                    return;
                }
                else if(size == 2){
                    graphics.setColor(color);
                    graphics.setStroke(new BasicStroke(3));
                    graphics.drawRect(old_X, old_Y, diameter + current_X - old_X, diameter + current_Y - old_Y);
                    dragShape = false;
                    return;
                }
                else if(size == 3){
                    graphics.setColor(color);
                    graphics.setStroke(new BasicStroke(5));
                    graphics.drawRect(old_X, old_Y, diameter + current_X - old_X, diameter + current_Y - old_Y);
                    dragShape = false;
                    return;
                }
                else if(size == 4){
                    graphics.setColor(color);
                    graphics.setStroke(new BasicStroke(7));
                    graphics.drawRect(old_X, old_Y, diameter + current_X - old_X, diameter + current_Y - old_Y);
                    dragShape = false;
                    return;
                }
            }

        }
        //graphics.dispose();
        //graphics = null;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


    /**
     * MouseMotionListener
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        if (drag == false) {
            return;
        }

        current_X = e.getX();
        current_Y = e.getY();

        int height = getHeight();
        int width = getWidth();

        if (current_Y < 56) {
            current_Y = 56;
        }

        color = graphics.getColor();
        if (eraser == true) {

            if (current_Y < 60) {
                current_Y = 60;
            }


            graphics.setStroke(new BasicStroke(15));
            graphics.setColor(Color.WHITE);
            graphics.drawLine(old_X, old_Y, current_X, current_Y);
            old_X = current_X;
            old_Y = current_Y;
            return;
        }
        graphics.setColor(color);

        if (currentShape == LINE) {
            if(size == 1) {
                graphics.setStroke(new BasicStroke(1));
                graphics.drawLine(old_X, old_Y, current_X, current_Y);
                old_X = current_X;
                old_Y = current_Y;
            }
            else if(size == 2)
            {
                graphics.setStroke(new BasicStroke(3));
                graphics.drawLine(old_X, old_Y, current_X, current_Y);
                old_X = current_X;
                old_Y = current_Y;
            }
            else if(size == 3)
            {
                graphics.setStroke(new BasicStroke(5));
                graphics.drawLine(old_X, old_Y, current_X, current_Y);
                old_X = current_X;
                old_Y = current_Y;
            }
            else if(size == 4)
            {
                graphics.setStroke(new BasicStroke(7));
                graphics.drawLine(old_X, old_Y, current_X, current_Y);
                old_X = current_X;
                old_Y = current_Y;
            }

        }

        if (currentShape == OVAL) {
            if (diameter + current_X - old_X > 0) {
                height = diameter + old_Y - current_Y;
                width = diameter + old_X - current_Y;
                dragShape = true;
            } else {
                graphics.drawOval(old_X, old_Y, diameter - old_X - current_X, diameter - old_Y - current_Y);
            }
        }

        if (currentShape == RECT) {
            dragShape = true;
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

}
