package _code_generation._ormclient.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import _code_generation._cons.CommonCons;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class BuilderIServiec {
	
	private static final String TEMPLATE_DIRECTORY;
	static {
		String path = BuilderIServiec.class.getResource("").getPath();
		int indexOf = path.indexOf("target/classes");
		if(indexOf > -1) {
			path = path.replaceAll("target/classes", "src/main/java");
		}
		TEMPLATE_DIRECTORY = path;
	}
	
	private static Configuration cfg;
	
	public static void main(String[] args) throws IOException {
		System.err.println(TEMPLATE_DIRECTORY);
		// 初始化FreeMarker配置  
        // 创建一个Configuration实例  
        cfg = new Configuration();  
        // 设置FreeMarker的模版文件位置  
        cfg.setDirectoryForTemplateLoading(new File(TEMPLATE_DIRECTORY));
        
        Map<String, Object> root = new HashMap<>();
        
        String service_name = "UserAcquire";
        String annotation = "用户获取欢乐券";
        root.put("project_name", CommonCons.PROJECT_NAME);
    	root.put("libmodel_name", "UserAcquireModel");  
        root.put("email", CommonCons.EMAIL);  
        root.put("date", CommonCons.getNow()); 
        root.put("service_name", service_name);
        root.put("annotation", annotation);
        String pack = "client/service";
        String fileName = "I" + service_name + "Service.java";  
        String savePath = TEMPLATE_DIRECTORY +  "/" + pack;
        Template template = cfg.getTemplate("IService.ftl");  
        String realSavePath = savePath;  
        File newsDir = new File(realSavePath);  
        if (!newsDir.exists()) {  
            newsDir.mkdirs();  
        }  
        try {  
            Writer out = new OutputStreamWriter(new FileOutputStream(newsDir+ "/"+ fileName), "UTF-8");  
            template.process(root, out);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
	}
	
	

}
