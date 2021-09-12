package com.pruebapractica.apitestdocker.estudiantes.infraestructura;

import java.io.FileInputStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

@Configuration
public class FirebaseConfig {

	@Bean
	public Firestore firestore() throws Exception {
		FileInputStream serviceAccount = new FileInputStream("./practicaltest-e58f1-firebase-adminsdk-efnc1-6f89594812.json");
		@SuppressWarnings("deprecation")
		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount)).build();
		FirebaseApp firebaseApp = FirebaseApp.initializeApp(options);
		return FirestoreClient.getFirestore(firebaseApp);
	}

}
