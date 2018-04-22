package vista;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import controlador.Controlador;
import controlador.MicroControladorLayersPadreHijo;
import idiomas.Texto;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JSlider;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JToggleButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class PanelHabitacionEmergenteJacuzzi extends JPanel {
	private static final long serialVersionUID = 1L;
	private Texto t;
	private JButton btnLlenar;
	private JButton btnVaciar;
	private JSlider sliderAgua;

	public PanelHabitacionEmergenteJacuzzi(MicroControladorLayersPadreHijo m, Controlador controlador) {
		t = controlador.getTexto();
		
		this.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 109, 240), new Color(0, 109, 240), new Color(0, 109, 240), new Color(0, 109, 240)));
		this.setSize(695, 315);
		this.setName("p" + this.getClass().getSimpleName().substring(1));
		setLayout(null);

		JButton btnCerrar = new JButton(t.getBtnCerrar());
		btnCerrar.setFocusPainted(false);
		btnCerrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Ocultar panel
				m.changeLayer(0);
			}
		});
		btnCerrar.setBounds(610, 11, 75, 50);
		add(btnCerrar);
		
		JLabel lblControlJacuzzi = new JLabel(t.getLblControlJacuzzi());
		lblControlJacuzzi.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblControlJacuzzi.setBounds(10, 11, 141, 30);
		add(lblControlJacuzzi);
		
		JLabel lblTemperatura = new JLabel("-");
		lblTemperatura.setForeground(Color.BLACK);
		lblTemperatura.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTemperatura.setBounds(572, 238, 28, 19);
		add(lblTemperatura);
		
		JLabel lblBurbujas = new JLabel("");
		lblBurbujas.setBounds(485, 104, 200, 200);
		add(lblBurbujas);
		
		JLabel lbljacuzzi = new JLabel("");
		lbljacuzzi.setBounds(485, 104, 200, 200);
		add(lbljacuzzi);
		lbljacuzzi.setIcon(new ImageIcon(PanelHabitacionEmergenteJacuzzi.class.getResource("/iconos/jacuzziVacio.png")));
		
		JPanel panelBurbujas = new JPanel();
		panelBurbujas.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 109, 240), new Color(0, 109, 240),
						new Color(0, 109, 240), new Color(0, 109, 240)), t.getLblBurbujas() , TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 15), null));
		panelBurbujas.setBounds(10, 52, 306, 65);
		add(panelBurbujas);
		panelBurbujas.setLayout(null);
		
		JToggleButton tglBtnBurbujas = new JToggleButton(t.getBtnActivar());
		tglBtnBurbujas.setFocusPainted(false);
		tglBtnBurbujas.setBounds(59, 15, 187, 41);
		panelBurbujas.add(tglBtnBurbujas);
		tglBtnBurbujas.setIcon(new ImageIcon(PanelHabitacionEmergenteJacuzzi.class.getResource("/iconos/jacuzziBurbujas_x32.png")));
		tglBtnBurbujas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tglBtnBurbujas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tglBtnBurbujas.isSelected()) {
					lblBurbujas.setIcon(new ImageIcon(PanelHabitacionEmergenteJacuzzi.class.getResource("/iconos/jacuzziBurbujas.png")));
					controlador.getHabitacion().getJacuzzi().setEncendido(true);
					tglBtnBurbujas.setText(t.getBtnDesactivar());
				}
				else {
					lblBurbujas.setIcon(null);
					controlador.getHabitacion().getJacuzzi().setEncendido(false);
					tglBtnBurbujas.setText(t.getBtnActivar());
				}
			}
		});
		
		JPanel panelTemperatura = new JPanel();
		panelTemperatura.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 109, 240), new Color(0, 109, 240),
						new Color(0, 109, 240), new Color(0, 109, 240)), t.getLblTemperatura(), TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 15), null));
		panelTemperatura.setBounds(326, 52, 149, 252);
		add(panelTemperatura);
		panelTemperatura.setLayout(null);
		
		JSlider sliderTemperatura = new JSlider();
		sliderTemperatura.setFocusable(false);
		sliderTemperatura.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (sliderTemperatura.getValue() > 0 && sliderTemperatura.getMajorTickSpacing() > 0 && (sliderTemperatura.getValue() % sliderTemperatura.getMajorTickSpacing() == 0))
					lblTemperatura.setText(sliderTemperatura.getValue() + "�");
			}
		});
		sliderTemperatura.setMinimum(10);
		sliderTemperatura.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sliderTemperatura.setPaintLabels(true);
		sliderTemperatura.setSnapToTicks(true);
		sliderTemperatura.setPaintTicks(true);
		sliderTemperatura.setMajorTickSpacing(5);
		sliderTemperatura.setMinorTickSpacing(5);
		sliderTemperatura.setMaximum(60);
		sliderTemperatura.setOrientation(SwingConstants.VERTICAL);
		sliderTemperatura.setBounds(10, 20, 115, 221);
		panelTemperatura.add(sliderTemperatura);
		
		lblTemperatura.setText(sliderTemperatura.getValue() + "�");

		JPanel panelAgua = new JPanel();
		panelAgua.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 109, 240), new Color(0, 109, 240),
				new Color(0, 109, 240), new Color(0, 109, 240)), t.getLblAgua(), TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 15), null));
		panelAgua.setBounds(10, 128, 306, 176);
		add(panelAgua);
		panelAgua.setLayout(null);
		
		sliderAgua = new JSlider();
		sliderAgua.setFocusable(false);
		sliderAgua.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (sliderAgua.getValue() == 0) {
					tglBtnBurbujas.setSelected(false);
					tglBtnBurbujas.setEnabled(false);
					tglBtnBurbujas.setText("Activar");
					lblBurbujas.setIcon(null);
					lblTemperatura.setVisible(false);
				}
				else if (sliderAgua.getValue() > 0) {
					tglBtnBurbujas.setEnabled(true);
					lblTemperatura.setVisible(true);
					if (controlador.getHabitacion().getJacuzzi().isEncendido()) {
						tglBtnBurbujas.setSelected(true);
						tglBtnBurbujas.setEnabled(true);
						tglBtnBurbujas.setText("Desactivar");
						lblBurbujas.setIcon(new ImageIcon(PanelHabitacionEmergenteJacuzzi.class.getResource("/iconos/jacuzziBurbujas.png")));
					}
				}
				
				switch (sliderAgua.getValue()) {
					case 0:
						lbljacuzzi.setIcon(new ImageIcon(PanelHabitacionEmergenteJacuzzi.class.getResource("/iconos/jacuzziVacio.png")));
						break;
					case 25:
						lbljacuzzi.setIcon(new ImageIcon(PanelHabitacionEmergenteJacuzzi.class.getResource("/iconos/jacuzzi25.png")));
						break;
					case 50:
						lbljacuzzi.setIcon(new ImageIcon(PanelHabitacionEmergenteJacuzzi.class.getResource("/iconos/jacuzzi50.png")));
						break;
					case 75:
						lbljacuzzi.setIcon(new ImageIcon(PanelHabitacionEmergenteJacuzzi.class.getResource("/iconos/jacuzzi75.png")));
						break;
					case 100:
						lbljacuzzi.setIcon(new ImageIcon(PanelHabitacionEmergenteJacuzzi.class.getResource("/iconos/jacuzzi100.png")));
						break;
				}
			}
		});
		sliderAgua.setBounds(96, 37, 200, 50);
		panelAgua.add(sliderAgua);
		sliderAgua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sliderAgua.setPaintLabels(true);
		sliderAgua.setPaintTicks(true);
		sliderAgua.setSnapToTicks(true);
		sliderAgua.setValue(0);
		sliderAgua.setMajorTickSpacing(25);
		sliderAgua.setMinorTickSpacing(25);
		
		JLabel lblLlenar = new JLabel(t.getLblLlenar()+ "(%):");
		lblLlenar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLlenar.setBounds(16, 50, 70, 20);
		panelAgua.add(lblLlenar);
		
		btnLlenar = new JButton(t.getLblLlenar());
		btnLlenar.setFocusPainted(false);
		btnLlenar.setBounds(10, 119, 126, 46);
		panelAgua.add(btnLlenar);
		btnLlenar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLlenar.setIcon(new ImageIcon(PanelHabitacionEmergenteJacuzzi.class.getResource("/iconos/jacuzziLleno_x32.png")));
		
		btnVaciar = new JButton(t.getLblVaciar());
		btnVaciar.setFocusPainted(false);
		btnVaciar.setBounds(164, 119, 132, 46);
		panelAgua.add(btnVaciar);
		btnVaciar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVaciar.setIcon(new ImageIcon(PanelHabitacionEmergenteJacuzzi.class.getResource("/iconos/jacuzziVacio_x32.png")));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 106, 286, 2);
		panelAgua.add(separator);
		btnVaciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toggleButtonsOnFill(false);
				
				new Thread() {
					public void run() {
						int i = sliderAgua.getValue();
						while (i > 0) {
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							i -= sliderAgua.getMajorTickSpacing();
							sliderAgua.setValue(i);
						}
						
						toggleButtonsOnFill(true);
					}
				}.start();
			}
		});
		btnLlenar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toggleButtonsOnFill(false);
				
				new Thread() {
					public void run() {
						int i = sliderAgua.getValue();
						while (i < 100) {
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							i += sliderAgua.getMajorTickSpacing();;
							sliderAgua.setValue(i);
						}
						
						toggleButtonsOnFill(true);
					}
				}.start();
			}
		});
		btnLlenar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread() {
					public void run() {
						
					}
				}.start();
			}
		});
	}
	
	private void toggleButtonsOnFill(boolean b) {
		btnLlenar.setEnabled(b);
		btnVaciar.setEnabled(b);
		sliderAgua.setEnabled(b);
	}
}
