package archiver;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.*;

import java.util.*;

public class CTabHuffmanCodesTabItem {
    private CTabItem tbtmNewCodes;
    private Table table;
    private TableColumn tblclmnChar;
    private TableColumn tblclmnCharASCIICode;
    private TableColumn tblclmnCode;
    private CTabFolder tabFolder;
    private ArrayList<String[]> tableRows = new ArrayList<String[]>();

    public CTabHuffmanCodesTabItem(CTabFolder arg0, int arg1) {
        this.tabFolder = arg0;
        initUI();
    }

    public void dispose() {
        tbtmNewCodes.dispose();
    }

    public void initUI() {

        // tab Show Codes
        tbtmNewCodes = new CTabItem(tabFolder, SWT.NONE);
        tbtmNewCodes.setText("Show Codes");

        ScrolledComposite scrolledCodesComposite = new ScrolledComposite(tabFolder, SWT.BORDER | SWT.H_SCROLL
                | SWT.V_SCROLL);
        tbtmNewCodes.setControl(scrolledCodesComposite);
        scrolledCodesComposite.setExpandHorizontal(true);
        scrolledCodesComposite.setExpandVertical(true);

        table = new Table(scrolledCodesComposite, SWT.BORDER | SWT.FULL_SELECTION);
        table.setHeaderVisible(true);
        table.setLinesVisible(true);

        tblclmnChar = new TableColumn(table, SWT.NONE);
        tblclmnChar.setAlignment(SWT.CENTER);
        tblclmnChar.setWidth(39);
        tblclmnChar.setText("Char");

        tblclmnCharASCIICode = new TableColumn(table, SWT.NONE);
        tblclmnCharASCIICode.setWidth(57);
        tblclmnCharASCIICode.setText("   ASCII");
        table.setSortColumn(tblclmnCharASCIICode);

        tblclmnCode = new TableColumn(table, SWT.NONE);
        tblclmnCode.setWidth(450);
        tblclmnCode.setText("Huffman Code");

        Listener sortListener = new Listener() {
            public void handleEvent(Event e) {
                TableColumn column = (TableColumn) e.widget;
                if (column == tblclmnChar)
                    Collections.sort(tableRows, BY_CHAR);
                if (column == tblclmnCharASCIICode)
                    Collections.sort(tableRows, BY_ASCII);
                if (column == tblclmnCode)
                    Collections.sort(tableRows, BY_CODE);
                table.setSortColumn(column);
                updateTable();
            }
        };
        tblclmnChar.addListener(SWT.Selection, sortListener);
        tblclmnCharASCIICode.addListener(SWT.Selection, sortListener);
        tblclmnCode.addListener(SWT.Selection, sortListener);

        scrolledCodesComposite.setContent(table);
        scrolledCodesComposite.setMinSize(table.computeSize(SWT.DEFAULT, SWT.DEFAULT));

    }

    public void fillTable(HashMap<Character, String> hashMap) {
        for (Map.Entry<Character, String> entry : hashMap.entrySet()) {
            TableItem item = new TableItem(table, SWT.NONE);
            String[] stringArray = {entry.getKey().toString(), (int) entry.getKey() + "", entry.getValue()};
            item.setText(stringArray);
            tableRows.add(stringArray);
        }
        table.redraw();
    }

    private void updateTable() {
        table.removeAll();
        for (String[] row : tableRows) {
            TableItem item = new TableItem(table, SWT.NONE);
            item.setText(row);
        }
    }

    public final Comparator<String[]> BY_CHAR = new Comparator<String[]>() {
        @Override
        public int compare(String[] o1, String[] o2) {
            return o1[0].compareTo(o2[0]);
        }
    };

    public final Comparator<String[]> BY_ASCII = new Comparator<String[]>() {
        @Override
        public int compare(String[] o1, String[] o2) {
            return new Integer(o1[1]).compareTo(new Integer(o2[1]));
        }
    };

    public final Comparator<String[]> BY_CODE = new Comparator<String[]>() {
        @Override
        public int compare(String[] o1, String[] o2) {
            int len1 = o1[2].length();
            int len2 = o2[2].length();
            if (len1 > len2)
                return 1;
            else if (len1 < len2)
                return -1;
            else
                return 0;
        }
    };
}
