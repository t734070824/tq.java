package _etl_orm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class MainServerFreeMarkerUtil {
	
    private Configuration cfg;  
    
    public void init() throws Exception {  
        // 初始化FreeMarker配置  
        // 创建一个Configuration实例  
        cfg = new Configuration();  
        // 设置FreeMarker的模版文件位置  
        cfg.setDirectoryForTemplateLoading(new File("src/main/java/_etl_orm"));
    } 
    
    
    public void process(MainServerFreeMarkerUtil hf) throws Exception {
//    	Map root = new HashMap();
//    	
//    	List<ServiceNameModel> service_list = new ArrayList<>();
//    	service_list.add(new ServiceNameModel("Test1Sevice", "TEST_1_SEVICE"));
//    	service_list.add(new ServiceNameModel("Test2Sevice", "TEST_2_SEVICE"));
//    	
//    	
//    	Date date = new Date();  
//    	String project_name = "coupon";
//    	root.put("project_name", project_name);
//    	root.put("service_list", service_list);  
//        root.put("email", "tq@108.com");  
//        root.put("date", date);  
//  
//        String fileName = "MainServer.java";  
//        String savePath = "src/main/java/_etl_orm/src/main/java/dc/orm/" + project_name + "/server";
//        Template template = cfg.getTemplate("MainServer.ftl");  
//        hf.buildTemplate(root, savePath, fileName, template);
    }
    
    public void buildTemplate(Map<?, ?> root, String savePath,  
            String fileName, Template template) {  

  
        String realSavePath = savePath;  
  
        File newsDir = new File(realSavePath);  
        if (!newsDir.exists()) {  
            newsDir.mkdirs();  
        }  
  
        try {  
            // SYSTEM_ENCODING = "UTF-8";  
            Writer out = new OutputStreamWriter(new FileOutputStream(newsDir+ "/" + fileName), "UTF-8");  
  
            template.process(root, out);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
  
    } 
    
    public static void main(String[] args) throws Exception {
    	MainServerFreeMarkerUtil util = new MainServerFreeMarkerUtil();
    	util.init();
    	util.process(util);
	}


}
