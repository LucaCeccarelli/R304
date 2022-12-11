module fr.univ_amu.iut {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.univ_amu.iut.interface_application to javafx.fxml;
    exports fr.univ_amu.iut.interface_application;
}