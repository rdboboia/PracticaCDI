/*

The following notices can be found in each source file of the 
original project.

Copyright (C) 2018 EquipoSPA:
	David Herrero Pascual	- GitHub: Deividhp13
	Antonio Castro Blanco	- GitHub: Castrum38
	Radu Dumitru Boboia		- GitHub: rdboboia
	Sergio Cavero D�az		- GitHub: scaverod

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program. If not, see <http://www.gnu.org/licenses/>.

You can contact us at our GitHub written above.

To see the full license, check:
https://github.com/scaverod/PracticaCDI/blob/master/LICENSE

*/

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
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;

public class PanelHabitacionEmergenteVentana2 extends JPanel {
	private static final long serialVersionUID = 1L;
	private Texto t;
	// Valores de la posicion de las persianas del 0 al 4
	private int persianas;
	private ImageIcon[] persianasIcon = {
			new ImageIcon(PanelHabitacionEmergenteVentana2.class.getResource("/iconos/persiana0.png")),
			new ImageIcon(PanelHabitacionEmergenteVentana2.class.getResource("/iconos/persiana1.png")),
			new ImageIcon(PanelHabitacionEmergenteVentana2.class.getResource("/iconos/persiana2.png")),
			new ImageIcon(PanelHabitacionEmergenteVentana2.class.getResource("/iconos/persiana3.png")),
			new ImageIcon(PanelHabitacionEmergenteVentana2.class.getResource("/iconos/persiana4.png")) };
	private ImageIcon[] ventanasIcon = {
			new ImageIcon(PanelHabitacionEmergenteVentana2.class.getResource("/iconos/ventana0.png")),
			new ImageIcon(PanelHabitacionEmergenteVentana2.class.getResource("/iconos/ventana1.png")) };


	private JLabel lblVentana;
	private JLabel lblPersiana;
	private JButton btnCerrar;
	private JButton btnAbrir;
	private JButton btnCerrarV;
	private JButton btnSubir;
	private JButton btnBajar;

	
	
