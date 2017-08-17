package archiver.mine;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class InOutTabItem {
	private CTabItem inOutTabItem;
	private CTabFolder tabFolder;
	private Label inFileLabel;
	private Label outFileLabel;

	public InOutTabItem(CTabFolder folder, int swtSomething) {
		this.tabFolder = folder;
		initUI();
	}

	private void initUI() {
		// TAb IN AND OUT

		inOutTabItem = new CTabItem(tabFolder, SWT.NONE);
		inOutTabItem.setText("In - out");

		Composite compositeInOut = new Composite(tabFolder, SWT.NONE);
		compositeInOut.setLayout(null);

		Label in_lbl = new Label(compositeInOut, SWT.NONE);
		in_lbl.setBounds(5, 5, 16, 15);
		in_lbl.setText("In :");
		inFileLabel = new Label(compositeInOut, SWT.NONE);
		inFileLabel.setBounds(37, 5, 373, 15);

		outFileLabel = new Label(compositeInOut, SWT.NONE);
		outFileLabel.setBounds(37, 28, 373, 15);

		Label out_lbl = new Label(compositeInOut, SWT.NONE);
		out_lbl.setBounds(5, 28, 29, 15);
		out_lbl.setText("Out : ");

		inOutTabItem.setControl(compositeInOut);
	}

	public void changeInOut(String in, String out) {
		this.inFileLabel.setText(in);
		this.outFileLabel.setText(out);
	}

	public void updateOutExtention(String out) {
		if (out != null)
			this.outFileLabel.setText(out);
	}

	public void setInFile(String in) {
		if (in != null)
			this.inFileLabel.setText(in);
	}

}
