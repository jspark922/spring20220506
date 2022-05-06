package lecture.c08core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Setter;

@Component
public class Car {
	@Setter
	private Engine engine;
	
	@Autowired
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	public void go() {
		engine.action();
	}
}
