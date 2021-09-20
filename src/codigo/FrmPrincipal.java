/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;


/**
 *
 * @author Lesly Quevedo
 */
public class FrmPrincipal extends javax.swing.JFrame {
JFileChooser seleccionar = new JFileChooser();
File archivo;
FileInputStream entrada;
FileOutputStream salida;

    
    /**
     * Creates new form FrmPrincipal
     */
    public FrmPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
   
    public String GuardarArchivo (File archivo,String documento){
            String mensaje=null;
            
            try {
                salida=new  FileOutputStream(archivo);
                byte[]bytxt=documento.getBytes();
                salida.write(bytxt);
                mensaje="Archivo Guardado";
                
            }catch (Exception e){   
            }
            return mensaje;
    }
    public void Palabra_central(String cadena, int contador){    
        String[] words = cadena.split("\\s+");
        int mitad = contador/2;
        if (contador%2!=0){
            mitad = mitad + 1;
        }
        int contador2 = mitad - 1;
        for (int i = 0; i <= mitad; i++) {
            if(i == contador2){
                words[i] = words[i].replaceAll("[^\\w]", "");
                txtPalCen.setText("" + words[i]);
            }
        }
        
    }
    public void Palabras_pares_impares(String cadena, int contador){
        String[] words = cadena.split("\\s+");
        int par=0;
        int impar=0;
        for (int i = 0; i <= contador; i++) {
                words[i] = words[i].replaceAll("[^\\w]", "");
                int par_impar = words[i].length();
                System.out.println(par_impar);
                if (par_impar % 2 == 0){
                    impar += 1;
                    txtpar.setText("" + impar);
                    
                }else{
                    par += 1;
                    txtimpar.setText("" + par);
                }
                
        }
        
        
    }
    
    public void Repeticiones_letra_u(String cadena){
        int contadorVocales = 0;
        char letraArray[] = cadena.toCharArray();
        char letra = letraArray[0];
        int contadorLetraRepetida = 0;

        for(int i=0; i<cadena.length(); i++){
            switch(cadena.charAt(i)){
                case 'u': case 'U': case 'ú':
                    contadorVocales++;
                    break;
            }
        }
        txtU.setText("" + contadorVocales);
    }
    
    public void Repeticiones_letra_o(String cadena){
        int contadorVocales = 0;
        char letraArray[] = cadena.toCharArray();
        char letra = letraArray[0];
        int contadorLetraRepetida = 0;

        for(int i=0; i<cadena.length(); i++){
            switch(cadena.charAt(i)){
                case 'o': case 'O': case 'ó':
                    contadorVocales++;
                    break;
            }
        }
        txtO.setText("" + contadorVocales);
    }
    
    public void Repeticiones_letra_i(String cadena){
        int contadorVocales = 0;
        char letraArray[] = cadena.toCharArray();
        char letra = letraArray[0];
        int contadorLetraRepetida = 0;

        for(int i=0; i<cadena.length(); i++){
            switch(cadena.charAt(i)){
                case 'i': case 'I': case 'í':
                    contadorVocales++;
                    break;
            }
        }
        txtI.setText("" + contadorVocales);
    }
    
    public void Repeticiones_letra_e(String cadena){
        int contadorVocales = 0;
        char letraArray[] = cadena.toCharArray();
        char letra = letraArray[0];
        int contadorLetraRepetida = 0;

        for(int i=0; i<cadena.length(); i++){
            switch(cadena.charAt(i)){
                case 'e': case 'E': case 'é':
                    contadorVocales++;
                    break;
            }
        }
        txtE.setText("" + contadorVocales);
    }
    
