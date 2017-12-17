/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sponsor;

import java.util.List;

import javax.swing.table.AbstractTableModel;


class SponsorTableModel extends AbstractTableModel {

	public static final int OBJECT_COL = -1;
	private static final int NUME_SPONSOR_COL = 0;
	private static final int DATA_FONDARII_COL = 1;
	private static final int FONDATOR_COL = 2;
	private static final int SEDIU_COL = 3;
        private static final int INDUSTRIE_COL = 4;
        private static final int PROFIT_COL = 5;
        private static final int NUMAR_ANGAJATI_COL = 6;
        private static final int WEBSITE_COL = 7;

	private String[] columnNames = { "Nume Sponsor", "Data Fondarii", "Fondator",
			"Sediu","Industrie","Profit","Numar Angajati","Website" };
	private List<Sponsor> employees;

	public SponsorTableModel(List<Sponsor> theEmployees) {
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

		Sponsor tempSponsor = employees.get(row);

		switch (col) {
                case NUME_SPONSOR_COL:
			return tempSponsor.getNumeSponsor();
                case DATA_FONDARII_COL:
                        return tempSponsor.getDataFondarii();
                case FONDATOR_COL:
                        return tempSponsor.getFondator(); 
                case SEDIU_COL:
                        return tempSponsor.getSediu();
                case INDUSTRIE_COL:
                        return tempSponsor.getIndustrie();
                case PROFIT_COL:
                        return tempSponsor.getProfit();
                case NUMAR_ANGAJATI_COL:
                        return tempSponsor.getNumarAngajati();
                case WEBSITE_COL:
                        return tempSponsor.getWebsite();
		case OBJECT_COL:
			return tempSponsor;
		default:
			return tempSponsor.getNumeSponsor();
		}
	}

	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}
