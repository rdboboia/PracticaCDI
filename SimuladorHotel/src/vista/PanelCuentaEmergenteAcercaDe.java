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

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;
import java.awt.event.ActionEvent;

public class PanelCuentaEmergenteAcercaDe extends JPanel {
	private static final long serialVersionUID = 1L;
	private Texto t;

	public PanelCuentaEmergenteAcercaDe(MicroControladorLayersPadreHijo m, Controlador controlador) {
		t = controlador.getTexto();

		this.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 109, 240), new Color(0, 109, 240),
				new Color(0, 109, 240), new Color(0, 109, 240)));
		this.setSize(695, 315);
		this.setName("p" + this.getClass().getSimpleName().substring(1));
		setLayout(null);

		JButton btnCerrar = new JButton(t.getBtnCerrar());

		btnCerrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Ocultar panel
				m.changeLayer(0);
			}
		});
		btnCerrar.setBounds(610, 11, 75, 50);
		add(btnCerrar);

		this.addHierarchyListener(new HierarchyListener() {
			public void hierarchyChanged(HierarchyEvent e) {
				if (e.getChangeFlags() == HierarchyEvent.HIERARCHY_FIRST || e.getChangeFlags() == HierarchyEvent.SHOWING_CHANGED) {

					t = controlador.getTexto();
				}
			}
		});
	}
}
