import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.*;
import java.awt.*;

public class Graphs extends JFrame {

    //field
    private final DefaultCategoryDataset ds;

    public Graphs(String title) {
        super(title); //calls constructor of super class
        this.ds = new DefaultCategoryDataset(); //initializes field ds
    }

    /**
    Adds the runtime measurements to the dataset.
    @param algorithm Name of sorting algorithm
    @param size Size of array.
    @param avgTime Avgerage time it takes to sort the array.
     */
    public void addData(String algorithm, int size, double avgTime) {
        ds.addValue(avgTime, algorithm, String.valueOf(size)); //adds data
    }


    /**
     *Creates the line chart and displays the runtime values.
     */
    public void createChart() {
        JFreeChart chart = ChartFactory.createLineChart(
                "Sorting Algorithm Runtimes", //title
                "Size of Array", //x-axis
                "Average Time (ms)", //y-axis
                createDataset()
        );

        configureAxis(chart); //configures for better readability

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 600));

        setContentPane(chartPanel); //sets contents to chart panel

        pack(); //fits JFrame to its components

        setLocationRelativeTo(null); //centers on screen

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * Configuers y-axis for better readability.
     * @param chart
     */
    private void configureAxis(JFreeChart chart){
        NumberAxis yAxis = (NumberAxis) chart.getCategoryPlot().getRangeAxis();
        yAxis.setAutoRangeIncludesZero(false);
    }

    /**
     * Returns the dataset.
     * @return ds
     */
    private CategoryDataset createDataset() {
        return ds;
    }
}
