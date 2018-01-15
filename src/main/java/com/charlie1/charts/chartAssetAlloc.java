package com.charlie1.charts;

import java.awt.Color;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;

/**
 * Servlet implementation class chartAssetAlloc
 */
public class chartAssetAlloc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public chartAssetAlloc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		OutputStream out = response.getOutputStream();
		
		
		DefaultPieDataset dataset = new DefaultPieDataset();             
	      dataset.setValue( "IPhone 5s" , new Double( 20 ) );             
	      dataset.setValue( "SamSung Grand" , new Double( 20 ) );             
	    dataset.setValue( "MotoG" , new Double( 40 ) );             
     dataset.setValue( "Nokia Lumia" , new Double( 10 ) ); 

	      JFreeChart chart = ChartFactory.createPieChart3D( 
	         "" ,  // chart title                   
	         dataset ,         // data 
	         true ,            // include legend                   
	         true, 
	         false);

	      final PiePlot3D plot = ( PiePlot3D ) chart.getPlot( );             
	      plot.setStartAngle( 270 );             
	      plot.setForegroundAlpha( 0.60f ); 
	      plot.setBackgroundPaint(Color.WHITE);
	      plot.setLabelBackgroundPaint(Color.WHITE);
	      plot.setInteriorGap( 0.02 );             
	      int width = 350;   /* Width of the image */             
	      int height = 250;  /* Height of the image */                             
	      //File pieChart3D = new File( "pie_Chart3D.jpeg" );                           
	      ChartUtilities.writeChartAsPNG( out , chart , width , height );   
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
