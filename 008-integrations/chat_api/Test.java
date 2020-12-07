package chat_api;

public class Test {

	public static void main(String[] args) {
		String phone = "593979171837";
		String menssage = "Mensaje enviado hacia whatsapp";
		
		Whatsapp wsp = new Whatsapp("hry4ar9py8h6oz3o", "https://api.chat-api.com/instance193736/");
		
		
		// OBETENER INFORMACION DE LA INSTANCIA, EN ESPECIAL SI ESTA AUTENTIFICADA
		//System.out.println( wsp.getStatus() );
		
		// OBTENER INFORMACION SOBRE EL TELEFONO, EN ESPECIAL LA BATERIA
		//System.out.println( wsp.getMe() );
		
		// ENVIAR UN MENSAJE PLANO
		System.out.println( wsp.sendMessage(phone, menssage) );
		
		// ENVIAR UN ARCHIVO DESDE COMO UN MENSAJE
		//System.out.println( wsp.sendFile(phone, "https://s1.eestatic.com/2020/05/18/como/Gatos-Mascotas-Trucos-Curiosidades-Como_hacer_490961518_152142875_1706x960.jpg", 
		//		"gato.jpg", "Es un gato", false) );
		
		// PARA ENVIAR AUDIOS COMO MENSAJES		
		//System.out.println( wsp.sendPTT(phone, "https://habitanto-cdn.s3-us-west-2.amazonaws.com/Habitanto_Meow.mp3") );
		
		// ENVIAR UNA UBICACION POR MENSAJE
		//System.out.println( wsp.sendLocation(phone, "-0.223", "-78.415", "Conjunto Caisaló") );
		
		// CREAR GRUPOS TOMANDO UN LISTADO DE TELEFONOS
		//String[] phones = {"593979171837","593979171246"};
		//System.out.println( wsp.createGroup("Este es el grupo", phones, "Responde aca y traiga algo") );
		
		// MOSTRAR LA COLA DE MENSAJES AUN NO ENVIADOS
		//System.out.println( wsp.showMessagesQueue() );
		
		// LIMPIAR LA COLA DE MENSAJES PENDIENTES
		//System.out.println( wsp.clearMessagesQueue() );
		
		// VERIFICAR SI UN CELULAR TIENE ACCESO A WHATSAPP
		//System.out.println( wsp.checkPhone(phone) );

		
	}

}
