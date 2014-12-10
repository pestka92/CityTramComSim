package tramwaj;
import java.awt.EventQueue;
public class Test {
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
@Override
public void run() {
// java.util.Properties systemProperties = System.getProperties();
// systemProperties.setProperty("http.proxyHost", "localhost");
// systemProperties.setProperty("http.proxyPort", "8008");
new MyFrame().setVisible(true);
}
});
}
}