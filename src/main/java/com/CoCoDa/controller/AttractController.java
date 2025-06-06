package com.CoCoDa.controller;

import java.util.HashMap;

import org.json.JSONArray;
import com.CoCoDa.repository.AttractDao;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/attract") // 공통 경로
public class AttractController {

    @Autowired
    private final AttractDao dao;

    public AttractController(AttractDao dao) {
        this.dao = dao;
    }

    @GetMapping("/select")
    public JSONArray selectAttraction(@RequestParam int sigungu_cd) {
        return dao.selectattraction(sigungu_cd);
    }

    @GetMapping("/subway")
    public JSONArray bringSubway(@RequestParam double wgsx, @RequestParam double wgsy) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("wgsx", wgsx);
        params.put("wgsy", wgsy);

        return dao.selectsubway(params);
    }
        
}
