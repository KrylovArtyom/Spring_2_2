package web.service;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarServiceImpl implements CarService{

	private static final List<Car> carList = new ArrayList<>();

	static {
		carList.add(new Car("Toyota", "Camry", (short) 2021));
		carList.add(new Car("Toyota", "Fortuner", (short) 2017));
		carList.add(new Car("Toyota", "150", (short) 2000));
		carList.add(new Car("Toyota", "300", (short) 2021));
		carList.add(new Car("Toyota", "Prada", (short) 2005));
	}

	@Override
	public List<Car> getCars(int count) {
		return (count == 0) ? carList : carList.subList(0, count);
	}
}
