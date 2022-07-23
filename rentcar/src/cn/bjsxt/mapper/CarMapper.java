package cn.bjsxt.mapper;

import java.util.List;
import java.util.Map;

import cn.bjsxt.pojo.Car;

public interface CarMapper {
	public int addCar(Car car);

	public List<Car> selectCar(Map map);

	public int deleteCarById(Map map);

	public Car selectCarById(int carId);

	public int updateCar(Car car);

	public List<Car> findCarsInfo();

	public List<Car> selectCarsType();

	public List<Car> selectCarsBrand();

	public List<Car> findCarByType(String type);

	public List<Car> findCarByBrand(String brand);

	public List<Car> findCarsByPrice(Map map);

	public List<Car> findAllCars();

	public int updateRentFlag(int i);
	
	public int updateRentFlagByNo(String number);

	public Car findCarByNumber(String carNumber);

	public int changeFlagByNumber(Map<String, String> map);
}
