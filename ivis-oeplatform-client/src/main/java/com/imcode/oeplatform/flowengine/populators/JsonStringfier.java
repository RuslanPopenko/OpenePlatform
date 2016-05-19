package com.imcode.oeplatform.flowengine.populators;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.imcode.entities.Pupil;
import se.unlogic.standardutils.string.Stringyfier;

import java.util.ArrayList;

/**
 * Created by vitaly on 27.10.15.
 */
public class JsonStringfier implements Stringyfier<Object> {
    @Override
    public String format(Object bean) {
        ObjectMapper mapper = new ObjectMapper();

        StringBuilder jsonBean = new StringBuilder("[");

        ArrayList<Pupil> list = (ArrayList<Pupil>) bean;

        for (Pupil pupil : list) {
            try {
                jsonBean.append(mapper.writeValueAsString(pupil));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            jsonBean.append(",");
        }

        jsonBean.deleteCharAt(jsonBean.length() - 1);
        jsonBean.append("]");

        return jsonBean.toString();

    }
}
