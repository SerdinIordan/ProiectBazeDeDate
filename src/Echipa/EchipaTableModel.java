/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Echipa;
import java.util.List;

import javax.swing.table.AbstractTableModel;


public class EchipaTableModel extends AbstractTableModel {

	public static final int OBJECT_COL = -1;
        private static final int NUME_ECHIPA_COL = 0;
        private static final int ANTRENOR_COL = 1;
        private static final int CAPITAN_COL = 2;
        private static final int BUGET_COL = 3;
        private static final int STADION_COL = 4;
        private static final int ORAS_COL = 5;
        private static final int CAMP_CASTIGATE_COL = 6;
        
        

	private String[] columnNames = { "NumeEchipa", "Antrenor", "Capitan",
			"Buget","Stadion","Oras","CampCastigate" };
	private List<Echipa> echipe;

	public EchipaTableModel(List<Echipa> theEchipe) {
		echipe = theEchipe;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return echipe.size();
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {

		Echipa tempEmployee = echipe.get(row);

		switch (col) {
		case NUME_ECHIPA_COL:
			return tempEmployee.getNumeEchipa();
		case ANTRENOR_COL:
			return tempEmployee.getAntrenor();
		case CAPITAN_COL:
			return tempEmployee.getCapitan();
		case BUGET_COL:
			return tempEmployee.getBuget();
                case STADION_COL:
			return tempEmployee.getStadion();
                case ORAS_COL:
                return tempEmployee.getOras();
                case CAMP_CASTIGATE_COL:
                return tempEmployee.getCampCastigate();
                
		case OBJECT_COL:
			return tempEmployee;
		default:
			return tempEmployee.getNumeEchipa();
		}
	}

	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}
