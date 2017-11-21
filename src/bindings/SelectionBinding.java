package bindings;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.paint.Color;

//Lighting has Light JavaFX Bean and Light has Color JavaFX Bean
public class SelectionBinding {

	public SelectionBinding() {
		
		ObjectProperty<Lighting> root = new SimpleObjectProperty<>(new Lighting());
		//Lighting root = new Lighting();
		
		//select can accept ObservableValue or Object as a root
		ObjectBinding<Color> selectBinding = Bindings.select(root, "light", "color");

		selectBinding.addListener(new ChangeListener<Color>() {
			@Override
			public void changed(ObservableValue<? extends Color> observableValue, Color oldValue, Color newValue) {
				System.out.println("The color has changed -> old = " + oldValue + ", new = " + newValue);
			}
		});
//		selectBinding.addListener( (e, oldValue, newValue) -> {
//			System.out.println("The color has changed -> old = " + oldValue + ", new = " + newValue);
//		});
		
		Light l1 = new Light.Point();
		l1.setColor(Color.BLACK);
		
		Lighting lg = new Lighting();
		lg.setLight(l1);
		
		//root.getLight().setColor(Color.RED);
		root.set(lg);
		
	}

	public static void main(String[] args) {
		new SelectionBinding();
	}

}