	public PanelHabitacionEmergenteVentana2(MicroControladorLayersPadreHijo m, Controlador controlador) {
		addHierarchyListener(new HierarchyListener() {
			public void hierarchyChanged(HierarchyEvent e) {
				if (e.getChangeFlags() == HierarchyEvent.HIERARCHY_FIRST) {
					// Compruebo Persiana
					if (controlador.getHabitacion().getPersianaDer() == 0) {
						persianas = 0;
						btnSubir.setEnabled(false);
						btnBajar.setEnabled(true);
						lblPersiana.setIcon(persianasIcon[persianas]);
					} else if (controlador.getHabitacion().getPersianaDer() == 4) {
						persianas = 4;
						btnSubir.setEnabled(true);
						btnBajar.setEnabled(false);
						lblPersiana.setIcon(persianasIcon[persianas]);
					}
					//Compruebo ventana
					if (controlador.getHabitacion().getVentanaDer() == 0) {
						btnAbrir.setEnabled(true);
						btnCerrarV.setEnabled(false);
						lblVentana.setIcon(ventanasIcon[0]);
						
					} else if (controlador.getHabitacion().getVentanaDer() == 1) {
						btnAbrir.setEnabled(false);
						btnCerrarV.setEnabled(true);
						lblVentana.setIcon(ventanasIcon[1]);
					}

				}
			}
		});

		t = controlador.getTexto();

		
		this.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 109, 240), new Color(0, 109, 240),
				new Color(0, 109, 240), new Color(0, 109, 240)));
		this.setSize(695, 315);
		this.setName("p" + this.getClass().getSimpleName().substring(1));
		setLayout(null);

		btnCerrar = new JButton("");
		btnCerrar.setText(t.getBtnCerrar());
		btnCerrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Ocultar panel
				m.changeLayer(0);
			}
		});
		btnCerrar.setBounds(610, 11, 75, 50);
		add(btnCerrar);

		JPanel panelVentana = new JPanel();
		panelVentana.setBorder(new TitledBorder(
				new BevelBorder(BevelBorder.LOWERED, new Color(0, 109, 240), new Color(0, 109, 240),
						new Color(0, 109, 240), new Color(0, 109, 240)),
				t.getLblVentana(), TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 15), null));
		panelVentana.setBounds(10, 64, 334, 240);
		add(panelVentana);
		panelVentana.setLayout(null);

		lblVentana = new JLabel("");
		lblVentana.setIcon(ventanasIcon[0]);
		lblVentana.setBounds(92, 24, 150, 150);
		panelVentana.add(lblVentana);

		btnAbrir = new JButton(t.getBtnAbrir());
		btnAbrir.setRequestFocusEnabled(false);

		btnCerrarV = new JButton(t.getBtnCerrar());
		btnCerrarV.setRequestFocusEnabled(false);

		btnCerrarV.setEnabled(false);

		btnAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAbrir.setEnabled(false);
				btnCerrarV.setEnabled(true);
				lblVentana.setIcon(ventanasIcon[1]);
				controlador.getHabitacion().setVentanaDer(1);
			}
		});
		btnAbrir.setBounds(59, 185, 78, 44);
		panelVentana.add(btnAbrir);

		btnCerrarV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCerrarV.setEnabled(false);
				btnAbrir.setEnabled(true);
				lblVentana.setIcon(ventanasIcon[0]);
				controlador.getHabitacion().setVentanaDer(0);
			}
		});
		btnCerrarV.setBounds(196, 185, 78, 44);
		panelVentana.add(btnCerrarV);

		JPanel panelPersiana = new JPanel();
		panelPersiana.setBorder(new TitledBorder(
				new BevelBorder(BevelBorder.LOWERED, new Color(0, 109, 240), new Color(0, 109, 240),
						new Color(0, 109, 240), new Color(0, 109, 240)),
				t.getLblPersianas(), TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 15), null));
		panelPersiana.setLayout(null);
		panelPersiana.setBounds(354, 64, 334, 240);
		add(panelPersiana);

		btnSubir = new JButton("");
		btnSubir.setRequestFocusEnabled(false);

		btnBajar = new JButton("");
		btnBajar.setRequestFocusEnabled(false);

		btnSubir.setEnabled(false);
		btnSubir.setIcon(
				new ImageIcon(PanelHabitacionEmergenteVentana2.class.getResource("/iconos/flechaArriba_x32_blue.png")));
		btnSubir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (persianas > 1) {
					persianas--;
					lblPersiana.setIcon(persianasIcon[persianas]);
					btnBajar.setEnabled(true);
					controlador.getHabitacion().setPersianaDer(persianas);
				} else if (persianas == 1) {
					persianas--;
					lblPersiana.setIcon(persianasIcon[persianas]);
					btnSubir.setEnabled(false);
					controlador.getHabitacion().setPersianaDer(persianas);
				}
			}
		});
		btnSubir.setBounds(59, 185, 78, 44);
		panelPersiana.add(btnSubir);

		lblPersiana = new JLabel("");
		lblPersiana.setIcon(persianasIcon[0]);
		lblPersiana.setBounds(92, 24, 150, 150);
		panelPersiana.add(lblPersiana);

		btnBajar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (persianas < 3) {
					persianas++;
					btnSubir.setEnabled(true);
					lblPersiana.setIcon(persianasIcon[persianas]);
					controlador.getHabitacion().setPersianaDer(persianas);
				} else if (persianas == 3) {
					persianas++;
					lblPersiana.setIcon(persianasIcon[persianas]);
					btnBajar.setEnabled(false);
					controlador.getHabitacion().setPersianaDer(persianas);
				}

			}
		});
		btnBajar.setIcon(
				new ImageIcon(PanelHabitacionEmergenteVentana2.class.getResource("/iconos/flechaAbajo_x32_blue.png")));
		btnBajar.setBounds(196, 185, 78, 44);
		panelPersiana.add(btnBajar);

		JLabel lblTitulo = new JLabel(t.getLblControlVentana());
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTitulo.setBounds(10, 31, 167, 14);
		add(lblTitulo);
		
		
		this.addHierarchyListener(new HierarchyListener() {
			public void hierarchyChanged(HierarchyEvent e) {
				if (e.getChangeFlags() == HierarchyEvent.HIERARCHY_FIRST
						|| e.getChangeFlags() == HierarchyEvent.SHOWING_CHANGED) {

					t = controlador.getTexto();

					panelPersiana.setBorder(new TitledBorder(
							new BevelBorder(BevelBorder.LOWERED, new Color(0, 109, 240), new Color(0, 109, 240),
									new Color(0, 109, 240), new Color(0, 109, 240)),
							t.getLblPersianas(), TitledBorder.LEADING, TitledBorder.TOP,
							new Font("Tahoma", Font.PLAIN, 15), null));

					panelVentana.setBorder(new TitledBorder(
							new BevelBorder(BevelBorder.LOWERED, new Color(0, 109, 240), new Color(0, 109, 240),
									new Color(0, 109, 240), new Color(0, 109, 240)),
							t.getLblVentana(), TitledBorder.LEADING, TitledBorder.TOP,
							new Font("Tahoma", Font.PLAIN, 15), null));

					btnAbrir.setText(t.getBtnAbrir());
					btnCerrarV.setText(t.getBtnCerrar());
					lblTitulo.setText(t.getLblControlVentana());
					btnCerrar.setText(t.getBtnCerrar());

				}
			}
		});
	}
}
