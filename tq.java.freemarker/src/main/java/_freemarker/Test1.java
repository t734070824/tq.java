package _freemarker;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class Test1 {
	
	public static void main(String[] args) throws IOException, TemplateException {
		//创建Freemarker配置实例
		Configuration cfg = new Configuration();
		cfg.setDirectoryForTemplateLoading(new File("src/main/java/_freemarker"));
		
		//创建数据模型
		Map<String,	Object> root = new HashMap<>();
		Map<String,	String> data = new HashMap<>();
		data.put("1", "123");
		data.put("2", "123");
        root.put("user", data);
        
        //加载模板文件
        Template t1 = cfg.getTemplate("a.ftl");
        
        //显示生成的数据,//将合并后的数据打印到控制台
        Writer out = new OutputStreamWriter(System.out); 
        t1.process(root, out);
        out.flush();
		
	}

}
