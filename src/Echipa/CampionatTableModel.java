/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Echipa;
import java.util.List;

import javax.swing.table.AbstractTableModel;


public class CampionatTableModel extends AbstractTableModel {

	public static final int OBJECT_COL = -1;
        private static final int POZITIE_COL = 0;
        private static final int NUME_ECHIPA_COL = 1;
        //private static final int POZITIE_COL = 1;
        private static final int PUNCTE_COL = 2;
        private static final int MECIURI_JUCATE_COL = 3;
        private static final int VICTORII_COL = 4;
        private static final int EGALURI_COL = 5;
        private static final int INFRANGERI_COL = 6;
        private static final int GOLURI_DATE_COL = 7;
        private static final int GOLURI_PRIMITE_COL = 8;
        
        
        

	private String[] columnNames = {"Loc","NumeEchipa","Puncte","MJ","V","E","I","GD","GP" };
	private List<equip> echipe;

	public CampionatTableModel(List<equip> theEchipe) {
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

		equip tempEmployee = echipe.get(row);
                //int loc=0;
		switch (col) {
                    case POZITIE_COL:
                        return tempEmployee.getPozitie();
                    
		case NUME_ECHIPA_COL:
			return tempEmployee.getNume();
                      
		case PUNCTE_COL:
			return tempEmployee.getPuncte();
                case MECIURI_JUCATE_COL:
                        return tempEmployee.getMj();
                case VICTORII_COL:
                        return tempEmployee.getVictorii();
                case EGALURI_COL:
                        return tempEmployee.getEgaluri();
                case INFRANGERI_COL:
                        return tempEmployee.getInfrangeri();
                case GOLURI_DATE_COL:
                        return tempEmployee.getGoluridate();
                case GOLURI_PRIMITE_COL:
                        return tempEmployee.getGoluriprimite();
                        
                        
		case OBJECT_COL:
			return tempEmployee;
		default:
			return tempEmployee.getNume();
		}
	}

	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}

