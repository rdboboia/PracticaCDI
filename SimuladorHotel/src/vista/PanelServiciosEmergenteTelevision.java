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

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import controlador.Controlador;
import controlador.MicroControladorLayers;
import controlador.MicroControladorLayersPadreHijo;
import idiomas.Texto;
import tiposVariable.StringDouble;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import java.awt.event.ActionListener;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.Semaphore;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextPane;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class PanelServiciosEmergenteTelevision extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLayeredPane panelContenedor;
	private JPanel panelPrincipal;
	private JPanel panelConfirmacion;
	private Semaphore s;
	private Texto t;
	private JButton btnMoviestar;
	private JButton btnNetflix;
	private JButton btnBBC;
	private JButton btnBeinSport;

	public PanelServiciosEmergenteTelevision(MicroControladorLayersPadreHijo microControlador, String padre, Controlador controlador, Semaphore s) {
		this.s = s;
		t = controlador.getTexto();
		setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 102), new Color(0, 0, 102), new Color(0, 0, 102),
				new Color(0, 0, 102)));
		this.setSize(new Dimension(695, 315));
		this.setName("p" + this.getClass().getSimpleName().substring(1)); // No modificar
		setLayout(null);

		panelContenedor = new JLayeredPane();
		panelContenedor.setBounds(0, 0, 695, 315);
		add(panelContenedor);
		panelContenedor.setLayout(null);

		panelPrincipal = new JPanel();
		panelPrincipal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cerrarPanelConfirmacion();
			}
		});
		panelPrincipal.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 109, 240), new Color(0, 109, 240),
				new Color(0, 109, 240), new Color(0, 109, 240)));
		panelPrincipal.setBounds(0, 0, 695, 315);
		panelContenedor.setLayer(panelPrincipal, 1);
		panelContenedor.add(panelPrincipal);
		panelPrincipal.setLayout(null);

		crearPanelConfirmacion("<precio>", controlador);

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

		JLabel lblGif = new JLabel("");
		lblGif.setBorder(new LineBorder(Color.GREEN));
		lblGif.setOpaque(true);
		lblGif.setVisible(false);
		lblGif.setIcon(new ImageIcon(PanelServiciosEmergenteWifi.class.getResource("/iconos/check-gif-1.gif")));
		lblGif.setBounds(287, 103, 120, 109);
		panelPrincipal.add(lblGif);

		btnMoviestar = new JButton("");
		btnMoviestar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Thread() {
					public void run() {
						try {
							mostrarPanelConfirmacion(
									String.valueOf(controlador.getServicios().getTelevision().getPrecioMoviestarPlus())
											+ " �", controlador);

							s.acquire();

							if (((PanelConfirmacion) panelConfirmacion).getConfirmacion() == true) {
								// Actualizar ventana; en otro caso no hacer nada
								btnMoviestar.setEnabled(false);
								controlador.getCuenta().getGasto().addGasto(new StringDouble(t.getMovistar(),
										controlador.getServicios().getTelevision().getPrecioMoviestarPlus()));
								controlador.getServicios().getTelevision().setActivadoMoviestarPlus(true);
								lblGif.setVisible(true);
								Thread.sleep(2050);
								lblGif.setVisible(false);
								btnMoviestar.setIcon(new ImageIcon(
										PanelServiciosEmergenteTelevision.class.getResource("/iconos/movistarC.png")));
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
		btnMoviestar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnMoviestar
				.setIcon(new ImageIcon(PanelServiciosEmergenteTelevision.class.getResource("/iconos/movistar.png")));
		btnMoviestar.setBounds(59, 138, 100, 90);
		btnMoviestar.setContentAreaFilled(false);
		panelPrincipal.add(btnMoviestar);

		JTextPane txtpnInfo = new JTextPane();
		txtpnInfo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpnInfo.setEditable(false);
		txtpnInfo.setOpaque(false);
		txtpnInfo.setText(t.getPanelServiciosEmergenteTelevisionTxt());
		txtpnInfo.setBounds(10, 11, 590, 81);
		panelPrincipal.add(txtpnInfo);

		btnNetflix = new JButton("");
		btnNetflix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread() {
					public void run() {
						try {
							mostrarPanelConfirmacion(
									String.valueOf(controlador.getServicios().getTelevision().getPrecioNetflix())
											+ " �", controlador);

							s.acquire();

							if (((PanelConfirmacion) panelConfirmacion).getConfirmacion() == true) {
								// Actualizar ventana; en otro caso no hacer nada
								btnNetflix.setEnabled(false);
								controlador.getCuenta().getGasto().addGasto(new StringDouble(t.getNetflix(),
										controlador.getServicios().getTelevision().getPrecioNetflix()));
								controlador.getServicios().getTelevision().setActivadoNetflix(true);
								lblGif.setVisible(true);
								Thread.sleep(2050);
								lblGif.setVisible(false);
								// Tiene que hacerse siempre!
								btnNetflix.setIcon(new ImageIcon(
										PanelServiciosEmergenteTelevision.class.getResource("/iconos/netflixC.png")));
								((PanelConfirmacion) panelConfirmacion).setConfirmacion(false);
							}
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
					}
				}.start();
			}
		});
		btnNetflix.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnNetflix.setIcon(new ImageIcon(PanelServiciosEmergenteTelevision.class.getResource("/iconos/netflix.png")));
		btnNetflix.setBounds(218, 138, 100, 90);
		btnNetflix.setContentAreaFilled(false);
		panelPrincipal.add(btnNetflix);

		btnBBC = new JButton("");
		btnBBC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread() {
					public void run() {
						try {
							mostrarPanelConfirmacion(
									String.valueOf(controlador.getServicios().getTelevision().getPrecioBBC()) + " �", controlador);

							s.acquire();

							if (((PanelConfirmacion) panelConfirmacion).getConfirmacion() == true) {
								// Actualizar ventana; en otro caso no hacer nada
								btnBBC.setEnabled(false);
								controlador.getCuenta().getGasto().addGasto(new StringDouble(t.getBBC(),
										controlador.getServicios().getTelevision().getPrecioBBC()));
								controlador.getServicios().getTelevision().setActivadoBBC(true);
								lblGif.setVisible(true);
								Thread.sleep(2050);
								lblGif.setVisible(false);
								btnBBC.setIcon(new ImageIcon(
										PanelServiciosEmergenteTelevision.class.getResource("/iconos/bbcC.png")));
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
		btnBBC.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnBBC.setIcon(new ImageIcon(PanelServiciosEmergenteTelevision.class.getResource("/iconos/bbc.png")));
		btnBBC.setBounds(377, 138, 100, 90);
		btnBBC.setContentAreaFilled(false);
		panelPrincipal.add(btnBBC);

		btnBeinSport = new JButton("");
		btnBeinSport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread() {
					public void run() {
						try {
							mostrarPanelConfirmacion(
									String.valueOf(controlador.getServicios().getTelevision().getPrecioBeinSport())
											+ " �", controlador);

							s.acquire();

							if (((PanelConfirmacion) panelConfirmacion).getConfirmacion() == true) {
								// Actualizar ventana; en otro caso no hacer nada
								btnBeinSport.setEnabled(false);
								controlador.getCuenta().getGasto().addGasto(new StringDouble(t.getBein(),
										controlador.getServicios().getTelevision().getPrecioBeinSport()));
								controlador.getServicios().getTelevision().setActivadoBeinSport(true);
								lblGif.setVisible(true);
								Thread.sleep(2050);
								lblGif.setVisible(false);
								btnBeinSport.setIcon(new ImageIcon(
										PanelServiciosEmergenteTelevision.class.getResource("/iconos/beinC.png")));
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
		btnBeinSport.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnBeinSport
				.setIcon(new ImageIcon(PanelServiciosEmergenteTelevision.class.getResource("/iconos/beinsport.png")));
		btnBeinSport.setBounds(536, 138, 100, 90);
		btnBeinSport.setContentAreaFilled(false);
		panelPrincipal.add(btnBeinSport);
		
		this.addHierarchyListener(new HierarchyListener() {
			public void hierarchyChanged(HierarchyEvent e) {
				if (e.getChangeFlags() == HierarchyEvent.HIERARCHY_FIRST || e.getChangeFlags() == HierarchyEvent.SHOWING_CHANGED) {
					t = controlador.getTexto();
					
					btnCerrar.setText(t.getBtnCerrar());
					txtpnInfo.setText(t.getPanelServiciosEmergenteTelevisionTxt());
				}
			}
		});
	}

	public void cerrarPanelConfirmacion() {
		panelContenedor.setLayer(panelConfirmacion, 0);
	}

	public void crearPanelConfirmacion(String precio, Controlador controlador) {
		panelConfirmacion = new PanelConfirmacion(new MicroControladorLayers(panelContenedor), this.getName(), s, precio, t);
		panelConfirmacion.setBounds(147, 57, 400, 200);
		
		panelConfirmacion.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getNewValue().equals(0)) {
					if (!controlador.getServicios().getTelevision().isActivadoBBC())
						btnBBC.setEnabled(true);
					
					if (!controlador.getServicios().getTelevision().isActivadoBeinSport())
						btnBeinSport.setEnabled(true);
					
					if (!controlador.getServicios().getTelevision().isActivadoMoviestarPlus())
						btnMoviestar.setEnabled(true);
					
					if (!controlador.getServicios().getTelevision().isActivadoNetflix())
						btnNetflix.setEnabled(true);
				}
				else if (evt.getNewValue().equals(2)) {
					btnBBC.setEnabled(false);
					btnBeinSport.setEnabled(false);
					btnMoviestar.setEnabled(false);
					btnNetflix.setEnabled(false);
				}
			}
		});
		
		panelContenedor.setLayer(panelConfirmacion, 0);
		panelContenedor.add(panelConfirmacion);
	}

	public void mostrarPanelConfirmacion(String precio, Controlador controlador) {
		crearPanelConfirmacion(precio, controlador);
		panelContenedor.setLayer(panelConfirmacion, 2);
	}
}
