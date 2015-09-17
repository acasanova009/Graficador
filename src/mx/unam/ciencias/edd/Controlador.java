
package mx.unam.ciencias.edd;


//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;

import java.lang.Math;
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
    /* Componentes de la interfaz gráfica. */
    private JFrame ventana;
    
    private PanelPintar panel;
    private JButton[] buttons;
    
    private JSpinner spinnerAncho;
    private JSpinner spinnerAlto;
    
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
        JTextField textField = new JTextField("Se puede arrastrar con el mouse.");
        textField.setColumns(10);
        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                panel.generaPuntos(textField.getText());
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
        JButton clear = new JButton("Borrar");
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                panel.reset();
                panel.generaPuntos("");
                ventana.repaint();
            }
        });
        bh.add(clear);
        
        
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
    
//    Line2D veticalLine = new Line2D.Double(300, 0, 300, 600);
//    Line2D horizontalLine = new Line2D.Double(0, 300, 600, 300);
    
    
        private static final int pixelesVistaX = 600;
        private static final int pixelesVistaY = 600;

        public Diccionario<String,ArbolSintactico<Ficha>> graficas;
        public Lista<Line2D.Double> puntos;
    
//        public ArbolSintactico<Ficha> a;
    
        String funcion ;
    double anchura;
    double altura;
    double centerX;
     double centerY;
    
    double lastX;
    double lastY;
    
        public PanelPintar() {
            
            reset();
            
            generaPuntos("");
            
            setBackground(Color.WHITE);
            setBorder(BorderFactory.createLineBorder(Color.black));
            
            addMouseListener(new MouseAdapter(){
                public void mousePressed(MouseEvent e){
                    lastX = e.getX();
                    lastY = e.getY();
                }
            });
            
            addMouseMotionListener(new MouseAdapter(){
                public void mouseDragged(MouseEvent e){
                    double magX =  e.getX() -lastX;
                    double magY =  e.getY() -lastY;
                    
                    update(0,0,magX,magY);
                    
                    lastX = e.getX();
                    lastY = e.getY();
                    repaint();
                }
            });
            
        }
    public void reset(){
        
        anchura = 50;
        altura=50;
        centerX = pixelesVistaX/2;
        centerY = pixelesVistaY/2;
//        graficas = new Lista<Lista<Line2D.Double>>();
        
    }
    
    
    
    public void update(double alt, double anch, double x, double y){
        
        if(alt!=0)
            altura=alt;
        if(anch!=0)
            anchura =anch;
            centerX +=x;
            centerY +=y;
        
        generaPuntos(funcion);
    }
    
    
    
    public void generaPuntos(String s) {
        funcion = s;
        ArbolSintactico<Ficha> a = Parser.scanf(s);
        
//        if(graficas.contiene(s))
//            a = graficas.get(s)
//        else
//            a = Parser.scanf(s);
        
        puntos = new Lista<Line2D.Double>();
        if(a!=null)
        {
            double x1;
            for(double x = -(centerX) ; x <= -(centerX-300.0)+600; x++)
            {
                try{
                    double y = a.evaluar(x/anchura);
                    y = y*altura;

                    //Estos es por la cantidad de pixeles.
                    y*=-1;//Por que el eje de Y de swing es positivo hacia abajo.
                    y+=centerY;
                    x1=x+centerX;
                    puntos.agregaFinal(new Line2D.Double(x1,y,x1,y));
                    
                }catch(IllegalArgumentException e){}
            }
            
//            graficas.agregaFinal(perk);
        }
        
    }
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
                Graphics2D g2 = (Graphics2D)g;
           
            
//             for(Lista<Line2D.Double> puntos :graficas){
                Point2D.Double last = null;
                for(Line2D.Double p :puntos){
                    if(last!=null){
//
                    
//                    System.out.println("Last=" +last.getY()+ " new="+ p.getY1());
                    
                    //Esto esta muy mal hecho, pero no se me ocurre como detectar asintotas aun.
                    //Ya que en terminos computacionales no son asintotas. Son lineas casi verticales.
                    if(distancia(last.getX(),last.getY(), p.getX1(),p.getY1() )<200)
                    {
                        //
                        g2.draw(new Line2D.Double(last,p.getP1()));
                    }

                    
                    

//
//                    if(p.getX1()-last.getX()==0)
//                    {
//                    
//                    //                    {
////                    System.out.println("Last_X=" +last.getX()+ " new_x="+ p.getX1());
//                        System.out.print("Last=" +last.getX+ " new="+ p.getY1());
//
//                    }
//                    
//                    if(((int)last.getY() - (int)p.getY1() ) != 0)
//                    {
//                        
//                        double futureLineSlope =(((int)last.getX() - (int)p.getX1())/  ((int)last.getY() - (int)p.getY1() )  );//x1-x2/y1-y2
//                        
//                        if(futureLineSlope==0)
//                        {
//                            
//                            System.out.print("  Slopes="+futureLineSlope + "\n");
//                        }
//                        else
//                            
//                            g2.draw(new Line2D.Double(last,p.getP1()));
//                    }else{
//                        
//                        g2.draw(new Line2D.Double(last,p.getP1()));
//                    }
                        //es totalmente horizaontal
                    
                    

//                    System.out.print("  Slopes="+futureLineSlope + "\n");
//                    if((int)last.getY() - (int)p.getY1() ==0)
//                    {
//                        System.out.println("YES");
//                    }
//                    else

            
                    
                }
                    last = (Point2D.Double)p.getP1();
                    g2.draw(p);
                }
//             }
            
            
            g2.draw(new Line2D.Double(centerX,0,centerX,600));
            
            g2.draw(new Line2D.Double(0,centerY, 600,centerY));
        }
    private double distancia(double x1,double y1, double x2, double y2)
    {
        x1= Math.abs(x1);
        y1= Math.abs(y1);
        x2= Math.abs(x2);
        y2= Math.abs(y2);
        
        
        
        return Math.sqrt( Math.pow(x2-x1,2) + Math.pow(y2-y1,2));
        
    }
}
