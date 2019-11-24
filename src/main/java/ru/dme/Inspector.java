package ru.dme;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//This class is getting request from ConsoleReader and send it to nalog.ru, then getting respnse
class Inspector {

    private static final Logger LOGGER = LogManager.getLogger(Inspector.class.getName());
    private final String URL = "http://npchk.nalog.ru/chk-lst.html";
    private final String FIELD_NAME = "lst";
    private final String ERROR = "Ошибка. Вы ничего не ввели.";

    String check(String idNumbers) {
        if(idNumbers.isEmpty()){
            return ERROR;
        }
        try {
            HttpPost post = new HttpPost(URL);

            List<NameValuePair> parameters = new ArrayList<>();

            parameters.add(new BasicNameValuePair(FIELD_NAME, idNumbers));

            post.setEntity(new UrlEncodedFormEntity(parameters));

            CloseableHttpClient httpclient = HttpClients.createDefault();

            return new BasicResponseHandler().handleResponse(httpclient.execute(post));
        } catch (IOException e) {
            LOGGER.error("Connection issue", e);
            return null;
        }
    }
}
