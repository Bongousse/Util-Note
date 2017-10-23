package excel;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import bxt.msgp.util.LayoutBuilder;
import bxt.utils.DateTimeUtils;
import bxt.utils.StringUtils;
import constant.IConstant;
import excel.domain.BxmColumnDto;
import excel.domain.BxtMsgLayoutDto;

public class LayoutMigration {

	private final String[] STRING_TYPE_LIST = { "String", "Character", "Date" };
	private final String[] NUMBER_TYPE_LIST = { "Integer", "BigDecimal", "Short", "Long", "BigInteger", "Float",
			"Double" };
	private final String[] UNSUPPORTED_TYPE_LIST = { "Boolean", "Double" };

	private final String CAT_CLCF = "BXM OMM Migration";
	private final String USER_ID = "sysadmin";

	public void layoutMigration(List<BxmColumnDto> list) throws Exception {
		String layoutId = list.get(0).getOmmName();

		BxtMsgLayoutDto layoutDto = new BxtMsgLayoutDto();
		layoutDto.setLayoutId(layoutId);
		layoutDto.setLayoutNm(layoutId);
		layoutDto.setCatClcf(CAT_CLCF);
		String dttm = DateTimeUtils.instance().getDateTimeMilFormat();
		layoutDto.setRegUserId(USER_ID);
		layoutDto.setRegDttm(dttm);
		layoutDto.setLastUpdtUserId(USER_ID);
		layoutDto.setLastUpdtDttm(dttm);

		LayoutBuilder layout = new LayoutBuilder();
		layout.start(layoutId);

		for (BxmColumnDto column : list) {

			layout.appendField(column.getName());

			String type = null;
			boolean isRef = false;

			if (column.getType() == null || column.getType().isEmpty()) {
				throw new Exception("unknown type. name:" + column.getName());
			} else if (Arrays.asList(STRING_TYPE_LIST).contains(column.getType())) {
				type = "string";
			} else if (Arrays.asList(NUMBER_TYPE_LIST).contains(column.getType())) {
				type = "number";
			} else if (Arrays.asList(UNSUPPORTED_TYPE_LIST).contains(column.getType())) {
				// TODO 에러처리
			} else {
				type = "reference";
				isRef = true;
			}

			layout.setFieldType(type);
			layout.setFieldDesc(column.getDescription());
			layout.setFieldLength(Integer.valueOf(column.getLength()));
			layout.setFieldDecimal(Integer.valueOf(column.getDecimal()));

			if (column.getArrayReference() != null && !StringUtils.instance().isEmpty(column.getArrayReference())) {
				layout.setFieldArray(column.getArrayReference());
			}

			if (isRef) {
				String refLayoutId = getLastSplittedString(column.getType(), IConstant.LAYOUT_DELIMETER);
				layout.setFieldRefId(refLayoutId);
			} else {
				layout.setFieldRefId("");
			}

			layout.endField();
		}
		layout.end();

		layoutDto.setLayoutData(layout.toString().getBytes());

		// if (bxtMsgLayout.getDetail(cutMsgLayoutId) != null) {
		// logger.info("Updating....{}", bxtMsgDto);
		// bxtMsgLayout.update(bxtMsgDto);
		// } else {
		// logger.info("Inserting....{}", bxtMsgDto);
		// bxtMsgLayout.add(bxtMsgDto);
		// }
	}

	private String getLastSplittedString(String str, String delimeter) {
		String[] splitted = str.split(Pattern.quote(delimeter));
		return splitted[splitted.length - 1];
	}

}
