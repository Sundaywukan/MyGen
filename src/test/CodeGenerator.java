package test;

import java.io.IOException;

import freemarker.template.TemplateException;
import gen.Gen;

public class CodeGenerator {

    public static void main(String[] args) {
        try {
			new Gen("zzzz", "Zzzz").gen();
		} catch (IOException | TemplateException e) {
			e.printStackTrace();
		};
    }

   
}
