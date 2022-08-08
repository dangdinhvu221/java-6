package poly.edu.com.demo.dao;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import poly.edu.com.demo.bean.EarPhoneMap;
import poly.edu.com.demo.entity.EarPhone;

@Repository
public class EarphoneDAO {
    RestTemplate rest = new RestTemplate();
    private String url = "https://poly-java-6-b7b9d-default-rtdb.firebaseio.com/earPhones.json";

    private String getUrl(String key) {
        return url.replace(".json", "/" + key + ".json");
    }

    public EarPhoneMap findAll() {
        return rest.getForObject(url, EarPhoneMap.class);
    }

    public EarPhone findByKey(String key) {
        return rest.getForObject(getUrl(key), EarPhone.class);
    }

    public String create(EarPhone data) {
        HttpEntity<EarPhone> entity = new HttpEntity<>(data);
        JsonNode resp = rest.postForObject(url, entity, JsonNode.class);
        return resp.get("name").asText();
    }

    public EarPhone update(String key, EarPhone data) {
        HttpEntity<EarPhone> entity = new HttpEntity<>(data);
        rest.put(getUrl(key), entity);
        return data;
    }

    public void delete(String key) {
        rest.delete(getUrl(key));
    }
}
