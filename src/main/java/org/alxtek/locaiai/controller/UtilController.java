package org.alxtek.locaiai.controller;

import lombok.AllArgsConstructor;
import org.alxtek.locaiai.web.UtilsService;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.poi.ss.usermodel.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;


@RestController
@AllArgsConstructor
public class UtilController {

    private final UtilsService utilService;

    @GetMapping("/generate-excel")
    public ResponseEntity<byte[]> generateExcel(@RequestParam String className, @RequestParam int rowCount) throws IOException, IllegalAccessException, InstantiationException {
        Class<?> clazz = utilService.getClassByName(className);
        if (clazz == null) {
            return ResponseEntity.badRequest().body(null);
        }

        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet(className);

        // Création des en-têtes de colonne
        Row headerRow = sheet.createRow(0);
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            headerRow.createCell(i).setCellValue(fields[i].getName().toUpperCase());
        }

        Random random = new Random();
        for (int i = 1; i <= rowCount; i++) {
            Row row = sheet.createRow(i);
            Object instance = generateRandomInstance(clazz, random);
            for (int j = 0; j < fields.length; j++) {
                fields[j].setAccessible(true);
                Object value = fields[j].get(instance);
                if (value instanceof Number) {
                    row.createCell(j).setCellValue(((Number) value).doubleValue());
                } else {
                    row.createCell(j).setCellValue(Objects.toString(value, ""));
                }
            }
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        workbook.close();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=" + className + ".xlsx");

        return ResponseEntity.ok().headers(headers).body(outputStream.toByteArray());
    }

    private Object generateRandomInstance(Class<?> clazz, Random random) throws IllegalAccessException, InstantiationException {
        Object instance = clazz.newInstance();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.getType().equals(Long.class)) {
                field.set(instance, random.nextLong());
            } else if (field.getType().equals(String.class)) {
                field.set(instance, UUID.randomUUID().toString().substring(0, 8));
            } else if (field.getType().equals(Double.class)) {
                field.set(instance, random.nextDouble() * 100);
            }
        }
        return instance;
    }


}
