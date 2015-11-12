package kata5;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class HistogramDisplay extends ApplicationFrame {
    
    private final Histogram<String> histogram;
    
    public HistogramDisplay(Histogram<String> histogram) {
        super("Histograma");
        this.histogram = histogram;
        setContentPane(createPanel());
        pack();
    }
    
    private ChartPanel createPanel() {
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
        chartPanel.setPreferredSize(new Dimension(600, 400));
        return chartPanel;
        
    }
    
    private JFreeChart createChart(DefaultCategoryDataset dataSet) {
        JFreeChart chart = ChartFactory.createBarChart(null, "Dominios", "Nº de emails", dataSet, PlotOrientation.VERTICAL, false, false, false);
        return chart;
        
        
    }
    
    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                
        for(String key : histogram.keySet()) {
            dataset.addValue(histogram.get(key), "", key); 
        }
        
        return dataset;
    }
    
    public void execute() {
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
