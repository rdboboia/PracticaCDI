package vista;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import controlador.Controlador;
import controlador.MicroControladorLayers;
import controlador.MicroControladorPanelesPadreHijo;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;

public class PanelServiciosEmergenteLimpieza extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLayeredPane panelContenedor;
	private JPanel panelPrincipal;
	private JPanel panelConfirmacion;

	public PanelServiciosEmergenteLimpieza(MicroControladorPanelesPadreHijo microControlador, String padre, Controlador controlador) {
		this.setSize(new Dimension(695, 315));
		this.setName("p" + this.getClass().getSimpleName().substring(1));
		setLayout(null);
		
		panelContenedor = new JLayeredPane();
		panelContenedor.setBounds(0, 0, 695, 315);
		add(panelContenedor);
		panelContenedor.setLayout(null);
		
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 102), new Color(0, 0, 102), new Color(0, 0, 102), new Color(0, 0, 102)));
		panelPrincipal.setBounds(0, 0, 695, 315);
		panelContenedor.setLayer(panelPrincipal, 1);
		panelContenedor.add(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		panelConfirmacion = new PanelConfirmacion(new MicroControladorLayers(panelContenedor), this.getName());
		panelConfirmacion.setBounds(147, 57, 400, 200);
		panelContenedor.setLayer(panelConfirmacion, 0);
		panelContenedor.add(panelConfirmacion);
		
		JLabel lblPanelEmergente = new JLabel(this.getName());
		lblPanelEmergente.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanelEmergente.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblPanelEmergente.setBounds(10, 138, 675, 39);
		panelPrincipal.add(lblPanelEmergente);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // No modificar
				// Devuelve control al padre
				cerrarPanelConfirmacion();
				microControlador.cambiarPanel(padre);
			}
		});
		btnCerrar.setBounds(610, 11, 75, 50);
		panelPrincipal.add(btnCerrar);
		
		JButton btnNewButton = new JButton("botonEjemploVentanaEmergente");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelContenedor.setLayer(panelConfirmacion, 2);
			}
		});
		btnNewButton.setBounds(253, 230, 189, 23);
		panelPrincipal.add(btnNewButton);
	}
	
	public void cerrarPanelConfirmacion() {
		panelContenedor.setLayer(panelConfirmacion, 0);
	}
}
