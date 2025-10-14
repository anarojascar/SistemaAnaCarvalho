/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author anale
 */
public class Util {

    public static void habilitar(boolean valor, JComponent... componentes) {
        for (int i = 0; i < componentes.length; i++) {
            componentes[i].setEnabled(valor);

        }
    }

    public static void limpar(JComponent... componentes) {
        for (int i = 0; i < componentes.length; i++) {
            if (componentes[i] instanceof JTextField) {
                ((JTextField) componentes[i]).setText("");
            }
            if(componentes[i] instanceof JComboBox){
            ((JComboBox)componentes[i]).setSelectedIndex(-1);
            }
            if(componentes[i] instanceof JFormattedTextField){
            ((JFormattedTextField)componentes[i]).setText("");
            }
            if(componentes[i] instanceof JPasswordField){
            ((JPasswordField)componentes[i]).setText("");
            }
            if(componentes[i] instanceof JCheckBox){
            ((JCheckBox)componentes[i]).setSelected(false);
            }
        }
    }
    public static void mensagem(String cad){
        JOptionPane.showMessageDialog(null,cad);
    }
    public static boolean pergunta(String cad){
        JOptionPane.showConfirmDialog(null, cad);
        return true;
    }
    public static int strToInt(String num){
        return Integer.parseInt(num);
    }
    public static String intoStr(int num){
        return String.valueOf(num);
    }
    public static double strToDouble(String num){
       return Double.parseDouble(num);
    }
    public static String doubleToStr(double num){
        return String.valueOf(num);
    }
    public static Date strToDate(String data){
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static String dateToStr(Date data){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(data);
    }
}
