package br.com.view;

import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDesktopPane;

import br.com.entity.Paciente;
import br.com.pesistence.PacienteDao;

import com.toedter.calendar.JCalendar;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSeparator;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TelaIncial {

	private JFrame frame;
	private JTextField textRg;
	private JTextField textNome;
	private JTextField textCpf;
	private JTextField codPaciente;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaIncial window = new TelaIncial();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaIncial() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 536, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		JMenuItem mntmNovaConsulta = new JMenuItem("Nova Consulta");
		mnArquivo.add(mntmNovaConsulta);
		
		JPanel panel = new JPanel();
		
		JSeparator separator = new JSeparator();
		
		JLabel mensagem = new JLabel("");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(7)
									.addComponent(separator, GroupLayout.PREFERRED_SIZE, 469, GroupLayout.PREFERRED_SIZE))
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 474, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(121)
							.addComponent(mensagem)))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(mensagem)
					.addContainerGap(56, Short.MAX_VALUE))
		);
		
		JLabel lblNome = new JLabel("Nome");
		
		textRg = new JTextField();
		textRg.setColumns(10);
		
		JLabel lblRg = new JLabel("RG");
		
		textNome = new JTextField();
		textNome.setColumns(10);
		
		JLabel lblPlano = new JLabel("Plano");
		
		JLabel lblCpf = new JLabel("CPF");
		
		textCpf = new JTextField();
		textCpf.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Unimed-RJ"}));
		comboBox.setToolTipText("");
		
		JButton btnSalva = new JButton("Salva");
		btnSalva.addActionListener(new ActionListener() {
			
					
			public void actionPerformed(ActionEvent e) {
				Paciente paciente= new Paciente();
				paciente.setIdClinte(codPaciente.getText());
				paciente.setNome(textNome.getText());
				paciente.setRg(textRg.getText());
				paciente.setCpf(textCpf.getText());
				
				PacienteDao pd = new PacienteDao();
				try {
					pd.inserir(paciente);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				mensagem.setText("Cliente Cadastrado  "+paciente.getNome());
				
			System.out.println(paciente);
			
			}
		});
		
		JButton btnNewButton = new JButton("Excluir"); 
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			codPaciente.setText("");
			}
		});
		
		JLabel lblCodPaciente = new JLabel("Cod Paciente");
		
		codPaciente = new JTextField();
		codPaciente.setColumns(10);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String texto = null;
				Paciente paciente= new Paciente();
				PacienteDao pd = new PacienteDao();
				 List<Paciente> lista= new ArrayList<Paciente>();
				 try {
					lista = pd.consultar();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 for (Paciente paciente2 : lista) {
				 texto =texto+"\n"+ paciente2+"\n";
				}
				
				mensagem.setText(texto);
				System.out.println(texto);
			}
		});
		
		JLabel lblTelefone = new JLabel("Telefone");
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JLabel lblCelular = new JLabel("Celular");
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		JCalendar calendar = new JCalendar();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnSalva)
							.addGap(14)
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnConsultar))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCodPaciente)
								.addComponent(lblNome)
								.addComponent(lblRg)
								.addComponent(lblPlano)
								.addComponent(lblCpf)
								.addComponent(lblTelefone)
								.addComponent(lblCelular))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textRg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(codPaciente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textCpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(48)
									.addComponent(calendar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(66, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCodPaciente)
								.addComponent(codPaciente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNome)
								.addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblRg)
								.addComponent(textRg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPlano)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCpf)
								.addComponent(textCpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTelefone)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCelular)
								.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(calendar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(3)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSalva)
						.addComponent(btnConsultar)
						.addComponent(btnNewButton))
					.addGap(53))
		);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
	}
}
