/*

The following notices can be found in each source file.

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

package modelo;


public class Habitacion {

	private Temperatura temperatura;
	private boolean puertaAbierta;
	private Alarma despertador;
	private Jacuzzi jacuzzi;
	private boolean luzTechoHab;
	private boolean luzTechoBan;
	private boolean luzMesaIzq;
	private boolean luzMesaDer;
	private int persianaIzq;
	private int persianaDer;
	private int ventanaIzq;
	private int ventanaDer;

	public Habitacion(Temperatura temperatura, boolean puertaAbierta, Alarma despertador, Jacuzzi jacuzzi,
			boolean luzTechoHab, boolean luzTechoBan, boolean luzMesaIzq, boolean luzMesaDer, int persianaIzq,
			int persianaDer, int ventanaIzq, int ventanaDer) {

		this.temperatura = temperatura;
		this.puertaAbierta = puertaAbierta;
		this.setDespertador(despertador);
		this.jacuzzi = jacuzzi;
		this.luzTechoHab = luzTechoHab;
		this.luzTechoBan = luzTechoBan;
		this.luzMesaIzq = luzMesaIzq;
		this.luzMesaDer = luzMesaDer;
		this.persianaIzq = persianaIzq;
		this.persianaDer = persianaDer;
		this.ventanaIzq = ventanaIzq;
		this.ventanaDer = ventanaDer;
	}

	public Habitacion() {
		this.temperatura = new Temperatura(22);
		this.puertaAbierta = false;
		this.setDespertador(new Alarma(null, null));
		this.jacuzzi = new Jacuzzi(0, 0, false);
		this.luzTechoHab = false;
		this.luzTechoBan = false;
		this.luzMesaIzq = false;
		this.luzMesaDer = false;
		this.persianaIzq = 0;
		this.persianaDer = 0;
		this.ventanaIzq = 0;
		this.ventanaDer = 0;
	}

	public Temperatura getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(Temperatura temperatura) {
		this.temperatura = temperatura;
	}

	public boolean isPuertaAbierta() {
		return puertaAbierta;
	}

	public void setPuertaAbierta(boolean puertaAbierta) {
		this.puertaAbierta = puertaAbierta;
	}

	public Jacuzzi getJacuzzi() {
		return jacuzzi;
	}

	public void setJacuzzi(Jacuzzi jacuzzi) {
		this.jacuzzi = jacuzzi;
	}

	public boolean isLuzTechoHab() {
		return luzTechoHab;
	}

	public void setLuzTechoHab(boolean luzTechoHab) {
		this.luzTechoHab = luzTechoHab;
	}

	public boolean isLuzTechoBan() {
		return luzTechoBan;
	}

	public void setLuzTechoBan(boolean luzTechoBan) {
		this.luzTechoBan = luzTechoBan;
	}

	public boolean isLuzMesaIzq() {
		return luzMesaIzq;
	}

	public void setLuzMesaIzq(boolean luzMesaIzq) {
		this.luzMesaIzq = luzMesaIzq;
	}

	public boolean isLuzMesaDer() {
		return luzMesaDer;
	}

	public void setLuzMesaDer(boolean luzMesaDer) {
		this.luzMesaDer = luzMesaDer;
	}

	public int getPersianaIzq() {
		return persianaIzq;
	}

	public void setPersianaIzq(int persianaIzq) {
		this.persianaIzq = persianaIzq;
	}

	public int getPersianaDer() {
		return persianaDer;
	}

	public void setPersianaDer(int persianaDer) {
		this.persianaDer = persianaDer;
	}

	public int getVentanaIzq() {
		return ventanaIzq;
	}

	public void setVentanaIzq(int ventanaIzq) {
		this.ventanaIzq = ventanaIzq;
	}

	public int getVentanaDer() {
		return ventanaDer;
	}

	public void setVentanaDer(int ventanaDer) {
		this.ventanaDer = ventanaDer;
	}

	/**
	 * M�todo que apaga todas las luces de la casa
	 */
	public void apagarTodasLuces() {
		this.luzTechoHab = false;
		this.luzTechoBan = false;
		this.luzMesaIzq = false;
		this.luzMesaDer = false;
	}

	public Alarma getDespertador() {
		return despertador;
	}

	public void setDespertador(Alarma despertador) {
		this.despertador = despertador;
	}

}
