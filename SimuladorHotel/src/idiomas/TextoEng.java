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

package idiomas;

public class TextoEng extends Texto {
	public TextoEng() {
		// Comunes
		setBtnAceptar("Confirm");
		setBtnCerrar("Close");
		setBtnCancelar("Cancel");

		// Panel Login
		setLoginIniciaSesion("Login to use the app");
		setLoginUsuario("User");
		setLoginUsuarioToolTip("Type your username (your room number)");
		setLoginPassword("Password");
		setLoginPasswordToolTip("Type the password for your username");
		setLoginBtnAceptar("Accept");
		setLoginErrorMensaje("All fields must be filled");
		setLoginErrorTitulo("Empty field(s)");
		setLoginInfoTitulo(" How to enter the application? ");
		setLoginInfoMensaje("User: 101\nPassword: cdi");

		// Menu principal
		setMenuPrincipalBtnHabitacion("Room");
		setMenuPrincipalBtnSpa("Spa");
		setMenuPrincipalBtnServicios("Services");
		setMenuPrincipalBtnCuenta("Account");
		
		//Panel Habitacion Emergente Alarma
		setLblLunes("Monday");
		setLblMartes("Tuesday");
		setLblMiercoles("Wednesday");
		setLblJueves("Thursday");
		setLblViernes("Friday");
		setLblSabado("Saturday");
		setLblDomingo("Sunday");
		setTxtrParaEmpezarA("To start using our alarm clock, add an alarm just pressing the bottom right button");
		
		//Panel Habitacion Emergente Calefaccion
		setLblTituloTemperatura("Temperature Control Panel");
		setLblControlManual("Manual control");
		setBtnActivar("Enable");
		setBtnDesactivar("Disable");
		setLblProgramacionAutomatica("Automatic Programming");
		setLblInicio("Start");
		
		//Panel Habitacion Emergente Jacuzzi
		setLblControlJacuzzi("Jacuzzi Control Panel");
		setLblBurbujas("Bubbles");
		setLblTemperatura("Temperature");
		setLblAgua("Water");
		setLblLlenar("Fill");
		setLblVaciar("Empty");
		
		// Panel Habitacion Emergente Ayuda
		setTxtTip1("To interact with the elements of the room, click on those highlighted in yellow.");
		setTxtTip2("To interact with all the elements at once (such as all the lights), click on the lower buttons on the left.");
		setTxtTip3("To set an alarm clock, select the clock button at the bottom right.");
		
		//Panel Habitacion Emergente Ventana
		setLblControlVentana("Window Control Panel");
		setLblVentana("Window");
		setLblPersianas("Blind");
		setBtnAbrir("Open");
		
		// TODO: panel spa
		setLblTratamiento("Treatment");
		setLblSeleccionTratamiento("Select the treatment");
		setLblDuracion("Duration");
		setLblLugar("Place");
		setLblEmpleado("Massage Therapist");
		setBtnFecha("Date");
		setBtnHora("Hour");
		setLblPlazas("Available places:");
		setLblSpa("SPA");
		setLblSeleccionServicio("Select the service");
		setLblNumeroPersonas("Number of tickets");
		setStrPersonas("people");
		setStrPersona("person");

		// TODO: panel spa EMERGENTE 
		setLblTxtSpaTitulo("Select the time and day");

		// Panel Servicios
		setPanelServiciosBtnMinibar("Replenish minibar");
		setPanelServiciosBtnCambioToalla("Change towels");
		setPanelServiciosBtnTelefono("Call");
		setPanelServiciosBtnHorarioLimpieza("Set cleaning time");
		setPanelServiciosBtnBotones("Call bellboy");
		setPanelServiciosBtnCambioAlmohada("Change pillow");
		setPanelServiciosBtnCambiarSabanas("Change bed sheets");
		setPanelServiciosBtnComidaHab("Order food");
		setPanelServiciosBtnPedirTaxi("Request taxi");
		setPanelServiciosBtnTelevision("Buy channels");
		setPanelServiciosBtnWifi("Enable WiFi");
		setPanelServiciosBtnInformacion("Ask info");

		// Panel Emergen Informacion
		setBtnAdquirir("Acquire");
		setTxtInformacion("Our hotels have a totally personalized service. With just pressing the button, we will call the room phone from the hotel reception.\nAvailable 24 hours a day");
		setLblCoste("Cost:");

		// Panel Emergen Television
		setPanelServiciosEmergenteTelevisionTxt("Our hotels have a variety of exclusive channels for our most demanding clients.");
		
		// Panel Emergen Wifi
		setPanelServiciosEmergenteWifiTxt(
				"Everyone wants to be able to connect to the internet at any time, that's why, we have Wifi in all the rooms of the hotel of high quality.\r\n"
						+ "Once you activate the service, it will be available during your entire stay.");
		setPanelServiciosEmergenteWifiActivadoTxt("You have purchased the WiFi service. We hope you can enjoy the best quality of our internet connection.\n\nTo start using WiFi, enter the key in your devices.");
		setPanelServiciosEmergenteWifiPwdTxt("WiFi password:");

		// Panel Emergen Taxi
		setPanelServiciosEmergenteTaxiTxt("Do not waste your time calling a vehicle for your travel. We do it for you.\n\nList of associated companies:");

		// Panel Emergen Botones
		setPanelServiciosEmergenteBotonesTxt("Our hotels have a totally personalized service. With just pressing the button, a bellguy will come to your room to help you with what you need.\n Available 24 hours a day");

		// Panel Emergen Almofada
		setPanelServiciosEmergentealmohadaLatex("Latex");
		setPanelServiciosEmergentealmohadaVisco("Viscoelastic");
		setPanelServiciosEmergentealmohadaGel("Gel");
		setPanelServiciosEmergentealmohadaPluma("Feather");
		setPanelServiciosEmergentealmohadaTxt("We want you to rest as much as possible during your stay. Please select what kind of pillow you want and in a few minutes a bellguy will bring it to your room");

		//Panel Emergente Comida
		setPanelServiciosEmergenteComidaTxt("Our hotels have a totally personalized service. With just pressing the button, a bellguy will take the food from our exclusive restaurant directly to your room, so you can enjoy our gourmet meal in total comfort. Service available from 7 am to midnight");
				
		//Panel Emergente Toallas
		setPanelServiciosEmergenteToallasTxt("Our hotels have a totally personalized service. With just pressing the button, our cleaning service will go to your room with a set of clean towels. Service available 24 hours a day.");
		
		//Panel Emergente Minibar
		setPanelServiciosEmergenteMinibarTxt("Our hotels have a totally personalized service. With just pressing the button, a bellguy will go to your room and replace all the items in the minibar, so you can always enjoy the best drinks and snaks we have at your disposal.");
		
		//Panel Emergente Sabanas
		setPanelServiciosEmergenteSabanasTxt("Our hotels have a totally personalized service. With just pressing the button, our cleaning service will go to your room with a set of clean bed sheets. Service available 24 hours a day.");
		
		// Panel Emergente Limpieza
		setPanelServiciosEmergenteLimpiezaTxt("Select when we should clean your room.");
		setPanelServiciosEmergenteLimpiezaTxtUnaVezHaya("Notice: once this service is acquired you can change the time again with no extra cost.");
		setPanelServiciosEmergenteLimpiezaBtnCambiar("Change");
		
		// Panel Emergente Telefono
		setPanelServiciosEmergenteTelefonoTxt("Seleccione el continente al que desea llamar y a continuaci\u00F3n confirme la llamada. \r\nDespu\u00E9s podr\u00E1 usar el tel\u00E9fono de la habitaci\u00F3n para realizar la llamada.");
		setPanelServiciosEmergenteTelefonobtnConfirmarLLamada("Select a continent");
		
		// TODO: panel usuario
		setLblCuentaHabitacion("Room");
		setLblElegirIdioma("Choose Language");
		setLblCastellano("Spanish");
		setLblIngles("English");
		setLblRumano("Romanian");
		setLblGasto("Spending");
		setBtnMsDetalles("More details...");
		setLblGastoTotal("Total cost:");
		setLblPersonalizar("Personalize");
		setLblModoNocturno("Night mode");
		setLblInvertirColores("Reverse colors");
		setLblSalidaTexto("Text out by voice");
		setLblAumentarTexto("Increase text");
		setLblListaDeGastos("Spending List");

		// Panel Confirmacion
		setLblConfirmacion("Are you sure you want to proceed?");
		
		//Panel Cuenta Emergente Detalles
		setStrNingunServicio("You have not purchased any service.");
		setFacial("Facial massage");
		setThai("Thai massage");
		setSueco("Swedish massage");
		setTermal("Thermal circuit");
		setTurco("Turkish bath");
		setToallas("Towell exchange");
		setSabanas("Bedsheet exchange");
		setViscoelastica("Viscoelastic pillow");
		setLatex("Latex pillow");
		setPluma("Feather pillow");
		setGel("Gel pillow");
		setMiniBar("Replace minibar");
		setEuropa("Call to Europe");
		setAsia("Call to Asia");
		setAmerica("Call to America");
		setAfrica("Call to Africa");
		setBotones("Call bellboy");
		setComida("Order food");
		setHoraLimpieza("Choose cleaning hour");
		setWiFi("WiFi hiring");
		setNetflix("Netflix");
		setMovistar("Movistar");
		setBBC("BBC");
		setBein("Bein");
		setInfo("Request info");
		
		// Panel Acerca De
		setPanelAcercaDelblTitulo("About...");
		setPanelAcercaDeTxtInfo("Signing out is not implemented. Instead we leave you with the \"About\" panel.\r\n\r\nCredits to the authors from Flaticon, specially to Freepik, for providing us with most of the icons used in our application. In the following line are the credits as specified by Flaticon:\r\nIcons made by Freepik from https://www.flaticon.com/\r\nwww.flaticon.com is licensed by Creative Commons BY 3.0 CC 3.0 BY");
	}
}