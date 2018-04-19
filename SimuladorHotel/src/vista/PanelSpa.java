package vista;

import java.awt.Dimension;

import javax.swing.JPanel;

import controlador.Controlador;
import controlador.MicroControladorLayersPadreHijo;
import idiomas.Texto;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import java.awt.Color;
import java.beans.PropertyChangeListener;
import java.util.concurrent.Semaphore;
import java.beans.PropertyChangeEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class PanelSpa extends JPanel {
	private static final long serialVersionUID = 1L;
	private Texto t;

	private MicroControladorLayersPadreHijo microControlador;

	private JPanel panelEmergenteContenedor;
	private JPanel panelPrincipal;
	private JPanel panelBase;
	private JLayeredPane layeredPane;
	private JPanel panelOtro;
	private int tratamiento;
	private int spa;
	private double costeSPA;

	private Semaphore s;

	public PanelSpa(Controlador controlador) {
		t = controlador.getTexto();
		tratamiento = 0;
		spa = 0;
		this.s = new Semaphore(0);
		this.setSize(new Dimension(931, 483));
		this.setName("p" + this.getClass().getSimpleName().substring(1));
		setLayout(null);

		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 931, 483);
		add(layeredPane);

		panelPrincipal = new JPanel();
		panelPrincipal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarVentanaServicios();
			}
		});
		layeredPane.setLayer(panelPrincipal, 1);
		panelPrincipal.setBounds(0, 0, 931, 483);
		layeredPane.add(panelPrincipal);
		panelPrincipal.setLayout(null);

		JPanel panelIzquierdo = new JPanel();
		panelIzquierdo.setBorder(new LineBorder(Color.decode("#006df0"), 5, true));
		panelIzquierdo.setBounds(10, 11, 450, 461);
		panelPrincipal.add(panelIzquierdo);
		panelIzquierdo.setLayout(null);

		JButton btnAdquirirIzq = new JButton(t.getBtnAdquirir());
		btnAdquirirIzq.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdquirirIzq.setBounds(34, 398, 221, 41);
		panelIzquierdo.add(btnAdquirirIzq);

		JPanel panelTituloTrat = new JPanel();
		panelTituloTrat.setLayout(null);
		panelTituloTrat.setBorder(new LineBorder(new Color(0, 109, 240), 5));
		panelTituloTrat.setBackground(new Color(227, 233, 255));
		panelTituloTrat.setBounds(0, 0, 450, 60);
		panelIzquierdo.add(panelTituloTrat);

		JLabel lblTratamiento = new JLabel(t.getLblTratamiento());
		lblTratamiento.setHorizontalAlignment(SwingConstants.CENTER);
		lblTratamiento.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblTratamiento.setBounds(10, 10, 430, 39);
		panelTituloTrat.add(lblTratamiento);

		JLabel lblPrecioTrat = new JLabel(
				controlador.getServiciosSpa().getTratamientos().get(0).getPrecio()[0] + " \u20AC");
		JLabel lblPrecioSpa = new JLabel(
				String.valueOf(controlador.getServiciosSpa().getSpas().get(spa).getPrecio()[0]) + " \u20AC");
		JLabel lblNumPlazas = new JLabel(
				String.valueOf(controlador.getServiciosSpa().getSpas().get(spa).getAforoMax()));
		JComboBox<String> comboBoxDuracion = new JComboBox<String>();
		JComboBox<String> comboBoxLugar = new JComboBox<String>();
		JComboBox<String> comboBoxEmpleado = new JComboBox<String>();
		JComboBox<String> comboBoxPiscina = new JComboBox<String>();
		JComboBox<String> comboBoxNumPersonas = new JComboBox<String>();
		JComboBox<String> comboBoxDuracionSpa = new JComboBox<String>();

		comboBoxPiscina.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				spa = comboBoxPiscina.getSelectedIndex();
				comboBoxDuracionSpa.setModel(new DefaultComboBoxModel<String>(
						controlador.getServiciosSpa().getSpas().get(spa).getDuracion()));
				costeSPA = controlador.getServiciosSpa().getSpas().get(spa).getPrecio()[0];
				int multiplicador = comboBoxNumPersonas.getSelectedIndex() + 1;
				costeSPA = multiplicador * costeSPA;
				lblPrecioSpa.setText(String.valueOf(costeSPA) + " \u20AC");
				lblNumPlazas.setText(String.valueOf(controlador.getServiciosSpa().getSpas().get(spa).getAforoMax()
						- controlador.getServiciosSpa().getSpas().get(spa).getAsistentes()));
			}
		});

		JComboBox<String> comboBoxTratamiento = new JComboBox<String>();
		comboBoxTratamiento.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				tratamiento = comboBoxTratamiento.getSelectedIndex();
				comboBoxDuracion.setModel(new DefaultComboBoxModel<String>(
						controlador.getServiciosSpa().getTratamientos().get(tratamiento).getDuracion()));
				comboBoxLugar.setModel(new DefaultComboBoxModel<String>(
						controlador.getServiciosSpa().getTratamientos().get(tratamiento).getLugares()));
				comboBoxEmpleado.setModel(new DefaultComboBoxModel<String>(
						controlador.getServiciosSpa().getTratamientos().get(tratamiento).getTrabajadores()));
				lblPrecioTrat.setText(
						controlador.getServiciosSpa().getTratamientos().get(tratamiento).getPrecio()[0] + " \u20AC");
			}
		});
		comboBoxTratamiento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxTratamiento.setToolTipText("");
		comboBoxTratamiento
				.setModel(new DefaultComboBoxModel<String>(controlador.getServiciosSpa().getNombresTratamientos()));
		comboBoxTratamiento.setBounds(55, 110, 221, 25);
		panelIzquierdo.add(comboBoxTratamiento);

		JLabel lblSeleccionTratamiento = new JLabel(t.getLblSeleccionTratamiento());
		lblSeleccionTratamiento.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccionTratamiento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSeleccionTratamiento.setBounds(55, 71, 221, 41);
		panelIzquierdo.add(lblSeleccionTratamiento);

		JLabel iconoTratamiento = new JLabel("");
		iconoTratamiento.setIcon(new ImageIcon(PanelSpa.class.getResource("/iconos/massage (1).png")));
		iconoTratamiento.setBounds(331, 71, 64, 64);
		panelIzquierdo.add(iconoTratamiento);

		comboBoxDuracion.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				lblPrecioTrat.setText(controlador.getServiciosSpa().getTratamientos().get(tratamiento)
						.getPrecio()[comboBoxDuracion.getSelectedIndex()] + " \u20AC");
			}
		});
		comboBoxDuracion.setModel(
				new DefaultComboBoxModel<String>(controlador.getServiciosSpa().getTratamientos().get(0).getDuracion()));
		comboBoxDuracion.setToolTipText("");
		comboBoxDuracion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxDuracion.setBounds(55, 185, 221, 25);
		panelIzquierdo.add(comboBoxDuracion);

		JLabel lblDuracion = new JLabel("Duraci\u00F3n");
		lblDuracion.setHorizontalAlignment(SwingConstants.CENTER);
		lblDuracion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDuracion.setBounds(55, 146, 221, 41);
		panelIzquierdo.add(lblDuracion);

		JLabel iconoDuracion = new JLabel("");
		iconoDuracion.setIcon(new ImageIcon(PanelSpa.class.getResource("/iconos/time.png")));
		iconoDuracion.setBounds(331, 146, 64, 64);
		panelIzquierdo.add(iconoDuracion);

		JLabel lblLugar = new JLabel(t.getLblLugar());
		lblLugar.setHorizontalAlignment(SwingConstants.CENTER);
		lblLugar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLugar.setBounds(55, 221, 221, 41);
		panelIzquierdo.add(lblLugar);

		comboBoxLugar.setModel(
				new DefaultComboBoxModel<String>(controlador.getServiciosSpa().getTratamientos().get(0).getLugares()));
		comboBoxLugar.setToolTipText("");
		comboBoxLugar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxLugar.setBounds(55, 260, 221, 25);
		panelIzquierdo.add(comboBoxLugar);

		JLabel iconoLugar = new JLabel("");
		iconoLugar.setIcon(new ImageIcon(PanelSpa.class.getResource("/iconos/room.png")));
		iconoLugar.setBounds(331, 221, 64, 64);
		panelIzquierdo.add(iconoLugar);

		comboBoxEmpleado.setModel(new DefaultComboBoxModel<String>(
				controlador.getServiciosSpa().getTratamientos().get(0).getTrabajadores()));
		comboBoxEmpleado.setToolTipText("");
		comboBoxEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxEmpleado.setBounds(55, 335, 221, 25);
		panelIzquierdo.add(comboBoxEmpleado);

		JLabel lblEmpleado = new JLabel(t.getLblEmpleado());
		lblEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmpleado.setBounds(55, 296, 221, 41);
		panelIzquierdo.add(lblEmpleado);

		JLabel lblImagenEmpleado = new JLabel("");
		lblImagenEmpleado.setIcon(new ImageIcon(PanelSpa.class.getResource("/iconos/user.png")));
		lblImagenEmpleado.setBounds(341, 296, 64, 60);
		panelIzquierdo.add(lblImagenEmpleado);

		JPanel panelPrecioTrat = new JPanel();
		panelPrecioTrat.setBounds(289, 403, 125, 31);
		panelIzquierdo.add(panelPrecioTrat);
		panelPrecioTrat.setLayout(null);
		panelPrecioTrat.setForeground(Color.ORANGE);
		panelPrecioTrat.setBorder(new LineBorder(Color.ORANGE, 3));
		panelPrecioTrat.setBackground(new Color(255, 255, 153));

		JLabel lblCoste = new JLabel("Coste:");
		lblCoste.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCoste.setBounds(14, 0, 47, 31);
		panelPrecioTrat.add(lblCoste);

		lblPrecioTrat.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecioTrat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrecioTrat.setBounds(60, 0, 65, 31);
		panelPrecioTrat.add(lblPrecioTrat);

		JPanel panelDerecho = new JPanel();
		panelDerecho.setBorder(new LineBorder(Color.decode("#006df0"), 5, true));
		panelDerecho.setLayout(null);
		panelDerecho.setBounds(471, 11, 450, 461);
		panelPrincipal.add(panelDerecho);

		JPanel panelTituloSpa = new JPanel();
		panelTituloSpa.setBounds(0, 0, 450, 60);
		panelTituloSpa.setBorder(new LineBorder(new Color(0, 109, 240), 5));
		panelTituloSpa.setBackground(Color.decode("#E3E9FF"));
		panelDerecho.add(panelTituloSpa);
		panelTituloSpa.setLayout(null);

		JLabel lblSpa = new JLabel(t.getLblSpa());
		lblSpa.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpa.setBounds(10, 10, 430, 39);
		lblSpa.setFont(new Font("Tahoma", Font.PLAIN, 27));
		panelTituloSpa.add(lblSpa);

		JLabel lblSeleccioneElServicio = new JLabel(t.getLblSeleccionServicio());
		lblSeleccioneElServicio.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccioneElServicio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSeleccioneElServicio.setBounds(61, 71, 221, 41);
		panelDerecho.add(lblSeleccioneElServicio);

		comboBoxPiscina.setModel(new DefaultComboBoxModel<String>(controlador.getServiciosSpa().getNombresSpas()));
		comboBoxPiscina.setToolTipText("");
		comboBoxPiscina.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxPiscina.setBounds(61, 110, 221, 25);
		panelDerecho.add(comboBoxPiscina);

		JLabel lblImagenSpa = new JLabel("");
		lblImagenSpa.setIcon(new ImageIcon(PanelSpa.class.getResource("/iconos/jacuzzi.png")));
		lblImagenSpa.setBounds(345, 71, 64, 64);
		panelDerecho.add(lblImagenSpa);

		JLabel label = new JLabel("");
		label.setBounds(324, 71, 64, 64);
		panelDerecho.add(label);

		JPanel panelPrecioSPA = new JPanel();
		panelPrecioSPA.setLayout(null);
		panelPrecioSPA.setForeground(Color.ORANGE);
		panelPrecioSPA.setBorder(new LineBorder(Color.ORANGE, 3));
		panelPrecioSPA.setBackground(new Color(255, 255, 153));
		panelPrecioSPA.setBounds(289, 403, 125, 31);
		panelDerecho.add(panelPrecioSPA);

		JLabel label_2 = new JLabel("Coste:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_2.setBounds(14, 0, 47, 31);
		panelPrecioSPA.add(label_2);

		lblPrecioSpa.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecioSpa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrecioSpa.setBounds(60, 0, 65, 31);
		panelPrecioSPA.add(lblPrecioSpa);

		JLabel lblImagenReloj = new JLabel("");
		lblImagenReloj.setIcon(new ImageIcon(PanelSpa.class.getResource("/iconos/time.png")));
		lblImagenReloj.setBounds(345, 146, 64, 64);
		panelDerecho.add(lblImagenReloj);

		comboBoxDuracionSpa.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int multiplicador = comboBoxNumPersonas.getSelectedIndex() + 1;
				costeSPA = controlador.getServiciosSpa().getSpas().get(spa).getPrecio()[comboBoxDuracionSpa
						.getSelectedIndex()];
				costeSPA = multiplicador * costeSPA;
				lblPrecioSpa.setText(String.valueOf(costeSPA) + " \u20AC");

			}
		});
		comboBoxDuracionSpa.setToolTipText("");
		comboBoxDuracionSpa.setModel(
				new DefaultComboBoxModel<String>(controlador.getServiciosSpa().getSpas().get(spa).getDuracion()));
		comboBoxDuracionSpa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxDuracionSpa.setBounds(61, 185, 221, 25);
		panelDerecho.add(comboBoxDuracionSpa);

		JLabel label_5 = new JLabel("Duraci\u00F3n");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_5.setBounds(61, 146, 221, 41);
		panelDerecho.add(label_5);

		comboBoxNumPersonas.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int multiplicador = comboBoxNumPersonas.getSelectedIndex() + 1;
				costeSPA = controlador.getServiciosSpa().getSpas().get(spa).getPrecio()[comboBoxDuracionSpa
						.getSelectedIndex()];
				costeSPA = multiplicador * costeSPA;
				lblPrecioSpa.setText(String.valueOf(costeSPA) + " \u20AC");

			}
		});
		comboBoxNumPersonas.setToolTipText("");
		comboBoxNumPersonas.setModel(new DefaultComboBoxModel<String>(
				new String[] { "1 persona", "2 personas", "3 personas", "4 personas" }));
		comboBoxNumPersonas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxNumPersonas.setBounds(61, 259, 221, 25);
		panelDerecho.add(comboBoxNumPersonas);

		JLabel lblNumeroDePersonas = new JLabel("Numero de personas");
		lblNumeroDePersonas.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumeroDePersonas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNumeroDePersonas.setBounds(61, 221, 221, 41);
		panelDerecho.add(lblNumeroDePersonas);

		JPanel panelPlazasDisp = new JPanel();
		panelPlazasDisp.setLayout(null);
		panelPlazasDisp.setForeground(new Color(60, 179, 113));
		panelPlazasDisp.setBorder(new LineBorder(new Color(51, 153, 102), 3));
		panelPlazasDisp.setBackground(new Color(153, 255, 153));
		panelPlazasDisp.setBounds(114, 328, 221, 31);
		panelDerecho.add(panelPlazasDisp);

		JLabel lblPlazasDisponibles = new JLabel("Plazas disponibles:");
		lblPlazasDisponibles.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPlazasDisponibles.setBounds(14, 0, 127, 31);
		panelPlazasDisp.add(lblPlazasDisponibles);

		lblNumPlazas.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumPlazas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNumPlazas.setBounds(137, 0, 84, 31);
		panelPlazasDisp.add(lblNumPlazas);

		JLabel lblImagenUsers = new JLabel("");
		lblImagenUsers.setIcon(new ImageIcon(PanelSpa.class.getResource("/iconos/users.png")));
		lblImagenUsers.setBounds(345, 223, 64, 60);
		panelDerecho.add(lblImagenUsers);

		JButton btnAdquirirDch = new JButton(t.getBtnAdquirir());
		btnAdquirirDch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAdquirirDch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdquirirDch.setBounds(34, 398, 221, 41);
		panelDerecho.add(btnAdquirirDch);
		btnAdquirirIzq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeToVentanaEmergente(panelBase);
			}
		});

		panelEmergenteContenedor = new JPanel();
		panelEmergenteContenedor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// NO BORRAR
			}
		});

		panelEmergenteContenedor.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getNewValue().equals(0)) {
					// TODO: reactivar elementos del panelPrincipal (ahora panel al frente)
					btnAdquirirIzq.setEnabled(true);
					comboBoxDuracion.setEnabled(true);
					comboBoxEmpleado.setEnabled(true);
					comboBoxLugar.setEnabled(true);
					comboBoxTratamiento.setEnabled(true);
					comboBoxPiscina.setEnabled(true);
				} else if (evt.getNewValue().equals(2)) {
					// TODO: desactivar elementos del panelPrincipal (ahora panel al fondo)
					btnAdquirirIzq.setEnabled(false);
					comboBoxDuracion.setEnabled(false);
					comboBoxEmpleado.setEnabled(false);
					comboBoxLugar.setEnabled(false);
					comboBoxTratamiento.setEnabled(false);
					comboBoxPiscina.setEnabled(false);
				}
			}
		});

		layeredPane.setLayer(panelEmergenteContenedor, 0);
		panelEmergenteContenedor.setBounds(118, 84, 695, 315);
		layeredPane.add(panelEmergenteContenedor);
		panelEmergenteContenedor.setLayout(new CardLayout(0, 0));

		/* SEPARADOR */
		microControlador = new MicroControladorLayersPadreHijo(layeredPane, panelEmergenteContenedor);

		panelBase = new PanelSpaEmergenteBase(microControlador, this.getName(), controlador, s);
		panelEmergenteContenedor.add(panelBase, panelBase.getName());

//		panelOtro = new PanelSpaEmergenteOtro(microControlador, this.getName(), controlador, s);
//		panelEmergenteContenedor.add(panelOtro, panelOtro.getName());
	}

	private void establecerVentanaServicio(String panel) {
		CardLayout l = (CardLayout) panelEmergenteContenedor.getLayout();
		l.show(panelEmergenteContenedor, panel);
	}

	private void mostrarVentanaEmergente() {
		layeredPane.setLayer(panelEmergenteContenedor, 2);
	}

	private void mostrarVentanaServicios() {
		layeredPane.setLayer(panelEmergenteContenedor, 0);
	}

	private void changeToVentanaEmergente(JPanel panel) {
		establecerVentanaServicio(panel.getName());
		mostrarVentanaEmergente();
	}
}