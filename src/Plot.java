/*** Eclipse Class Decompiler plugin, copyright (c) 2012 Chao Chen (cnfree2000@hotmail.com) ***/

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.experimental.chart.plot.CombinedXYPlot;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class Plot extends ApplicationFrame {
	public Plot(String title) {
		super(title);
		JPanel panel = createDemoPanel();
		panel.setPreferredSize(new Dimension(500, 270));
		setContentPane(panel);
	}

	private static JFreeChart createCombinedChart() {
		IntervalXYDataset data1 = createDataset1();
		XYItemRenderer renderer1 = new XYLineAndShapeRenderer(true, false);
		renderer1.setBaseToolTipGenerator(new StandardXYToolTipGenerator("{0}: ({1}, {2})",
				new SimpleDateFormat("d-MMM-yyyy"), new DecimalFormat("0.00")));

		renderer1.setSeriesStroke(0, new BasicStroke(4.0F, 1, 2));

		renderer1.setSeriesPaint(0, Color.blue);

		DateAxis domainAxis = new DateAxis("Year");
		domainAxis.setLowerMargin(0.0D);
		domainAxis.setUpperMargin(0.02D);
		ValueAxis rangeAxis = new NumberAxis("$billion");
		XYPlot plot1 = new XYPlot(data1, null, rangeAxis, renderer1);
		plot1.setBackgroundPaint(Color.lightGray);
		plot1.setDomainGridlinePaint(Color.white);
		plot1.setRangeGridlinePaint(Color.white);

		IntervalXYDataset data2 = createDataset2();
		XYBarRenderer renderer2 = new XYBarRenderer() {
			public Paint getItemPaint(int series, int item) {
				XYDataset dataset = getPlot().getDataset();
				if (dataset.getYValue(series, item) >= 0.0D) {
					return Color.red;
				}

				return Color.green;
			}
		};
		renderer2.setSeriesPaint(0, Color.red);
		renderer2.setDrawBarOutline(false);
		renderer2.setBaseToolTipGenerator(new StandardXYToolTipGenerator("{0}: ({1}, {2})",
				new SimpleDateFormat("d-MMM-yyyy"), new DecimalFormat("0.00")));

		XYPlot plot2 = new XYPlot(data2, null, new NumberAxis("$billion"), renderer2);

		plot2.setBackgroundPaint(Color.lightGray);
		plot2.setDomainGridlinePaint(Color.white);
		plot2.setRangeGridlinePaint(Color.white);

		CombinedXYPlot cplot = new CombinedXYPlot(domainAxis, rangeAxis);
		cplot.add(plot1, 3);
		cplot.add(plot2, 2);
		cplot.setGap(8.0D);
		cplot.setDomainGridlinePaint(Color.white);
		cplot.setDomainGridlinesVisible(true);

		JFreeChart chart = new JFreeChart("CombinedXYPlotDemo1", JFreeChart.DEFAULT_TITLE_FONT, cplot, false);

		chart.setBackgroundPaint(Color.white);
		LegendTitle legend = new LegendTitle(cplot);
		chart.addSubtitle(legend);
		return chart;
	}

	private static IntervalXYDataset createDataset1() {
		TimeSeries series1 = new TimeSeries("Series 1");
		series1.add(new Month(1, 2005), 7627.7430000000004D);
		series1.add(new Month(2, 2005), 7713.1379999999999D);
		series1.add(new Month(3, 2005), 6776.9390000000003D);
		series1.add(new Month(4, 2005), 5764.5370000000003D);
		series1.add(new Month(5, 2005), 4777.8800000000001D);
		series1.add(new Month(6, 2005), 4836.4960000000001D);
		series1.add(new Month(7, 2005), 3887.6179999999999D);
		series1.add(new Month(8, 2005), 3926.933D);
		series1.add(new Month(9, 2005), 4932.71D);
		series1.add(new Month(10, 2005), 4027.123D);
		series1.add(new Month(11, 2005), 8092.3220000000001D);
		series1.add(new Month(12, 2005), 8170.4139999999998D);
		series1.add(new Month(1, 2006), 8196.0699999999997D);
		series1.add(new Month(2, 2006), 8269.8860000000004D);
		series1.add(new Month(3, 2006), 5371.1559999999999D);
		series1.add(new Month(4, 2006), 5355.7179999999998D);
		series1.add(new Month(5, 2006), 5356.777D);
		series1.add(new Month(6, 2006), 8420.0419999999995D);
		series1.add(new Month(7, 2006), 8444.3469999999998D);
		series1.add(new Month(8, 2006), 8515.0339999999997D);
		series1.add(new Month(9, 2006), 8506.9740000000002D);
		series1.add(new Month(10, 2006), 8584.3289999999997D);
		series1.add(new Month(11, 2006), 8633.2459999999992D);
		series1.add(new Month(12, 2006), 8680.2240000000002D);
		series1.add(new Month(1, 2007), 8707.5609999999997D);
		return new TimeSeriesCollection(series1);
	}

	private static IntervalXYDataset createDataset2() {
		TimeSeriesCollection dataset = new TimeSeriesCollection();

		TimeSeries series1 = new TimeSeries("Series 2");
		
		series1.add(new Month(1, 2005), 1200.0D);
		series1.add(new Month(2, 2005), 1400.0D);
		series1.add(new Month(3, 2005), 1500.0D);
		series1.add(new Month(4, 2005), 1700.0D);
		series1.add(new Month(5, 2005), 1600.0D);
		series1.add(new Month(6, 2005), 2400.0D);
		series1.add(new Month(7, 2005), 2100.0D);
		series1.add(new Month(8, 2005), 2200.0D);
		series1.add(new Month(9, 2005), 800.0D);
		series1.add(new Month(10, 2005), 2350.0D);
		series1.add(new Month(11, 2005), 500.0D);
		series1.add(new Month(12, 2005), 700.0D);
		series1.add(new Month(1, 2006), 900.0D);
		series1.add(new Month(2, 2006), 1500.0D);
		series1.add(new Month(3, 2006), 2100.0D);
		series1.add(new Month(4, 2006), 2200.0D);
		series1.add(new Month(5, 2006), 1900.0D);
		series1.add(new Month(6, 2006), 3000.0D);
		series1.add(new Month(7, 2006), 3780.0D);
		series1.add(new Month(8, 2006), 4000.0D);
		series1.add(new Month(9, 2006), 4500.0D);
		series1.add(new Month(10, 2006), 7000.0D);
		series1.add(new Month(11, 2006), 5500.0D);
		series1.add(new Month(12, 2006), 6000.0D);
		series1.add(new Month(1, 2007), 6500.0D);
		dataset.addSeries(series1);
		return dataset;
	}

	public static JPanel createDemoPanel() {
		JFreeChart chart = createCombinedChart();
		return new ChartPanel(chart);
	}

	public static void main(String[] args) {
		Plot demo = new Plot("JFreeChart : CombinedXYPlotDemo1");

		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);
	}
}