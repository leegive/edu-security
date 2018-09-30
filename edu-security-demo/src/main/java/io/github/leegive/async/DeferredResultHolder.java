package io.github.leegive.async;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Map;

/**
 * TODO
 *
 * @author leegive
 */
@Component
public class DeferredResultHolder {

    private Map<String, DeferredResult> map = new HashedMap();

    public Map<String, DeferredResult> getMap() {
        return map;
    }

    public void setMap(Map<String, DeferredResult> map) {
        this.map = map;
    }
}
