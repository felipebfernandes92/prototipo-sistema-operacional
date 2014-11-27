package EscalonadorDeProcessos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.awt.Font;

import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.border.EtchedBorder;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.JScrollPane;

import java.awt.Color;
import javax.swing.border.LineBorder;

public class escalonarProcessos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnExecutar;
	
	private JTextField chegadaProcesso1;
	private JTextField burstProcesso1;
	private JTextField prioridadeProcesso1;
	
	private JTextField chegadaProcesso2;
	private JTextField burstProcesso2;
	private JTextField prioridadeProcesso2;
	
	private JTextField chegadaProcesso3;
	private JTextField burstProcesso3;
	private JTextField prioridadeProcesso3;
	
	private JTextField chegadaProcesso4;
	private JTextField burstProcesso4;
	private JTextField prioridadeProcesso4;
	
	private JTextField chegadaProcesso5;
	private JTextField burstProcesso5;
	private JTextField prioridadeProcesso5;
	
	JTextField[][] processo = new JTextField[6][4];
	
	private JPanel painelProcesso1;
	private JPanel painelProcesso2;
	private JPanel painelProcesso3;
	private JPanel painelProcesso4;
	private JPanel painelProcesso5;
	public JTable tabelaResultados; 
	private JScrollPane scrollPane;
	private JTextPane textoMensagem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					escalonarProcessos frame = new escalonarProcessos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void CriaPaineisDosProcessos(String NumeroDeProcessosEscolhido) {
		painelProcesso1.setVisible(false);
		painelProcesso2.setVisible(false);
		painelProcesso3.setVisible(false);
		painelProcesso4.setVisible(false);
		painelProcesso5.setVisible(false);
	}

	/**
	 * Create the frame.
	 */
	public escalonarProcessos() {
		setTitle("Prot\u00F3tipo de simulador de sistemas operacionais");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 705, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelInformacoes = new JPanel();
		panelInformacoes.setBounds(0, 5, 689, 58);
		contentPane.add(panelInformacoes);
		panelInformacoes.setLayout(null);
		
		JTextPane txtpnEscalonadorDeProcessos = new JTextPane();
		txtpnEscalonadorDeProcessos.setEditable(false);
		txtpnEscalonadorDeProcessos.setBackground(UIManager.getColor("Button.background"));
		txtpnEscalonadorDeProcessos.setFont(new Font("Verdana", Font.BOLD, 18));
		txtpnEscalonadorDeProcessos.setText("Algoritmo de Escalonamento de Processos");
		txtpnEscalonadorDeProcessos.setBounds(120, 16, 453, 27);
		panelInformacoes.add(txtpnEscalonadorDeProcessos);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 68, 689, 147);
		panel.setFocusTraversalKeysEnabled(false);
		panel.setLayout(null);
		contentPane.add(panel);
		
		JTextPane tituloTotalDeProcessos = new JTextPane();
		tituloTotalDeProcessos.setBounds(211, 11, 118, 20);
		tituloTotalDeProcessos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tituloTotalDeProcessos.setBackground(UIManager.getColor("Button.background"));
		tituloTotalDeProcessos.setText("Total de processos");
		panel.add(tituloTotalDeProcessos);
		
		final JComboBox comboTotalProcessos = new JComboBox();
		comboTotalProcessos.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				String nomeProcesso = comboTotalProcessos.getSelectedItem().toString();
				CriaPaineisDosProcessos(nomeProcesso);			
				if (nomeProcesso.equals("2 processos")) {
					painelProcesso1.setVisible(true);
					painelProcesso2.setVisible(true);
				} else if (nomeProcesso.equals("3 processos")) {
					painelProcesso1.setVisible(true);
					painelProcesso2.setVisible(true);
					painelProcesso3.setVisible(true);
				} else if (nomeProcesso.equals("4 processos")) {
					painelProcesso1.setVisible(true);
					painelProcesso2.setVisible(true);
					painelProcesso3.setVisible(true);
					painelProcesso4.setVisible(true);
				} else if (nomeProcesso.equals("5 processos")) {
					painelProcesso1.setVisible(true);
					painelProcesso2.setVisible(true);
					painelProcesso3.setVisible(true);
					painelProcesso4.setVisible(true);
					painelProcesso5.setVisible(true);
				}
			}
		});
		comboTotalProcessos.setBounds(334, 12, 118, 20);
		comboTotalProcessos.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "2 processos", "3 processos", "4 processos", "5 processos"}));
		comboTotalProcessos.setFocusable(false);
		panel.add(comboTotalProcessos);
		
		JTextPane txtpnAlgoritmo = new JTextPane();
		txtpnAlgoritmo.setBounds(263, 43, 61, 20);
		txtpnAlgoritmo.setText("Algoritmo");
		txtpnAlgoritmo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnAlgoritmo.setBackground(SystemColor.menu);
		panel.add(txtpnAlgoritmo);
		
		final JComboBox comboAlgoritmo1 = new JComboBox();
		comboAlgoritmo1.setBounds(334, 43, 118, 20);
		comboAlgoritmo1.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "FIFO", "SJF", "HPF"}));
		comboAlgoritmo1.setFocusable(false);
		panel.add(comboAlgoritmo1);
		
		btnExecutar = new JButton("Executar");
		btnExecutar.setBounds(294, 118, 89, 23);
		btnExecutar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textoMensagem.setVisible(false);
				DefaultTableModel modelo = (DefaultTableModel) tabelaResultados.getModel();
				while (modelo.getRowCount() > 0) {
					modelo.removeRow(0); 
				}
				
				Integer totalProcessos = contaTotalProcessos(comboTotalProcessos.getSelectedIndex()+1);
				try {
					ArrayList<Processo> processos = InstanciaProcessos(totalProcessos);
					geraSimulacaoDeAcordoComOAlgoritmo(comboAlgoritmo1, processos);
				} catch (Exception e) {
					String mensagem = null;
					switch (comboAlgoritmo1.getSelectedIndex()) {
					case 1:
						mensagem = "Os valores de CHEGADA dos processos devem ser distintos";
						break;
					case 2:
						mensagem = "Os valores de BURST dos processos devem ser distintos";
						break;
					case 3:
						mensagem = "Os valores de PRIORIDADE dos processos devem ser distintos";
						break;
					default:
						mensagem = "Selecione a quantidade de processos e o algoritmo a ser testado";
						break;
					}	
					while (modelo.getRowCount() > 0) {
						modelo.removeRow(0); 
					}
					textoMensagem.setText(mensagem);
					textoMensagem.setVisible(true);
				}
				
			}

			private Integer contaTotalProcessos(int totalProcessos) {
				if (totalProcessos > 1) {
					return totalProcessos;
				}
				return null;
			}
			
			private ArrayList<Processo> InstanciaProcessos(int totalProcessos) {
				ArrayList<Processo> listaProcessos = new ArrayList<Processo>();
				
				for (int contagem = 1; contagem <= totalProcessos; contagem++) {
					Processo processos = new Processo();
					processos.setBurst(Integer.parseInt(processo[contagem][0].getText()));
					processos.setPrioridade(Integer.parseInt(processo[contagem][1].getText()));
					processos.setChegada(Integer.parseInt(processo[contagem][2].getText()));

					listaProcessos.add(processos);
				}
				return listaProcessos;
			}

			private void geraSimulacaoDeAcordoComOAlgoritmo(JComboBox comboAlgoritmo1, ArrayList<Processo> processos) {
				switch (comboAlgoritmo1.getSelectedIndex()) {
				case 1:
					executaSimulacaoFifo(processos);
					break;
				case 2:
					executaSimulacaoSJF(processos);
					break;
				case 3:
					executaSimulacaoHPF(processos);
					break;
				default:
					break;
				}			
			}

			private void executaSimulacaoFifo(ArrayList<Processo> processos) {
				DefaultTableModel modelo = (DefaultTableModel) tabelaResultados.getModel();
				Boolean primeiroMenor = true;
				Integer tempoResposta = 0;
				Integer turnAround = 0;
				Integer tempoEspera = 0;
				
				Integer[] posicaoMelhor = new Integer[100];
				for (int i = 0; i < processos.size(); i++) {
					Integer menor = 99999;
					Integer posicaoMenor = null;
					
					for(int j = 0; j < processos.size(); j++) {
						Integer chegada = processos.get(j).getChegada();
						if (posicaoMelhor[chegada] == null) {
							if (chegada < menor) {
								menor = chegada;
								posicaoMenor = j;
							}
						}
					}
					
					if (primeiroMenor) {
						tempoEspera = processos.get(posicaoMenor).setTempoEspera(0);
						tempoResposta = processos.get(posicaoMenor).setTempoResposta(processos.get(posicaoMenor).getBurst());
						turnAround = processos.get(posicaoMenor).setTurnAround(processos.get(posicaoMenor).getBurst());
						primeiroMenor = false;						
					} else {
						tempoEspera = processos.get(posicaoMenor).setTempoEspera(tempoEspera);
						tempoResposta = processos.get(posicaoMenor).setTempoResposta(tempoResposta + processos.get(posicaoMenor).getBurst());
						turnAround = processos.get(posicaoMenor).setTurnAround(turnAround + processos.get(posicaoMenor).getBurst());
					}
					
					modelo.addRow(new Object[]{posicaoMenor+1, processos.get(posicaoMenor).getBurst(),
													  processos.get(posicaoMenor).getTempoEspera(), 
													  processos.get(posicaoMenor).getTempoResposta(), 
													  processos.get(posicaoMenor).getTurnAround()});
					
					tempoEspera += processos.get(posicaoMenor).getBurst();
					posicaoMelhor[menor] = menor;
				}
				
			}
			
			private void executaSimulacaoSJF(ArrayList<Processo> processos) {
				DefaultTableModel modelo = (DefaultTableModel) tabelaResultados.getModel();
				Boolean primeiroMenor = true;
				Integer tempoResposta = 0;
				Integer turnAround = 0;
				Integer tempoEspera = 0;
				
				Integer[] posicaoMelhor = new Integer[100];
				for (int i = 0; i < processos.size(); i++) {
					Integer menor = 99999;
					Integer posicaoMenor = null;
					
					for(int j = 0; j < processos.size(); j++) {
						Integer tamanho = processos.get(j).getBurst();
						if (posicaoMelhor[tamanho] == null) {
							if (tamanho < menor) {
								menor = tamanho;
								posicaoMenor = j;
							}
						}
					}
					
					if (primeiroMenor) {
						tempoEspera = processos.get(posicaoMenor).setTempoEspera(0);
						tempoResposta = processos.get(posicaoMenor).setTempoResposta(processos.get(posicaoMenor).getBurst());
						turnAround = processos.get(posicaoMenor).setTurnAround(processos.get(posicaoMenor).getBurst());
						primeiroMenor = false;						
					} else {
						tempoEspera = processos.get(posicaoMenor).setTempoEspera(tempoEspera);
						tempoResposta = processos.get(posicaoMenor).setTempoResposta(tempoResposta + processos.get(posicaoMenor).getBurst());
						turnAround = processos.get(posicaoMenor).setTurnAround(turnAround + processos.get(posicaoMenor).getBurst());
					}
					
					modelo.addRow(new Object[]{posicaoMenor+1, processos.get(posicaoMenor).getBurst(),
													  processos.get(posicaoMenor).getTempoEspera(), 
													  processos.get(posicaoMenor).getTempoResposta(), 
													  processos.get(posicaoMenor).getTurnAround()});
					
					tempoEspera += processos.get(posicaoMenor).getBurst();
					posicaoMelhor[menor] = menor;
				}
				
			}
			
			private void executaSimulacaoHPF(ArrayList<Processo> processos) {
				DefaultTableModel modelo = (DefaultTableModel) tabelaResultados.getModel();
				Boolean primeiroMenor = true;
				Integer tempoResposta = 0;
				Integer turnAround = 0;
				Integer tempoEspera = 0;
				
				Integer[] posicaoMelhor = new Integer[100];
				for (int i = 0; i < processos.size(); i++) {
					Integer menor = 99999;
					Integer posicaoMenor = null;
					
					for(int j = 0; j < processos.size(); j++) {
						Integer prioridade = processos.get(j).getPrioridade();
						if (posicaoMelhor[prioridade] == null) {
							if (prioridade < menor) {
								menor = prioridade;
								posicaoMenor = j;
							}
						}
					}
					
					if (primeiroMenor) {
						tempoEspera = processos.get(posicaoMenor).setTempoEspera(0);
						tempoResposta = processos.get(posicaoMenor).setTempoResposta(processos.get(posicaoMenor).getBurst());
						turnAround = processos.get(posicaoMenor).setTurnAround(processos.get(posicaoMenor).getBurst());
						primeiroMenor = false;						
					} else {
						tempoEspera = processos.get(posicaoMenor).setTempoEspera(tempoEspera);
						tempoResposta = processos.get(posicaoMenor).setTempoResposta(tempoResposta + processos.get(posicaoMenor).getBurst());
						turnAround = processos.get(posicaoMenor).setTurnAround(turnAround + processos.get(posicaoMenor).getBurst());
					}
					
					modelo.addRow(new Object[]{posicaoMenor+1, processos.get(posicaoMenor).getBurst(),
													  processos.get(posicaoMenor).getTempoEspera(), 
													  processos.get(posicaoMenor).getTempoResposta(), 
													  processos.get(posicaoMenor).getTurnAround()});
					
					tempoEspera += processos.get(posicaoMenor).getBurst();
					posicaoMelhor[menor] = menor;
				}
				
			}
			
		});
		panel.add(btnExecutar);
		
		textoMensagem = new JTextPane();
		textoMensagem.setEditable(false);
		textoMensagem.setBackground(new Color(255, 192, 203));
		textoMensagem.setBounds(159, 84, 380, 20);
		panel.add(textoMensagem);
		textoMensagem.setVisible(false);
		
		JPanel painelConteudo = new JPanel();
		painelConteudo.setBorder(null);
		painelConteudo.setBounds(0, 221, 689, 170);
		contentPane.add(painelConteudo);
		painelConteudo.setLayout(null);
		
		painelProcesso1 = new JPanel();
		painelProcesso1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		painelProcesso1.setBackground(UIManager.getColor("RadioButton.background"));
		painelProcesso1.setBounds(10, 11, 125, 150);
		painelConteudo.add(painelProcesso1);
		painelProcesso1.setLayout(null);
		
		JTextPane processo1 = new JTextPane();
		processo1.setText("Processo 1");
		processo1.setFont(new Font("Tahoma", Font.BOLD, 13));
		processo1.setBackground(SystemColor.menu);
		processo1.setBounds(23, 5, 77, 20);
		painelProcesso1.add(processo1);
		
		chegadaProcesso1 = new JTextField();
		chegadaProcesso1.setText("0");
		chegadaProcesso1.setBounds(75, 75, 35, 20);
		painelProcesso1.add(chegadaProcesso1);
		chegadaProcesso1.setColumns(10);
		
		burstProcesso1 = new JTextField();
		burstProcesso1.setText("10");
		burstProcesso1.setColumns(10);
		burstProcesso1.setBounds(75, 44, 35, 20);
		painelProcesso1.add(burstProcesso1);
		
		prioridadeProcesso1 = new JTextField();
		prioridadeProcesso1.setText("1");
		prioridadeProcesso1.setColumns(10);
		prioridadeProcesso1.setBounds(75, 108, 35, 20);
		painelProcesso1.add(prioridadeProcesso1);
		
		JTextPane txtpnBurst = new JTextPane();
		txtpnBurst.setText("Burst:");
		txtpnBurst.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnBurst.setBackground(SystemColor.menu);
		txtpnBurst.setBounds(33, 44, 35, 20);
		painelProcesso1.add(txtpnBurst);
		
		JTextPane txtpnChegada = new JTextPane();
		txtpnChegada.setText("Chegada:");
		txtpnChegada.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnChegada.setBackground(SystemColor.menu);
		txtpnChegada.setBounds(15, 75, 56, 20);
		painelProcesso1.add(txtpnChegada);
		
		JTextPane txtpnPrioridade = new JTextPane();
		txtpnPrioridade.setText("Prioridade:");
		txtpnPrioridade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnPrioridade.setBackground(SystemColor.menu);
		txtpnPrioridade.setBounds(10, 108, 63, 20);
		painelProcesso1.add(txtpnPrioridade);
			
		painelProcesso2 = new JPanel();
		painelProcesso2.setLayout(null);
		painelProcesso2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		painelProcesso2.setBackground(SystemColor.menu);
		painelProcesso2.setBounds(145, 11, 125, 150);
		painelConteudo.add(painelProcesso2);
		
		JTextPane txtpnProcesso = new JTextPane();
		txtpnProcesso.setText("Processo 2");
		txtpnProcesso.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnProcesso.setBackground(SystemColor.menu);
		txtpnProcesso.setBounds(23, 5, 77, 20);
		painelProcesso2.add(txtpnProcesso);
		
		chegadaProcesso2 = new JTextField();
		chegadaProcesso2.setText("0");
		chegadaProcesso2.setColumns(10);
		chegadaProcesso2.setBounds(75, 75, 35, 20);
		painelProcesso2.add(chegadaProcesso2);
		
		burstProcesso2 = new JTextField();
		burstProcesso2.setText("10");
		burstProcesso2.setColumns(10);
		burstProcesso2.setBounds(75, 44, 35, 20);
		painelProcesso2.add(burstProcesso2);
		
		prioridadeProcesso2 = new JTextField();
		prioridadeProcesso2.setText("1");
		prioridadeProcesso2.setColumns(10);
		prioridadeProcesso2.setBounds(75, 108, 35, 20);
		painelProcesso2.add(prioridadeProcesso2);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setText("Burst:");
		textPane_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textPane_1.setBackground(SystemColor.menu);
		textPane_1.setBounds(33, 44, 35, 20);
		painelProcesso2.add(textPane_1);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setText("Chegada:");
		textPane_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textPane_2.setBackground(SystemColor.menu);
		textPane_2.setBounds(15, 75, 56, 20);
		painelProcesso2.add(textPane_2);
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setText("Prioridade:");
		textPane_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textPane_3.setBackground(SystemColor.menu);
		textPane_3.setBounds(10, 108, 63, 20);
		painelProcesso2.add(textPane_3);
		
		painelProcesso3 = new JPanel();
		painelProcesso3.setLayout(null);
		painelProcesso3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		painelProcesso3.setBackground(SystemColor.menu);
		painelProcesso3.setBounds(280, 11, 125, 150);
		painelConteudo.add(painelProcesso3);
		
		JTextPane txtpnProcesso_1 = new JTextPane();
		txtpnProcesso_1.setText("Processo 3");
		txtpnProcesso_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnProcesso_1.setBackground(SystemColor.menu);
		txtpnProcesso_1.setBounds(23, 5, 77, 20);
		painelProcesso3.add(txtpnProcesso_1);
		
		chegadaProcesso3 = new JTextField();
		chegadaProcesso3.setText("0");
		chegadaProcesso3.setColumns(10);
		chegadaProcesso3.setBounds(75, 75, 35, 20);
		painelProcesso3.add(chegadaProcesso3);
		
		burstProcesso3 = new JTextField();
		burstProcesso3.setText("10");
		burstProcesso3.setColumns(10);
		burstProcesso3.setBounds(75, 44, 35, 20);
		painelProcesso3.add(burstProcesso3);
		
		prioridadeProcesso3 = new JTextField();
		prioridadeProcesso3.setText("1");
		prioridadeProcesso3.setColumns(10);
		prioridadeProcesso3.setBounds(75, 108, 35, 20);
		painelProcesso3.add(prioridadeProcesso3);
		
		JTextPane textPane_5 = new JTextPane();
		textPane_5.setText("Burst:");
		textPane_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textPane_5.setBackground(SystemColor.menu);
		textPane_5.setBounds(33, 44, 35, 20);
		painelProcesso3.add(textPane_5);
		
		JTextPane textPane_6 = new JTextPane();
		textPane_6.setText("Chegada:");
		textPane_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textPane_6.setBackground(SystemColor.menu);
		textPane_6.setBounds(15, 75, 56, 20);
		painelProcesso3.add(textPane_6);
		
		JTextPane textPane_7 = new JTextPane();
		textPane_7.setText("Prioridade:");
		textPane_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textPane_7.setBackground(SystemColor.menu);
		textPane_7.setBounds(10, 108, 63, 20);
		painelProcesso3.add(textPane_7);
		
		painelProcesso4 = new JPanel();
		painelProcesso4.setLayout(null);
		painelProcesso4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		painelProcesso4.setBackground(SystemColor.menu);
		painelProcesso4.setBounds(415, 11, 125, 150);
		painelConteudo.add(painelProcesso4);
		
		JTextPane txtpnProcesso_2 = new JTextPane();
		txtpnProcesso_2.setText("Processo 4");
		txtpnProcesso_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnProcesso_2.setBackground(SystemColor.menu);
		txtpnProcesso_2.setBounds(23, 5, 77, 20);
		painelProcesso4.add(txtpnProcesso_2);
		
		chegadaProcesso4 = new JTextField();
		chegadaProcesso4.setText("0");
		chegadaProcesso4.setColumns(10);
		chegadaProcesso4.setBounds(75, 75, 35, 20);
		painelProcesso4.add(chegadaProcesso4);
		
		burstProcesso4 = new JTextField();
		burstProcesso4.setText("10");
		burstProcesso4.setColumns(10);
		burstProcesso4.setBounds(75, 44, 35, 20);
		painelProcesso4.add(burstProcesso4);
		
		prioridadeProcesso4 = new JTextField();
		prioridadeProcesso4.setText("1");
		prioridadeProcesso4.setColumns(10);
		prioridadeProcesso4.setBounds(75, 108, 35, 20);
		painelProcesso4.add(prioridadeProcesso4);
		
		JTextPane textPane_9 = new JTextPane();
		textPane_9.setText("Burst:");
		textPane_9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textPane_9.setBackground(SystemColor.menu);
		textPane_9.setBounds(33, 44, 35, 20);
		painelProcesso4.add(textPane_9);
		
		JTextPane textPane_10 = new JTextPane();
		textPane_10.setText("Chegada:");
		textPane_10.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textPane_10.setBackground(SystemColor.menu);
		textPane_10.setBounds(15, 75, 56, 20);
		painelProcesso4.add(textPane_10);
		
		JTextPane textPane_11 = new JTextPane();
		textPane_11.setText("Prioridade:");
		textPane_11.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textPane_11.setBackground(SystemColor.menu);
		textPane_11.setBounds(10, 108, 63, 20);
		painelProcesso4.add(textPane_11);
		
		painelProcesso5 = new JPanel();
		painelProcesso5.setLayout(null);
		painelProcesso5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		painelProcesso5.setBackground(SystemColor.menu);
		painelProcesso5.setBounds(550, 11, 125, 150);
		painelConteudo.add(painelProcesso5);
		
		JTextPane txtpnProcesso_3 = new JTextPane();
		txtpnProcesso_3.setText("Processo 5");
		txtpnProcesso_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnProcesso_3.setBackground(SystemColor.menu);
		txtpnProcesso_3.setBounds(23, 5, 77, 20);
		painelProcesso5.add(txtpnProcesso_3);
		
		chegadaProcesso5 = new JTextField();
		chegadaProcesso5.setText("0");
		chegadaProcesso5.setColumns(10);
		chegadaProcesso5.setBounds(75, 75, 35, 20);
		painelProcesso5.add(chegadaProcesso5);
		
		burstProcesso5 = new JTextField();
		burstProcesso5.setText("10");
		burstProcesso5.setColumns(10);
		burstProcesso5.setBounds(75, 44, 35, 20);
		painelProcesso5.add(burstProcesso5);
		
		prioridadeProcesso5 = new JTextField();
		prioridadeProcesso5.setText("1");
		prioridadeProcesso5.setColumns(10);
		prioridadeProcesso5.setBounds(75, 108, 35, 20);
		painelProcesso5.add(prioridadeProcesso5);
		
		JTextPane textPane_13 = new JTextPane();
		textPane_13.setText("Burst:");
		textPane_13.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textPane_13.setBackground(SystemColor.menu);
		textPane_13.setBounds(33, 44, 35, 20);
		painelProcesso5.add(textPane_13);
		
		JTextPane textPane_14 = new JTextPane();
		textPane_14.setText("Chegada:");
		textPane_14.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textPane_14.setBackground(SystemColor.menu);
		textPane_14.setBounds(15, 75, 56, 20);
		painelProcesso5.add(textPane_14);
		
		JTextPane textPane_15 = new JTextPane();
		textPane_15.setText("Prioridade:");
		textPane_15.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textPane_15.setBackground(SystemColor.menu);
		textPane_15.setBounds(10, 108, 63, 20);
		painelProcesso5.add(textPane_15);
		
		processo[1][0] = (burstProcesso1);
		processo[1][1] = (prioridadeProcesso1);
		processo[1][2] = (chegadaProcesso1);
		processo[2][0] = (burstProcesso2);
		processo[2][1] = (prioridadeProcesso2);
		processo[2][2] = (chegadaProcesso2);
		processo[3][0] = (burstProcesso3);
		processo[3][1] = (prioridadeProcesso3);
		processo[3][2] = (chegadaProcesso3);
		processo[4][0] = (burstProcesso4);
		processo[4][1] = (prioridadeProcesso4);
		processo[4][2] = (chegadaProcesso4);
		processo[5][0] = (burstProcesso5);
		processo[5][1] = (prioridadeProcesso5);
		processo[5][2] = (chegadaProcesso5);
			
		scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(0, 402, 689, 159);
		contentPane.add(scrollPane);
		
		tabelaResultados = new JTable();
		tabelaResultados.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Processo", "Burst CPU", "Tempo de espera", "Tempo de resposta", "Turn Around"
			}
		));
		scrollPane.setViewportView(tabelaResultados);
	painelProcesso1.setVisible(false);
	painelProcesso2.setVisible(false);
	painelProcesso3.setVisible(false);
	painelProcesso4.setVisible(false);
	painelProcesso5.setVisible(false);
	
	}
}
