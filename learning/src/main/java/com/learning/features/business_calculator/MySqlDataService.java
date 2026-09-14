package com.learning.features.business_calculator;

import org.springframework.stereotype.Repository;

//@Component
@Repository
public class MySqlDataService implements DataService {

	@Override
	public int[] retrieveData() {
		return new int[] { 1, 2, 3, 4, 5 };
	}

}