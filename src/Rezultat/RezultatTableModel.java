/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rezultat;

import Echipa.Echipa;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.table.AbstractTableModel;


class RezultatTableModel extends AbstractTableModel {

	public static final int OBJECT_COL = -1;
        private static final int ETAPAID_COL = 0;
        private static final int ECHIPAID1_COL = 1;
        private static final int NUMEECHIPA1_COL = 2;
        private static final int NUMARGOLURI1_COL = 3;
        private static final int NUMARGOLURI2_COL = 4;
        private static final int NUMEECHIPA2_COL = 5;
        private static final int ECHIPAID2_COL = 6;
        

	private String[] columnNames = { "Etapa ID", "Echipa ID1", "Nume Echipa1",
			"Numar Goluri1","Numar Goluri2","Nume Echipa2","Echipa ID2" };
	private List<Rezultat> employees;
       
       
      

	public RezultatTableModel(List<Rezultat> theEmployees) {
		employees = theEmployees;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return employees.size();
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {

		Rezultat tempEmployee = employees.get(row);
		switch (col) {
                    case  ETAPAID_COL:
                        return tempEmployee.getEtapaID();
                    case ECHIPAID1_COL:
                        return tempEmployee.getEchipaID1();
                    case NUMEECHIPA1_COL:
                        try{
                        RezultatDATA r=new RezultatDATA();
                        return r.getNumeEchipaID(tempEmployee.getEchipaID1());
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                     case NUMARGOLURI1_COL:
                         return tempEmployee.getNumarGoluri1();
                     case NUMARGOLURI2_COL:
                         return tempEmployee.getNumarGoluri2();
                     case NUMEECHIPA2_COL:
                        try{
                        RezultatDATA r=new RezultatDATA();
                        return r.getNumeEchipaID(tempEmployee.getEchipaID2());
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                     case ECHIPAID2_COL:
                         return tempEmployee.getEchipaID2();               
		case OBJECT_COL:
			return tempEmployee;
		default:
			return tempEmployee.getEtapaID();
		}
	}

	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}

