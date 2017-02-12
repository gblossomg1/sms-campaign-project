package com.concreteitsolutions.generic.externaldata.excel;


import com.concreteitsolutions.generic.externaldata.ExternalDataDao;
import com.concreteitsolutions.generic.externaldata.exceptions.ExternalDataTechnicalException;
import com.concreteitsolutions.generic.externaldata.model.ExternalData;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class ExcelExternalDataDaoImpl implements ExternalDataDao {

    public List<ExternalData> retrieveExternalDataFromExternalFile(InputStream inputStream) {

        XSSFRow row;
        List<ExternalData> excelDataList = new ArrayList<ExternalData>();
        XSSFWorkbook workBook;

        try {
            workBook = new XSSFWorkbook(inputStream);

            XSSFSheet spreadSheet = workBook.getSheetAt(0);

            Iterator<Row> rowIterator = spreadSheet.rowIterator();

            while (rowIterator.hasNext()) {
                row = (XSSFRow) rowIterator.next();
                ExternalData excelData = new ExternalData();
                Iterator<Cell> cellIterator = row.cellIterator();
                Integer position = 1;
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    if (cell.getCellType() != Cell.CELL_TYPE_STRING) {
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                    }
                    excelData.setValue(cell.getStringCellValue(), position);
                    position++;
                }
                excelDataList.add(excelData);
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new ExternalDataTechnicalException(ExternalDataTechnicalException.ExternalDataError.FILE_INPUT_ERROR);
        }

        return excelDataList;
    }

}
