package lt.cognizant.tms.services;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.cognizant.tms.entities.Task;
import lt.cognizant.tms.repositories.TaskRepository;
import lt.cognizant.tms.utils.ApacheCommonsCsvUtil;


@Service
public class CsvFileServices {
	
	@Autowired
	TaskRepository taskRepository;

	// Store Csv File's data to database
	public void store(InputStream file) {
		try {
			// Using ApacheCommons Csv Utils to parse CSV file
			List<Task> lstTasks = ApacheCommonsCsvUtil.parseCsvFile(file);
			
			// Using OpenCSV Utils to parse CSV file
			// List<Customer> lstCustomers = OpenCsvUtil.parseCsvFile(file);
			
			// Save customers to database
			taskRepository.saveAll(lstTasks);
		} catch(Exception e) {
			throw new RuntimeException("FAIL! -> message = " + e.getMessage());
		}
	}
	
	// Load Data to CSV File
    public void loadFile(Writer writer) throws IOException {
    	try {
        	List<Task> tasks = (List<Task>) taskRepository.findAll();
        	
        	// Using ApacheCommons Csv Utils to write Customer List objects to a Writer
             ApacheCommonsCsvUtil.customersToCsv(writer, tasks);
        	
        	// Using Open CSV Utils to write Customer List objects to a Writer
        	// OpenCsvUtil.customersToCsv(writer, customers);    		
    	} catch(Exception e) {
    		throw new RuntimeException("Fail! -> Message = " + e.getMessage());
    	}
    }
}