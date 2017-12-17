/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EchipaSponsor;

/**
 *
 * @author Serdin
 */
import java.util.List;

import javax.swing.table.AbstractTableModel;


class EchipaSponsorTableModel extends AbstractTableModel {

	public static final int OBJECT_COL = -1;
	private static final int SPONSORID_COL = 0;
	private static final int ECHIPAID_COL = 1;
	private static final int LUNIDECONTRACT_COL = 2;

	private String[] columnNames = { "Sponsor ID", "Echipa ID", "Luni de Contract"
			 };
	private List<EchipaSponsor> employees;

	public EchipaSponsorTableModel(List<EchipaSponsor> theEmployees) {
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

		EchipaSponsor tempEmployee = employees.get(row);

		switch (col) {
		case SPONSORID_COL:
			return tempEmployee.getSponsorID();
		case ECHIPAID_COL:
			return tempEmployee.getEchipaID();
		case LUNIDECONTRACT_COL:
			return tempEmployee.getLuniDeContract();
		case OBJECT_COL:
			return tempEmployee;
		default:
			return tempEmployee.getSponsorID();
		}
	}

	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}