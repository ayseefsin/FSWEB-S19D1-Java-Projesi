package com.workintech.Sp19d1.dto;

import com.workintech.Sp19d1.entity.Actor;

import java.time.LocalDate;
import java.util.List;

public record MovieResponse(long id , String name, String directorName) {
}
