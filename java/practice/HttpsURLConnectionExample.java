package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpsURLConnectionExample {

    public static void main(String[] args) {
        try {
            // API 요청을 보낼 URL
            String apiUrl = "https://koreanjson.com/posts";

            // URL 객체 생성
            URL url = new URL(apiUrl);

            // HttpsURLConnection 생성
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // 요청 메서드 설정 (GET 요청)
            connection.setRequestMethod("GET");

            // 응답 코드 확인
            int responseCode = connection.getResponseCode();
            System.out.println("응답 코드: " + responseCode);

            // 응답 데이터 읽기
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                reader.close();

                // 응답 데이터 출력
                System.out.println("응답 데이터:\n" + response.toString());
            } else {
                System.out.println("API 요청 실패");
            }

            // 연결 종료
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
