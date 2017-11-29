package test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.config.TableConfiguration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import freemarker.template.TemplateException;
import gen.Gen;

public class CodeGenerator {

    public static void main(String[] args) throws URISyntaxException, IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {
		List<String> warnings = new ArrayList<String>();
		File configFile = new File(CodeGenerator.class.getResource("/generatorConfig.xml").toURI());
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		//修行不够 只能通过投机取巧的办法实现
		
		List<Context> contexts = config.getContexts();
		//获取packageNamePath
		//这代码真是丑陋
		String packageNamePath="";
		for(Context context:contexts) {
			String s = context.getJavaClientGeneratorConfiguration().getTargetPackage();
			String sqlUrl=context.getJdbcConnectionConfiguration().getConnectionURL();
			String sqlDriver=context.getJdbcConnectionConfiguration().getDriverClass();
			String sqlUsername=context.getJdbcConnectionConfiguration().getUserId();
			String sqlPassword=context.getJdbcConnectionConfiguration().getPassword();
			String[] s1 = s.split(".mapper");
		    for(String s11:s1) {
		    	packageNamePath=s11;
		    }
		    List<TableConfiguration> tables = context.getTableConfigurations();
		    for(TableConfiguration table:tables) {
		    	String domainObjectName=table.getDomainObjectName();
		    	try {
					new Gen(domainObjectName.substring(0, 1).toLowerCase()+domainObjectName.substring(1), domainObjectName,domainObjectName,packageNamePath,packageNamePath.replace(".", "/"),sqlUrl,sqlDriver,sqlUsername,sqlPassword).gen();
				} catch (IOException | TemplateException e) {
					e.printStackTrace();
				};
		    }
		}

		DefaultShellCallback shellCallback = new DefaultShellCallback(true);

		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, shellCallback, warnings);

		myBatisGenerator.generate(null);

		System.out.println(warnings);
    }

}
