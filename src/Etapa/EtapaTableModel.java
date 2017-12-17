/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Etapa;

import java.util.List;

import javax.swing.table.AbstractTableModel;


class EtapaTableModel extends AbstractTableModel {

	public static final int OBJECT_COL = -1;
	private static final int NUMAR_ETAPA_COL = 0;
	private static final int DATA_ETAPEI_COL = 1;

	private String[] columnNames = {  "Numarul Etapei", "Data Etapei"
			};
	private List<Etapa> employees;

	public EtapaTableModel(List<Etapa> theEmployees) {
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

		Etapa tempEmployee = employees.get(row);

		switch (col) {
                    case NUMAR_ETAPA_COL:
			return tempEmployee.getNumarEtapa();
		case DATA_ETAPEI_COL:
			return tempEmployee.getDataEtapei();
		case OBJECT_COL:
			return tempEmployee;
		default:
			return tempEmployee.getNumarEtapa();
		}
	}

	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}

