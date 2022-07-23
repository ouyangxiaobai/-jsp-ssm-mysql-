package cn.bjsxt.service;

import java.util.List;
import java.util.Map;

import cn.bjsxt.pojo.Car;

public interface CarService {
	public int addCar(Car car);

	public List<Car> findCar(Map map);

	public int deleteCarById(Map map);

	public Car findCarById(int carId);

	public int updateCar(Car car);

	public List<Car> findCarsType();

	public List<Car> findCarsBrand();

	public List<Car> findCarByType(String type);

	public List<Car> findCarByBrand(String brand);

	public List<Car> findCarsByPrice(Map map);

	public List<Car> findAllCars();

	public int changeRentFlag(int i);

	public Car findCarByNumber(String carNumber);

	public int changeFlagByNumber(Map<String, String> map);
}
