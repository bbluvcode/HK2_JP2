/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.demojavafx2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ChartController implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Linechart
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.getData().addAll(new XYChart.Data<>(1, 5),
                new XYChart.Data<>(2, 10),
                new XYChart.Data<>(3, 15),
                new XYChart.Data<>(4, 20));
        lineChart.getData().add(series);

        lineChart.setMaxHeight(300);
        lineChart.setMaxWidth(300);
        lineChart.setLayoutX(0);
        lineChart.setLayoutY(0);

        //Bar chart
        CategoryAxis x = new CategoryAxis();
        NumberAxis y = new NumberAxis();
        BarChart<String, Number> barChart = new BarChart<>(x, y);
        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        series1.getData().addAll(new XYChart.Data<>("Category 1", 10),
                                new XYChart.Data<>("Category 2", 15),
                                new XYChart.Data<>("Category 3", 7));
        barChart.getData().add(series1);

        barChart.setMaxHeight(300);
        barChart.setMaxWidth(300);
        barChart.setLayoutX(300);
        barChart.setLayoutY(0);

        //PieChart
        PieChart pieChart = new PieChart();
        PieChart.Data slice1 = new PieChart.Data("Category 1", 30);
        PieChart.Data slice2 = new PieChart.Data("Category 2", 20);
        PieChart.Data slice3 = new PieChart.Data("Category 3", 50);
        pieChart.getData().addAll(slice1, slice2, slice3);
        
        pieChart.setMaxHeight(300);
        pieChart.setMaxWidth(300);
        pieChart.setLayoutX(0);
        pieChart.setLayoutY(300);
        
        //addAll
        anchorPane.getChildren().addAll(lineChart, barChart, pieChart);
    }

}
