package com.CoCoDa.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.CoCoDa.repository.OfferDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfferService {
    
	@Autowired	
    private OfferDao dao;

    public ArrayList<HashMap<String, Object>> offer(int sigungu_cd,String sales_divison_s_cd) {
		
		ArrayList<HashMap<String, Object>> result = new ArrayList<>();
		
		result = dao.selectoffer(sigungu_cd, sales_divison_s_cd);
		
		return result;
		
	}

    public ArrayList<HashMap<String, Object>> mapsousa(int sigungu_cd, String sales_divison_s_cd) {
		
		ArrayList<HashMap<String, Object>> result = new ArrayList<>();
		
		result = dao.selectoffer(sigungu_cd, sales_divison_s_cd);

		return result;

	}

}
