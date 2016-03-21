import java.awt.Color; 
import java.awt.BasicStroke; 
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.data.xy.XYDataset; 
import org.jfree.data.xy.XYSeries; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 
import org.jfree.chart.plot.XYPlot; 
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.plot.PlotOrientation; 
import org.jfree.data.xy.XYSeriesCollection; 
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;

public class XYLineChart_AWT extends ApplicationFrame 
{
	public XYLineChart_AWT( String applicationTitle, String chartTitle )
	{
		super(applicationTitle);
		JFreeChart xylineChart = ChartFactory.createXYLineChart(
				chartTitle ,
				"Category" ,
				"Score" ,
				createDataset() ,
				PlotOrientation.VERTICAL ,
				true , true , false);

		ChartPanel chartPanel = new ChartPanel( xylineChart );
		chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
		final XYPlot plot = xylineChart.getXYPlot( );
		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
		renderer.setSeriesPaint( 0 , Color.RED );
		renderer.setSeriesPaint( 1 , Color.GREEN );
		renderer.setSeriesPaint( 2 , Color.YELLOW );
		renderer.setSeriesStroke( 0 , new BasicStroke( 0.5f ) );
		renderer.setSeriesStroke( 1 , new BasicStroke( 0.5f ) );
		renderer.setSeriesStroke( 2 , new BasicStroke( 0.5f ) );
		plot.setRenderer( renderer ); 
		setContentPane( chartPanel ); 
	}

	private XYDataset createDataset( )
	{
		final XYSeries firefox = new XYSeries( "n.(logn)^3" ); 
		for(float i=1000.1f;i<5000;i=i+5.91f)
			firefox.add(i ,        Math.pow(i, 1.333333f) );
	
		final XYSeries firefox1 = new XYSeries( "2^sqrt(log x)" ); 
		for(float i=1000.1f;i<5000;i=i+5.91f)
			firefox1.add(i ,         Math.pow(2,Math.sqrt(Math.log(i))));
		/*final XYSeries firefox2 = new XYSeries( "Diff Root(x)" ); 
		for(float i=3000.1f;i<3500;i=i+5.91f)
			firefox2.add(i ,      5* i*(Math.log(i))/Math.log(2)-   i*Math.sqrt(i) );*/

/*		for(float i=0.1f;i<3;i=i+0.1f){
			firefox.add( Math.log(i) ,         Math.log(6*i) );
		//	System.out.println(i + "\t" +        Double.valueOf(10*Math.log(i)-i));
		}
*//*		final XYSeries firefox1 = new XYSeries( "Firefox1" );          
		for(float i=100f;i<1000000;i=i+10f)
			firefox1.add( Math.log(i) ,  Double.valueOf(Math.log(i*i)) );
		final XYSeries firefox2 = new XYSeries( "Firefox2" );          
		for(float i=100f;i<1000000;i=i+10f)
			firefox2.add( Math.log(i) ,  Double.valueOf(Math.log(12*i)) );
		final XYSeries firefox3 = new XYSeries( "Firefox3" );          
		for(float i=100f;i<1000000;i=i+10f)
			firefox3.add( Math.log(i) ,  Double.valueOf(Math.log(12*i*Math.log(i))) );
		final XYSeries firefox4 = new XYSeries( "Firefox4" );          
		for(float i=100f;i<1000000;i=i+10f)
			firefox4.add( Math.log(i) ,  Double.valueOf(2*Math.log(i)) );
*/
		/*final XYSeries chrome = new XYSeries( "Chrome" );          
      chrome.add( 1.0 , 4.0 );          
      chrome.add( 2.0 , 5.0 );          
      chrome.add( 3.0 , 6.0 );          
      final XYSeries iexplorer = new XYSeries( "InternetExplorer" );          
      iexplorer.add( 3.0 , 4.0 );          
      iexplorer.add( 4.0 , 5.0 );          
      iexplorer.add( 5.0 , 4.0 );  */        
		final XYSeriesCollection dataset = new XYSeriesCollection( );          
		dataset.addSeries( firefox );
		dataset.addSeries( firefox1 );
		//dataset.addSeries( firefox2 );          
/*		dataset.addSeries( firefox3 );          
		dataset.addSeries( firefox4 );          
*/		/*dataset.addSeries( chrome );          
      dataset.addSeries( iexplorer );*/
		return dataset;
	}

	public static void main( String[ ] args ) 
	{
		XYLineChart_AWT chart = new XYLineChart_AWT("Browser Usage Statistics", "Which Browser are you using?");
		chart.pack( );          
		RefineryUtilities.centerFrameOnScreen( chart );          
		chart.setVisible( true ); 
	}
}