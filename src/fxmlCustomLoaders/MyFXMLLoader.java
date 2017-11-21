package fxmlCustomLoaders;

import java.lang.reflect.Field;
import java.util.Properties;

import javafx.fxml.FXMLLoader;
import javafx.util.Callback;

public class MyFXMLLoader extends FXMLLoader {
	
	private Properties props = new Properties();
	
	public MyFXMLLoader(String propsPath) {
		this();
		try {
			props.load(this.getClass().getResourceAsStream(propsPath));
		} catch (Exception e) {
			System.out.println("Cant load proprties file "+e.getMessage());
		}
		
		System.out.println(props.getProperty("str"));
	}
	
	public MyFXMLLoader() {
		
		this.setControllerFactory(new Callback<Class<?>, Object>() {
			
			public Object call(Class<?> cl) {
				
				try {
					System.out.println("Controller class: "+cl.getName());
					Object contrInstance = cl.newInstance();
					
					Field[] flds = cl.getDeclaredFields();
					for(Field field : flds) {
						if(field.isAnnotationPresent(MyInject.class)) {
							System.out.println("Annotated field: "+field.getName());
							
							if(field.getType().isPrimitive()) {
								
								System.out.println("Cant instantiate a primitive type: "+field.getType());
								
							} else if(props.containsKey(field.getName())) {
								
								field.setAccessible(true);
								field.set(contrInstance, props.getProperty(field.getName()));
								
							} else {
								
								Object injNewinst = field.getType().newInstance();
								
								boolean accessible = field.isAccessible();
								field.setAccessible(true);
				                field.set(contrInstance, injNewinst);
				                field.setAccessible(accessible);
							}
							
						}
						
					}
					
	            	return contrInstance;
	            	
		        } catch (InstantiationException | IllegalAccessException ex) {
		            throw new IllegalStateException("Cant instantiate a controller: " + cl, ex);
		        }
			}
		});

	}
	
}
