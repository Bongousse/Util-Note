package excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import excel.domain.BxmColumnDto;

public class ExcelImport {
	public List<BxmColumnDto> xlsxToBxmColumnDtoList() {
		List<BxmColumnDto> list = new ArrayList<BxmColumnDto>();

		FileInputStream fis = null;
		XSSFWorkbook workbook = null;
		try {
			fis = new FileInputStream("C:\\Users\\Yong\\Documents\\export.xlsx");

			// XSSFWorkbook은 엑셀 파일 전체 내용을 담고있는 객체
			workbook = new XSSFWorkbook(fis);

			// 탐색에 사용할 Sheet, Row, Cell 객체
			XSSFSheet curSheet;
			XSSFRow curRow;
			XSSFCell curCell;
			BxmColumnDto columnDto;

			// Sheet 탐색 for문
			for (int sheetIndex = 0; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
				// 현재 Sheet 반환
				curSheet = workbook.getSheetAt(sheetIndex);

				// row 탐색 for문
				for (int rowIndex = 0; rowIndex < curSheet.getPhysicalNumberOfRows(); rowIndex++) {
					// row 0은 헤더정보이기 때문에 무시

					if (rowIndex == 0)
						continue;

					curRow = curSheet.getRow(rowIndex);
					columnDto = new BxmColumnDto();
					String value;

					// row의 cell 탐색 for문
					for (int cellIndex = 0; cellIndex < curRow.getPhysicalNumberOfCells(); cellIndex++) {
						curCell = curRow.getCell(cellIndex);
						if(curCell == null)
							continue;

						value = "";
						// cell 스타일이 다르더라도 String으로 반환 받음
						switch (curCell.getCellTypeEnum()) {
						case STRING:
							value = curCell.getStringCellValue();
							break;
						case NUMERIC:
							value = curCell.getNumericCellValue() + "";
							break;
						default:
							value = new String();
							break;
						}

						// 현재 column index에 따라서 dto에 입력
						switch (cellIndex) {
						case 0: // pacakageName
							columnDto.setPackageName(value);
							break;
						case 1: // ommName
							columnDto.setOmmName(value);
							break;
						case 2: // superType
							columnDto.setSuperType(value);
							break;
						case 3: // ommDescription
							columnDto.setOmmDescription(value);
							break;
						case 4: // type
							columnDto.setType(value);
							break;
						case 5: // name
							columnDto.setName(value);
							break;
						case 6: // description
							columnDto.setDescription(value);
							break;
						case 7: // length
							columnDto.setLength(value);
							break;
						case 8: // decimal
							columnDto.setDecimal(value);
							break;
						case 9: // arrayReference
							columnDto.setArrayReference(value);
							break;
						case 10: // align
							columnDto.setAlign(value);
							break;
						case 11: // fill
							columnDto.setFill(value);
							break;
						case 12: // formatType
							columnDto.setFormatType(value);
							break;
						case 13: // format
							columnDto.setFormat(value);
							break;
						case 14: // locale
							columnDto.setLocale(value);
							break;
						case 15: // referenceType
							columnDto.setReferenceType(value);
							break;
						case 16: // comment
							columnDto.setComment(value);
							break;
						default:
							break;
						}
					}
					list.add(columnDto);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (workbook != null)
					workbook.close();
				if (fis != null)
					fis.close();
			} catch (IOException e) {

			}
		}

		return list;
	}

	public void printList(List<BxmColumnDto> list) {
		for (BxmColumnDto dto : list) {
			System.out.println(dto.toString());
		}
	}

	public static void main(String[] args) {
		ExcelImport excelImport = new ExcelImport();
		List<BxmColumnDto> list = excelImport.xlsxToBxmColumnDtoList();
		excelImport.printList(list);
	}
}
