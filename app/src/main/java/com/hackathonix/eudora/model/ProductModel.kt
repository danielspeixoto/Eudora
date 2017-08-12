package com.hackathonix.eudora.model

import com.hackathonix.eudora.R

/**
 * Created by daniel on 8/11/17.
 */
class ProductModel {

    var products : ArrayList<Product> = arrayListOf()

    init {
        products.add(Product("KISS ME BATOM MATE ROSA CORAJOSA",
                R.drawable.kiss_me_batom_mate_rosa_corajosa,
               16.99, category =Category.MAKE_UP))

        products[0].canTry = true

        products.add(Product("MÁSCARA SIÀGE PROLONGA O LISO 250G",
                R.drawable.mascara_siage_prolonga_o_liso,
                43.99, category =Category.HAIR))

        products.add(Product("LOÇÃO HIDRATANTE VELVET CRISTAL 235ML",
                R.drawable.locao_hidratante_velvet,
                44.99, category =Category.BODY_N_BATH))

        products.add(Product("LOÇÃO TÔNICA NEO ETAGE 100ML",
                R.drawable.locao_tonica_facial_neoetage,
                39.99, category =Category.FACIAL))

        products.add(Product("APONTADOR SOUL DUO",
                R.drawable.apontador_soul_duo,
                17.99, category =Category.MAKE_UP))

        products.add(Product("NECESSAIRE MAKE 2 EM 1",
                R.drawable.necessaire_make_21,
                51.99, category =Category.ACCESSORIES))

        products.add(Product("GEL CREME CLAREADOR ANTISSINAIS 30ML",
                R.drawable.gel_creme_clareador,
                65.99, category =Category.FACIAL))

        products.add(Product("ÓLEO DE MASSAGEM HOT S. 100ML",
                R.drawable.oleo_massagem_hot,
                58.99, category =Category.BODY_N_BATH))
        products.add(Product("AURIEN LOÇÃO ILUMINADORA DES, CORPORAL 200ML",
                R.drawable.aurien_locao_iluminadora,
                44.99, category =Category.BODY_N_BATH))

    }

    fun insert(product : Product) {
        products.add(product)
    }


}