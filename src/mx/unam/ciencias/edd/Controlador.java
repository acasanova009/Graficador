
package mx.unam.ciencias.edd;


//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;

import java.util.NoSuchElementException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.net.URL;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseMotionAdapter;


import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.text.Document;


import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
/**
 * Interfaz Grafica para mi graficadora.
 */
public class Controlador{
    
    
    private static final int pixelesVistaX = 600;
    private static final int pixelesVistaY = 600;
    /* Opciones de la interfaz gráfica. */
    private static final int ZOOMIN     = 0;
    private static final int ZOOMOUT    = 1;
    private static final int CENTER     = 2;
    private static final int EQUALIZE   = 3;
    /* Componentes de la interfaz gráfica. */
    private JFrame ventana;
    
    private PanelPintar panel;
    private JButton[] buttons;
    
    private JSpinner spinnerAncho;
    private JSpinner spinnerAlto;
    private JSpinner spinnerX;
    private JSpinner spinnerY;
    
    //Cargamos la vista y la mostramos.
    private void vistaCargar()
    {
        
        //Tiene la vista que maneja, y la carga
        ventana = new JFrame("Graficador");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JToolBar bh = creaBarraHerramientas();
        ventana.add(bh, BorderLayout.NORTH);
        panel = new PanelPintar();
        panel.setPreferredSize(new Dimension(pixelesVistaX,pixelesVistaY));
        ventana.add(panel);
        ventana.setVisible(true);
        ventana.setResizable(false);
        
        ventana.pack();
        
    }
    
    /* Crea la barra de herramientas. */
    private JToolBar creaBarraHerramientas() {
        
        JToolBar bh = new JToolBar("Barra de Herramientas");
        
        buttons = new JButton[5];
        
        
        JLabel label = new JLabel("   f(x)=");
        bh.add(label);
        
        //fifth component is NOT a button!
        JTextField textField = new JTextField("x");
        textField.setColumns(10);
        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                panel.listener(textField.getText());
                ventana.repaint();

            }
        });
        bh.add(textField);
        
        ChangeListener listener;
        listener= new ChangeListener() {
            public void stateChanged(ChangeEvent e) {

                
                JSpinner j = (JSpinner)e.getSource();
                String s = j.getValue().toString();

//ALTURA
                double  r =Double.parseDouble(s);

                panel.update(r,0,0,0);

                ventana.repaint();
                
                
            }
        };
        
        
        bh.add(new JLabel("   Altura: "));
        spinnerAlto = creaRotativo( 50,-10000, 10000, 1, "#0");

        
        
        spinnerAlto.addChangeListener(listener);
        bh.add(spinnerAlto);
        
        
        listener = new ChangeListener() {
            public void stateChanged(ChangeEvent e) {

                
                JSpinner j = (JSpinner)e.getSource();
                String s = j.getValue().toString();

//ANCHURA
                double  r =Double.parseDouble(s);
                
                panel.update(0,r,0,0);
                ventana.repaint();
                
                
            }
        };
        bh.add(new JLabel("   Anchura: "));
        spinnerAncho = creaRotativo( 50,-10000, 10000, 1, "#0");
        
        spinnerAncho.addChangeListener(listener);
        
        bh.add(spinnerAncho);
        
//        
//        
//        buttons[ZOOMIN] = new JButton("Zoom In");
//        buttons[ZOOMIN].addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                //()
//            }
//        });
//        bh.add(buttons[ZOOMIN]);
//        
//        
//        buttons[ZOOMOUT] = new JButton("Zoom Out");
//        buttons[ZOOMOUT].addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                //()
//            }
//        });
//        bh.add(buttons[ZOOMOUT]);
//        
//        
//        buttons[CENTER] = new JButton("Center");
//        buttons[CENTER].addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                //()
//            }
//        });
//        bh.add(buttons[CENTER]);
//        
//        buttons[EQUALIZE] = new JButton("Equal");
//        buttons[EQUALIZE].addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                //()
//            }
//        });
//        
        
        
        return bh;
        
        
    }
    public Controlador() {
        vistaCargar();
        
        
    }
    /* Crea un rotativo con los valores recibidos. */
    private JSpinner creaRotativo(double valor, double min,
                                  double max, double paso,
                                  String formato) {
        JSpinner spinner =
        new JSpinner(new SpinnerNumberModel(valor, min, max, paso));
        
        JSpinner.NumberEditor ne = new JSpinner.NumberEditor(spinner, formato);
        JTextField tf = ne.getTextField();
        tf.setColumns(2);
        spinner.setEditor(ne);
        return spinner;
    }
}


class PanelPintar extends JPanel{
        
//        RedSquare redSquare = new RedSquare();
        Line2D veticalLine = new Line2D.Double(300, 0, 300, 600);
        Line2D horizontalLine = new Line2D.Double(0, 300, 600, 300);
    
    
        private static final int pixelesVistaX = 600;
        private static final int pixelesVistaY = 600;
    
