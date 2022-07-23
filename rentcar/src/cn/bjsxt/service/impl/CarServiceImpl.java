package cn.bjsxt.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjsxt.mapper.CarMapper;
import cn.bjsxt.pojo.Car;
import cn.bjsxt.service.CarService;

@Service
public class CarServiceImpl implements CarService {
	@Autowired
	private CarMapper carMapper;
	
	@Override
	public List<Car> findAllCars() {
		return carMapper.findAllCars();
	}

	@Override
	public int addCar(Car car) {
		return carMapper.addCar(car);
	}

	@Override
	public List<Car> findCar(Map map) {
		// TODO Auto-generated method stub
		return carMapper.selectCar(map);
	}

	@Override
	public int deleteCarById(Map map) {
		return carMapper.deleteCarById(map);
	}

	@Override
	public Car findCarById(int carId) {
		return carMapper.selectCarById(carId);
	}

	@Override
	public int updateCar(Car car) {
		return carMapper.updateCar(car);
	}

	@Override
	public List<Car> findCarsType() {
		return carMapper.selectCarsType();
	}

	@Override
	public List<Car> findCarsBrand() {
		return carMapper.selectCarsBrand();
	}

	@Override
	public List<Car> findCarByType(String type) {
		return carMapper.findCarByType(type);
	}

	@Override
	public List<Car> findCarByBrand(String brand) {
		return carMapper.findCarByBrand(brand);
	}

	@Override
	public List<Car> findCarsByPrice(Map map) {
		return carMapper.findCarsByPrice(map);
	}


	@Override
	public int changeRentFlag(int i) {
		return carMapper.updateRentFlag(i);
	}

	@Override
	public Car findCarByNumber(String carNumber) {
		return carMapper.findCarByNumber(carNumber);
	}

	@Override
	public int changeFlagByNumber(Map<String, String> map) {
		return carMapper.changeFlagByNumber(map);
	}

}