     public void Repeticiones_letra_a(String cadena){
        int contadorVocales = 0;
        char letraArray[] = cadena.toCharArray();
        char letra = letraArray[0];
        int contadorLetraRepetida = 0;

        for(int i=0; i<cadena.length(); i++){
            switch(cadena.charAt(i)){
                case 'a': case 'A': case 'á':
                    contadorVocales++;
                    break;
            }
        }
        txtA.setText("" + contadorVocales);
    }
    public void ultimapalabra(){
    String longitud=txtEntrada.getText();
        int cadena=longitud.lastIndexOf(" ");
        String ult=longitud.substring(cadena);
        txt_1p.setText(ult);

    }    
    public void letrac(){   
    String longitud=txtEntrada.getText();
     int num = longitud.length();
    for (int i=0;i<=(num-1);i++){
        int j=i/2;
        char cadena=longitud.charAt(j);
        txt_letrac.setText(String.valueOf(cadena));
        }
    }   
    public void ultletra(){
    String longitud=txtEntrada.getText();
     int num = longitud.length();
    for (int i=0;i<=(num-1);i++){
        char cadena=longitud.charAt(i);
        txt_ultletra.setText(String.valueOf(cadena));
    }
    }       
    public void primerletra(){
    String longitud=txtEntrada.getText();
        char cadena=longitud.charAt(0);
        txt_1letra.setText(String.valueOf(cadena));
    }    
    public void longitudpalabras(){
    String longitud=txtEntrada.getText();
    StringTokenizer st= new StringTokenizer(longitud);
        txt_palab.setText(""+st.countTokens());
    
    }    
    
    public void longitud(){
    String longitud=txtEntrada.getText();
    int cadena=longitud.length();
        txt_long.setText(String.valueOf(cadena));
    
    }    
    public void copiar (String copiar ){
        StringSelection ss = new StringSelection(copiar);
    Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
    cb.setContents(ss, null);
    }
    
