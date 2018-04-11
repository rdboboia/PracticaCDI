package idiomas;

public class TextoEsp extends Texto {
	public TextoEsp() {
		// Comunes
		setBtnAceptar("Aceptar");
		setBtnCerrar("Cerrar");

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

		setLblCoste("Coste:");
		// Panel Emergen Television
		setPanelServiciosEmergenteTelevisionTxt(
				"Nuestros hoteles cuentan con una variedad de canales exclusivos para nuestros clientes m�s exigentes.");
		// Panel Emergen Wifi
		setPanelServiciosEmergenteWifiTxt(
				"Todo el mundo quiere tener la posibilidad de conectarse a internet en cualquier momento, por eso, nosotros contamos con Wifi en todas las habitaciones del hotel de alta calidad. \r\n"
						+ "Una vez usted active el servicio, �ste estar� disponible durante toda su estancia. ");
		setPanelServiciosEmergenteWifiActivadoTxt(
				"Has adquirido el servicio de WiFi. Esperamos que pueda disfrutar de la mejor calidad de nuestra conexion a internet.\n\nPara comenzar a usar el WiFi introduzca la clave en sus dispositivos.");
		setPanelServiciosEmergenteWifiPwdTxt("Clave del WiFi:");
		// Panel Emergen Taxi
		setPanelServiciosEmergenteTaxiTxt(
				"No pierdas tu tiempo llamando a un veh�culo para tu traslado. Nosotros lo hacemos por t�.\n\nLista de empresas asociadas:");
		// TODO: panel usuario

		setLblCuentaHabitacion("Habitaci�n");
		// Panel Confirmacion
		setLblConfirmacion("�Desea confirmar su compra?");

	}
}