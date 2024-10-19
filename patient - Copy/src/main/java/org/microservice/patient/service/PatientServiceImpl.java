package org.microservice.patient.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService{
    private List<String> names = Arrays.asList("sameh", "ahmed", "alaa");
    @Override
    public String getPatientName(String name) {
        return names.stream()
                .filter(n -> n.equals(name))
                .findAny().orElse("Not patient Found");

    }
}
