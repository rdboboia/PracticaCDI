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

public class TextoEsp extends Texto {
	public TextoEsp() {
		// Comunes
		setBtnAceptar("Aceptar");
		setBtnCerrar("Cerrar");
		setBtnCancelar("Cancelar");

		// Panel Login
		setLoginIniciaSesion("Inicie sesi�n para usar la aplicaci�n");
		setLoginUsuario("Usuario");
		setLoginUsuarioToolTip("Introduzca su usuario (n�mero de habitaci�n)");
		setLoginPassword("Contrase�a");
		setLoginPasswordToolTip("Introduzca la contrase�a asociada al usuario introducido m�s arriba");
		setLoginBtnAceptar("Aceptar");
		setLoginErrorMensaje("Ning�n campo puede estar vac�o");
		setLoginErrorTitulo("Campo(s) vac�os");
		setLoginInfoTitulo("�C�mo entrar en la aplicaci�n?");
		setLoginInfoMensaje("Usuario: 101\nContrase�a: cdi");

		// Menu principal
		setMenuPrincipalBtnHabitacion("Habitaci�n");
		setMenuPrincipalBtnSpa("Spa");
		setMenuPrincipalBtnServicios("Servicios");
		setMenuPrincipalBtnCuenta("Cuenta");
		
		//Panel Habitacion Emergente Alarma
		setLblLunes("Lunes");
		setLblMartes("Martes");
		setLblMiercoles("Mi�rcoles");
		setLblJueves("Jueves");
		setLblViernes("Viernes");
		setLblSabado("S�bado");
		setLblDomingo("Domingo");
		setTxtrParaEmpezarA("Para empezar a utilizar nuestro sistema de despertador a\u00F1ada una alarma pulsando en el bot\u00F3n inferior derecho");
		
		//Panel Habitacion Emergente Calefaccion
		setLblTituloTemperatura("Control de temperatura");
		setLblControlManual("Control manual");
		setBtnActivar("Activar");
		setBtnDesactivar("Desactivar");
		setLblProgramacionAutomatica("Programaci�n Autom�tica");
		setLblInicio("Inicio");
		
		//Panel Habitacion Emergente Jacuzzi
		setLblControlJacuzzi("Control del Jacuzzi");
		setLblBurbujas("Burbujas");
		setLblTemperatura("Temperatura");
		setLblAgua("Agua");
		setLblLlenar("Llenar");
		setLblVaciar("Vaciar");
		
		// Panel Habitacion Emergente Ayuda
		setTxtTip1("Para interactuar con los elementos de la habitaci�n pulse sobre aquellos que est�n resaltados de amarillo.");
		setTxtTip2("Para  interactuar  con  todos  los  elementos  a   la  vez  (como  por  ejemplo, todas las luces) pulse sobre los botones inferiores de la izquierda.");
		setTxtTip3("Para programar  un despertador,  seleccione el bot�n  del reloj  que se encuentra en la parte inferior izquierda.");
		
		//Panel Habitacion Emergente Ventana
		setLblControlVentana("Control de la ventana");
		setLblVentana("Ventana");
		setLblPersianas("Persianas");
		setBtnAbrir("Abrir");
		
		// TODO: panel spa
		setLblTratamiento("Tratamiento");
		setLblSeleccionTratamiento("Seleccione el tratamiento deseado");
		setLblDuracion("Duraci�n");
		setLblLugar("Lugar");
		setLblEmpleado("Empleado");
		setBtnFecha("Fecha");
		setBtnHora("Hora");
		setLblPlazas("Plazas disponibles:");
		setLblSpa("SPA");
		setLblSeleccionServicio("Seleccione el servicio deseado");
		setLblNumeroPersonas("N�mero de tickets");
		setStrPersonas("personas");
		setStrPersona("persona");
		
		// TODO: panel spa EMERGENTE
		setLblTxtSpaTitulo("Seleccione la hora y el d�a");

		// Panel Servicios
		setPanelServiciosBtnMinibar("Reponer minibar");
		setPanelServiciosBtnCambioToalla("Cambiar toallas");
		setPanelServiciosBtnTelefono("Realizar llamada");
		setPanelServiciosBtnHorarioLimpieza("Hora limpieza");
		setPanelServiciosBtnBotones("Llamar al botones");
		setPanelServiciosBtnCambioAlmohada("Cambiar almohada");
		setPanelServiciosBtnCambiarSabanas("Cambiar sabanas");
		setPanelServiciosBtnComidaHab("Pedir comida");
		setPanelServiciosBtnPedirTaxi("Pedir taxi");
		setPanelServiciosBtnTelevision("Adquirir canales");
		setPanelServiciosBtnWifi("Activar WiFi");
		setPanelServiciosBtnInformacion("Solicitar informaci�n");

		// Panel Emergen Informacion
		setBtnAdquirir("Adquirir");
		setTxtInformacion("Nuestros hoteles cuentan con una atenci�n totalmente personalizada. Con solo pulsar el bot�n, le llamaremos al tel�fono de la habitaci�n desde la recepci�n del hotel.\nDisponible las 24 horas al d�a");
		setLblCoste("Coste:");

		// Panel Emergen Television
		setPanelServiciosEmergenteTelevisionTxt("Nuestros hoteles cuentan con una variedad de canales exclusivos para nuestros clientes m�s exigentes.");

		// Panel Emergen Wifi
		setPanelServiciosEmergenteWifiTxt(
				"Todo el mundo quiere tener la posibilidad de conectarse a internet en cualquier momento, por eso nosotros contamos con Wifi en todas las habitaciones del hotel de alta calidad. \r\n"
						+ "Una vez usted active el servicio, �ste estar� disponible durante toda su estancia. ");
		setPanelServiciosEmergenteWifiActivadoTxt("Has adquirido el servicio de WiFi. Esperamos que pueda disfrutar de la mejor calidad de nuestra conexion a internet.\n\nPara comenzar a usar el WiFi introduzca la clave en sus dispositivos.");
		setPanelServiciosEmergenteWifiPwdTxt("Clave del WiFi:");

		// Panel Emergen Taxi
		setPanelServiciosEmergenteTaxiTxt("No pierdas tu tiempo llamando a un veh�culo para tu traslado. Nosotros lo hacemos por ti.\n\nLista de empresas asociadas:");

		// Panel Emergen Botones
		setPanelServiciosEmergenteBotonesTxt("Nuestros hoteles cuentan con una atenci\u00F3n totalmente personalizada. Con solo pulsar el bot\u00F3n, un botones se acercar\u00E1 hasta su habitaci\u00F3n para ayudarle en lo que necesite.\r\nDisponible las 24 horas al d\u00EDa");
		
		// Panel Emergen Almohada
		setPanelServiciosEmergentealmohadaLatex("L�tex");
		setPanelServiciosEmergentealmohadaVisco("Viscoel�stica");
		setPanelServiciosEmergentealmohadaGel("Gel");
		setPanelServiciosEmergentealmohadaPluma("Pluma");
		setPanelServiciosEmergentealmohadaTxt("Queremos que descanse todo lo posible durante su estancia. Seleccione el tipo de almohada que desee y en unos minutos un botones se la subir� a la habitaci�n");
		
		//Panel Emergente Comida
		setPanelServiciosEmergenteComidaTxt("Nuestros hoteles cuentan con una atenci\u00F3n totalmente personalizada. Con solo pulsar el bot\u00F3n, un botones le llevar� la comida desde nuestro exclusivo restaurante directamente a su habitaci�n para que pueda disfrutar de nuestra comida gourmet con total comodidad. Servicio disponible de 7:00 a 00:00");
		
		//Panel Emergente Toallas
		setPanelServiciosEmergenteToallasTxt("Nuestros hoteles cuentan con una atenci\u00F3n totalmente personalizada. Con solo pulsar el bot\u00F3n, nuestro servicio de limpieza subir� a su habitaci�n con un juego de toallas limpias. Servicio disponible las 24 horas del d�a");
		
		//Panel Emergente Minibar
		setPanelServiciosEmergenteMinibarTxt("Nuestros hoteles cuentan con una atenci\u00F3n totalmente personalizada. Con solo pulsar el bot\u00F3n, un botones repondr� todos los art�culos del minibar, para que siempre pueda disfrutar de las mejores bebidas y snacks que tenemos a su disposici�n");
		
		//Panel Emergente Sabanas
		setPanelServiciosEmergenteSabanasTxt("Nuestros hoteles cuentan con una atenci\u00F3n totalmente personalizada. Con solo pulsar el bot\u00F3n, nuestro servicio de limpieza subir� a su habitaci�n con un juego de s�banas limpias. Servicio disponible las 24 horas del d�a");
		
		// Panel Emergente Limpieza
		setPanelServiciosEmergenteLimpiezaTxt("Seleccione la hora m�s adecuada para que limpiemos la habitaci�n.");
		setPanelServiciosEmergenteLimpiezaTxtUnaVezHaya("Aviso: Una vez haya adquirido este servicio podr\u00E1 cambiar la hora ilimitadas veces sin coste alguno.");
		setPanelServiciosEmergenteLimpiezaBtnCambiar("Cambiar");
		
		// Panel Emergente Telefono
		setPanelServiciosEmergenteTelefonoTxt("Seleccione el continente al que desea llamar y a continuaci\u00F3n confirme la llamada. \r\nDespu\u00E9s podr\u00E1 usar el tel\u00E9fono de la habitaci\u00F3n para realizar la llamada.");
		setPanelServiciosEmergenteTelefonobtnConfirmarLLamada("Seleccione un continente");
		
		// Panel usuario
		setLblCuentaHabitacion("Habitaci�n");
		setLblElegirIdioma("Elegir idioma");
		setLblCastellano("Castellano");
		setLblIngles("Ingl�s");
		setLblRumano("Rumano");
		setLblGasto("Gasto");
		setBtnMsDetalles("M�s detalles...");
		setLblGastoTotal("Gasto total:");
		setLblPersonalizar("Personalizar");
		setLblModoNocturno("Modo nocturno");
		setLblInvertirColores("Invertir colores");
		setLblSalidaTexto("Salida de texto por voz");
		setLblAumentarTexto("Aumentar texto");
		setLblListaDeGastos("Lista de Gastos");

		// Panel Confirmacion
		setLblConfirmacion("�Desea confirmar la operaci�n?");
		
		//Panel Emergente Detalles (provisional)
		setStrNingunServicio("No ha adquirido ning�n servicio");
		setFacial("Masaje facial");
		setThai("Masaje Thai");
		setSueco("Masaje Sueco");
		setTermal("Circuito Termal");
		setTurco("Ba�o Turco");
		setToallas("Cambio de toallas");
		setSabanas("Cambio de sabanas");
		setViscoelastica("Contratar Almohada viscoel�stica");
		setLatex("Contratar almohada latex");
		setPluma("Contratar almohada pluma");
		setGel("Contratar almohada gel");
		setMiniBar("Reponer minibar");
		setEuropa("Llamada Europa");
		setAsia("Llamada Asia");
		setAmerica("Llamada Am�rica");
		setAfrica("Llamada �frica");
		setBotones("Llamada al botones");
		setComida("Pedido de comida");
		setHoraLimpieza("Seleccionar hora de limpieza");
		setWiFi("Contratar WiFi");
		setNetflix("Contratar Netflix");
		setMovistar("Contratar Movistar");
		setBBC("Contratar BBC");
		setBein("Contratar Bein");
		setInfo("Solicitar informaci�n");
		
		// Panel Acerca De
		setPanelAcercaDelblTitulo("Acerca de...");
		setPanelAcercaDeTxtInfo("Cerrar sesi�n no implementado. En su lugar dejamos el \"Acerca de\".\r\n\r\nCr�ditos a los autores de Flaticon, especialmente a Freepik, por proporcionar la mayor�a de iconos de nuestra aplicaci�n. A continuaci�n dejamos los cr�ditos tal y como nos lo indican:\r\nIcons made by Freepik from https://www.flaticon.com/\r\nwww.flaticon.com is licensed by Creative Commons BY 3.0 CC 3.0 BY");
	}
}