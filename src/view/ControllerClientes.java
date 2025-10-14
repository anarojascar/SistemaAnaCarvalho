/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.AacClientes;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author anale
 */
public class ControllerClientes extends AbstractTableModel {
    private List lstClientes;

    public void setList(List lstClientes) {
        this.lstClientes = lstClientes;
    }
    
    public AacClientes getBean(int rowIndex) {
        return (AacClientes) lstClientes.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstClientes.size();
                
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        AacClientes aacClientes = (AacClientes) lstClientes.get( rowIndex);
        if ( columnIndex == 0 ){
            return aacClientes.getAacIdCliente();
        } else if (columnIndex ==1) {
            return aacClientes.getAacNome();        
        } else if (columnIndex ==2) {
            return aacClientes.getAacEmail();
        } else if (columnIndex ==3) {
            return aacClientes.getAacUltimoPedido();
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
            return "Email";
        } else if ( columnIndex == 3) {
            return "Ultimo Pedido";
        } 
        return "";
    }
    
}