        public Line2D.Double[] puntos;
    
        public ArbolSintactico<Ficha> a;
    
        String funcion ;
    double anchura;
    double altura;
    double x_;
     double y_;
    
        public PanelPintar() {
            
            anchura = 50;
            altura=50;
            listener("x");
            setBackground(Color.WHITE);
            setBorder(BorderFactory.createLineBorder(Color.black));
            
//            addMouseListener(new MouseAdapter(){
//                public void mousePressed(MouseEvent e){
//                    moveSquare(e.getX(),e.getY());
//                }
//            });
            
//            addMouseMotionListener(new MouseAdapter(){
//                public void mouseDragged(MouseEvent e){
//                  moveSquare(e.getX(),e.getY());
//                    moveLine(veticalLine,e.getX(),e.getY());
//                    moveLine(horizontalLine,e.getX(),e.getY());
//                }
//            });
            
        }
    
    
    
    public void update(double alt, double anch, double x, double y){
        
        if(alt!=0)
            altura=alt;
        if(anch!=0)
            anchura =anch;
        
        
        listener(funcion);
    }
    
    
    
    public void listener(String s) {
        funcion = s;
        
        
        a = Parser.scanf(s);
        
        
        double k = (double)pixelesVistaX+0.0;
        double deDominio = -300.0;//partir de -300;
        double hastaDominio = 300.0;//Mayor o igual a deDominio.
        double dominioPuntos = hastaDominio +( -1*deDominio );
        double segmentoUnitario = 1;//Cien pixeles por cada 1 entero.
        double ratio = k/(segmentoUnitario *100);
        
        
        
        puntos = new Line2D.Double[pixelesVistaY];
        
        if(a!=null)
        {
            int c=0;
            
            
            double x1;
            for(double x = deDominio ; x <= hastaDominio && c<pixelesVistaY; x+=dominioPuntos/k)
            {
                try{
                    double y = a.evaluar(x/anchura);
                    
                    
                    
                    y = y*altura;
                    
                    
                    //Estos es por la cantidad de pixeles.
                    
                    y*=-1;//Por que el eje de Y de swing es positivo hacia abajo.
                    y+=300;
                    x1=x+300;
                    puntos[c] = new Line2D.Double(x1,y,x1,y);
                    
                }catch(IllegalArgumentException e){
                    
                    puntos[c] = new Line2D.Double(300,300,300,300);
                }
                
                c++;
            }
        }
        
    }
    
        private void moveLine(Line2D line,int x, int y){
            final double x1 = line.getX1();
            final double x2 = line.getX2();
            final double y1 = line.getY1();
            final double y2 = line.getY2();
            
            
            
        }
//        private void moveSquare(int x, int y){
//            
//            // Current square state, stored as final variables
//            // to avoid repeat invocations of the same methods.
//            final int CURR_X = redSquare.getX();
//            final int CURR_Y = redSquare.getY();
//            final int CURR_W = redSquare.getWidth();
//            final int CURR_H = redSquare.getHeight();
//            final int OFFSET = 1;
//            
//            if ((CURR_X!=x) || (CURR_Y!=y)) {
//                
//                // The square is moving, repaint background
//                // over the old square location.
//                repaint(CURR_X,CURR_Y,CURR_W+OFFSET,CURR_H+OFFSET);
//                
//                // Update coordinates.
//                redSquare.setX(x);
//                redSquare.setY(y);
//                
//                // Repaint the square at the new location.
//                repaint(redSquare.getX(), redSquare.getY(),
//                        redSquare.getWidth()+OFFSET,
//                        redSquare.getHeight()+OFFSET);
//            }
//        }
    
    
    
    
    
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
                Graphics2D g2 = (Graphics2D)g;
           
            
            Point2D.Double last = null;
            for(Line2D.Double p:puntos){
                if(last!=null){
                    
                    g2.draw(new Line2D.Double(p.getP1(),last));
                    
                    
                }
                last = (Point2D.Double)p.getP1();
                g2.draw(p);
            }
            
            

                g2.draw(veticalLine);
                g2.draw(horizontalLine);
            
//            redSquare.paintSquare(g);
        }
    }
    
class RedSquare{
        
        private int xPos = 50;
        private int yPos = 50;
        private int width = 20;
        private int height = 20;
        
        public void setX(int xPos){
            this.xPos = xPos;
        }
        
        public int getX(){
            return xPos;
        }
        
        public void setY(int yPos){
            this.yPos = yPos;
        }
        
        public int getY(){
            return yPos;
        }
        
        public int getWidth(){
            return width;
        } 
        
        public int getHeight(){
            return height;
        }
        
        public void paintSquare(Graphics g){
            g.setColor(Color.BLACK);
            g.fillRect(xPos,yPos,width,height);
            g.setColor(Color.BLACK);
            g.drawRect(xPos,yPos,width,height);  
        }
}
