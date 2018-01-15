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
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYDifferenceRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
//import org.jfree.ui.Spacer;

/**
 * Servlet implementation class chart_cagr
 */
public class chart_cagr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public chart_cagr() {
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

	    TimeSeries series1 = new TimeSeries("Random 1");
	    TimeSeries series2 = new TimeSeries("Random 2");
	    double value1 = 0.0;
	    double value2 = 0.0;
	    Day day = new Day();
	    for (int i = 0; i < 200; i++) {
	        value1 = value1 + Math.random() - 0.5;
	        value2 = value2 + Math.random() - 0.5;
	        series1.add(day, value1);
	        series2.add(day, value2);
	        day = (Day) day.next();
	    }

	    TimeSeriesCollection dataset = new TimeSeriesCollection();
	    dataset.addSeries(series1);
	    dataset.addSeries(series2);

	    JFreeChart chart = ChartFactory.createTimeSeriesChart(
	        "",
	        "Time", "Value",
	        dataset,
	        false,  // legend
	        false,  // tool tips
	        false  // URLs
	    );
	    chart.setBackgroundPaint(Color.white);
	    XYPlot plot = chart.getXYPlot();
	    plot.setRenderer(new XYDifferenceRenderer(Color.green, Color.red, false));
	    plot.setBackgroundPaint(Color.WHITE);
	    plot.setDomainGridlinePaint(Color.white);
	    plot.setRangeGridlinePaint(Color.white);
	  //  plot.setAxisOffset(new Spacer(Spacer.ABSOLUTE, 5.0, 5.0, 5.0, 5.0));

	    ValueAxis domainAxis = new DateAxis("Time");
	    domainAxis.setLowerMargin(0.0);
	    domainAxis.setUpperMargin(0.0);
	    plot.setDomainAxis(domainAxis);
	    plot.setForegroundAlpha(0.5f);
	    response.setContentType("image/png");
	    ChartUtilities.writeChartAsPNG(out,chart,450,300); 
		
		
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
