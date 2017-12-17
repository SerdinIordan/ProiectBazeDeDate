/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jucator;

import java.util.List;

import javax.swing.table.AbstractTableModel;


class JucatorTableModel extends AbstractTableModel {

	public static final int OBJECT_COL = -1;
	private static final int ECHIPAID_COL = 0;
	private static final int NUME_COL = 1;
	private static final int PRENUME_COL = 2;
	private static final int DATA_NASTERII_COL = 3;
        private static final int INALTIME_COL = 4;
        private static final int GREUTATE_COL = 5;
        private static final int POZITIE_COL = 6;

	private String[] columnNames = { "EchipaID", "Nume", "Prenume","Data Nasterii","Inaltime","Greutate",
			"Pozitie" };
	private List<Jucator> employees;

	public JucatorTableModel(List<Jucator> theEmployees) {
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

		Jucator tempEmployee = employees.get(row);

		switch (col) {
                case ECHIPAID_COL:
			return tempEmployee.getEchipaID();
                case NUME_COL:
			return tempEmployee.getNume();
                case PRENUME_COL:
			return tempEmployee.getPrenume();
                case DATA_NASTERII_COL:
			return tempEmployee.getDataNasterii();
                case INALTIME_COL:
			return tempEmployee.getInaltime();
                case GREUTATE_COL:
			return tempEmployee.getGreutate();
                case POZITIE_COL:
			return tempEmployee.getPozitie();
                
		case OBJECT_COL:
			return tempEmployee;
		default:
			return tempEmployee.getEchipaID();
		}
	}

	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}