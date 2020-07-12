package ace.devops.module.util

import org.apache.tools.ant.util.StringUtils

import java.util.stream.Collectors

/**
 * @author Caspar* @contract 279397942@qq.com
 * @create 2020/7/12 12:58
 * @description
 */
class HttpUtils {
    private static final Integer DEFAULT_CONNECTION_TIMEOUT = 5 * 1000;
    private static final Integer DEFAULT_READ_TIMEOUT = 5 * 1000;
    private static final String REQUEST_METHOD_GET = "GET";

    static String get(String url, Map<String, String> params) {
        String urlParams = params.entrySet()
                .stream()
                .map(p -> {
                    return String.format("%s=%s", p.key, p.value);
                })
                .collect(Collectors.toList())
                .join("&");
        String realUrl = String.format("%s?%s",
                url,
                urlParams
        )
        String body = "";
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(realUrl).openConnection()
        try {
            httpURLConnection.setConnectTimeout(DEFAULT_CONNECTION_TIMEOUT);
            httpURLConnection.setReadTimeout(DEFAULT_READ_TIMEOUT)
            httpURLConnection.setRequestMethod(REQUEST_METHOD_GET);

            httpURLConnection.connect();
            //返回打开连接读取的输入流，输入流转化为StringBuffer类型，这一套流程要记住，常用
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()))) {
                StringBuffer stringBuffer = new StringBuffer();
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuffer.append(line);
                }
                body = new String(stringBuffer.toString().getBytes(), "UTF-8");
                bufferedReader.close();
            }
            httpURLConnection.disconnect();
        } catch (Exception ex) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
        return body;
    }
}
