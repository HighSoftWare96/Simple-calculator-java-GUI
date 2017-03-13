import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Main {

	protected Shell shell;
	private Text firstN;
	private Text secondN;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Main window = new Main();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("Advanced Calculator");

		Label result = new Label(shell, SWT.NONE);
		result.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.NORMAL));
		result.setAlignment(SWT.CENTER);
		result.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		result.setForeground(SWTResourceManager.getColor(0, 0, 0));
		result.setBounds(70, 202, 314, 49);

		firstN = new Text(shell, SWT.BORDER);
		firstN.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		firstN.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		firstN.setBounds(10, 10, 199, 72);

		secondN = new Text(shell, SWT.BORDER);
		secondN.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		secondN.setBounds(215, 10, 209, 72);

		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(70, 88, 85, 15);
		lblNewLabel.setText("First Number");

		Label lblSecondNumber = new Label(shell, SWT.NONE);
		lblSecondNumber.setBounds(271, 88, 97, 15);
		lblSecondNumber.setText("Second Number");
		
		//OPERAZIONE: SOMMA
		Button plusB = new Button(shell, SWT.NONE);
		plusB.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				double number1, number2;
				try {
					number1 = Double.parseDouble(firstN.getText());
				} catch (Exception e1) {
					MessageDialog.openError(shell, "Error", "Insert the correct numbers!");
					return;
				}
				try {
					number2 = Double.parseDouble(secondN.getText());
				} catch (Exception e2) {
					MessageDialog.openError(shell, "Error", "Insert the correct numbers!");
					return;
				}
				double resultN = number1 + number2;
				result.setText("" + resultN);
				
				//resetting variables
				firstN.setText("" + resultN);
				number1 = resultN;
			}
		});
		plusB.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		plusB.setBounds(134, 109, 75, 25);
		plusB.setText("+");
		
		
		//OPERAZIONE: SOTTRAZIONE
		Button minusB = new Button(shell, SWT.NONE);
		minusB.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				double number1, number2;
				try {
					number1 = Double.parseDouble(firstN.getText());
				} catch (Exception e1) {
					MessageDialog.openError(shell, "Error", "Insert the correct numbers!");
					return;
				}
				try {
					number2 = Double.parseDouble(secondN.getText());
				} catch (Exception e2) {
					MessageDialog.openError(shell, "Error", "Insert the correct numbers!");
					return;
				}
				double resultN = number1 - number2;
				result.setText("" + resultN);
				
				//resetting variables
				firstN.setText("" + resultN);
				number1 = resultN;
			}

		});
		minusB.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		minusB.setBounds(215, 109, 75, 25);
		minusB.setText("-");

		//OPERAZIONE: DIVISIONE
		Button divB = new Button(shell, SWT.NONE);
		divB.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				double number1, number2;
				try {
					number1 = Double.parseDouble(firstN.getText());
				} catch (Exception e1) {
					MessageDialog.openError(shell, "Error", "Insert the correct numbers!");
					return;
				}
				try {
					number2 = Double.parseDouble(secondN.getText());
				} catch (Exception e2) {
					MessageDialog.openError(shell, "Error", "Insert the correct numbers!");
					return;
				}

				double resultN;

				try {
					resultN = number1 / number2;
				} catch (Exception e3) {
					MessageDialog.openError(shell, "Incorrent operation", "Impossible to perform this operation");
					return;
				}

				result.setText("" + resultN);
				
				//resetting variables
				firstN.setText("" + resultN);
				number1 = resultN;
			}

		});
		divB.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		divB.setBounds(134, 140, 75, 25);
		divB.setText("/");
		
		//OPERAZIONE: MOLTIPLICAZIONE
		Button molB = new Button(shell, SWT.NONE);
		molB.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				double number1, number2;
				try {
					number1 = Double.parseDouble(firstN.getText());
				} catch (Exception e1) {
					MessageDialog.openError(shell, "Error", "Insert the correct numbers!");
					return;
				}
				try {
					number2 = Double.parseDouble(secondN.getText());
				} catch (Exception e2) {
					MessageDialog.openError(shell, "Error", "Insert the correct numbers!");
					return;
				}
				double resultN = number1 * number2;
				result.setText("" + resultN);
				
				//resetting variables
				secondN.setText("" + resultN);
				number2 = resultN;
			}
		});
		molB.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		molB.setBounds(215, 140, 75, 25);
		molB.setText("*");

		Label lblResult = new Label(shell, SWT.NONE);
		lblResult.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.ITALIC));
		lblResult.setAlignment(SWT.CENTER);
		lblResult.setBounds(186, 171, 56, 25);
		lblResult.setText("Result");

	}

}
