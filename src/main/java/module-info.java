module org.example.gestormaterialg2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.gestormaterialg2 to javafx.fxml;
    exports org.example.gestormaterialg2;
}