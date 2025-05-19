package conexion;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 *
 * @author Sebastian Moreno
 */
public class ConexionMongo {

    private static MongoClient mongoClient = null;
    private static final String URL = "mongodb+srv://sebastianMoreno:itson1234@sistemacarniceria.96fuvui.mongodb.net/?retryWrites=true&w=majority&appName=SistemaCarniceria";
    private static final String DATABASE_NAME = "SistemaCarniceria";

    private ConexionMongo() {
    }

    public static MongoDatabase getDatabase() {

        if (mongoClient == null) {

            // 1. Configuramos el codec para manejar POJOs
            CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(
                    MongoClientSettings.getDefaultCodecRegistry(),
                    CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build())
            );

            // 2. Configuramos los ajustes del cliente MongoDB, incluyendo la cadena de conexión
            // (URL) y el registro de codecs anterior
            MongoClientSettings clientSettings = MongoClientSettings.builder()
                    .applyConnectionString(new com.mongodb.ConnectionString(URL))
                    .codecRegistry(pojoCodecRegistry)
                    .build();

            // 3. Asignamos los ajustes al MongoClient estático de la clase
            mongoClient = MongoClients.create(clientSettings);

            // 4. Regresamos la base de datos con la configuración de codecs
            return mongoClient.getDatabase(DATABASE_NAME).withCodecRegistry(pojoCodecRegistry);
        }
        return mongoClient.getDatabase(DATABASE_NAME);
    }

}
