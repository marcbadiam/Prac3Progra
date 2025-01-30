package InterficieGrafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import Classes.*;
import LlistesGestioFitxers.*;

import java.io.IOException;

public class AppInterficieGrafica extends JFrame {
    private LlistaAccionsText llistaAccions;
    private LlistaAssociacionsSerial llistaAssociacions;
    private JTextArea textArea;
    private List<JCheckBox> checkBoxes;

    public AppInterficieGrafica(LlistaAccionsText llistaAccions, LlistaAssociacionsSerial llistaAssociacions) {
        this.llistaAccions = llistaAccions;
        this.llistaAssociacions = llistaAssociacions;
        initialize();
    }

    private void initialize() {
        setTitle("Aplicació Gràfica de Demostracions");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        checkBoxes = new ArrayList<>();
        for (int i = 0; i < llistaAssociacions.getNElem(); i++) {
            Associacio associacio = llistaAssociacions.getAssociacio(i);
            if (associacio != null) {
                JCheckBox checkBox = new JCheckBox(associacio.getNomAssociacio());
                checkBoxes.add(checkBox);
                panel.add(checkBox);
            }
        }

        JScrollPane scrollPaneCheckBoxes = new JScrollPane(panel);
        scrollPaneCheckBoxes.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPaneCheckBoxes.setPreferredSize(new Dimension(300, 800));

        JButton button = new JButton("Mostrar Demostracions");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarDemostracions();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(button);

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPaneTextArea = new JScrollPane(textArea);

        add(scrollPaneCheckBoxes, BorderLayout.WEST);
        add(buttonPanel, BorderLayout.NORTH);
        add(scrollPaneTextArea, BorderLayout.CENTER);
    }
 
    private void mostrarDemostracions() {
        System.out.println("ENTRE   AQUIIIIIIIIIIIIII");
        LlistaAssociacionsSerial llistaCarregada1 = new LlistaAssociacionsSerial();
        try {
            llistaCarregada1.carregarAssociacions();
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error carregant associacions: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        System.out.println("Y AQUIIIIIIIIIIIIII");
        textArea.setText("");
        LlistaAssociacionsSerial selectedAssociacions = new LlistaAssociacionsSerial();
        LlistaAccionsText selectedAccions = new LlistaAccionsText();
        LlistaAccionsText llistaAccionsGran = new LlistaAccionsText();
        llistaAccionsGran.carregarAccions();

        for (JCheckBox checkBox : checkBoxes) {
            if (checkBox.isSelected()) {

                for(int i=0; llistaAccionsGran.getNElem()>i; i++){
                    System.out.println("111111111111");
                    for(int j=0; llistaAccionsGran.getAccio(i).getLlistaAss().getNomAssociacioPosicio(j)!=null ; j++){
                        boolean esDemo = llistaAccionsGran.getAccio(i) instanceof Demostracio;
                        //boolean esActiu = llistaAccionsGran.getAccio(i).getActiu();
                        if(esDemo && llistaAccionsGran.getAccio(i).getLlistaAss().getNomAssociacioPosicio(j).equals(checkBox.getText())){
                            selectedAccions.afegirAccio(llistaAccionsGran.getAccio(i));
                            System.out.println("HA ENTRAT\n\n");
                            System.out.println(llistaAccionsGran.getAccio(i).getLlistaAss().getNomAssociacioPosicio(j));
                            System.out.println(checkBox.getText());
                        }
                        //System.out.println("222222222222");
                        //System.out.println("AQUIAQUIAQUI: "+llistaAccionsGran.getAccio(i).getLlistaAss().getNomAssociacioPosicio(j));
                        //System.out.println("Checkbox: "+checkBox.getText());
                    }
                }
            }
        }

        System.out.println(selectedAccions.toString());
        textArea.setFont(new Font("Arial", Font.PLAIN, 24));
        textArea.append(selectedAccions.toString() + "\n\n");
/*
        LlistaAssociacionsSerial selectedAssociacionsComp = new LlistaAssociacionsSerial();
        for (int i=0; i<llistaAccions.getNElem(); i++){
            if(llistaAccions.getAccio(i)){
                selectedAccions.afegirAccio(llistaAccions.getAccio(i));
            }
        } */
        /*
        for (int i=0; i<llistaAccions.getNElem(); i++){
            if(llistaAccions.getAccio(i).getAssociacio)){
                selectedAccions.afegirAccio(llistaAccions.getAccio(i));
            }
        } */
/*
        for (Activitats activitat : llistaAccions.getLlistaActivitats()) {
            if (activitat != null && activitat instanceof Demostracions) {
                Demostracions demostracio = (Demostracions) activitat;
                if (selectedAssociacions.isEmpty() || selectedAssociacions.contains(demostracio.getEntitat().getNomAssociacio())) {
                    textArea.append(demostracio.toString() + "\n\n");
                }
            }
        } */
    }

    public static void main(String[] args) {
        // Crear llistes d'activitats i entitats
        LlistaAssociacionsSerial llistaAssociacions = new LlistaAssociacionsSerial();
        LlistaAccionsText llistaAccions = new LlistaAccionsText();

        // Afegir entitats i activitats (exemple)
        try {
            llistaAssociacions.carregarAssociacions();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error carregant associacions: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        llistaAccions.carregarAccions();

        // Crear i mostrar la interfície gràfica
        AppInterficieGrafica app = new AppInterficieGrafica(llistaAccions, llistaAssociacions);
        app.setVisible(true);
    }
}
