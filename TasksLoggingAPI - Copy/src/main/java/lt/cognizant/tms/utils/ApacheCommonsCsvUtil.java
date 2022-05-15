package lt.cognizant.tms.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.CSVParser;

import lt.cognizant.tms.entities.Task;



public class ApacheCommonsCsvUtil {
	private static String csvExtension = "csv";
	
	public static void customersToCsv(Writer writer, List<Task> tasks) throws IOException {

		try (CSVPrinter csvPrinter = new CSVPrinter(writer,
				CSVFormat.DEFAULT.withHeader("task_name","time_spent_on_task", "task_group","task_assignee","subtasks","is_task_finished_flag"));) {
			for (Task task : tasks) {
				List<Object> data = Arrays.asList(
									task.getTask_name(),
									task.getTime_spent_on_task(),
									task.getTask_group(),
									task.getTask_assignee(),
									task.getSubtasks(),
									task.getIs_task_finished_flag()
									

						);

				csvPrinter.printRecord(data);
			}
			csvPrinter.flush();
		} catch (Exception e) {
			System.out.println("Writing CSV error!");
			e.printStackTrace();
		}
	}
	
	public static List<Task> parseCsvFile(InputStream is) {
		BufferedReader fileReader = null;
		CSVParser csvParser = null;

		List<Task> task = new ArrayList<Task>();

		try {
			fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			csvParser = new CSVParser();
			
			@Deprecated
			Iterable<CSVRecord> csvRecords = CSVFormat.RFC4180
					.withFirstRecordAsHeader()
					.withIgnoreHeaderCase()
					.withTrim()
					.withHeader("task_name","time_spent_on_task", "task_group","task_assignee","subtasks","is_task_finished_flag")
					.parse(fileReader);
			

			
			CSVFormat csvFormat = CSVFormat.DEFAULT;

			for (CSVRecord csvRecord : csvRecords) {
//				

				Task task1 = new Task(
						csvRecord.get("task_name"),
						csvRecord.get("time_spent_on_task"),
						csvRecord.get("task_group"),
						csvRecord.get("task_assignee"),
						csvRecord.get("subtasks"),
						Boolean.parseBoolean(csvRecord.get("is_task_finished_flag"))
								
								);
				
				task.add(task1);
			}

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
	
	public static boolean isCSVFile(MultipartFile file) {
		String extension = file.getOriginalFilename().split("\\.")[1];
		
		if(!extension.equals(csvExtension)) {
			return false;
		}
		
		return true;
	}

}
