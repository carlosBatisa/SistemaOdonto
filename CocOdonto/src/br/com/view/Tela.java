package br.com.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.com.controle.ControleCliente;
import br.com.entity.Cliente;
import br.com.pesistence.ClienteDao;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import com.mysql.jdbc.EscapeTokenizer;
import com.toedter.calendar.JDateChooser;

public class Tela {

	private JFrame frame;
	private JTextField textpNome;
	private JTextField textpData;
	private JTextField textNome;
	private JTextField textTelefone;
	private JTextField textCelular;
	private JTextField textPlano;
	private JTextField textHora;
	private JTable table;
	private JDateChooser textData;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela window = new Tela();
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
	public Tela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 661, 469);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel painelPesquisa = new JPanel();
		painelPesquisa.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Pesquisa", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		
		JPanel painelConsulta = new JPanel();
		painelConsulta.setBorder(new TitledBorder(null, "Marca Consulta", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(painelConsulta, GroupLayout.PREFERRED_SIZE, 624, Short.MAX_VALUE)
							.addGap(1))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(11)
							.addComponent(painelPesquisa, GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(15)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(painelPesquisa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(painelConsulta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
					.addGap(5))
		);
		
		criarTabela(scrollPane);
		
/**/
		scrollPane.setViewportView(table);
		
		painelConsulta.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(57dlu;default)"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblNome_1 = new JLabel("Nome:");
		lblNome_1.setFont(new Font("Arial Black", Font.PLAIN, 12));
		painelConsulta.add(lblNome_1, "2, 2");
		
		textNome = new JTextField();
		textNome.setFont(new Font("Arial Black", Font.PLAIN, 12));
		painelConsulta.add(textNome, "4, 2, 17, 1, fill, fill");
		textNome.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Arial Black", Font.PLAIN, 12));
		painelConsulta.add(lblTelefone, "2, 4");
	
		
		 try{
			 MaskFormatter telefone = new javax.swing.text.MaskFormatter("(##) ####-####");

			 textTelefone = new javax.swing.JFormattedTextField(telefone);
			 textTelefone.setText("(  )    -    ");
			 }catch(Exception e){
			}
		textTelefone.setFont(new Font("Arial Black", Font.PLAIN, 12));
		painelConsulta.add(textTelefone, "4, 4, 11, 1, fill, default");
		textTelefone.setColumns(10);
		
		
		 try{
			 MaskFormatter telefone = new javax.swing.text.MaskFormatter("(##) #####-####");
			 textCelular = new javax.swing.JFormattedTextField(telefone);
			 }catch(Exception e){
			}
					 
					 JLabel lblCelular = new JLabel("Celular");
					 lblCelular.setFont(new Font("Arial Black", Font.PLAIN, 12));
					 painelConsulta.add(lblCelular, "16, 4");
		
					 
					 
		textCelular.setFont(new Font("Arial Black", Font.PLAIN, 12));
		painelConsulta.add(textCelular, "18, 4, fill, default");
		textCelular.setColumns(10);
		
		JLabel lblPlano = new JLabel("Plano");
		lblPlano.setFont(new Font("Arial Black", Font.PLAIN, 12));
		painelConsulta.add(lblPlano, "2, 6");
		
		textPlano = new JTextField();
		textPlano.setFont(new Font("Arial Black", Font.PLAIN, 12));
		painelConsulta.add(textPlano, "4, 6, 13, 1, fill, default");
		textPlano.setColumns(10);
		
		JLabel lblObs = new JLabel("Obs:");
		lblObs.setFont(new Font("Arial Black", Font.PLAIN, 12));
		painelConsulta.add(lblObs, "18, 6");
		
		JLabel lblData_1 = new JLabel("Data:");
		lblData_1.setFont(new Font("Arial Black", Font.PLAIN, 12));
		painelConsulta.add(lblData_1, "2, 8, left, default");
		
		 try{
			 MaskFormatter data = new javax.swing.text.MaskFormatter("##/##/####");
			 }catch(Exception e){
			}
		
		 try{
			 MaskFormatter hora = new javax.swing.text.MaskFormatter("##:##");
			 textHora = new javax.swing.JFormattedTextField(hora);
			 textHora.setText("");
			 }catch(Exception e){
			}
					 			 			 			 
					 			 			 			 JDateChooser textData = new JDateChooser();
					 			 			 			 painelConsulta.add(textData, "4, 8, 3, 1, fill, fill");
					 			 			 			 
					 			 			 			 JLabel lblHora = new JLabel("Hora:");
					 			 			 			 lblHora.setFont(new Font("Arial Black", Font.PLAIN, 12));
					 			 			 			 painelConsulta.add(lblHora, "12, 8, left, default");
					 			 			 
					 			 			 			 
					 			 			 			 
					 			 			 			 
					 			 			 			 textHora.setFont(new Font("Arial Black", Font.PLAIN, 12));
					 			 			 			 painelConsulta.add(textHora, "14, 8, 3, 1, fill, default");
					 			 			 			 textHora.setColumns(10);
					 			 			 			 
					 			 			 			 JButton btnMarca = new JButton("Marca");
					 			 			 			 
					 			 			 			 btnMarca.addActionListener(new ActionListener() {
					 			 			 			 	public void actionPerformed(ActionEvent e) {
					 			 			 			 		
					 			 			 			 		
					 			 			 			 		String nome= textNome.getText();			 			 			 		
					 			 			 			 		
					 			 			 			 		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
																
					 			 			 			 		String hora=textHora.getText();
					 			 			 			 		
					 			 			 			 				 			
					 			 			 			 			
					 			 			 			 			if (textData.getDate() != null) {
					 			 			 			 			String data=String.valueOf(sdf.format(textData.getDate()));
																	
						 			 			 			 		System.out
																			.println("DATA DO CALENDARI"+data);
					 			 			 			 			if (nome.length()>3) {	
					 			 			 			 				if (!hora.equals("  :  ")) {
					 			 			 			 				Cliente cliente = new Cliente();
							 			 			 			 		cliente.setData(data);
							 			 			 			 		cliente.setHora(textHora.getText());
							 			 			 			 		cliente.setNome(textNome.getText());
							 			 			 			 		cliente.setTelefone(textTelefone.getText());
							 			 			 			 		cliente.setCelular(textCelular.getText());
							 			 			 			 		cliente.setPlano(textPlano.getText());
							 			 			 			 		
							 			 			 			 		ControleCliente cc= new ControleCliente();
							 			 			 			 		cc.cadastrarCliente(cliente);
							 			 			 			 		
							 			 			 			 		//para atualiza a tabele...
							 			 			 			 		criarTabela(scrollPane);
							 			 			 			 	    limparCampos();
																		}else {
																			JOptionPane.showMessageDialog(null, "Por Favor Digite uma Hora Valida.",nome, JOptionPane.WARNING_MESSAGE);
																		}
					 			 			 			 			
																	}else {
																		JOptionPane.showMessageDialog(null, "Digite O nome do Paciente.",nome, JOptionPane.WARNING_MESSAGE);
																	}
						 			 			 			 	
																}else {
																	JOptionPane.showMessageDialog(null, "Por Favor Uma DATA Para marca a Consulta.",nome, JOptionPane.WARNING_MESSAGE);
																}
					 			 			 			 		
					 			 			 			 		
					 			 			 			 	
					 			 			 			 		
					 			 			 			 	
					 			 			 			 	}
					 			 			 			 });
					 			 			 			 
					 			 			 			 JScrollPane scrollPane_1 = new JScrollPane();
					 			 			 			 painelConsulta.add(scrollPane_1, "18, 8, 3, 3, fill, fill");
					 			 			 			 
					 			 			 			 JTextArea textArea = new JTextArea();
					 			 			 			 scrollPane_1.setViewportView(textArea);
					 			 			 			 painelConsulta.add(btnMarca, "2, 10");
					 			 			 			 
					 			 			 			 JButton btnLimpar = new JButton("Limpar");
					 			 			 			 btnLimpar.addActionListener(new ActionListener() {
					 			 			 			 	public void actionPerformed(ActionEvent e) {
					 			 			 			 		
					 			 			 			 	
				 			 			 			 	    limparCampos();
					 			 			 			 		
					 			 			 			 	}
					 			 			 			 });
					 			 			 			 painelConsulta.add(btnLimpar, "4, 10");
					 			 			 			 
					 			 			 			 JButton btnNewButton = new JButton("Excluir");
					 			 			 			 btnNewButton.setToolTipText("Para Excluir uma consulta, preencha os compos de DATA e HORA");
					 			 			 			 btnNewButton.addActionListener(new ActionListener() {
					 			 			 			 	public void actionPerformed(ActionEvent e) {
					 			 			 			 		
					 			 			 			 		int opcao=JOptionPane.showConfirmDialog(null,"Tem certeza que deseja excluir?","Exclusão",2);
					 			 			 			 		System.out
																		.println(opcao);
					 			 			 			 		
					 			 			 			 		if (opcao==0) {
					 			 			 			 		 ControleCliente cc = new ControleCliente();
					 			 			 			 		 Cliente cliente = new Cliente();
					 			 			 			 		 cliente.setData(String.valueOf(textData.getDate()));
					 			 			 			 		cliente.setHora(textHora.getText());
					 			 			 			 		 
					 			 			 			 		 cc.excluirConsulta(cliente);
					 			 			 			 		 limparCampos();
					 			 			 			 		 criarTabela(scrollPane);
																	
																}
					 			 			 			 		
					 			 			 			 		
					 			 			 			 		
					 			 			 			 	}
					 			 			 			 });
					 			 			 			 painelConsulta.add(btnNewButton, "6, 10");
		painelPesquisa.setLayout(new BoxLayout(painelPesquisa, BoxLayout.X_AXIS));
		
		JLabel lblNome = new JLabel("Nome:  ");
		lblNome.setFont(new Font("Arial Black", Font.PLAIN, 12));
		painelPesquisa.add(lblNome);
		
		textpNome = new JTextField();
		textpNome.setFont(new Font("Arial Black", Font.PLAIN, 12));
		painelPesquisa.add(textpNome);
		textpNome.setColumns(40);
		
		JLabel lblData = new JLabel("   Data:  ");
		lblData.setFont(new Font("Arial Black", Font.PLAIN, 12));
		painelPesquisa.add(lblData);
		
		try{
			MaskFormatter data1 = new MaskFormatter("##/##/####");
			textpData = new JFormattedTextField(data1);
		}catch(Exception e){
			
		}
		
		
		
		textpData.setFont(new Font("Arial Black", Font.PLAIN, 12));
		painelPesquisa.add(textpData);
		textpData.setColumns(10);
		
		JButton btnConsulta = new JButton("Pesquisar");
		btnConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControleCliente cc = new ControleCliente();
				Cliente cliente1 = new Cliente();
				
				cliente1.setData(textpData.getText());
				cc.pesquisarPorData(cliente1);
				limparCampos();
				
				
				// Criando Tabela que pesquisa Pela Data da Consulta
				
				DefaultTableModel modelo = new DefaultTableModel();

				List<Cliente> lista = null;
				table = new JTable(modelo);
				modelo.addColumn("Data");
				modelo.addColumn("Hora");
				modelo.addColumn("Nome");
				modelo.addColumn("Telefone");
				modelo.addColumn("Celular");
				modelo.addColumn("Plano");
				modelo.addColumn("----");
				
				
				
				// JLabel lblExcluir = new JLabel("Excluir");
				//.addActionListener(new ActionListener() {
					 // void actionPerformed(ActionEvent e) {
					 			
					 	
					 //	}
					// });
				

				try {

					
					ClienteDao pd2 = new ClienteDao();
					lista = pd2.consultarPorData(cliente1);
					for (Cliente cliente : lista) {
						modelo.addRow(new Object[] { cliente.getData(),
								cliente.getHora(), cliente.getNome(),cliente.getTelefone(),
								cliente.getCelular(),cliente.getPlano()});
						

					}

				} catch (Exception e2) {
					// TODO: handle exception
				}

				scrollPane.setViewportView(table);
				
				
				
			}
		});
		btnConsulta.setFont(new Font("Arial Black", Font.PLAIN, 12));
		painelPesquisa.add(btnConsulta);
		frame.getContentPane().setLayout(groupLayout);
		
	
	
	
	}
	////////////////////////////////////////////////////////////////////
	private void criarTabela(JScrollPane scrollPane) {
		DefaultTableModel modelo = new DefaultTableModel();

		List<Cliente> lista = null;
		table = new JTable(modelo);
		modelo.addColumn("Data");
		modelo.addColumn("Hora");
		modelo.addColumn("Nome");
		modelo.addColumn("Telefone");
		modelo.addColumn("Celular");
		modelo.addColumn("Plano");
		modelo.addColumn("----");
		
		
		
		// JLabel lblExcluir = new JLabel("Excluir");
		//.addActionListener(new ActionListener() {
			 // void actionPerformed(ActionEvent e) {
			 			
			 	
			 //	}
			// });
		

		try {

			
			ClienteDao pd2 = new ClienteDao();
			lista = pd2.consultar();
			for (Cliente cliente : lista) {
				modelo.addRow(new Object[] { cliente.getData(),
						cliente.getHora(), cliente.getNome(),cliente.getTelefone(),
						cliente.getCelular(),cliente.getPlano()});
				

			}

		} catch (Exception e2) {
			// TODO: handle exception
		}

		scrollPane.setViewportView(table);
	}
	
	public void limparCampos(){
		String t = "";
		
		textNome.setText(t);
		//textData.setDate(new Date());;
		textHora.setText(t);
		textTelefone.setText(t);
		textCelular.setText(t);
		textPlano.setText(t);
		textpNome.setText(t);
		textpData.setText(t);
		
	}
}
