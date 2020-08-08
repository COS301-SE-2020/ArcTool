/**
 * A console application that tests the UnzipUtility class
 *
 * 
 *
 */
public class UnzipUtilityTest {

	public static void main(String[] args) {
		String zipFilePath = "C:/Users/user/Desktop/zipping/ArcTool-New_MVC.zip";
		String destDirectory = "C:/Users/user/Desktop/zipping";
		UnzipUtility unzipper = new UnzipUtility();

		try {
			unzipper.unzip(zipFilePath, destDirectory);
		} catch (Exception ex) {
			// some errors occurred
			ex.printStackTrace();
		}
	}

}
