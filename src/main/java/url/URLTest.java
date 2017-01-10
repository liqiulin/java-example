package url;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by liqiulin on 2016/12/21.
 */
public class URLTest {
    public static void main(String[] args) throws Exception{

        System.out.println("=============================================");
        String s = "http://www.baidu.com";
        System.out.println(appendDefaultQuery(s));
        s = "shttp://www.baidu.com";
        System.out.println(appendDefaultQuery(s));
        s = "http://www.baidu.com?";
        System.out.println(appendDefaultQuery(s));
        s = "http://www.baidu.com??";
        System.out.println(appendDefaultQuery(s));
        s = "http://www.baidu.com?eee";
        System.out.println(appendDefaultQuery(s));
        s = "http://www.baidu.com?eee&asdf";
        System.out.println(appendDefaultQuery(s));
        s = "http://www.baidu.com?eee&asdf#";
        System.out.println(appendDefaultQuery(s));
        s = "http://www.baidu.com?eee&asdf#d";
        System.out.println(appendDefaultQuery(s));
        s = "http://www.baidu.com#";
        System.out.println(appendDefaultQuery(s));
        s = "http://www.baidu.com#33";
        System.out.println(appendDefaultQuery(s));

        s = "https://www.ceshi113.com/XV/Home/Index#stream/showfeed/=/id-1231";
        System.out.println(appendDefaultQuery(s));

        System.out.println();
        System.out.println();
        System.out.println();

        String code = "d";
        String baseUrl = "www.baudu.com";
        baseUrl = "www.baudu.com";
        System.out.println(genJumpLinkTest(code, baseUrl));
        baseUrl = "http://www.baudu.com";
        System.out.println(genJumpLinkTest(code, baseUrl));
        baseUrl = "http://www.baudu.com?";
        System.out.println(genJumpLinkTest(code, baseUrl));
        baseUrl = "http://www.baudu.com?1=1";
        System.out.println(genJumpLinkTest(code, baseUrl));
        baseUrl = "http://www.baudu.com#";
        System.out.println(genJumpLinkTest(code, baseUrl));
        baseUrl = "http://www.baudu.com#11";
        System.out.println(genJumpLinkTest(code, baseUrl));
        baseUrl = "https://www.ceshi112.com/XV/Home/Index?1=1#stream/showtopic/=/name-asdf";
        System.out.println(genJumpLinkTest(code, baseUrl));

        baseUrl = "#stream/showtopic/=/name-asdf";
        System.out.println(genJumpLinkTest(code, baseUrl));

    }

    public static String appendDefaultQuery(String urlStr) {
        try {
            URL url = new URL(urlStr);
            if (!"http".equals(url.getProtocol()) && !"https".equals(url.getProtocol()) ) {
                return urlStr;
            }
            String appendQueryStr = "?1=1";
            if (url.getQuery() == null) {
                if (url.getRef() == null) {
                    return urlStr + appendQueryStr;
                } else {
                    String newUrl = urlStr.substring(0, urlStr.indexOf("#"));
                    return newUrl + appendQueryStr + "#" + url.getRef();
                }
            } else {
                return urlStr;
            }
        } catch (Exception e) {

        }
        return urlStr;
    }

    public static String genJumpLinkTest(String code, String baseUrl) throws Exception {
        String nonce = "nonce";
        String timestamp = String.valueOf(System.currentTimeMillis());
        String codeSig = "codeSig";

        StringBuilder addQueryBuilder = new StringBuilder();
        addQueryBuilder.append("code=").append(code);
        addQueryBuilder.append("&codeSig=").append(codeSig);
        addQueryBuilder.append("&timestamp=").append(timestamp);
        addQueryBuilder.append("&nonce=").append(nonce);

        boolean isNormalURL = true;
        try {
            new URL(baseUrl);
        } catch (MalformedURLException e) {
            isNormalURL = false;
        }
        if (isNormalURL) {
            return addQueryToBaseUrl(baseUrl, addQueryBuilder.toString());
        } else {
            if (baseUrl.contains("?")) {
                return baseUrl + "&" + addQueryBuilder.toString();
            } else {
                return baseUrl + "?" + addQueryBuilder.toString();
            }
        }
    }

    private static String addQueryToBaseUrl(String baseUrl, String addQueryString) throws Exception{
        StringBuilder callBackLoginUrlBuilder = new StringBuilder();
        try {
            URL url = new URL(baseUrl);
            String ref = url.getRef();
            String query = url.getQuery();

            if (ref == null) {  // 无锚点
                callBackLoginUrlBuilder.append(baseUrl);
                if (query == null) {
                    callBackLoginUrlBuilder.append("?");
                } else {
                    if (!"".equals(query)) {
                        callBackLoginUrlBuilder.append("&");
                    }
                }
                callBackLoginUrlBuilder.append(addQueryString);
            } else {
                if (query == null) {
                    String preUrl = baseUrl.substring(0, baseUrl.indexOf("#"));
                    callBackLoginUrlBuilder.append(preUrl);
                    callBackLoginUrlBuilder.append("?");
                    callBackLoginUrlBuilder.append(addQueryString);
                    callBackLoginUrlBuilder.append("#" + ref);
                } else {
                    String preUrl = baseUrl.substring(0, baseUrl.indexOf("?"));
                    callBackLoginUrlBuilder.append(preUrl);
                    if (!"".equals(query)) {
                        callBackLoginUrlBuilder.append("?" + query);
                        callBackLoginUrlBuilder.append("&");
                    }
                    callBackLoginUrlBuilder.append(addQueryString);
                    callBackLoginUrlBuilder.append("#" + ref);
                }
            }
            return callBackLoginUrlBuilder.toString();
        } catch (MalformedURLException e) {
            throw e;
        }
    }
}
