package fr.univ_amu.iut;

import fr.univ_amu.iut.backend.magasin.ApprovisionnementMagasin;
import fr.univ_amu.iut.backend.magasin.InitListeChampionsExistants;
import fr.univ_amu.iut.backend.magasin.Magasin;
import org.junit.jupiter.api.Test;

public class TestMagasin {

    @Test
    public void aa(){
        Magasin magasin = new Magasin();
        magasin.initMagasin();

    }

}
