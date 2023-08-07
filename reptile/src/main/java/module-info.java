module com.reptile.reptile {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.reptile.reptile to javafx.fxml;
    exports com.reptile.reptile;
}