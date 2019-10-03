package com.aplus.gaming.schedular.utils.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class PatternUtil {

    /**
     * 发票扫描—匹配指定范围内的数字和"."
     */
    public static final Pattern SCAN_MATCHNUMBER = Pattern.compile("[^0-9\\.\\-]");
    /**
     * 数字0-9
     */
    public static final Pattern NUMBER = Pattern.compile("[0-9]*");

    /**
     * Init—用于判断字符串是否为数字的方法
     */
    public static final Pattern INIT_PATTERNNUMBER = Pattern.compile("^-?[\\d]*[.]?[\\d]*");

    /**
     * 财务初始化-广东地区校验字符串是否是数字
     */
    public static final Pattern CWCSH_PATTERN_GDDQ_IS_NUM = Pattern.compile("^-?[\\d]*[-]?[.]?[\\d]*");
    /**
     * 财务初始化-校验字符串是否是数字
     */
    public static final Pattern Cwcsh_PatternNumber = Pattern.compile("-?[0-9]+.*[0-9]*");
    /**
     * 财务初始化-校验字符串是否是整数
     */
    public static final Pattern CWCSH_PATTERN_INTEGER = Pattern.compile("^\\d+$|-\\d+$");
    /**
     * 财务初始化-校验字符串是否为小数 ，包含正负
     */
    public static final Pattern CWCSH_PATTERN_DECIMAL = Pattern.compile("\\d+\\.\\d+$|-\\d+\\.\\d+$");


    /**
     * 报表--查看是否包含[]内容
     */
    public static final Pattern Rpt_ContainBracket = Pattern.compile("\\[.*?\\]");

    /**
     * 报表--小数正则表达式
     */
    public static final Pattern Rpt_DecimalRegex = Pattern.compile("[-|0-9]*\\.[0-9]{1,}");

    /**
     * 报表--整数正则表达式
     */
    public static final Pattern Rpt_IntegerRegex = Pattern.compile("[-|0-9]*");


    /**
     * 报表--包含SumF正则表达式
     */
    public static final Pattern Rpt_ContainSumF = Pattern.compile("SumF\\(.*?\\)");


    /**
     * 报表--包含分号
     */
    public static final Pattern Rpt_ContainComma = Pattern.compile("\\'.*?\\'");


    /**
     * 判断是否为整数，包含正负
     */
    public static final Pattern DIGITAL = Pattern.compile("^\\d+$|-\\d+$");

    /**
     * 判断是否为小数 ，包含正负
     */
    public static final Pattern NUMBER_DOT = Pattern.compile("\\d+\\.\\d+$|-\\d+\\.\\d+$");

    /**
     * 判断科学计数法
     */
    public static final Pattern SCIENTIFIC = Pattern.compile("^((-?\\d+.?\\d*)[Ee]{1}([+-]?\\d+))$");

    /**
     * 判断千分位
     */
    public static final Pattern THOUSANDTH = Pattern.compile("^(([1-9][0-9]{0,2}(,\\d{3})*)|0)(\\.\\d+)?$");


    /**
     * 账套科目-判断为数字的正则表达式
     */
    public static final Pattern ZTKM_ZZBDS_SZ = Pattern.compile("[\\d]*");

    /**
     * 资金-校验金额正则表达式
     */
    public static final Pattern ZJ_VALID_MONEY = Pattern.compile("^(([0-9]+\\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\\.[0-9]+)|([0-9]*[1-9][0-9]*))$");


    /**
     * 资金-校验日期yyyy-MM-dd HH-mm-ss
     */
    public static final Pattern ZJ_VALID_DATE_YYYY_MM_DD_HH_MM_SS = Pattern.compile("^\\d{4}\\D+\\d{1,2}\\D+\\d{1,2}\\D+\\d{1,2}\\D+\\d{1,2}\\D+\\d{1,2}\\D*$");

    /**
     * 资金-校验日期yyyy-MM-dd HH-mm
     */
    public static final Pattern ZJ_VALID_DATE_YYYY_MM_DD_HH_MM = Pattern.compile("^\\d{4}\\D+\\d{1,2}\\D+\\d{1,2}\\D+\\d{1,2}\\D+\\d{1,2}$");

    /**
     * 资金-校验日期yyyy-MM-dd
     */
    public static final Pattern ZJ_VALID_DATE_YYYY_MM_DD = Pattern.compile("^\\d{4}\\D+\\d{1,2}\\D+\\d{1,2}$");

    /**
     * 清单缓存-校验日期yyyy-MM-dd
     */
    public static final Pattern QDHC_VALID_DATE_YYYY_MM_DD = Pattern.compile("^\\d{4}-\\d{1,2}-\\d{1,2}$");

    /**
     * 资金-校验日期yy-MM-dd
     */
    public static final Pattern ZJ_VALID_DATE_YY_MM_DD = Pattern.compile("^\\d{2}\\D+\\d{1,2}\\D+\\d{1,2}$");


    /**
     * 资金-校验日期MM-dd-yyyy
     */
    public static final Pattern ZJ_VALID_DATE_MM_DD_YYYY = Pattern.compile("^\\d{1,2}\\D+\\d{1,2}\\D+\\d{4}$");


    /**
     * 资金-校验日期yyyyMMddHHmmss
     */
    public static final Pattern ZJ_VALID_DATE_YYYYMMDD_HHMMSS = Pattern.compile("^\\d{14}$");


    /**
     * 资金-校验日期yyyyMMddHHmmssSSS
     */
    public static final Pattern ZJ_VALID_DATE_YYYYMMDD_HHMMSSSSS = Pattern.compile("^\\d{17}$");


    /**
     * 资金-校验日期yyyyMMdd
     */
    public static final Pattern ZJ_VALID_DATE_YYYYMMDD = Pattern.compile("^\\d{8}$");

    /**
     * StringUtil-校验字符串
     */
    public static final Pattern STRING_VALIDSTR = Pattern
            .compile("^[\\u4E00-\\u9FA5\\u9FA6-\\u9FCB\\u3400-\\u4DB5\\u20000-\\u2A6D\\u2A700-\\u2B734\\u2B740-\\u2B81D\\u2B820-\\u2CEA16\\u2CEB0-\\u2EBE0A-Za-z·]+$");

    /**
     * 中文校验字符串
     */
    public static final Pattern CHINESE_VALID = Pattern.compile("^[\\u4E00-\\u9FA5]+$");


    /**
     * StringUtil-校验特殊字符
     */
    public static final Pattern STRING_VALID_SPECIALSTR = Pattern.compile("\\~|\\?|\\|\\!|\\@|\\#|\\$|\\%|\\^|\\&|\\*|\\/|\\<|\\>|\\{|\\}|\\+|\\=|\\;|\\:|\\\"|\\||\\｜|\\]|\\[|\\～|\\｀|\\＊|\\︿|\\！|\\＠|\\＆|\\＃|\\￥|\\％|\\&|\\—|\\×|\\－|\\＿|\\＋|\\＝|\\［|\\］|\\｛|\\｝|\\【|\\】|\\＼|\\：|\\；|\\“|\\《|\\》|\\。|\\？|\\|\\／|\\\u007F");

    /**
     * StringUtils-换行符
     */
    public final static Pattern CRLF_PATTERN = Pattern.compile("\\r|\\n|\\r\\n");

    /**
     * dateUtils-日期format
     */
    public final static Map<Pattern, String> dateRegFormat = new HashMap<>();
    static {
        // 2014年3月12日 13时5分34秒，2014-03-12
        dateRegFormat.put(Pattern.compile("^\\d{4}\\D+\\d{1,2}\\D+\\d{1,2}\\D+\\d{1,2}\\D+\\d{1,2}\\D+\\d{1,2}\\D*$"), "yyyy-MM-dd-HH-mm-ss");
        // 2014-03-12
        dateRegFormat.put(Pattern.compile("^\\d{4}\\D+\\d{2}\\D+\\d{2}\\D+\\d{2}\\D+\\d{2}$"), "yyyy-MM-dd-HH-mm");
        // 2014-03-12
        dateRegFormat.put(Pattern.compile("^\\d{4}\\D+\\d{2}\\D+\\d{2}\\D+\\d{2}$"), "yyyy-MM-dd-HH");
        // 2014-03-12
        dateRegFormat.put(Pattern.compile("^\\d{4}\\D+\\d{2}\\D+\\d{2}$"), "yyyy-MM-dd");
        // 2014-3-12
        dateRegFormat.put(Pattern.compile("^\\d{4}\\D+\\d{1}\\D+\\d{2}$"), "yyyy-MM-dd");
        // 2014-3-1
        dateRegFormat.put(Pattern.compile("^\\d{4}\\D+\\d{1}\\D+\\d{1}$"), "yyyy-MM-dd");
        // 2014-03
        dateRegFormat.put(Pattern.compile("^\\d{4}\\D+\\d{2}$"), "yyyy-MM");
        // 2014
        dateRegFormat.put(Pattern.compile("^\\d{4}$"), "yyyy");
        // 20140312120534
        dateRegFormat.put(Pattern.compile("^\\d{14}$"), "yyyyMMddHHmmss");
        // 201403121205
        dateRegFormat.put(Pattern.compile("^\\d{12}$"), "yyyyMMddHHmm");
        // 2014031212
        dateRegFormat.put(Pattern.compile("^\\d{10}$"), "yyyyMMddHH");
        // 20140312
        dateRegFormat.put(Pattern.compile("^\\d{8}$"), "yyyyMMdd");
        // 201403
        dateRegFormat.put(Pattern.compile("^\\d{6}$"), "yyyyMM");
        // 13:05:34
        dateRegFormat.put(Pattern.compile("^\\d{2}\\s*:\\s*\\d{2}\\s*:\\s*\\d{2}$"), "yyyy-MM-dd-HH-mm-ss");
        // 13:05
        dateRegFormat.put(Pattern.compile("^\\d{2}\\s*:\\s*\\d{2}$"), "yyyy-MM-dd-HH-mm");
        // 14.10.18(年.月.日)
        dateRegFormat.put(Pattern.compile("^\\d{2}\\D+\\d{1,2}\\D+\\d{1,2}$"), "yy-MM-dd");
        // 30.12(日.月)
        dateRegFormat.put(Pattern.compile("^\\d{1,2}\\D+\\d{1,2}$"), "yyyy-dd-MM");
        // 12.21.2013(日.月.年)
        dateRegFormat.put(Pattern.compile("^\\d{1,2}\\D+\\d{1,2}\\D+\\d{4}$"), "dd-MM-yyyy");
    }


    /**
     * 人民币校验 不考虑分隔符的正确性
     */
    public static final Pattern AMOUNT_PATTERN = Pattern.compile("^(0|(-)?[0-9]\\d{0,11})\\.(\\d\\d)$");

    /**
     * 手机号
     */
    public static final Pattern MOBILE_PHONE = Pattern.compile("^[1][3,4,5,6,7,8,9][0-9]{9}$");

    /**
     * 座机号
     */
    public static final Pattern LANDLINE_NUMBER = Pattern.compile("^[0]\\d{10}|[0]\\d{11}$");


    /**
     * 日期格式
     */
    public static final Pattern DATA_PATTERN1 = Pattern.compile(
            "(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)");

    public static final Pattern DATA_PATTERN2 = Pattern.compile(
            "(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})/(((0[13578]|1[02])/(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)/(0[1-9]|[12][0-9]|30))|(02/(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))/02/29)");

    public static final Pattern DATA_PATTERN3 = Pattern.compile(
            "(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3}).(((0[13578]|1[02]).(0[1-9]|[12][0-9]|3[01]))|((0[469]|11).(0[1-9]|[12][0-9]|30))|(02.(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00)).02.29)");

    public static final Pattern DATA_PATTERN4 = Pattern.compile(
            "(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})_(((0[13578]|1[02])_(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)_(0[1-9]|[12][0-9]|30))|(02_(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))_02_29)");

    /**
     * 数字验证
     */
    public static final Pattern IDCARD_DIGITAL = Pattern.compile("^[0-9]*$");

    /**
     * 日期验证
     */
    public static final Pattern IDCARD_DATE = Pattern.compile("^\\d{4}\\d{2}\\d{2}$");

    /**
     * 时间验证
     */
    public static final Pattern IDCARD_DAY = Pattern.compile("^\\d{2}\\d{2}\\d{2}$");

    /**
     * url验证
     */
    public static final Pattern PATTERN_URI = Pattern.compile("^((/[a-zA-Z]+)+(/\\d+)+(/[a-zA-Z]+)*(/\\d+)*)+$");

    /**
     * 11位数字
     */
    public static final Pattern DIGITAL_ELE = Pattern.compile("^\\d{11}$");

    /**
     * 数字和字母
     */
    public static final Pattern ALNUM = Pattern.compile("^[a-zA-Z\\d]+$");

    /**
     * Base64编码
     */
    public static final Pattern BASE64 = Pattern.compile("^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{4}|[A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)$");

    /**
     * 9.12之前港澳居民往来内地通行证（回乡证）：以H或M开头，后8位或10位数字^[H|M](\d{8}|\d{10})$
     * 9.12后 需求3144如下：
     */
    public static final Pattern HXZ = Pattern.compile("^[A-Za-z0-9]{9}|[A-Za-z0-9]{11}$");

}
