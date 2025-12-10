/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.AacVendas;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author anale
 */
public class ControllerConsultarVendas extends AbstractTableModel{
    
    private List lstVendas;

    public void setList(List lstVendas) {
        this.lstVendas = lstVendas;
        this.fireTableDataChanged();
    }

      @Override
    public int getRowCount() {
        return lstVendas.size();
                
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        AacVendas aacVendas = (AacVendas) lstVendas.get( rowIndex);
               if (columnIndex == 0 ) {
            return aacVendas.getAacIdVendas();
        } else if (columnIndex ==1) {
            return aacVendas.getAacClientes();        
        } else if (columnIndex ==2) {
            return aacVendas.getAacFuncionarios();
        }else if (columnIndex ==3) {
            return aacVendas.getAacDataVenda();
        }
        return ""; 
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "Clientes";         
        } else if ( columnIndex == 2) {
            return "Funcionarios";
        } else if ( columnIndex == 3) {
            return "Data Venda";
        } 
        return "";
    }
}
