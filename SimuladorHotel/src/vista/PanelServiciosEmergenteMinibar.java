package vista;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import controlador.Controlador;
import controlador.MicroControladorLayers;
import controlador.MicroControladorLayersPadreHijo;
import idiomas.Texto;
import tiposVariable.StringDouble;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.concurrent.Semaphore;
import java.awt.event.ActionEvent;

import javax.swing.JLayeredPane;

public class PanelServiciosEmergenteMinibar extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLayeredPane panelContenedor;
	private JPanel panelPrincipal;
	private JPanel panelConfirmacion;
	private Semaphore s;
	private Texto t;

	public PanelServiciosEmergenteMinibar(MicroControladorLayersPadreHijo microControlador, String padre, Controlador controlador, Semaphore s) {
		this.s = s;
		t = controlador.getTexto();
		this.setSize(new Dimension(695, 315));
		this.setName("p" + this.getClass().getSimpleName().substring(1));
		setLayout(null);

		panelContenedor = new JLayeredPane();
		panelContenedor.setBounds(0, 0, 695, 315);
		add(panelContenedor);
		panelContenedor.setLayout(null);

		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 109, 240), new Color(0, 109, 240),
				new Color(0, 109, 240), new Color(0, 109, 240)));
		panelPrincipal.setBounds(0, 0, 695, 315);
		panelContenedor.setLayer(panelPrincipal, 1);
		panelContenedor.add(panelPrincipal);
		panelPrincipal.setLayout(null);

		JLabel lblGif = new JLabel("");
		lblGif.setBorder(new LineBorder(Color.GREEN));
		lblGif.setOpaque(true);
		lblGif.setVisible(false);
		lblGif.setIcon(new ImageIcon(PanelServiciosEmergenteWifi.class.getResource("/iconos/check-gif-1.gif")));
		lblGif.setBounds(287, 103, 120, 109);
		panelPrincipal.add(lblGif);

		JTextPane txtpnInfo = new JTextPane();
		txtpnInfo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpnInfo.setEditable(false);
		txtpnInfo.setOpaque(false);
		//Mensaje en la clase Texto
		txtpnInfo.setText(t.getPanelServiciosEmergenteMinibarTxt());
		txtpnInfo.setBounds(10, 11, 590, 81);
		panelPrincipal.add(txtpnInfo);

		crearPanelConfirmacion("<precio>");

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 153));
		panel.setBorder(new LineBorder(Color.ORANGE, 3));
		panel.setForeground(Color.ORANGE);
		panel.setBounds(45, 166, 593, 35);
		panelPrincipal.add(panel);

		JLabel lblPrecio = new JLabel(t.getLblCoste());
		panel.add(lblPrecio);
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel label = new JLabel(String.valueOf(controlador.getServicios().getMinibar().getPrecio()) + "\u20AC");
		panel.add(label);
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JButton btnCerrar = new JButton(t.getBtnCerrar());
		btnCerrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // No modificar
				// Devuelve control al padre
				microControlador.changeLayer(0);
				s.release(s.getQueueLength());
			}
		});
		btnCerrar.setBounds(610, 11, 75, 50);
		panelPrincipal.add(btnCerrar);

		JButton btnAdquirir = new JButton(t.getBtnAdquirir());
		btnAdquirir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdquirir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread() {
					public void run() {
						try {
							mostrarPanelConfirmacion(controlador.getServicios().getMinibar().getPrecio() + "\u20AC");

							s.acquire();

							if (((PanelConfirmacion) panelConfirmacion).getConfirmacion() == true) {
								// Actualizar ventana; en otro caso no hacer nada
								controlador.getCuenta().getGasto().addGasto(new StringDouble(t.getMiniBar(),
										controlador.getServicios().getMinibar().getPrecio()));
								lblGif.setVisible(true);
								Thread.sleep(2050);
								lblGif.setVisible(false);

								// Tiene que hacerse siempre!
								((PanelConfirmacion) panelConfirmacion).setConfirmacion(false);
							}
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
					}
				}.start();
			}
		});
		btnAdquirir.setBounds(260, 223, 175, 53);
		panelPrincipal.add(btnAdquirir);
	}

	public void cerrarPanelConfirmacion() {
		panelContenedor.setLayer(panelConfirmacion, 0);
	}

	public void crearPanelConfirmacion(String precio) {
		panelConfirmacion = new PanelConfirmacion(new MicroControladorLayers(panelContenedor), this.getName(), s, precio, t);
		panelConfirmacion.setBounds(147, 57, 400, 200);
		panelContenedor.setLayer(panelConfirmacion, 0);
		panelContenedor.add(panelConfirmacion);
	}

	public void mostrarPanelConfirmacion(String precio) {
		crearPanelConfirmacion(precio);
		panelContenedor.setLayer(panelConfirmacion, 2);
	}
}
