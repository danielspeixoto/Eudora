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
               16.99, Category.MAKE_UP))

        products.add(Product("LÚMIS AMOUR DEO COLÔNIA 100ML",
                R.drawable.lumis_amour_del_colonia,
                64.90, Category.PERFUME))

        products.add(Product("MÁSCARA SIÀGE PROLONGA O LISO 250G",
                R.drawable.mascara_siage_prolonga_o_liso,
                43.99, Category.HAIR))

        products.add(Product("LOÇÃO HIDRATANTE VELVET CRISTAL 235ML",
                R.drawable.locao_hidratante_velvet,
                44.99, Category.BODY_N_BATH))

        products.add(Product("LOÇÃO TÔNICA NEO ETAGE 100ML",
                R.drawable.locao_tonica_facial_neoetage,
                39.99, Category.FACIAL))

        products.add(Product("APONTADOR SOUL DUO",
                R.drawable.apontador_soul_duo,
                17.99, Category.MAKE_UP))

        products.add(Product("NECESSAIRE MAKE 2 EM 1",
                R.drawable.necessaire_make_21,
                51.99, Category.ACCESSORIES))

        products.add(Product("GEL CREME CLAREADOR ANTISSINAIS 30ML",
                R.drawable.gel_creme_clareador,
                65.99, Category.FACIAL))

        products.add(Product("ÓLEO DE MASSAGEM HOT S. 100ML",
                R.drawable.oleo_massagem_hot,
                58.99, Category.BODY_N_BATH))

        products.add(Product("ÓLEO DE MASSAGEM HOT S. 100ML",
                R.drawable.gel_creme_clareador,
                65.99, Category.BODY_N_BATH))

        products.add(Product("AURIEN LOÇÃO ILUMINADORA DES, CORPORAL 200ML",
                R.drawable.aurien_locao_iluminadora,
                44.99, Category.BODY_N_BATH))

        products.add(Product("PÓ COMPACTO B SOUL GO MATE",
                R.drawable.po_compacto_bsoul_gomate,
                28.99, Category.MAKE_UP))
    }

    fun insert(product : Product) {
        products.add(product)
    }


}