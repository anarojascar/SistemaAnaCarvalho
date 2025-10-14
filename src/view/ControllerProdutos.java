/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.AacProdutos;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author anale
 */
public class ControllerProdutos extends AbstractTableModel {
    private List lstProdutos;

    public void setList(List lstProdutos) {
        this.lstProdutos = lstProdutos;
    }
    
    public AacProdutos getBean(int rowIndex) {
        return (AacProdutos) lstProdutos.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstProdutos.size();
                
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        AacProdutos aacProdutos = (AacProdutos) lstProdutos.get( rowIndex);
        if ( columnIndex == 0 ){
            return aacProdutos.getAacIdProdutos();
        } else if (columnIndex ==1) {
            return aacProdutos.getAacMarca();        
        } else if (columnIndex ==2) {
            return aacProdutos.getAacPreco();
        } 
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "Marca";         
        } else if ( columnIndex == 2) {
            return "Preço (R$)";
        } 
        return "";
    }
    
}
