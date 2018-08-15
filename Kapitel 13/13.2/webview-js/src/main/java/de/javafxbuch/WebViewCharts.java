package de.javafxbuch;

import javafx.application.Application;
import javafx.concurrent.Worker.State;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 *
 * @author antonepple
 */
public class WebViewCharts extends Application {

    @Override
    public void start(Stage primaryStage) {
        WebView webView = new WebView();
        final WebEngine engine = webView.getEngine();
        engine.load(WebViewCharts.class.getResource("charts.html").toExternalForm());
        Scene scene = new Scene(webView, 300, 250);
        engine.getLoadWorker().stateProperty().addListener((e, o, n) -> {
            if (n == State.SUCCEEDED) {
                String js = constructJavaScript(
                        "Beispiel-Tabelle", new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun",
                            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, "Temperature",
                        new Series("Tokyo", new float[]{7.0f, 6.9f, 9.5f, 14.5f, 18.2f, 21.5f, 25.2f, 26.5f, 23.3f, 18.3f, 13.9f, 9.6f}),
                        new Series("Munich", new float[]{-0.2f, 0.8f, 5.7f, 11.3f, 17.0f, 22.0f, 24.8f, 24.1f, 20.1f, 14.1f, 8.6f, 2.5f}),
                        new Series("London", new float[]{3.9f, 4.2f, 5.7f, 8.5f, 11.9f, 15.2f, 17.0f, 16.6f, 14.2f, 10.3f, 6.6f, 4.8f})
                );
                engine.executeScript(js);
            }
        });
        primaryStage.setTitle("JavaFX WebView Chart Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public String constructJavaScript(String title, String[] categories, String xAxis, Series... series) {
        String result = "$(function () {\n"
                + "        $('#container').highcharts({\n"
                + "            title: {\n"
                + "                text: '" + title + "',\n"
                + "                x: -20 //center\n"
                + "            },\n"
                + "            xAxis: {\n"
                + "                categories: "
                + convertToCommaDelimited(categories)
                + "\n"
                + "            },\n"
                + "            yAxis: {\n"
                + "                title: {\n"
                + "                    text: '" + xAxis + "'\n"
                + "                },\n"
                + "                plotLines: [{\n"
                + "                    value: 0,\n"
                + "                    width: 1,\n"
                + "                    color: '#808080'\n"
                + "                }]\n"
                + "            },\n"
                + "            tooltip: {\n"
                + "                valueSuffix: '°C'\n"
                + "            },\n"
                + "            legend: {\n"
                + "                layout: 'vertical',\n"
                + "                align: 'right',\n"
                + "                verticalAlign: 'middle',\n"
                + "                borderWidth: 0\n"
                + "            },\n"
                + "            series: [{\n";
        for (Series serie : series) {
            result += "                name: '" + serie.getTitle() + "',\n"
                    + "                data: " + serie.getSeriesDataAsString() + "\n"
                    + "            }, {\n";
        }
        result = result.substring(0, result.lastIndexOf(','));
        result
                += "]\n"
                + "        });\n"
                + "    });\n"
                + "    \n"
                + "\n"
                + "\n"
                + "";
        return result;

    }

    public static String convertToCommaDelimited(String[] list) {
        StringBuilder ret = new StringBuilder("[");
        for (int i = 0; list != null && i < list.length; i++) {
            ret.append("'");
            ret.append(list[i]);
            ret.append("'");
            if (i < list.length - 1) {
                ret.append(',');
            }
        }
        ret.append(']');
        return ret.toString();
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
