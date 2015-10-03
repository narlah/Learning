package archiver;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;

public class VisualInterface {
	private ArchiverController controller = new ArchiverController();
	private CTabHuffmanCodesTabItem ctabFCodesItem;
	private CTabFolder tabFolder;
	private InOutTabItem inoutTabItem;
	private ShowCompressorWikiTabItem showCompressorWikiTabItem;
	private int tabSelection = 0;

	public enum compressionTypes {
		Huffman("nik"), GZiPStream("zip"), LZ77("lz7"), Something_Else("arc");
		private final String fileExtention;

		compressionTypes(String type) {
			this.fileExtention = type;
		}

		public String getExtention() {
			return fileExtention;
		}
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	Shell initUI() {
		Display display = new Display();
		final Shell shell = new Shell(display);
		controller.setCompressorName("Huffman"); // default selected
		tabFolder = new CTabFolder(shell, SWT.BORDER);
		tabFolder.setSimple(false);
		tabFolder.setBounds(0, 21, 605, 570);
		tabFolder.setSelection(tabSelection);
		tabFolder.setFocus();
		tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(
				SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
		// tab items
		// >tabs
		inoutTabItem = new InOutTabItem(tabFolder, SWT.NONE);

		if (controller.getCompressorName() != null && controller.getCompressorName().equalsIgnoreCase("Huffman")) {
			ctabFCodesItem = new CTabHuffmanCodesTabItem(tabFolder, SWT.NONE);
		}

		showCompressorWikiTabItem = new ShowCompressorWikiTabItem(tabFolder, controller.getCompressorName());

		// <tabs

		shell.setSize(624, 638);
		shell.setText("Archiver Visual Interface");
		shell.setLayout(null);

		// Menu management
		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);

		MenuItem mntmNewSubmenu = new MenuItem(menu, SWT.CASCADE);
		mntmNewSubmenu.setText("File");

		Menu menu_1 = new Menu(mntmNewSubmenu);
		mntmNewSubmenu.setMenu(menu_1);

		MenuItem fileMenuOpen = new MenuItem(menu_1, SWT.NONE);
		fileMenuOpen.setText("Open");

		MenuItem fileMenuClose = new MenuItem(menu_1, SWT.NONE);
		fileMenuClose.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				controller.setInFile(null);
				controller.setInFile(null);
				inoutTabItem.changeInOut("", "");
			}
		});
		fileMenuClose.setText("Close");

		// menu item exit
		MenuItem fileMenuExit = new MenuItem(menu_1, SWT.NONE);
		fileMenuExit.setText("Exit");
		fileMenuExit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				System.exit(1);
			}
		});

		// menu item open (File selector)
		class Open implements SelectionListener {
			public void widgetSelected(SelectionEvent event) {
				FileDialog fd = new FileDialog(shell, SWT.OPEN);
				fd.setText("Open");
				fd.setFilterPath(".");
				String[] filterExt = { "*.*", "*.txt", "*.doc", "*.rtf", "*.xml" };
				fd.setFilterExtensions(filterExt);
				String selected = fd.open();
				if (selected != null) {
					System.out.println(selected);
					controller.setInFile(selected);
					String outFileName = controller.setOutFileFromIn(selected);
					if (controller.getCompressorName().equalsIgnoreCase("Huffman")) {
						inoutTabItem.changeInOut(selected, outFileName);
					}
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		}

		fileMenuOpen.addSelectionListener(new Open());

		new MenuItem(menu, SWT.SEPARATOR);

		@SuppressWarnings(value = { "unused" })
		MenuItem menuItem = new MenuItem(menu, SWT.SEPARATOR);

		// menu item Archive
		MenuItem menuArchive = new MenuItem(menu, SWT.NONE);
		menuArchive.addSelectionListener(new SelectionAdapter() {
			@SuppressWarnings("unchecked")
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				try {
					controller.compress();
					if (controller.getCompressorName().equalsIgnoreCase("Huffman")) {
						ctabFCodesItem.fillTable((HashMap<Character, String>) controller.getDataStructure());
					}
				} catch (IllegalArgumentException | IOException e) {
					System.out.println(e.getMessage());
				}
			}
		});
		menuArchive.setText("Archive");

		// menu item UnPack
		MenuItem menuUnpack = new MenuItem(menu, SWT.NONE);
		menuUnpack.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
			}
		});
		menuUnpack.setText("UnPack");

		// menu item ShowCodes
		// MenuItem menuShowCodes = new MenuItem(menu, SWT.NONE);
		// menuShowCodes.setText("Show Compressor info");
		// TODO try to add the combo to the menu bar

		ProgressBar progressBar = new ProgressBar(shell, SWT.NONE);
		progressBar.setBounds(10, 563, 256, 17);
		progressBar.setVisible(false);
		// TODO progress bar ?

		// Compress Selector combo
		final Combo comboCompressSelector = new Combo(shell, SWT.NONE);
		comboCompressSelector.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				String selectedMethod = comboCompressSelector.getText();
				if (!controller.getCompressorName().equalsIgnoreCase(selectedMethod)) {
					controller.changeCompressor(selectedMethod);
					if (selectedMethod.equalsIgnoreCase("Huffman")) {
						ctabFCodesItem.initUI();
					} else
						ctabFCodesItem.dispose();
					showCompressorWikiTabItem.dispose();
					showCompressorWikiTabItem = new ShowCompressorWikiTabItem(tabFolder, selectedMethod);

					String newOutFileName = controller.updateOutFileExtention(compressionTypes.valueOf(selectedMethod)
							.getExtention());
					inoutTabItem.setInFile(controller.getInFile());
					inoutTabItem.updateOutExtention(newOutFileName);
				}
			}
		});
		comboCompressSelector.setItems(Arrays.toString(compressionTypes.values()).replaceAll("^.|.$", "").split(", "));
		comboCompressSelector.setBounds(517, 0, 91, 17);
		comboCompressSelector.select(0);

		return shell;
	}
}
