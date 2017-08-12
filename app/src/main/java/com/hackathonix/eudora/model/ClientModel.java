package com.hackathonix.eudora.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.hackathonix.eudora.R;


/**
 * Created by dcandrade on 8/12/17.
 */

public class ClientModel {
    List<Client> clients;

    public ClientModel(){
       this.clients = new ArrayList<>();
        this.load();
    }

    private  void load(){
      ArrayList<Product> products = new ProductModel().getProducts();
        this.clients.add(new Client("João Marcos",  R.drawable.joao_marcos));
        this.clients.add(new Client("Maria Ferreira", R.drawable.maria_ferreira));
        this.clients.add(new Client("Ana Souza", R.drawable.ana_souza));
        this.clients.add(new Client("Júlia Machado", R.drawable.julia_machado));
        this.clients.add(new Client("Marcela Santana", R.drawable.marcela_santana));
        this.clients.add(new Client("Thais Moreira", R.drawable.thais_moreira));
        this.clients.add(new Client("Pedro Jesus", R.drawable.pedro_jesus));

        for(Client client : this.clients){
            Collections.shuffle(products);
            int amountProducts = (int) Math.random() * 9; //generates 0 to 9 purchases
            amountProducts +=1; //at least 1
            int productUnits = (int) Math.random() * 4;
            amountProducts +=1;

            for(int i =0; i<amountProducts; i++){
                client.buy(products.get(i), productUnits);
            }
        }
    }
}
