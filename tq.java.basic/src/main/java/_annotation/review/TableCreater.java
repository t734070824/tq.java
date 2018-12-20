package _annotation.review;


import _annotation.Constraints;
import _annotation.DBTable;
import _annotation.SQLInteger;
import _annotation.SQLString;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class TableCreater {

	
	public static void main(String[] args) throws ClassNotFoundException {
		String[] className = new String[]{"_annotation.Member"};
		printSql(className);
	}

	private static void printSql(String[] className) throws ClassNotFoundException {
		
		for (String cn : className) {
			Class<?> c1 = Class.forName(cn);
			DBTable annotation = c1.getAnnotation(DBTable.class);
			if(annotation == null){
				System.err.println("No DbTable annotation " + cn);
				continue;
			}
			
			String tableName = annotation.name();
			if(tableName.length() < 1) 
				tableName = c1.getName().toUpperCase();
			
			List<String> columnDefs = new ArrayList<>();
			for(Field field : c1.getDeclaredFields()){
				String columnName = null;
				Annotation[] declaredAnnotations = field.getDeclaredAnnotations();
				if(declaredAnnotations.length < 1){
					continue;
				}
				if(declaredAnnotations[0] instanceof SQLInteger){
					SQLInteger sInt = (SQLInteger) declaredAnnotations[0];
					if(sInt.name().length() < 1){
						columnName = field.getName().toUpperCase();
					} else {
						columnName = sInt.name();
					}
					columnDefs.add(columnName + " INT "  + getConstraints(sInt.constraints()));
				}
				
				if(declaredAnnotations[0] instanceof SQLString){
					SQLString sStr = (SQLString) declaredAnnotations[0];
					if(sStr.name().length() < 1){
						columnName = field.getName().toUpperCase();
					} else {
						columnName = sStr.name();
					}
					columnDefs.add(columnName + " varchar(" + sStr.value() + ") " + getConstraints(sStr.constraints()));
				}
			}
			
			
			StringBuilder createCommand = new StringBuilder();
			createCommand.append("create table ").append(tableName).append(" (");
			for(String comm : columnDefs){
				createCommand.append("\n " + comm + " ,");
			}
			String createtable = createCommand.substring(0, createCommand.length() - 1) + ");";
			System.err.println("create table sql : \n" + createtable);
		}
		
		
	}

	private static String getConstraints(Constraints con) {
		String constraints = "";
		if(!con.allowNull())
			constraints = " NOT NULL";
		if(con.primaryKey())
			constraints = " primary key";
		if(con.unique())
			constraints = " unique";
		return constraints;
	}
	

}
