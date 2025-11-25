/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.AacVendasProdutos;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Marcos
 */
public class ControllerVendasProdutos extends AbstractTableModel {

    private List lstVendasProdutos;

    public void setList(List lstVendasProdutos) {
        this.lstVendasProdutos = lstVendasProdutos;
        this.fireTableDataChanged();
    }
    
    public AacVendasProdutos getBean(int rowIndex) {
        return (AacVendasProdutos) lstVendasProdutos.get(rowIndex);
    }

    public void addBean(AacVendasProdutos vendasProdutos) {
        lstVendasProdutos.add(vendasProdutos);
        this.fireTableDataChanged();
    }
    
    public void removeBean(int rowIndex) {
        lstVendasProdutos.remove(rowIndex);
        this.fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return lstVendasProdutos.size();                
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        AacVendasProdutos aacVendasProdutos = (AacVendasProdutos) lstVendasProdutos.get( rowIndex);
        if ( columnIndex == 0 ){
            return aacVendasProdutos.getAacProdutos().getAacIdProdutos();
        } else if (columnIndex ==1) {
            return aacVendasProdutos.getAacProdutos().getAacMarca();
        } else if (columnIndex ==2) {
            return aacVendasProdutos.getAacUnidades();
        } else if (columnIndex ==3) {
            return aacVendasProdutos.getAacPrecoUnitario();
        }else if (columnIndex ==4) {
            return aacVendasProdutos.getAacPrecoUnitario()*aacVendasProdutos.getAacUnidades();
        }
        return ""; 
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "Produto";         
        } else if ( columnIndex == 2) {
            return "Quantidade";
        } else if ( columnIndex == 3) {
            return "Valor Unitário";
        } else if ( columnIndex == 4) {
            return "Total";
        } 
        return "";
    }
}
