package TestProj2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.GridLayout;

public class INTERFACE extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static boolean valide=true;
	private JTable table;
	private JTable RAM;
	private JTextField PC;
	private JTextField A;
	private JTextField B;
	private JTextField X;
	private JTextField Y;
	private JTextField U;
	private JTextField S;
	private JTextField DP;
	private JTextField CCR;
	String[][] ROM = null;
	String[] columnNames = { "adress", "code" };
	String[][] RAM_ = null;
	String[] nom = { "address", "valeur" };

	public INTERFACE() {
		setBackground(SystemColor.control);
		setTitle("M6809");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		
		setResizable(false);
		
		JPanel Pwest = new JPanel();
		JPanel Peast = new JPanel();
		JPanel Pcentre = new JPanel();
		JPanel Psouth = new JPanel();
		Pwest.setPreferredSize(new Dimension(190,300));
		Peast.setPreferredSize(new Dimension(272,600));
		Psouth.setPreferredSize(new Dimension(200,45));
		Pcentre.setPreferredSize(new Dimension(420,50));
		Pcentre.setBackground(Color.lightGray);
		Pwest.setBackground(Color.lightGray);
		Peast.setBackground(Color.lightGray);
		Psouth.setBackground(Color.lightGray);
		add(Pcentre,BorderLayout.CENTER);
		add(Peast,BorderLayout.EAST);
		add(Pwest,BorderLayout.WEST);
		add(Psouth,BorderLayout.SOUTH);
		


		JScrollPane scrollPane = new JScrollPane();

		JScrollPane scrollPane_RAM = new JScrollPane();
		
		Pwest.setLayout(new GridLayout(2,1));
		Pwest.add(scrollPane);
		Pwest.add(scrollPane_RAM);
		scrollPane.setPreferredSize(new Dimension(190, 500));
		scrollPane_RAM.setPreferredSize(new Dimension(190, 500));
		
		
		JTextArea code_espace = new JTextArea();
		code_espace.setEditable(true);
		JScrollPane scrollCode = new JScrollPane(code_espace);
		scrollCode.setPreferredSize(new Dimension(420, 500));
		Pcentre.add(scrollCode);


		
		Peast.setLayout(null);  

		ImageIcon icon = new ImageIcon("");
		JLabel imageLabel = new JLabel(icon);
		imageLabel.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
		Peast.add(imageLabel);


		PC = new JTextField();
		PC.setEditable(false);
		PC.setBounds(105, 10, 120, 40);  
		PC.setFont(new Font("Tahoma", Font.BOLD, 17));
		Peast.add(PC);

		S = new JTextField();
		S.setEditable(false);
		S.setBounds(40, 102, 100, 40); 
		S.setFont(new Font("Tahoma", Font.BOLD, 17));
		Peast.add(S);

		U = new JTextField();
		U.setEditable(false);
		U.setBounds(168, 102, 100, 40);  
		U.setFont(new Font("Tahoma", Font.BOLD, 17));
		Peast.add(U);

		A = new JTextField();
		A.setEditable(false);
		A.setBounds(40, 173, 60, 40); 
		A.setFont(new Font("Tahoma", Font.BOLD, 17));
		Peast.add(A);

		B = new JTextField();
		B.setEditable(false);
		B.setBounds(40, 277, 60, 40);    
		B.setFont(new Font("Tahoma", Font.BOLD, 17));
		Peast.add(B);

		DP = new JTextField();
		DP.setEditable(false);
		DP.setFont(new Font("Tahoma", Font.BOLD, 17));
		DP.setBounds(43, 347, 60, 40);   
		Peast.add(DP);

		CCR = new JTextField();
		CCR.setEditable(false);
		CCR.setBounds(110, 345, 140, 45); 
		CCR.setFont(new Font("Tahoma", Font.BOLD, 17));
		Peast.add(CCR);

		X = new JTextField();
		X.setEditable(false);
		X.setBounds(30, 435, 100, 40);
		X.setFont(new Font("Tahoma", Font.BOLD, 17));
		Peast.add(X);

		Y = new JTextField();
		Y.setEditable(false);
		Y.setBounds(170, 435, 100, 40); 
		Y.setFont(new Font("Tahoma", Font.BOLD, 17));
		Peast.add(Y);




		JButton COMPILE = new JButton("COMPILER");
		COMPILE.setFont(new Font("Tahoma", Font.BOLD, 11));
		COMPILE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cont = code_espace.getText();
				if (cont.isEmpty()) {
					JFrame Frame = new JFrame("�criture dans un fichier");
					Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					Frame.setSize(400, 300);
					Frame.getContentPane().setLayout(new BorderLayout());
					JOptionPane.showMessageDialog(Frame, "Veuillez entrer du code avant de compiler.", "Erreur",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				Compilation.init_Rom();
				Execution.init_Ram();
				File_class.FILE(code_espace.getText());
				Compilation.Rom[Compilation.adress][1]="3F";
				ROM = Compilation.Rom;
				table = new JTable();
				table.setModel(new DefaultTableModel(ROM, columnNames));
				scrollPane.setViewportView(table);
			}
		});
		COMPILE.setPreferredSize(new Dimension(119, 31));
		Psouth.add(COMPILE);

		JButton pas = new JButton("PAS A PAS");
		pas.setFont(new Font("Tahoma", Font.BOLD, 11));
		pas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (valide&&Execution.detectMode()) {
					RAM_ = Execution.RAM;
					RAM = new JTable();
					RAM.setModel(new DefaultTableModel(RAM_, nom));
					scrollPane_RAM.setViewportView(RAM);
					PC.setText( Execution.RAM[Execution.address][0]);
					A.setText(new String(Execution.A));
					B.setText(new String(Execution.B));
					X.setText(new String(Execution.X));
					Y.setText(new String(Execution.Y));
					U.setText(new String(Execution.U));
					S.setText(new String(Execution.S));
					DP.setText(new String(Execution.DP));
					CCR.setText(new String(Execution.CCR));
				}
			}
		});
		pas.setPreferredSize(new Dimension(119, 31));
		Psouth.add(pas);

		JButton EXECUTE = new JButton("EXECUTER");
		EXECUTE.setFont(new Font("Tahoma", Font.BOLD, 11));
		EXECUTE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				while (valide&&Execution.detectMode()) {
					RAM_ = Execution.RAM;
					RAM = new JTable();
					RAM.setModel(new DefaultTableModel(RAM_, nom));
					scrollPane_RAM.setViewportView(RAM);
					PC.setText( Execution.RAM[Execution.address][0]);
					A.setText(new String(Execution.A));
					B.setText(new String(Execution.B));
					X.setText(new String(Execution.X));
					Y.setText(new String(Execution.Y));
					U.setText(new String(Execution.U));
					S.setText(new String(Execution.S));
					DP.setText(new String(Execution.DP));
					CCR.setText(new String(Execution.CCR));
				}
			}

		});
		EXECUTE.setPreferredSize(new Dimension(119, 31));
		Psouth.add(EXECUTE);


		
		JButton Ram_Ecrir = new JButton("ECRIRE");
		Ram_Ecrir.setFont(new Font("Tahoma", Font.BOLD, 11));
		Ram_Ecrir.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame();
				frame.setBounds(450, 300, 250, 195);
				frame.getContentPane().setLayout(null);
				frame.setVisible(true);
				JTextField Valeur = new JTextField();
				Valeur.setBounds(120, 77, 65, 19);
				frame.getContentPane().add(Valeur);
				Valeur.setColumns(10);
				
				JTextField adress = new JTextField();
				adress.setBounds(45, 77, 65, 19);
				frame.getContentPane().add(adress);
				adress.setColumns(10);
				
				JLabel ADDRESS = new JLabel("ADDRESS");
				ADDRESS.setBounds(45, 58, 45, 13);
				frame.getContentPane().add(ADDRESS);
				
				JLabel VALEUR = new JLabel("VALEUR");
				VALEUR.setBounds(125, 54, 45, 13);
				frame.getContentPane().add(VALEUR);
				
				JButton Ecrir = new JButton("Ecrir");
				Ecrir.setBounds(85, 106, 85, 21);
				frame.getContentPane().add(Ecrir);
				Ecrir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						boolean test=true;
						String add=adress.getText().trim();
						String val=Valeur.getText().trim();
						if(add.length()!=4){
							ERROR("address invalid");
							valide=true;
							test=false;
						}
						 if(val.length()!=2) {
							ERROR("valeur invalid");
							valide=true;
						}
						try {
							int value=Integer.parseInt(val.substring(0,1), 16);
							value=Integer.parseInt(val, 16);
							if(value<0) {
								ERROR("valeur invalid");
								valide=true;
								test=false;
							}
							if(add.charAt(0)=='-'||add.charAt(0)=='+') {
								ERROR(" invalid address");
								valide=true;
								test=false;
							}
							int add_int=Integer.parseInt(add, 16);
							if(add_int>6000) {
								ERROR("la plus grand address est 1770H");
								valide=true;
								test=false;
							}
							if(test) {
								Execution.RAM[add_int][1]=val;
								RAM_ = Execution.RAM;
								ERROR("Ecritur bien fait");
								valide=true;
								RAM = new JTable();
								RAM.setModel(new DefaultTableModel(RAM_, nom));
								scrollPane_RAM.setViewportView(RAM);
								frame.dispose();
							}
							
						}catch(Exception e1) {
							ERROR("Input invald");
							valide=true;
							test=false;
						}
						
					}
				});
			}
		});
		Ram_Ecrir.setPreferredSize(new Dimension(119, 31));
		Psouth.add(Ram_Ecrir);
		
		
		
		
		JButton effacer = new JButton("EFFACER");
		effacer.setFont(new Font("Tahoma", Font.BOLD, 11));
		effacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				code_espace.setText("");
			}
		});
		effacer.setPreferredSize(new Dimension(119, 31));
		Psouth.add(effacer);
		
		JMenuBar Bar = new JMenuBar();
		JMenu Menu = new JMenu("File");
		JMenuItem SAVES = new JMenuItem("Save");
		JMenuItem RESET = new JMenuItem("Reset");
		JMenuItem Open = new JMenuItem("Open");
		Bar.add(Menu);
		Menu.add(SAVES);
		Menu.add(Open);
		Menu.add(RESET);
		setJMenuBar(Bar);
		
		SAVES.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JFrame Frame = new JFrame("�criture dans un fichier");
				Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Frame.setSize(400, 300);
				Frame.getContentPane().setLayout(new BorderLayout());

				String cont = code_espace.getText();
				if (cont.isEmpty()) {
					JOptionPane.showMessageDialog(Frame, "Veuillez entrer du code avant de sauvegarder.", "Erreur",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				JFileChooser fileChooser = new JFileChooser();
				int option = fileChooser.showSaveDialog(Frame);
				if (option == JFileChooser.APPROVE_OPTION) {
					String filePath = fileChooser.getSelectedFile().getAbsolutePath();
					saveToFile(filePath, cont);
				}
			}
		});
		
		
		RESET.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Compilation.init_Rom();
				Execution.init_Ram();
				Execution.address = 0;
				Execution.A[0] = '0';
				Execution.A[1] = '0';
				Execution.B[0] = '0';
				Execution.B[1] = '0';
				Execution.PC[0] = '0';
				Execution.PC[1] = '0';
				Execution.PC[2] = '0';
				Execution.PC[3] = '0';
				Execution.S[0] = '0';
				Execution.S[1] = '0';
				Execution.S[2] = '0';
				Execution.S[3] = '0';
				Execution.X[0] = '0';
				Execution.X[1] = '0';
				Execution.X[2] = '0';
				Execution.X[3] = '0';
				Execution.U[0] = '0';
				Execution.U[1] = '0';
				Execution.U[2] = '0';
				Execution.U[3] = '0';
				Execution.Y[0] = '0';
				Execution.Y[1] = '0';
				Execution.Y[2] = '0';
				Execution.Y[3] = '0';
				Execution.DP[0] = '0';
				Execution.DP[1] = '0';
				Execution.CCR[0] = '0';
				Execution.CCR[1] = '0';
				Execution.CCR[2] = '0';
				Execution.CCR[3] = '0';
				Execution.CCR[4] = '0';
				Execution.CCR[5] = '0';
				Execution.CCR[6] = '0';
				Execution.CCR[7] = '0';

				RAM_ = Execution.RAM;
				RAM = new JTable();
				RAM.setModel(new DefaultTableModel(RAM_, nom));
				scrollPane_RAM.setViewportView(RAM);
				PC.setText( Execution.RAM[Execution.address][0]);
				A.setText(new String(Execution.A));
				B.setText(new String(Execution.B));
				X.setText(new String(Execution.X));
				Y.setText(new String(Execution.Y));
				U.setText(new String(Execution.U));
				S.setText(new String(Execution.S));
				DP.setText(new String(Execution.DP));
				CCR.setText(new String(Execution.CCR));

			}
		});
		
		Open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame Frame = new JFrame();
				Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Frame.setSize(400, 300);
				Frame.getContentPane().setLayout(new BorderLayout());

				JFileChooser fileChooser = new JFileChooser();
				int option = fileChooser.showSaveDialog(Frame);
				if (option == JFileChooser.APPROVE_OPTION) {
					String filePath = fileChooser.getSelectedFile().getAbsolutePath();
					String contenu=readFromFile(filePath);
					code_espace.setText(contenu);
					
				}
			}
		});
		
		
		}
	

	public static void saveToFile(String filePath, String content) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
			writer.write(content);
			JOptionPane.showMessageDialog(null, "Le fichier a �t� sauvegard� avec succ�s.", "Succ�s",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erreur lors de l��criture dans le fichier : " + e.getMessage(),
					"Erreur", JOptionPane.ERROR_MESSAGE);
		}
	}
	public static void ERROR(String error_nome) {
		valide=false;
		JOptionPane.showMessageDialog(null, error_nome, "Succ�s",
				JOptionPane.INFORMATION_MESSAGE);
		return;
	}
	public static String readFromFile(String filePath) {
		try (BufferedReader Read = new BufferedReader(new FileReader(filePath))) {
			String line,contenu="";
			while((line= Read.readLine())!=null) {
			contenu=contenu+line;
			contenu+="\n";}
			return contenu;
		} catch (IOException e) {

			JOptionPane.showMessageDialog(null, "Erreur lors de l��criture dans le fichier : " + e.getMessage(),
					"Erreur", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			try {
				INTERFACE frame = new INTERFACE();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}