    public String pegar (){
      String resultado ="";
      Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
      
      Transferable contenido = cb.getContents(null);
      if (contenido.isDataFlavorSupported(DataFlavor.stringFlavor)){
          try {
              resultado = (String) contenido.getTransferData(DataFlavor.stringFlavor);
          } catch (UnsupportedFlavorException ex) {
            JOptionPane.showMessageDialog (null, ex.getMessage());
          } catch (IOException ex) {
            JOptionPane.showMessageDialog (null, ex.getMessage());
         }
      }
      return resultado;
    }
    public String AbrirArchivo (File archivo){
        String documento="";
            try{
                entrada=new FileInputStream(archivo);
                int ascci;
                while((ascci=entrada.read())!=-1){
                    char caracter=(char)ascci;
                    documento+=caracter;
                }
            }catch(IOException e){
            }
            return documento;    
        }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        txtEntrada = new javax.swing.JTextField();
        btnAnalizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_long = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_palab = new javax.swing.JTextField();
        txt_1letra = new javax.swing.JTextField();
        txt_ultletra = new javax.swing.JTextField();
        txt_letrac = new javax.swing.JTextField();
        txt_1p = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtPalCen = new javax.swing.JTextField();
        txtP1 = new javax.swing.JTextField();
        txtA = new javax.swing.JTextField();
        txtE = new javax.swing.JTextField();
        txtI = new javax.swing.JTextField();
        txtO = new javax.swing.JTextField();
        txtU = new javax.swing.JTextField();
        txtpar = new javax.swing.JTextField();
        txtimpar = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        JmenuAbrir = new javax.swing.JMenuItem();
        guardar = new javax.swing.JMenuItem();
        Guardarcomo = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenucopiar = new javax.swing.JMenuItem();
        Jmenupegar = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("File");
        jMenuBar3.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar3.add(jMenu6);

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtEntrada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEntradaActionPerformed(evt);
            }
        });

        btnAnalizar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnAnalizar.setText("Procesar");
        btnAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarActionPerformed(evt);
            }
        });

        txtResultado.setColumns(20);
        txtResultado.setRows(5);
        jScrollPane1.setViewportView(txtResultado);

        jLabel1.setText("Ingrese un texto o abra un archivo");

        jLabel2.setText("Longitud del texto ");

        jLabel3.setText("Total de palabras");

        jLabel4.setText("Primera letra del texto");

        jLabel5.setText("Ultima letra del texto");

        jLabel6.setText("Letra central del texto");

        jLabel7.setText("Primera Palabra");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Repeticiones de \"A\", \"a\" ó \"á\":");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Repeticiones de \"I\", \"i\" ó \"í\":");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Repeticiones de \"E\", \"e\" ó \"é\":");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Repeticiones de \"O\", \"o\" u \"ó\":");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Repeticiones de \"U\", \"u\" ó \"ú\":");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Palabras con cantidad de caracteres par:");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Palabras con cantidad de caracteres impar:");

        jLabel8.setText("Palabra central");

        jLabel9.setText("Ultima Palabra");

        jLabel10.setText("TRADUCCIÓN A CLAVE MURCIELAGO");

        jMenu1.setText("Archivo");

        JmenuAbrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        JmenuAbrir.setText("Abrir ");
        JmenuAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmenuAbrirActionPerformed(evt);
            }
        });
        jMenu1.add(JmenuAbrir);

        guardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        guardar.setText("Guardar ");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        jMenu1.add(guardar);

        Guardarcomo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F12, 0));
        Guardarcomo.setText("Guardar Como ");
        Guardarcomo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarcomoActionPerformed(evt);
            }
        });
        jMenu1.add(Guardarcomo);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Editar");

        jMenucopiar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenucopiar.setText("Copiar");
        jMenucopiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenucopiarActionPerformed(evt);
            }
        });
        jMenu2.add(jMenucopiar);

        Jmenupegar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        Jmenupegar.setText("Pegar");
        Jmenupegar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmenupegarActionPerformed(evt);
            }
        });
        jMenu2.add(Jmenupegar);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setText("Cortar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(txtP1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_palab))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_long, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_1letra, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_ultletra))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_letrac))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel9))
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_1p, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                                    .addComponent(txtPalCen))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 200, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel14)
                                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtU, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtO, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtA, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                                        .addComponent(txtE)
                                        .addComponent(txtI, javax.swing.GroupLayout.Alignment.TRAILING))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel19)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jLabel10))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtpar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(242, 242, 242)
                .addComponent(btnAnalizar)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAnalizar)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_long, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_palab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_1letra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_ultletra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_letrac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_1p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtPalCen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14)
                            .addComponent(txtO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtpar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(txtimpar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarActionPerformed
        // TODO add your handling code here:
        String cadena_completa;
       cadena_completa = txtEntrada.getText();
       
        int contador = 1, pos;
        cadena_completa = cadena_completa.trim();                              
        if (cadena_completa.isEmpty()) { 
            contador = 0;
        } else {
                pos = cadena_completa.indexOf(" "); 
                while (pos != -1) {   //mientras que se encuentre un espacio en blanco
                       contador++;    //se cuenta una palabra
                       pos = cadena_completa.indexOf(" ", pos + 1); //se busca el siguiente espacio en blanco                       
                }                                     //a continuación del actual
        }
         
        
        
        
        
        StringTokenizer tokens = new StringTokenizer(cadena_completa);
        String primeraPalabra = tokens.nextToken();
        txtP1.setText("" +primeraPalabra);
        
        String frase = txtEntrada.getText();
        Clave_murcielago(frase);
        longitud();
        longitudpalabras();
        primerletra();
        ultletra();
        letrac();
        Palabra_central(cadena_completa,contador);
        ultimapalabra();
        Repeticiones_letra_a(cadena_completa);
        Repeticiones_letra_e(cadena_completa);
        Repeticiones_letra_i(cadena_completa);
        Repeticiones_letra_o(cadena_completa);
        Repeticiones_letra_u(cadena_completa);
        Palabras_pares_impares(cadena_completa,contador);
         
        
    }//GEN-LAST:event_btnAnalizarActionPerformed
public void Clave_murcielago(String frase){
 //System.out.println(frase);
          Scanner sc = new Scanner(System.in);
        char[] cadena = new char[900];
        
        //Sentencia for aninidada de if en la cual comprobaremos la cadena de texto enviada!
        for(int i=0; i<frase.length(); i++)
        {
            
            //Con estos if comprobamos las letras que se ingresan
            switch (frase.charAt(i)) {
                case 'M':
                case 'm':
                    cadena[i] = '0';
                    //System.out.println("0");
                    break;
                case 'U':
                case 'u':
                    cadena[i] = '1';
                    //System.out.println("1");
                    break;
                case 'R':
                case 'r':
                    cadena[i] = '2';
                    //System.out.println("2");
                    break;
                case 'C':
                case 'c':
                    cadena[i] = '3';
                    //System.out.println("3");
                    break;
                case 'I':
                case 'i':
                    cadena[i] = '4';
                    //System.out.println("4");
                    break;
                case 'E':
                case 'e':
                    cadena[i] = '5';
                    //System.out.println("5");
                    break;
                case 'L':
                case 'l':
                    cadena[i] = '6';
                    //System.out.println("6");
                    break;
                case 'A':
                case 'a':
                    cadena[i] = '7';
                    //System.out.println("7");
                    break;
                case 'G':
                case 'g':
                    cadena[i] = '8';
                    //System.out.println("8");
                    break;
                case 'O':
                case 'o':
                    cadena[i] = '9';
                    //System.out.println("9");
                    break;
                default:
                    cadena[i] = frase.charAt(i);
                    break;
            }
        String resultado = String.valueOf(cadena);
        //System.out.println(cadena);
        //System.out.println(resultado);
       txtResultado.setText(resultado);
      
        }
    }
    private void JmenuAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmenuAbrirActionPerformed
      
        // TODO add your handling code here:
         if(seleccionar.showDialog(null, "Abrir")==JFileChooser.APPROVE_OPTION){
            archivo=seleccionar.getSelectedFile();
            if(archivo.canRead()){
                if(archivo.getName().endsWith("txt")){
                    String documento=AbrirArchivo(archivo);
                    txtEntrada.setText(documento);
                }else{
                    JOptionPane.showMessageDialog(null, "Archivo No Compatible");
                }
            }
        }
        
    }//GEN-LAST:event_JmenuAbrirActionPerformed

    private void jMenucopiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenucopiarActionPerformed
        // TODO add your handling code here:
        copiar(txtEntrada.getText());
    }//GEN-LAST:event_jMenucopiarActionPerformed

    private void JmenupegarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmenupegarActionPerformed
        // TODO add your handling code here:
        txtEntrada.setText(pegar()); 
    }//GEN-LAST:event_JmenupegarActionPerformed

    private void txtEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEntradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEntradaActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        txtEntrada.setText(null);
        txtResultado.setText(null);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        // TODO add your handling code here:
        archivo=seleccionar.getSelectedFile();
            if(archivo.getName().endsWith("txt")){
                String Documento=txtEntrada.getText();
                String mensaje=GuardarArchivo(archivo,Documento);
                if(mensaje!=null){
                    JOptionPane.showMessageDialog(null, mensaje);
                }else{
                JOptionPane.showMessageDialog(null, "Archivo No Compatible");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Guardar Documento de Texto");
            }
                     
    }//GEN-LAST:event_guardarActionPerformed

    private void GuardarcomoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarcomoActionPerformed
        // TODO add your handling code here:
   if(seleccionar.showDialog(null, "Guardar")==JFileChooser.APPROVE_OPTION){
            archivo=seleccionar.getSelectedFile();
            if(archivo.getName().endsWith("txt")){
                String Documento=txtEntrada.getText();
                String mensaje=GuardarArchivo(archivo,Documento);
                if(mensaje!=null){
                    JOptionPane.showMessageDialog(null, mensaje);
                }else{
                JOptionPane.showMessageDialog(null, "ARCHIVO NO COMPATIBLE");
                }
            }else{
                JOptionPane.showMessageDialog(null, "GUARDAR DOCUMENTO DE TEXTO txt");
            }
        }
    
        
    }//GEN-LAST:event_GuardarcomoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Guardarcomo;
    private javax.swing.JMenuItem JmenuAbrir;
    private javax.swing.JMenuItem Jmenupegar;
    private javax.swing.JButton btnAnalizar;
    private javax.swing.JMenuItem guardar;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenucopiar;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtA;
    private javax.swing.JTextField txtE;
    private javax.swing.JTextField txtEntrada;
    private javax.swing.JTextField txtI;
    private javax.swing.JTextField txtO;
    private javax.swing.JTextField txtP1;
    private javax.swing.JTextField txtPalCen;
    private javax.swing.JTextArea txtResultado;
    private javax.swing.JTextField txtU;
    private javax.swing.JTextField txt_1letra;
    private javax.swing.JTextField txt_1p;
    private javax.swing.JTextField txt_letrac;
    private javax.swing.JTextField txt_long;
    private javax.swing.JTextField txt_palab;
    private javax.swing.JTextField txt_ultletra;
    private javax.swing.JTextField txtimpar;
    private javax.swing.JTextField txtpar;
    // End of variables declaration//GEN-END:variables
}
