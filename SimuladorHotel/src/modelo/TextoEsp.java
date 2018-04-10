package modelo;

public class TextoEsp extends Texto {
	public TextoEsp() {
		// Panel Login
		setLoginIniciaSesion("Inicie sesi�n para usar la aplicaci�n");
		setLoginUsuario("Usuario");
		setLoginUsuarioToolTip("Introduzca su usuario (n�mero de habitaci�n)");
		setLoginPassword("Contrase�a");
		setLoginPasswordToolTip("Introduzca la contrase�a asociada al usuario introducido m�s arriba");
		setLoginBtnAceptar("Aceptar");
		setLoginErrorMensaje("Ning�n campo puede estar vac�o");
		setLoginErrorTitulo("Campo(s) vac�os");

		// Menu principal
		setMenuPrincipalBtnHabitacion("Habitaci�n");
		setMenuPrincipalBtnSpa("Spa");
		setMenuPrincipalBtnServicios("Servicios");
		setMenuPrincipalBtnCuenta("Cuenta");

		// TODO: panel habitacion
		// TODO: panel spa

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
		setCerrar("Cerrar");
		// Panel Emergen Informacion
		setBtnAdquirir("Adquirir");
		setTxtInformacion(
				"Nuestros hoteles cuentan con una atenci�n totalmente personalizada. Con solo pulsar el bot�n, le llamaremos al tel�fono de la habitaci�n desde la recepci�n del hotel.\nDisponible las 24 horas al d�a");

		setLblCoste("Coste :");
		// Panel Emergen Television
		setPanelServiciosEmergenteTelevisionTxt(
				"Nuestros hoteles cuentan con una variedad de canales exclusivos para nuestros clientes m�s exigentes.");
		// Panel Emergen Wifi
		setPanelServiciosEmergenteWifiTxt(
				"Todo el mundo quiere tener la posibilidad de conectarse a internet en cualquier momento, por eso, nosotros contamos con Wifi en todas las habitaciones del hotel de alta calidad. \r\n"
						+ "Una vez usted active el servicio, �ste estar� disponible durante toda su estancia. ");

		// TODO: panel usuario
	}
}