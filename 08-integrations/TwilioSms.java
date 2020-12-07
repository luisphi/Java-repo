import java.util.*;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.*;
import com.twilio.sdk.resource.instance.*;

/**
 * 
 * Envío de sms usando la plataforma de Twilio
 *
 */
public class TwilioSms {
	// Find your Account Sid and Token at twilio.com/user/account
	public static final String ACCOUNT_SID = "ACCOUNT_SID";
	public static final String AUTH_TOKEN = "AUTH_TOKEN";

	public static void main(String[] args) throws TwilioRestException {
		TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);

		// Build the parameters
		try {
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("To", "+593979171840"));
			params.add(new BasicNameValuePair("From", "+13154017679"));
			params.add(new BasicNameValuePair("Body", "Hola que tal "));

			MessageFactory messageFactory = client.getAccount().getMessageFactory();
			Message message = messageFactory.create(params);
			System.out.println(message.getSid());
			System.out.println(message.getPrice());
			System.out.println(message.getStatus());
			System.out.println(message.toJSON());

		} catch (TwilioRestException e) {
			System.out.println(e.getErrorMessage());
		}
	}
}