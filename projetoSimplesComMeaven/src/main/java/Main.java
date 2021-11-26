
import com.mongodb.client.*;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        String uri = "mongodb://127.0.0.1:27017/";
        MongoClient mongoClient = MongoClients.create(uri);

        MongoDatabase mongoDatabase = mongoClient.getDatabase("vemserdbc");

        MongoCollection<Document> hoteis = mongoDatabase.getCollection("Hoteis");
        MongoCollection<Document> usuarios = mongoDatabase.getCollection("usuario");

        // Adicionando novo hotel

//        Document novoHotel = new Document("nome", "Sky Valle")
//                .append("logradouro", "Rua Acácia Negra")
//                .append("numero", 700)
//                .append("cep", "95670000")
//                .append("cidade", "Gramado")
//                .append("estado", "RS")
//                .append("quartos", Arrays.asList(103, 203, 303))
//                .append("reservas", Arrays.asList(12, 15, 17));
//
//        hoteis.insertOne(novoHotel);

        // Buscando Hotel
        System.out.println("--Hotel");
        Document hotel = hoteis.find().first();
        System.out.println(hotel);

        // Buscando Hotel Canoas Parque Hotel
        System.out.println("--Hotel Canoas Parque Hotel");
        Document hotel2 = hoteis.find(Filters.eq("nome", "Canoas Parque Hotel")).first();
        System.out.println(hotel2);

        // Buscando usuário
        System.out.println("--Usuário");
        Document usuario = usuarios.find().first();
        System.out.println(usuario);

        // Buscando usuário Jubileu
        System.out.println("--Usuário Jubileu");
        Document usuario2 = usuarios.find(Filters.eq("nome", "Jubileu Gomes")).first();
        System.out.println(usuario2);

        // Deletando Hotel Canoas Hotel Castel

//        hoteis.deleteOne(Filters.eq("nome", "Canoas Hotel Castel"));


        // Deletando usuario Duque

//        usuarios.deleteOne(Filters.eq("nome", "Duque Cardoso"));

        // Atualizando Hotel Life

        hoteis.updateOne(Filters.eq("nome", "Life Hotel"), new Document("$set", new Document("logradouro", "Avenida Guilherme Schell")));

        // Atualzando Usuário Charlote

        usuarios.updateOne(Filters.eq("nome", "Charlote Cardoso"), new Document("$set", new Document("idade", "18")));

        // Agregando Hotéis por cidade

        System.out.println("--Todos os hotéis");
        hoteis.aggregate(Arrays.asList(match(Filters.empty()),
                group("$cidade.nome", Accumulators.sum("qtd", 1))))
                .forEach(doc -> System.out.println(doc.toJson()));



    }
}