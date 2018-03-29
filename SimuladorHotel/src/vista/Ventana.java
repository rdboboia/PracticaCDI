package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JToggleButton;
import javax.swing.ButtonGroup;
import java.awt.Font;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class Ventana extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPasswordField campoPassword;
	private JTextField campoUsuario;
	private JPanel panelPrincipal;
	private JPanel panelLogin;
	private JPanel pantalla;

	public Ventana() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 745);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		// contentPane.setCursor(new Cursor(Cursor.HAND_CURSOR));

		JLayeredPane layeredPane = new JLayeredPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(layeredPane, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(layeredPane,
				GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE));

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Ventana.class.getResource("/iconos/marcoTablet.png")));
		label.setBounds(130, 3, 1080, 690);
		layeredPane.add(label);

		pantalla = new JPanel();
		layeredPane.setLayer(pantalla, 1);
		pantalla.setBounds(195, 51, 951, 594);
		layeredPane.add(pantalla);
		pantalla.setLayout(new CardLayout(0, 0));

		panelLogin = new JPanel();
		panelLogin.setName("panelLogin");
		pantalla.add(panelLogin, panelLogin.getName());

		JLabel lblInicieSesinPara = new JLabel("Inicie sesi\u00F3n para usar la aplicaci\u00F3n");
		lblInicieSesinPara.setHorizontalAlignment(SwingConstants.CENTER);
		lblInicieSesinPara.setFont(new Font("Tahoma", Font.PLAIN, 24));

		JPanel panelDatosSesion = new JPanel();
		GroupLayout gl_panelLogin = new GroupLayout(panelLogin);
		gl_panelLogin.setHorizontalGroup(gl_panelLogin.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelLogin.createSequentialGroup().addContainerGap()
						.addGroup(gl_panelLogin.createParallelGroup(Alignment.TRAILING)
								.addComponent(panelDatosSesion, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 931,
										Short.MAX_VALUE)
								.addComponent(lblInicieSesinPara, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 931,
										Short.MAX_VALUE))
						.addContainerGap()));
		gl_panelLogin.setVerticalGroup(gl_panelLogin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLogin.createSequentialGroup().addContainerGap()
						.addComponent(lblInicieSesinPara, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panelDatosSesion, GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
						.addContainerGap()));

		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 24));

		campoPassword = new JPasswordField();
		campoPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginHandler();
			}
		});
		campoPassword.setToolTipText("Introduzca la contrase\u00F1a asociada al usuario introducido m\u00E1s arriba");
		campoPassword.setFont(new Font("Tahoma", Font.PLAIN, 24));

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 24));

		campoUsuario = new JTextField();
		campoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginHandler();
			}
		});
		campoUsuario.setToolTipText("Introduzca su usuario (n\u00FAmero de habitaci\u00F3n)");
		campoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 24));

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginHandler();
			}
		});
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 24));

		JSeparator separador = new JSeparator();
		GroupLayout gl_panelDatosSesion = new GroupLayout(panelDatosSesion);
		gl_panelDatosSesion.setHorizontalGroup(gl_panelDatosSesion.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDatosSesion.createSequentialGroup().addGap(298).addGroup(gl_panelDatosSesion
						.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panelDatosSesion.createSequentialGroup()
								.addComponent(lblUsuario, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
								.addGap(18).addComponent(campoUsuario, GroupLayout.PREFERRED_SIZE, 188,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelDatosSesion.createSequentialGroup().addComponent(lblContrasea).addGap(18)
								.addComponent(campoPassword, GroupLayout.PREFERRED_SIZE, 188,
										GroupLayout.PREFERRED_SIZE))
						.addComponent(btnAceptar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap(299, Short.MAX_VALUE))
				.addComponent(separador, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 931, Short.MAX_VALUE));
		gl_panelDatosSesion.setVerticalGroup(gl_panelDatosSesion.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDatosSesion.createSequentialGroup()
						.addComponent(separador, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE).addGap(135)
						.addGroup(gl_panelDatosSesion.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblUsuario, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addComponent(campoUsuario, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
						.addGap(19)
						.addGroup(gl_panelDatosSesion.createParallelGroup(Alignment.BASELINE).addComponent(lblContrasea)
								.addComponent(campoPassword, GroupLayout.PREFERRED_SIZE, 32,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18).addComponent(btnAceptar).addContainerGap(194, Short.MAX_VALUE)));
		panelDatosSesion.setLayout(gl_panelDatosSesion);
		panelLogin.setLayout(gl_panelLogin);

		panelPrincipal = new JPanel();
		panelPrincipal.setName("panelPrincipal");
		pantalla.add(panelPrincipal, panelPrincipal.getName());
		layeredPane.setLayer(panelPrincipal, 1);

		JPanel menuPrincipal = new JPanel();

		JPanel pantallaMenu = new JPanel();
		GroupLayout gl_panelPrincipal = new GroupLayout(panelPrincipal);
		gl_panelPrincipal.setHorizontalGroup(gl_panelPrincipal.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelPrincipal.createSequentialGroup().addContainerGap()
						.addGroup(gl_panelPrincipal.createParallelGroup(Alignment.TRAILING)
								.addComponent(pantallaMenu, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 931,
										Short.MAX_VALUE)
								.addComponent(menuPrincipal, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 931,
										Short.MAX_VALUE))
						.addContainerGap()));
		gl_panelPrincipal.setVerticalGroup(gl_panelPrincipal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPrincipal.createSequentialGroup().addContainerGap()
						.addComponent(menuPrincipal, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(pantallaMenu, GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE).addContainerGap()));
		pantallaMenu.setLayout(new CardLayout(0, 0));

		JPanel panelHabitacion = new PanelHabitacion();
		pantallaMenu.add(panelHabitacion, panelHabitacion.getName());

		JPanel panelSpa = new PanelSpa();
		pantallaMenu.add(panelSpa, panelSpa.getName());

		JPanel panelServicios = new PanelServicios();
		pantallaMenu.add(panelServicios, panelServicios.getName());

		JPanel panelCuenta = new PanelCuenta();
		pantallaMenu.add(panelCuenta, panelCuenta.getName());

		JToggleButton btnSpa = new JToggleButton("Spa");
		btnSpa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout l = (CardLayout) pantallaMenu.getLayout();
				l.show(pantallaMenu, panelSpa.getName());
			}
		});
		btnSpa.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnSpa.setSelectedIcon(new ImageIcon(Ventana.class.getResource("/iconos/spa_x32_black.png")));
		btnSpa.setIcon(new ImageIcon(Ventana.class.getResource("/iconos/spa_x32_blue.png")));
		buttonGroup.add(btnSpa);

		JToggleButton btnHabitacion = new JToggleButton("Habitaci\u00F3n");
		btnHabitacion.setSelected(true);
		btnHabitacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout l = (CardLayout) pantallaMenu.getLayout();
				l.show(pantallaMenu, panelHabitacion.getName());
			}
		});
		btnHabitacion.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnHabitacion.setSelectedIcon(new ImageIcon(Ventana.class.getResource("/iconos/cama_x32_black.png")));
		btnHabitacion.setIcon(new ImageIcon(Ventana.class.getResource("/iconos/cama_x32_blue.png")));
		buttonGroup.add(btnHabitacion);

		JToggleButton btnCuenta = new JToggleButton("Cuenta");
		btnCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout l = (CardLayout) pantallaMenu.getLayout();
				l.show(pantallaMenu, panelCuenta.getName());
			}
		});
		btnCuenta.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnCuenta.setSelectedIcon(new ImageIcon(Ventana.class.getResource("/iconos/usuario_x32_black.png")));
		buttonGroup.add(btnCuenta);
		btnCuenta.setIcon(new ImageIcon(Ventana.class.getResource("/iconos/usuario_x32_blue.png")));

		JToggleButton btnServicios = new JToggleButton("Servicios");
		btnServicios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout l = (CardLayout) pantallaMenu.getLayout();
				l.show(pantallaMenu, panelServicios.getName());
			}
		});
		btnServicios.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnServicios.setSelectedIcon(new ImageIcon(Ventana.class.getResource("/iconos/servicios_x32_black.png")));
		btnServicios.setIcon(new ImageIcon(Ventana.class.getResource("/iconos/servicios_x32_blue.png")));
		buttonGroup.add(btnServicios);
		GroupLayout gl_menuPrincipal = new GroupLayout(menuPrincipal);
		gl_menuPrincipal.setHorizontalGroup(gl_menuPrincipal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_menuPrincipal.createSequentialGroup().addContainerGap()
						.addComponent(btnHabitacion, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnSpa, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
						.addComponent(btnServicios, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnCuenta, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		gl_menuPrincipal.setVerticalGroup(gl_menuPrincipal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_menuPrincipal.createSequentialGroup().addContainerGap().addGroup(gl_menuPrincipal
						.createParallelGroup(Alignment.LEADING)
						.addComponent(btnHabitacion, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_menuPrincipal.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnServicios, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSpa, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnCuenta, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		menuPrincipal.setLayout(gl_menuPrincipal);
		panelPrincipal.setLayout(gl_panelPrincipal);
		contentPane.setLayout(gl_contentPane);
	}

	/* ******* */
	/* METHODS */
	/* ******* */

	private void loginHandler() {
		// TODO: call user validation method

		if (campoUsuario.getText().length() == 0 || campoPassword.getPassword().length == 0) {
			// TODO: esto es temporal; hay que crear los mensajes en otra clase para poder
			// cambiar de idioma f�cilmente
			JOptionPane.showMessageDialog(contentPane, "Ning�n campo puede estar vac�o.", "Campo(s) vac�os",
					JOptionPane.ERROR_MESSAGE);
		} else {
			CardLayout l = (CardLayout) pantalla.getLayout();
			l.show(pantalla, panelPrincipal.getName());
		}
	}
}