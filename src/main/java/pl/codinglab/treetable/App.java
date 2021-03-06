package pl.codinglab.treetable;

import de.saxsys.mvvmfx.FluentViewLoader;
import de.saxsys.mvvmfx.MvvmFX;
import de.saxsys.mvvmfx.ViewTuple;
import de.saxsys.mvvmfx.cdi.MvvmfxCdiApplication;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.codinglab.treetable.view.main.MainView;
import pl.codinglab.treetable.view.main.MainViewModel;

import javax.inject.Inject;
import java.util.Locale;
import java.util.ResourceBundle;

public class App extends MvvmfxCdiApplication {

    private static final Logger LOG = LoggerFactory.getLogger(App.class);

    @Inject
    private ResourceBundle resourceBundle;

    @Override
    public void startMvvmfx(Stage stage) throws Exception {
        LOG.info("Starting the Application");
        MvvmFX.setGlobalResourceBundle(resourceBundle);
        stage.setTitle(resourceBundle.getString("window.title"));
        ViewTuple<MainView, MainViewModel> main = FluentViewLoader.fxmlView(MainView.class).load();
        Scene scene = new Scene(main.getView());
        scene.getStylesheets().add("css/styles.css");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        launch(args);
    }

}
