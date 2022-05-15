package lt.cognizant.tms.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

import lt.cognizant.tms.entities.Task;



public class OpenCsvUtil {

	public static List<Task> parseCsvFile(InputStream is) {
		String[] CSV_HEADER = { "task_name","time_spent_on_task", "task_group","task_assignee","subtasks","is_task_finished_flag" };
		Reader fileReader = null;
		CsvToBean<Task> csvToBean = null;
	
		List<Task> task = new ArrayList<Task>();
		
		try {
			fileReader = new InputStreamReader(is);
	
			ColumnPositionMappingStrategy<Task> mappingStrategy = new ColumnPositionMappingStrategy<Task>();
	
			mappingStrategy.setType(Task.class);
			mappingStrategy.setColumnMapping(CSV_HEADER);
	
			csvToBean = new CsvToBeanBuilder<Task>(fileReader).withMappingStrategy(mappingStrategy).withSkipLines(1)
					.withIgnoreLeadingWhiteSpace(true).build();
	
			task = csvToBean.parse();
			
			return task;
		} catch (Exception e) {
			System.out.println("Reading CSV Error!");
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				System.out.println("Closing fileReader/csvParser Error!");
				e.printStackTrace();
			}
		}
		
		return task;
	}

	public static void customersToCsv(Writer writer, List<Task> task) {
		String[] CSV_HEADER = { "task_name","time_spent_on_task", "task_group","task_assignee","subtasks","is_task_finished_flag" };
	    
	    StatefulBeanToCsv<Task> beanToCsv = null;
	 
	    try {
	      // write List of Objects
	      ColumnPositionMappingStrategy<Task> mappingStrategy = 
	                new ColumnPositionMappingStrategy<Task>();
	      
	      mappingStrategy.setType(Task.class);
	      mappingStrategy.setColumnMapping(CSV_HEADER);
	      
	      beanToCsv = new StatefulBeanToCsvBuilder<Task>(writer)
	          .withMappingStrategy(mappingStrategy)
	                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
	                    .build();
	 
	      beanToCsv.write(task);
	    } catch (Exception e) {
	      System.out.println("Writing CSV error!");
	      e.printStackTrace();
	    }
	}
}