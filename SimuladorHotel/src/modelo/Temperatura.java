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

package modelo;

import java.util.ArrayList;

public class Temperatura {

	private int temperaturaActual;
	private ArrayList<ProgramacionTemperatura> programacionTemperatura;

	public Temperatura(int temperaturaActual) {
		this.temperaturaActual = temperaturaActual;
		this.programacionTemperatura = new ArrayList<ProgramacionTemperatura>();
	}

	public double getTemperaturaActual() {
		return temperaturaActual;
	}

	public void setTemperaturaActual(int temperaturaActual) {
		this.temperaturaActual = temperaturaActual;
	}

	public ArrayList<ProgramacionTemperatura> getProgramacionTemperatura() {
		return programacionTemperatura;
	}

	public void setProgramacionTemperatura(ArrayList<ProgramacionTemperatura> programacionTemperatura) {
		this.programacionTemperatura = programacionTemperatura;
	}

}
