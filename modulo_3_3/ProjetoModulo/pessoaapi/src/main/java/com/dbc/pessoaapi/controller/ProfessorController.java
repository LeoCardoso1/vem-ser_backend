package com.dbc.pessoaapi.controller;


import com.dbc.pessoaapi.entity.ProfessorEntity;
import com.dbc.pessoaapi.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Validated
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/professor")
public class ProfessorController {
    private final ProfessorRepository professorRepository;

    @PostMapping("/criar")
    public ProfessorEntity create(@Valid @RequestBody ProfessorEntity professorEntity){
        return professorRepository.save(professorEntity);
    }

    @GetMapping("/listar")
    public List<ProfessorEntity> list(){
        return professorRepository.findAll()
                .stream()
                .collect(Collectors.toList());
    }


}
