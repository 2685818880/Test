package demo;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class sendapplet extends Applet implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -615152852143064661L;
	Label sendlable;
	Label messageInfo;
	Button sendButton;
	TextField sendText;
	TextField messageText;
	URLConnection connect;
	String message;
	URL chatURL;

	public String getAppletInfo() {
		return "this is a applet--servlet";
	}

	public synchronized void init() {
		super.init();
		resize(500, 300);
		sendlable = new Label("Please enter Massage");
		messageInfo = new Label("What you hava send:");
		sendText = new TextField(40);
		sendButton = new Button("Send");
		messageText = new TextField(40);
		messageText.setEditable(false);
		//

		//
		Panel mainp = new Panel();
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.gridy = 0;
		gbc.gridx = 0;
		gbc.gridwidth = 10;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.NONE;
		mainp.setLayout(gbl);
		gbl.setConstraints(sendlable, gbc);
		mainp.add(sendlable);
		gbc.gridy = 1;
		gbc.gridwidth = 9;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbl.setConstraints(sendText, gbc);
		mainp.add(sendText);
		gbc.gridx = 9;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.NONE;
		gbl.setConstraints(sendButton, gbc);
		mainp.add(sendButton);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 10;
		gbl.setConstraints(messageInfo, gbc);
		mainp.add(messageInfo);
		gbc.gridy = 3;
		gbc.weighty = 100;
		gbc.gridheight = 10;
		gbc.fill = GridBagConstraints.BOTH;
		gbl.setConstraints(messageText, gbc);
		mainp.add(messageText);
		sendButton.addActionListener(this);
		// 構造的panel加入到applet中
		setLayout(new BorderLayout());
		add("Center", mainp);
		chatURL = getCodeBase();
	}

	public synchronized void start() {
	}

	public synchronized void stop() {
	}

	public synchronized void destroy() {
	}

	//
	@SuppressWarnings("deprecation")
	private void Send() {
		message = sendText.getText();
		sendText.setText("");
		// showStatus("Message send!");
		p("Message send!");
		messageText.setText("message");
		String queryString = "/servlet/Receive?message"+ URLEncoder.encode(message);
		p("Attemping to send :" + message);
		try {
			connect = (new URL(chatURL, queryString)).openConnection();
			showStatus("Open Connection!");
			connect.setDefaultUseCaches(false);
			connect.setUseCaches(false);
			connect.setDoInput(true);
			connect.setDoOutput(false);
			connect.connect();
			p("Make connection to " + connect);
			showStatus("Open Sream!");
			DataInputStream in = new DataInputStream(connect.getInputStream());
			showStatus("reading");
			message = in.readLine();
			while (message != null) {
				messageText.setText(message);
				message = in.readLine();

			}// end while

		}// end try
		catch (MalformedURLException e2) {
			System.err.println("Malformedurlexception:" + e2.toString());

		}// end catch
		catch (IOException e1) {
			System.err.println(e1.toString());

		}

	}// end Send

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == sendButton) {
			Send();

		}

	}

	private void p(String debug) {
		messageText.setText(debug);
		// System.out.println("app-servlet:"+debug);

	}

}