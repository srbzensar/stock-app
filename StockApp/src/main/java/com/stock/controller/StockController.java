package com.stock.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stock.dto.StockDto;

@RestController
@RequestMapping("/zenstockapp")
public class StockController {

	@GetMapping(value="/stock/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StockDto> getStockById(@PathVariable("id") int stockId) {
		return new ResponseEntity<StockDto>(stocks.stream().filter(stock->stock.getId()==stockId).findAny().get(), HttpStatus.OK);
	}
	
	
	@GetMapping(value="/stocks", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<StockDto>> getAllStocks() {
		return new ResponseEntity<List<StockDto>>(stocks, HttpStatus.OK);
	}
	
	private static List<StockDto> stocks = new ArrayList<>();
	
	static {
		stocks.add(new StockDto(1, "TCS", "BSE", 12000));
		stocks.add(new StockDto(2, "Reliance", "NSE", 5000));
		stocks.add(new StockDto(3, "Zensar", "BSE", 19000));
	}
	
	
}
