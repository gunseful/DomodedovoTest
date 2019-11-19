package ru.dme;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Inspector {

    private final String URL = "http://npchk.nalog.ru/chk-lst.html";
    private final String FIELD_NAME = "lst";
    private final String FAIL = "Ошибка. Вы ничего не ввели";

    public String check(String identificadors) {
        if(identificadors.equals("")){
            return FAIL;
        }
        try {
            HttpPost post = new HttpPost(URL);
            List<NameValuePair> parameters = new ArrayList<>();
            parameters.add(new BasicNameValuePair(FIELD_NAME, identificadors));
            post.setEntity(new UrlEncodedFormEntity(parameters));
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpResponse httpresponse = httpclient.execute(post);
            return new BasicResponseHandler().handleResponse(httpresponse);
        } catch (IOException e) {
            e.printStackTrace();
            return FAIL;
        }
    }
}
