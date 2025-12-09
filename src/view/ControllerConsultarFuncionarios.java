/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.AacFuncionarios;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author anale
 */
public class ControllerConsultarFuncionarios extends AbstractTableModel{
    private List lstFuncionarios;

    public void setList(List lstfuncionarios) {
        this.lstFuncionarios = lstFuncionarios;
        this.fireTableDataChanged();
    }
    @Override
    public int getRowCount() {
         return lstFuncionarios.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         AacFuncionarios aacFuncionarios = (AacFuncionarios) lstFuncionarios.get( rowIndex);
               if (columnIndex == 0 ) {
            return aacFuncionarios.getAacIdFuncionario();
        } else if (columnIndex ==1) {
            return aacFuncionarios.getAacNome();        
        } else if (columnIndex ==2) {
            return aacFuncionarios.getAacTipoContratacao();
        }else if (columnIndex ==3) {
            return aacFuncionarios.getAacEmailProfissional();
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
            return "Contrato/Função";
        } else if ( columnIndex == 3) {
            return "Email Profissional";
        } 
        return "";
    }
}
