package com.prototype.api.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prototype.domain.service.DanfeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("danfe")
@RequiredArgsConstructor
public class ApiController {

    private final DanfeService danfeService;

    @GetMapping("gerate")
    public void gerarRelatorio(HttpServletResponse response) {
        danfeService.gerarDanfe(response);
    }


}
