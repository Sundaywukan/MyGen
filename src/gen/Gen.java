/**   
 * @Title: Gen.java 
 * @Package gen 
 * @Description: TODO
 * @author wk 
 * @date Sep 13, 2017 9:29:02 AM 
 * @version V1.0   
 */
package gen;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import test.DatebaseConn;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

/**
 * @className:Gen.java
 * @author: wk
 * @date Sep 13, 2017 9:29:02 AM
 * @version:v1.0
 * @description:TODO
 */
public class Gen {

	private String curDir;

	private String templetDir;

	private String serviceName;

	private String serviceImplName;

	private String controllerName;

	private String mapperName;

	private String className;

	private String modelName;

	private String PACKNAME;

	private String PACKNAME_PATH;
	
	private String mappingPath;

	public Gen(String modelName, String calssName, String mappingPath,String packName, String packageNamePath) {
		this.curDir = System.getProperty("user.dir");
		// 把路径中\转为/
		this.curDir = this.curDir.replace('\\', '/');
		this.templetDir = this.curDir + "/src/templet";

		// 设置各类名称
		this.modelName = modelName;
		serviceName = calssName + "Service";
		serviceImplName = calssName + "ServiceImpl";
		controllerName = calssName + "Controller";
		mapperName = calssName + "Mapper";
		className = calssName;

		this.PACKNAME = packName;
		this.PACKNAME_PATH = packageNamePath;
		
		this.mappingPath =mappingPath;
	}

	public void gen() throws IOException, TemplateException {
		// 需要的数据
		Map<String, Object> root = new HashMap<String, Object>();
		// 生成service
		root.put("packageName", PACKNAME);
		root.put("modelName", modelName);
		root.put("serviceName", serviceName);
		root.put("className", className);
		root.put("author", "wuk");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd hh:mm");
		root.put("createDate", sdf.format(new Date()));
		String fileName = curDir + "/src/" + PACKNAME_PATH + "/service/" + modelName;
		String template = "Service.ftl";
		mkFile(fileName, root, template, serviceName + ".java");

		// 生成serviceImpl
		root.clear();
		root.put("packageName", PACKNAME);
		root.put("modelName", modelName);
		root.put("className", className);
		root.put("classVar", className.substring(0, 1).toLowerCase() + className.substring(1));
		root.put("serviceImplName", serviceImplName);
		root.put("serviceName", serviceName);
		root.put("mapperName", mapperName);
		root.put("mapperVar", mapperName.substring(0, 1).toLowerCase() + mapperName.substring(1));
		root.put("author", "wuk");
		root.put("createDate", sdf.format(new Date()));
		fileName = curDir + "/src/" + PACKNAME_PATH + "/service/impl/" + modelName;
		template = "ServiceImpl.ftl";
		mkFile(fileName, root, template, serviceImplName + ".java");

		// 生成Controller
		root.clear();
		root.put("mappingPath", mappingPath);
		root.put("packageName", PACKNAME);
		root.put("controllerName", controllerName);
		root.put("author", "wuk");
		root.put("createDate", sdf.format(new Date()));
		root.put("serviceName", serviceName);
		root.put("serviceVar", serviceName.substring(0, 1).toLowerCase() + serviceName.substring(1));
		root.put("modelName", modelName);
		root.put("className", className);
		fileName = curDir + "/src/" + PACKNAME_PATH + "/controller/" + modelName;
		template = "Controller.ftl";
		mkFile(fileName, root, template, controllerName + ".java");

		// 生成Mapper
		root.clear();
		root.put("packageName", PACKNAME);
		root.put("author", "wuk");
		root.put("createDate", sdf.format(new Date()));
		root.put("modelName", modelName);
		root.put("mapperName", mapperName);
		root.put("className", className);
		fileName = curDir + "/src/" + PACKNAME_PATH + "/mapper/" + modelName;
		template = "Mapper.ftl";
		mkFile(fileName, root, template, mapperName + ".java");

		// 生成Req
		root.clear();
		root = new DatebaseConn().BuilMap(root);
		root.put("packageName", PACKNAME);
		root.put("author", "wuk");
		root.put("modelName", modelName);
		root.put("createDate", sdf.format(new Date()));
		root.put("className", className + "CreateReq");
		fileName = curDir + "/src/" + PACKNAME_PATH + "/vo/req/" + modelName;
		template = "CreateReq.ftl";
		mkFile(fileName, root, template, className + "CreateReq" + ".java");
		root.clear();
		root = new DatebaseConn().BuilMap(root);
		root.put("packageName", PACKNAME);
		root.put("author", "wuk");
		root.put("modelName", modelName);
		root.put("createDate", sdf.format(new Date()));
		root.put("className", className + "UpdateReq");
		fileName = curDir + "/src/" + PACKNAME_PATH + "/vo/req/" + modelName;
		template = "CreateReq.ftl";
		mkFile(fileName, root, template, className + "UpdateReq" + ".java");

		System.out.println("gen code success!");
	}

	public void mkFile(String fileName, Map<String, Object> root, String template, String className)
			throws TemplateException, IOException {
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
		// 设置引用模板地址
		try {
			cfg.setDirectoryForTemplateLoading(new File(templetDir));
		} catch (Exception e) {
			e.printStackTrace();
		}
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		Template temp = cfg.getTemplate(template);
		File dir = new File(fileName);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		OutputStream fos = new FileOutputStream(new File(dir, className)); // java文件的生成目录
		Writer out = new OutputStreamWriter(fos);
		temp.process(root, out);
		fos.flush();
		fos.close();
		System.out.println("生成" + className + "成功!");
	}
}
