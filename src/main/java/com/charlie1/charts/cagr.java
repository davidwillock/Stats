package com.charlie1.charts;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.awt.Color;
import java.io.*;



import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;



import java.awt.image.RenderedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




//import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;









/**
 * Servlet implementation class cagr
 */
public class cagr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cagr() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("image/png");
		
        ServletOutputStream os = response.getOutputStream();
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(76, "Java", "Sandeep");
        dataset.addValue(30, "Java", "Sangeeta");
        dataset.addValue(50, "Java", "Surabhi");
        dataset.addValue(20,"Java", "Sumanta");
        dataset.addValue(10, "Oracle", "Sandeep");
        dataset.addValue(90, "Oracle", "Sangeeta");
        dataset.addValue(23, "Oracle", "Surabhi");
        dataset.addValue(87, "Oracle", "Sumanta");
        
        JFreeChart chart = ChartFactory.createAreaChart(
        		  "Area Chart", "", "Value", dataset, 
        		   PlotOrientation.VERTICAL,
        		  true, true, false);
        
        RenderedImage  chartImage = chart.createBufferedImage(300, 300);
        ImageIO.write(chartImage, "png", os);
        os.flush();
        os.close();
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	
	private XYDataset createDataset() {
	    TimeSeriesCollection dataset = new TimeSeriesCollection();

	    TimeSeries series1 = new TimeSeries("Series1");
	    series1.add(new Day(1, 1, 2017), 50);
	    series1.add(new Day(2, 1, 2017), 40);
	    series1.add(new Day(3, 1, 2017), 45);
	    series1.add(new Day(4, 1, 2017), 30);
	    series1.add(new Day(5, 1, 2017), 50);
	    series1.add(new Day(6, 1, 2017), 45);
	    series1.add(new Day(7, 1, 2017), 60);
	    series1.add(new Day(8, 1, 2017), 45);
	    series1.add(new Day(9, 1, 2017), 55);
	    series1.add(new Day(10, 1, 2017), 48);
	    series1.add(new Day(11, 1, 2017), 60);
	    series1.add(new Day(12, 1, 2017), 45);
	    series1.add(new Day(13, 1, 2017), 65);
	    series1.add(new Day(14, 1, 2017), 45);
	    series1.add(new Day(15, 1, 2017), 55);
	    dataset.addSeries(series1);

	    TimeSeries series2 = new TimeSeries("Series2");
	    series2.add(new Day(1, 1, 2017), 40);
	    series2.add(new Day(2, 1, 2017), 35);
	    series2.add(new Day(3, 1, 2017), 26);
	    series2.add(new Day(4, 1, 2017), 45);
	    series2.add(new Day(5, 1, 2017), 40);
	    series2.add(new Day(6, 1, 2017), 35);
	    series2.add(new Day(7, 1, 2017), 45);
	    series2.add(new Day(8, 1, 2017), 48);
	    series2.add(new Day(9, 1, 2017), 31);
	    series2.add(new Day(10, 1, 2017), 32);
	    series2.add(new Day(11, 1, 2017), 21);
	    series2.add(new Day(12, 1, 2017), 35);
	    series2.add(new Day(13, 1, 2017), 10);
	    series2.add(new Day(14, 1, 2017), 25);
	    series2.add(new Day(15, 1, 2017), 15);
	    dataset.addSeries(series2);
	    

	    return dataset;
	  }
	
	
	
	
	
	
	
	
	
	
	
	

}
