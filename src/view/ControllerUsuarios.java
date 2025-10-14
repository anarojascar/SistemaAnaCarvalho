/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.AacUsuarios;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author anale
 */
public class ControllerUsuarios extends AbstractTableModel {
     private List lstUsuarios;

    public void setList(List lstUsuarios) {
        this.lstUsuarios = lstUsuarios;
    }
    
    public AacUsuarios getBean(int rowIndex) {
        return (AacUsuarios) lstUsuarios.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstUsuarios.size();
                
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        AacUsuarios aacUsuarios = (AacUsuarios) lstUsuarios.get( rowIndex);
        if ( columnIndex == 0 ){
            return aacUsuarios.getAacIdUsuarios();
        } else if (columnIndex ==1) {
            return aacUsuarios.getAacNomeCompleto();        
        } else if (columnIndex ==2) {
            return aacUsuarios.getAacApelido();
        } else if (columnIndex ==3) {
            return aacUsuarios.getAacCpf();
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "Nome";         
        } else if ( columnIndex == 2) {
            return "Apelido";
        } else if ( columnIndex == 3) {
            return "Cpf";
        } 
        return "";
    }
}
