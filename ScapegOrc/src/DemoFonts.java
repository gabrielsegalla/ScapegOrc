

import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;

public class DemoFonts {

	public static void main(String[] args) {
		try {
			Font f = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("fonts/alagard.ttf"))).deriveFont(Font.PLAIN,8);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}