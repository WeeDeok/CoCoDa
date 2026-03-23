package com.CoCoDa.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.CoCoDa.repository.OfferDao;
import com.CoCoDa.Constant.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfferService {
    
	@Autowired	
    private OfferDao dao;

    public ArrayList<HashMap<String, Object>> offer(int sigungu_cd,String sales_divison_s_cd) {
		if (sales_divison_s_cd == null) {
			throw new IllegalArgumentException(ErrorMessage.SALES_DIVISON_S_CD_CANNOT_BE_NULL.getMessage());
		}
		ArrayList<HashMap<String, Object>> result = new ArrayList<>();
		
		result = dao.selectoffer(sigungu_cd, sales_divison_s_cd);
		
		return result;
		
	}

    public ArrayList<HashMap<String, Object>> mapsousa(int sigungu_cd, String sales_divison_s_cd) {
		if (sales_divison_s_cd == null) {
			throw new IllegalArgumentException(ErrorMessage.SALES_DIVISON_S_CD_CANNOT_BE_NULL.getMessage());
		}
		ArrayList<HashMap<String, Object>> result = new ArrayList<>();
		
		result = dao.selectoffer(sigungu_cd, sales_divison_s_cd);

		return result;

	}

}
