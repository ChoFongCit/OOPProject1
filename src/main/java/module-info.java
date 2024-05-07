module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
        requires javafx.web;
            
        requires org.controlsfx.controls;
            requires com.dlsc.formsfx;
            requires net.synedra.validatorfx;
            requires org.kordamp.ikonli.javafx;
            requires org.kordamp.bootstrapfx.core;
            requires com.almasb.fxgl.all;
    requires java.sql;

    opens pong to javafx.fxml;
    exports pong;
    exports pong.controller;
    opens pong.controller to javafx.fxml;
    exports pong.model;
    opens pong.model to javafx.fxml;
    exports pong.view;
    opens pong.view to javafx.fxml;
}