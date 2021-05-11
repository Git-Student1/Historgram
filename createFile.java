import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class createFile {

	
	public static void main(String[] args) throws IOException {
		File file =new File("C://Users//User//Documents//Maximilian//Studium//2.Semester/Informatik 2//eclipse-workspace//Exercise_4_Histogram//src//testfile.txt");
		FileWriter writer = new FileWriter(file);
		writer.write("ho");
		writer.close();
	}
}
