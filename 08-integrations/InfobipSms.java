import infobip.api.client.SendSingleTextualSms;
import infobip.api.config.BasicAuthConfiguration;
import infobip.api.model.sms.mt.send.SMSResponse;
import infobip.api.model.sms.mt.send.SMSResponseDetails;
import infobip.api.model.sms.mt.send.textual.SMSTextualRequest;

import java.util.Arrays;

/***
 * 
 * Envío de sms utilizando la plataforma Infobip. Se usa la librería .jar
 * provista por el proveedor
 *
 */

public class InfobipSms {

	String BASE_URL = "https://api.infobip.com/";
	static String USERNAME = "Username";
	static String PASSWORD = "password";

	static String FROM = "Cuenta";
	static String MESSAGE_TEXT = "Estimado/a Contacto1 Apellido2 Se informa que tiene un pago para este mes por 12345.23";

	public static void main(String[] args) {
		try {
			SendSingleTextualSms client = new SendSingleTextualSms(new BasicAuthConfiguration(USERNAME, PASSWORD));

			SMSTextualRequest requestBody = new SMSTextualRequest();
			requestBody.setFrom(FROM);
			requestBody.setTo(Arrays.asList("593968603474"));
			// requestBody.setTo(Arrays.asList("593987197002"));
			requestBody.setText(MESSAGE_TEXT);

			SMSResponse response = client.execute(requestBody);

			SMSResponseDetails sentMessageInfo = response.getMessages().get(0);
			System.out.println("Message ID: " + sentMessageInfo.getMessageId());
			System.out.println("Receiver: " + sentMessageInfo.getTo());
			System.out.println("Message status: " + sentMessageInfo.getStatus().getDescription());
			System.out.println("Message status: " + sentMessageInfo.getStatus().getGroupId());

			if (sentMessageInfo.getStatus().getGroupId() == 0 || sentMessageInfo.getStatus().getGroupId() == 1
					|| sentMessageInfo.getStatus().getGroupId() == 3) {
				// Enviado
			} else {
				// no enviado
			}

		} catch (Exception e) {
			System.out.println("Error");
		}
	}
}
