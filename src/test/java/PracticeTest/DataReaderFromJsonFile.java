package PracticeTest;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReaderFromJsonFile {
	
	
	public List<HashMap<String, String>> getDatafromJsonFile() throws IOException {
		
		//Converting Data in JSON file into a String Variable
		
		String jsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\test\\java\\PracticeTest\\LoginCredentials.json"));
		
		//Converting JSON content into HASHMAP Using External Dependency in POM - Jackson DataBind
		
		ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {});
        
        return data;
		
		
	}

}
