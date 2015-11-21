import java.io.File;

/**
 * Create a mock directory containing the files : "hello", "hello.txt", "hello.class", ".classhello", "he.classllo", ".class"
 */
public class MockFile extends File {

	private static final long serialVersionUID = 6833759609396625529L;

	public MockFile() {
		super("");
	}
	
	@Override
	public String[] list(){
		String paths[] = {"hello", "hello.txt", "hello.class", ".classhello", "he.classllo", ".class"};
		return paths;
	}

}
