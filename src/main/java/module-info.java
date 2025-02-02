module dev.reymark {
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires transitive core.fx;
    requires transitive core.db;
    requires javafx.base;
    requires core.util;
    requires atlantafx.base;
    requires javafx.graphics;
    requires java.sql.rowset;

    opens dev.reymark to javafx.fxml;
    opens dev.reymark.app to javafx.fxml;

    exports dev.reymark;
    exports dev.reymark.app;
}
